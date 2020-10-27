package com.scrumble.boardapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Story {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BoardList getList() {
        return list;
    }

    public void setList(BoardList list) {
        this.list = list;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "list_id")
    private BoardList list;

    @JsonBackReference
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks;

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public static class Builder {
        private int id;
        private final String name;
        private String description;
        private boolean archived;
        private BoardList list;
        private Task task;

        public Builder(String name) {
            this.name = name;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder archived(boolean archived) {
            this.archived = archived;
            return this;
        }

        public Builder list(BoardList list) {
            this.list = list;
            return this;
        }

        public Story build() {
            Story story = new Story();
            story.setId(id);
            story.setName(name);
            story.setDescription(description);
            story.setArchived(archived);
            story.setList(list);
            return story;
        }
    }
}
