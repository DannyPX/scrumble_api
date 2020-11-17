package com.scrumble.boardapi.Models;

import javax.persistence.*;

@Entity
@Table(name = "[User]")
public class User {
    @Id
    @Column
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public static class Builder {
        private final String username;

        public Builder(String username) {
            this.username = username;
        }

        public User build() {
            User user = new User();
            user.setUsername(username);
            return user;
        }
    }
}
