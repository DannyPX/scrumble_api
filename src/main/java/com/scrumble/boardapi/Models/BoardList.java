package com.scrumble.boardapi.Models;

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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public static class Builder{
        private final String name;
        private String description;
        private boolean archived;

        public Builder(String name) {
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder archived(boolean archived) {
            this.archived = archived;
            return this;
        }

        public BoardList build() {
            BoardList boardList = new BoardList();
            boardList.setName(name);
            boardList.setDescription(description);
            boardList.setArchived(archived);
            return boardList;
        }
    }
}
