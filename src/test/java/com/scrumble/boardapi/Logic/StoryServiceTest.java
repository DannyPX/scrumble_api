package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Story;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoryServiceTest {
    private StoryService storyService = new StoryService();

    @Test
    void create() {
        Story story = new Story();
        story.setArchived(false);
        story.setDescription("StoryDescriptionTest");
        story.setName("StoryNameTest");
       Story returnStory = storyService.create(story);
        Assert.isTrue(story.getDescription() == returnStory.getDescription(), "Description mismatch");
        Assert.isTrue(story.getName() == returnStory.getName(), "Name mismatch");
        Assert.isTrue(story.isArchived() == returnStory.isArchived(), "IsArchived mismatch");
        Assert.notNull(story.getId(), "Id not created");
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
        Assert.isTrue(storyService.getById(returnStory.getId()) == returnStory, "Stories mismatch in getByid");
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
