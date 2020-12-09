package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Repositories.IBoardListRepository;
import com.scrumble.boardapi.Repositories.IBoardRepository;
import com.scrumble.boardapi.Repositories.ITaskRepository;
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

    @Autowired
    private IBoardListRepository boardListRepository;

    @Autowired
    private ITaskRepository taskRepository;

    public Board create(final Board board) {
        board.setCreatedAt(LocalDate.now());
        return boardRepository.save(board);
    }

    public Board getById(int id) {
        Optional<Board> board = boardRepository.findById(id);

        List<BoardList> lists = new ArrayList<>();

        Iterable<BoardList> all = boardListRepository.findAll();
        Iterable<Task> alltasks = taskRepository.findAll();


        for (var listItem : all) {
            if (listItem.getId() == board.get().getId()) {
                for (var tasky : alltasks) {
                    if (tasky.getList().getId() == listItem.getId()) {
                        listItem.addTasks(tasky);
                    }
                }

                lists.add(listItem);
            }
        }
        
        board.get().setLists(lists);

        return board.isEmpty() ? null : board.get();
    }

    public List<Board> getAll() {
        var boards = new ArrayList<Board>();
        boardRepository.findAll().forEach(boards::add);
        return boards;
    }
}
