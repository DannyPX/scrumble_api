package com.scrumble.boardapi.Repositories;

import com.scrumble.boardapi.Models.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoardRepository extends CrudRepository<Board, Integer> {

}
