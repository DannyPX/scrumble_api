package com.scrumble.boardapi;

<<<<<<< HEAD
public class Task {
=======
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
>>>>>>> 187a464a3e4fa7332559cd6b67fc9d62d84d5c18
}
