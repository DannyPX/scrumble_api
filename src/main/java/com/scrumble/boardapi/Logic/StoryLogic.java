package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Story;

public class StoryLogic {
    private final Story story;

    StoryLogic(Story story)
    {
        this.story = story;
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

    public TaskLogic[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }
}
