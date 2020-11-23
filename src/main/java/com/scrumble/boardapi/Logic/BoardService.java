package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
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
}
