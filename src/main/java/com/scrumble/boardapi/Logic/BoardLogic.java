package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.BurnDownChart;
import com.scrumble.boardapi.Models.Label;

import java.util.List;

public class BoardLogic {

    private final Board board;

    BoardLogic(Board board)
    {
        this.board = board;
    }

    public boolean joinBoard(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public UserLogic updateRole(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public boolean kickMember(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public boolean leave(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public List createList(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public StoryLogic createStory(UserLogic user) {
        throw new UnsupportedOperationException();
    }

    public TaskLogic createTask(TaskLogic task) {
        throw new UnsupportedOperationException();
    }

    public Label createLabel(Label label) {
        throw new UnsupportedOperationException();
    }

    public boolean removeList(BoardList list) {
        throw new UnsupportedOperationException();
    }

    public List<UserLogic> getBoardMembers() {
        throw new UnsupportedOperationException();
    }

    public List<String> getLists() {
        throw new UnsupportedOperationException();
    }

    public BurnDownChart getBurnDownChart() {
        throw new UnsupportedOperationException();
    }

}
