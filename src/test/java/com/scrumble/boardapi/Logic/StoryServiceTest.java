package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Story;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoryServiceTest {
    @Autowired
    private StoryService storyService;

    @Test
    void create() {
        Story story = new Story();
        story.setArchived(false);
        story.setDescription("StoryDescriptionTest");
        story.setName("StoryNameTest");
       Story returnStory = storyService.create(story);
        Assert.isTrue(story.getDescription().equals(returnStory.getDescription()), "Description mismatch");
        Assert.isTrue(story.getName().equals(returnStory.getName()), "Name mismatch");
        Assert.isTrue(story.isArchived() == returnStory.isArchived(), "IsArchived mismatch");
    }

    @Test
    void getAll() {
        Story story = new Story();
        story.setArchived(false);
        story.setDescription("StoryDescriptionTestgetAll");
        story.setName("StoryNameTestgetAll");
        Story returnStory = storyService.create(story);
        Assert.isTrue(storyService.getAll().contains(returnStory), "Story not in getAll method");
    }

    @Test
    void getById() {
        Story story = new Story();
        story.setArchived(false);
        story.setDescription("StoryDescriptionTestgetById");
        story.setName("StoryNameTestgetById");
        Story returnStory = storyService.create(story);
        Assert.isTrue(storyService.getById(returnStory.getId()).getName().equals(returnStory.getName()), "Stories mismatch in getByid");
    }

    @Test
    void updateStory() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void assignTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void removeTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getTasks() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }
}
