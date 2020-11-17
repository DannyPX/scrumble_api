package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Repositories.IBoardListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardListService {

    @Autowired
    private IBoardListRepository boardListRepository;

    public BoardListService() {}

    public BoardList create(BoardList boardList) {
        return boardListRepository.save(boardList);
    }

    public List<BoardList> getAll() {
        var lists = new ArrayList<BoardList>();
        boardListRepository.findAll().forEach(lists::add);
        return lists;
    }

    public BoardList getById(int id) {
        Optional<BoardList> boardList = boardListRepository.findById(id);
        return boardList.isEmpty() ? null : boardList.get();
    }

    public BoardList update(BoardList boardList) {
        return boardListRepository.save(boardList);
    }

    private  BoardList boardList;

    BoardListService(BoardList boardList)
    {
        this.boardList = boardList;
    }

    public boolean updateList() throws Exception {
        throw new Exception("Not implemented");
        // Updates list information like the name and description
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
