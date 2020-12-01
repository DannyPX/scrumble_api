package com.scrumble.boardapi.Models;

import javax.persistence.*;

@Entity
@Table(name = "[User]")
public class User {
    @Id
    @Column
    private int id;

    @Column
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public static class Builder {
        private final String username;
        int id = 0;

        public Builder(String username, int id) {
            this.username = username;
            this.id = id;
        }

        public Builder(String username) {
            this.username = username;
        }


        public User build() {
            User user = new User(id, username);
            return user;
        }
    }
}
