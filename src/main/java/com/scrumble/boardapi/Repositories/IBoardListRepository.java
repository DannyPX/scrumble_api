package com.scrumble.boardapi.Repositories;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBoardListRepository extends CrudRepository<BoardList, Integer> {
    List<BoardList> findByBoard(@Param("board") Board board);
}
