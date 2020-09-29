package com.scrumble.boardapi;

import java.time.LocalDateTime;

public class Task {
    private String name;
    private String description;
    private boolean archived;
    private LocalDateTime deadline;
    private int scrumPoints;

    public boolean assignTask(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeAssignment(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean updateTask(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean assignLabel(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeLabel(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean getLabels(User user) throws Exception {
        throw new Exception("Not implemented");
    }
}
