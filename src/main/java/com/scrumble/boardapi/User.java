package com.scrumble.boardapi;

import javax.persistence.*;

@Entity
@Table
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

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void register(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean singIn(User user) {
        throw new UnsupportedOperationException();
    }

    public boolean singOut(User user) {
        return true;
    }

    public boolean createBoard(Board board) {
        throw new UnsupportedOperationException();
    }

    public Board[] getBoards(User user) {
        throw new UnsupportedOperationException();
    }
}
