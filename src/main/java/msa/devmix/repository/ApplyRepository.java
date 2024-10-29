package msa.devmix.repository;

import msa.devmix.domain.board.Apply;
import msa.devmix.domain.board.BoardPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findByUserId(Long userId);

    void deleteAllByBoardPositionId(Long boardId);

    void deleteAllByBoardPositionIn(List<BoardPosition> boardPositions);
}
