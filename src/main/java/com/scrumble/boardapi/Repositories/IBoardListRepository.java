package com.scrumble.boardapi.Repositories;

import com.scrumble.boardapi.Models.BoardList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoardListRepository extends CrudRepository<BoardList, Integer> {

}
