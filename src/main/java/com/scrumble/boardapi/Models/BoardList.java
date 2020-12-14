package com.scrumble.boardapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

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


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    public Set<Task> getTasks() {
        return tasks;
    }

    public void addTasks(Task task) {
        this.tasks.add(task);
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task>  tasks;

    @JsonManagedReference
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Story> stories;


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
        private Board board;

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

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public BoardList build() {
            BoardList boardList = new BoardList();
            boardList.setName(name);
            boardList.setDescription(description);
            boardList.setArchived(archived);
            boardList.setBoard(board);
            return boardList;
        }
    }
}
