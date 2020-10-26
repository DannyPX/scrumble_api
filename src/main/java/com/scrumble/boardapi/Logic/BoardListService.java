package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.BoardList;

public class BoardListService {

    

    private final BoardList boardList;

    BoardListService(BoardList boardList)
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

    public TaskService[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }

    public TaskService[] getStories() throws Exception {
        throw new Exception("Not implemented");
    }
}
