package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.BurnDownChart;
import com.scrumble.boardapi.Models.Label;
import com.scrumble.boardapi.Repositories.IBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BoardService {

    @Autowired
    private IBoardRepository boardRepository;


    BoardService(Board board)
    {
        //this.board = board;
    }

    public BoardService() {}

    public Board create(final Board board) {
        board.setCreatedAt(LocalDate.now());
        board.setLists(initializeDefaultScrumTemplate(board));
        return boardRepository.save(board);
    }

    private Set<BoardList> initializeDefaultScrumTemplate(Board board){
        Set<BoardList> lists = new HashSet<>();

        // initialize list values
        BoardList todo = new BoardList();
        todo.setName("Todo");
        todo.setDescription("List with things to do");

        BoardList inProgress = new BoardList();
        inProgress.setName("In progress");
        inProgress.setDescription("List with things in progress");

        BoardList done = new BoardList();
        done.setName("Done");
        done.setDescription("List with things done");

        lists.add(todo);
        lists.add(inProgress);
        lists.add(done);
        return lists;
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
