package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Story;
import com.scrumble.boardapi.Repositories.IStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoryService {

    @Autowired
    private IStoryRepository storyRepository;

    public Story create(Story story) {
        return storyRepository.save(story);
    }

    public List<Story> getAll() {
        var stories = new ArrayList<Story>();
        storyRepository.findAll().forEach(stories::add);
        return stories;
    }

    public Story getById(int id) {
        Optional<Story> story = storyRepository.findById(id);
        return story.isEmpty() ? null : story.get();
    }

    private  Story story;

    StoryService(Story story)
    {
        this.story = story;
    }

    public StoryService() {

    }

    public Story updateStory() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean assignTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public TaskService[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }
}
