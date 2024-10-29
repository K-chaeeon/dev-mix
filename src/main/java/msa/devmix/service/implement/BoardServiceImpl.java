package msa.devmix.service.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import msa.devmix.domain.board.*;
import msa.devmix.domain.common.Position;
import msa.devmix.domain.constant.NotificationType;
import msa.devmix.domain.constant.RecruitmentStatus;
import msa.devmix.domain.user.User;
import msa.devmix.dto.*;
import msa.devmix.exception.CustomException;
import msa.devmix.exception.ErrorCode;
import msa.devmix.repository.*;
import msa.devmix.service.BoardService;
import msa.devmix.service.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardPositionRepository boardPositionRepository;
    private final PositionRepository positionRepository;
    private final TechStackRepository techStackRepository;
    private final BoardTechStackRepository boardTechStackRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ApplyRepository applyRepository;
    private final ScrapRepository scrapRepository;
    private final NotificationService notificationService;


    /**
     * 게시글 기능
     */
    //게시글 단건 조회
    @Override
    public BoardWithPositionTechStackDto getBoard(Long boardId) {

        BoardDto boardDto = boardRepository
                .findById(boardId)
                .map(board -> {
                    board.increaseViewCount();
                    return board;
                })
                .map(BoardDto::from)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND, String.format("boardId: %d", boardId)));

        List<BoardPositionDto> boardPositionDtoList = boardPositionRepository
                .findByBoardId(boardId).stream()
                .map(BoardPositionDto::from)
                .toList();

        List<BoardTechStackDto> boardTechStackDtoList = boardTechStackRepository
                .findByBoardId(boardId).stream()
                .map(BoardTechStackDto::from)
                .toList();

        return BoardWithPositionTechStackDto.of(boardDto, boardPositionDtoList, boardTechStackDtoList);
    }

    //게시글 저장
    @Override
    @Transactional
    public void saveBoard(BoardDto boardDto,
                          List<BoardPositionDto> boardPositionDtos,
                          List<BoardTechStackDto> boardTechStackDtos) {

        Board board = boardDto.toEntity();
        board.setRecruitmentStatus(RecruitmentStatus.RECRUITING);
        board.setUser(userRepository.findById(boardDto.getUserDto().getId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND)));
        board.setViewCount(0L);

        boardRepository.save(board);

        /**
         * todo: 기술 스택명, 포지션에 대한 검증 로직 + boardxxxDto.toEntity()
         * todo: 최대 인원수 검증 필요
         */

        List<String> positionNames = boardPositionDtos.stream()
                .map(BoardPositionDto::getPositionName)
                        .toList();

        List<Position> existingPositions = positionRepository.findByPositionNameIn(positionNames);

        if (positionNames.size() != existingPositions.size()) {
            throw new CustomException(ErrorCode.POSITION_NOT_FOUND);
        }

        boardPositionDtos.stream()
                .map(boardPositionDto -> {
                    if (positionRepository.findByPositionName(boardPositionDto.getPositionName()) != null) {
                        return boardPositionDto.toEntity(board, positionRepository.findByPositionName(boardPositionDto.getPositionName()));
                    } else {
                        throw new CustomException(ErrorCode.POSITION_NOT_FOUND);
                    }
                })
                .forEach(boardPositionRepository::save);

        boardTechStackDtos.stream()
                .map(boardTechStackDto -> {
                    if (techStackRepository.findByTechStackName(boardTechStackDto.getTechStackName()) != null) {
                        return boardTechStackDto.toEntity(board, techStackRepository.findByTechStackName(boardTechStackDto.getTechStackName()));
                    } else {
                        throw new CustomException(ErrorCode.TECH_STACK_NOT_FOUND);
                    }
                })
                .forEach(boardTechStackRepository::save);

    }

    //게시글 수정
    @Override
    @Transactional
    public void updateBoard(Long boardId,
                            BoardDto boardDto,
                            List<BoardPositionDto> boardPositionDtos,
                            List<BoardTechStackDto> boardTechStackDtos) {

    }

    //게시글 삭제
    @Override
    @Transactional
    public void deleteBoard(Long boardId, User user) {
        boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        boardRepository.findByIdAndUserId(boardId, user.getId())
                        .orElseThrow(() -> new CustomException(ErrorCode.PERMISSION_DENIED));

        deleteRelatedBoard(boardId);
        boardRepository.deleteById(boardId);
    }

    private void deleteRelatedBoard(Long boardId) {
        // 연관된 엔티티 일괄 삭제
        List<BoardPosition> boardPositionList = boardPositionRepository.findByBoardId(boardId);
        applyRepository.deleteAllByBoardPositionIn(boardPositionList);
        boardTechStackRepository.deleteAllByBoardId(boardId);
        boardPositionRepository.deleteAllByBoardId(boardId);
        scrapRepository.deleteAllByBoardId(boardId);
        commentRepository.deleteAllByBoardId(boardId);
    }

    //게시글 리스트 조회
    @Override
    public Page<BoardDto> getBoards(Pageable pageable) {
        return null;
    }

    //게시글 조회수 증가
//게시글을 조회할 때마다 조회수 증가 로직이 함께 실행되면 그 두 기능이 강하게 결합되므로,
//조회수 증가를 독립된 API 로 분리하면 유지보수성이 높아짐
    @Transactional
    @Override
    public void increaseViewCount(Long boardId) {
         Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
         board.increaseViewCount(); //Dirty checking
    }


    /**
     * 스크랩 기능
     */
    @Transactional
    @Override
    public void putScrap(Long boardId, User user) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));

        scrapRepository.findByUserIdAndBoardId(user.getId(), boardId)
                .ifPresentOrElse(
                        scrapRepository::delete,
                        () -> scrapRepository.save(Scrap.of(user, board))
                );
    }

    /**
     * 댓글 기능
     */
    //댓글 리스트 조회 => fetch join 으로 N+1 문제 해결
    public List<CommentDto> getComments(Long boardId) {

        return commentRepository.findByBoardId(boardId)
                .stream()
                .map(CommentDto::from)
                .toList();
    }

    //댓글 등록
    @Transactional
    public void saveComment(CommentDto dto) {
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        commentRepository.save(dto.toEntity(board, dto.getUser()));

        notificationService.send(
            board.getUser(),
            NotificationType.POST_COMMENT,
            dto.getUser().getNickname()+ "님이 댓글을 등록했습니다!"
        );
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long boardId, Long commentId, User user) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new CustomException(ErrorCode.BOARD_NOT_FOUND));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));

        if (!comment.getUser().getId().equals(user.getId())) {
            throw new CustomException(ErrorCode.PERMISSION_DENIED);
        }

        commentRepository.delete(comment);
    }

}
