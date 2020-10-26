package com.scrumble.boardapi.Repositories;

import com.scrumble.boardapi.Models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends CrudRepository<Task, Integer> {

}
