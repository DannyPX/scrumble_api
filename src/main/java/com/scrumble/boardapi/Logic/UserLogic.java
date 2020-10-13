package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.User;

public class UserLogic {
    private final User user;

    UserLogic(User user)
    {
        this.user = user;
    }

    public boolean register(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public User singIn(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Board createBoard(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Board[] getBoards() throws Exception {
        throw new Exception("Not implemented");
    }
}
