package com.scrumble.boardapi.Models;

import org.apache.tomcat.jni.Local;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
        private int id;
        private final String name;
        private String description;
        private boolean archived;
        private LocalDate deadline;
        private int scrumPoints;

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

        public Builder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder scrumPoints(int scrumPoints) {
            this.scrumPoints = scrumPoints;
            return this;
        }

        public Task build() {
            Task task = new Task();
            task.setName(name);
            task.setDescription(description);
            task.setArchived(archived);
            task.setDeadline(deadline);
            task.setScrumPoints(scrumPoints);
            return task;
        }
    }
}
