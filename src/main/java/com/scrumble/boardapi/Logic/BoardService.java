package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.BurnDownChart;
import com.scrumble.boardapi.Models.Label;
import com.scrumble.boardapi.Repositories.IBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private IBoardRepository boardRepository;

    //private final Board board;

    BoardService(Board board)
    {
        //this.board = board;
    }

    public BoardService() {}

    public Board create(final Board board) {
        board.setCreatedAt(LocalDate.now());
        return boardRepository.save(board);
    }

    public Board getById(int id) {
        Optional<Board> board = boardRepository.findById(id);

        return board.isEmpty() ? null : board.get();
    }

    public List<Board> getAll() {
        var boards = new ArrayList<Board>();
         boardRepository.findAll().forEach(boards::add);
         return boards;
    }

    public boolean joinBoard(UserService user) {
        return false;
    }

    public UserService updateRole(UserService user) {
        throw new UnsupportedOperationException();
    }

    public boolean kickMember(UserService user) {
        throw new UnsupportedOperationException();
    }

    public boolean leave(UserService user) {
        throw new UnsupportedOperationException();
    }

    public List createList(UserService user) {
        throw new UnsupportedOperationException();
    }

    public StoryService createStory(UserService user) {
        throw new UnsupportedOperationException();
    }

    public TaskService createTask(TaskService task) {
        throw new UnsupportedOperationException();
    }

    public Label createLabel(Label label) {
        throw new UnsupportedOperationException();
    }

    public boolean removeList(BoardList list) {
        throw new UnsupportedOperationException();
    }

    public List<UserService> getBoardMembers() {
        throw new UnsupportedOperationException();
    }

    public List<String> getLists() {
        throw new UnsupportedOperationException();
    }

    public BurnDownChart getBurnDownChart() {
        throw new UnsupportedOperationException();
    }

}
