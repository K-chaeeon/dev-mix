package msa.devmix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.domain.constant.RecruitmentStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class BoardWithPositionTechStackDto {

    private Long boardId;
    private String title;
    private String content;
    private String imageUrl;
    private RecruitmentStatus recruitmentStatus;
    private Long viewCount;
    private Long projectPeriod;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UserDto userDto;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<BoardTechStackDto> boardTechStackDtos;
    private List<BoardPositionDto> boardPositionDtos;

    public static BoardWithPositionTechStackDto of(BoardDto boardDto,
                                                   List<BoardPositionDto> boardPositionDtos,
                                                   List<BoardTechStackDto> boardTechStackDtos) {
        return new BoardWithPositionTechStackDto(
                boardDto.getBoardId(),
                boardDto.getContent(),
                boardDto.getTitle(),
                boardDto.getImageUrl(),
                boardDto.getRecruitmentStatus(),
                boardDto.getViewCount(),
                boardDto.getProjectPeriod(),
                boardDto.getStartDate(),
                boardDto.getRecruitEndDate(),
                boardDto.getUserDto(),
                boardDto.getCreatedAt(),
                boardDto.getModifiedAt(),
                boardTechStackDtos,
                boardPositionDtos);
    }

}
