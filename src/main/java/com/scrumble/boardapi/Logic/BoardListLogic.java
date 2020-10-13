package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.BoardList;

public class BoardListLogic {

    private final BoardList boardList;

    BoardListLogic(BoardList boardList)
    {
        this.boardList = boardList;
    }

    public boolean updateList() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean assignTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public TaskLogic[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }

    public TaskLogic[] getStories() throws Exception {
        throw new Exception("Not implemented");
    }
}
