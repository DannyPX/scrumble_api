package com.scrumble.boardapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Table
@Entity
public class Board {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate createdAt;

    public boolean joinBoard(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean updateRole(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean kickMember(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean leave(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean createList(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean createStory(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean createTask(Task task) {
        throw new UnsupportedOperationException();
    }

    public boolean createLabel(Label label) {
        throw new UnsupportedOperationException();
    }

    public boolean removeList(BoardList list) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean removeList(List<BoardList> list) {
        throw new UnsupportedOperationException();
    }

    public List<User> getBoardMembers() {
        throw new UnsupportedOperationException();
    }

    public List<String> getLists() {
        throw new UnsupportedOperationException();
    }

    public void getBurndownchart() {
        throw new UnsupportedOperationException();
    }

    public int getId() {
        return this.id;
    }
}
