package msa.devmix.repository;

import msa.devmix.domain.board.BoardPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardPositionRepository extends JpaRepository<BoardPosition, Long> {

    List<BoardPosition> findByBoardId(Long boardId);

    void deleteAllByBoardId(Long boardId);
}
