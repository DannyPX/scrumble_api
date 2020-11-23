package com.scrumble.boardapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    public List<BoardList> getLists() {
        return lists;
    }

    public void setLists(List<BoardList> lists) {
        this.lists = lists;
    }


    @JsonBackReference
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BoardList> lists;


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public static class Builder {
        private final String name;
        private String description;
        private LocalDate createdAt;

        public Builder(String name) {
            this.name = name;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Board build() {
            Board board = new Board();
            board.setName(name);
            board.setDescription(description);
            board.setCreatedAt(createdAt);
            return board;
        }
    }
}
