package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
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

    public List<BoardList> getByBoardId(Board board) {
        return boardListRepository.findByBoard(board);
    }
}
