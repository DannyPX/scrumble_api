package com.scrumble.boardapi;

import javax.persistence.*;
import java.time.LocalDate;

@Table @Entity
public class Board {
    @Id @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalDate createdAt;

    public boolean joinBoard(User user){

    }
    public boolean updateRole(User user){

    }
    public boolean kickMember(User user){

    }
    public boolean leave(User user){

    }
    public boolean createList(User user){

    }
    public boolean createStory(User user){

    }
    public boolean createTask(Task task){

    }
    public boolean createLabel(Label label){

    }
    public boolean removeList(List list){

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

    public TimeStamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(TimeStamp createdAt) {
        this.createdAt = createdAt;
    }
    public boolean removeList(List list){

    }
    public User[] getBoardMembers(){

    }
    public List[] getLists(){

    }
    public getBurndownchart(){

    }
}
