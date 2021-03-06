package com.scrumble.boardapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.time.LocalDate;
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
    private LocalDate deadline;

    @Column
    private int scrumPoints;

    public BoardList getList() {
        return list;
    }

    public void setList(BoardList list) {
        this.list = list;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "boardList_id", nullable = true)
    private BoardList list;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "story_id", nullable = true)
    private Story story;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isArchived() {
        return archived;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }

    public int getScrumPoints() {
        return scrumPoints;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setScrumPoints(int scrumPoints) {
        this.scrumPoints = scrumPoints;
    }

    public static class Builder {
        private final String name;
        private String description;
        private boolean archived;
        private LocalDate deadline;
        private int scrumPoints;
        private BoardList list;
        private Story story;

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

        public Builder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder scrumPoints(int scrumPoints) {
            this.scrumPoints = scrumPoints;
            return this;
        }

        public Builder list(BoardList list) {
            this.list = list;
            return this;
        }

        public Builder story(Story story) {
            this.story = story;
            return this;
        }

        public Task build() {
            Task task = new Task();
            task.setName(name);
            task.setDescription(description);
            task.setArchived(archived);
            task.setDeadline(deadline);
            task.setScrumPoints(scrumPoints);
            task.setList(list);
            task.setStory(story);
            return task;
        }
    }
}
