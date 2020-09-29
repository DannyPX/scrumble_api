package com.scrumble.boardapi;

import javax.persistence.*;

@Entity @Table
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    public void register(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean singIn(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean createBoard(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Board[] getBoards() throws Exception {
        throw new Exception("Not implemented");
    }
}