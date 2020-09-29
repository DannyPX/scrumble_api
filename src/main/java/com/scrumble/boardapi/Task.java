package com.scrumble.boardapi;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

    @Column
    private LocalDateTime deadline;

    @Column
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

    public int getId() {
        return this.id;
    }
}
