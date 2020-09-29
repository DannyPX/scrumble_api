package com.scrumble.boardapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BoardList {
    @Id
    @GeneratedValue
    private int Id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

    public boolean updateList() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean assignTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public Task[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }

    public Task[] getStories() throws Exception {
        throw new Exception("Not implemented");
    }

    public int getId() {
        return Id;
    }
}
