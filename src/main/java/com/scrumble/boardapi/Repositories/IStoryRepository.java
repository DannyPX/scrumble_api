package com.scrumble.boardapi.Repositories;

import com.scrumble.boardapi.Models.Story;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoryRepository extends CrudRepository<Story, Integer> {

}
