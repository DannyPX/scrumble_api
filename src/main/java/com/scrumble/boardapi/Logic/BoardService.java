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
import java.util.*;

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
        //board.setLists(initializeDefaultScrumTemplate(board));
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

    public void initializeDefaultScrumTemplate(Board board){
        List<BoardList> lists = new ArrayList<>();

        // initialize list values
        BoardList todo = new BoardList();
        todo.setName("Todo");
        todo.setDescription("List with things to do");
        todo.setId(board.getId());

        BoardList inProgress = new BoardList();
        inProgress.setName("In progress");
        inProgress.setDescription("List with things in progress");
        inProgress.setId(board.getId());

        BoardList done = new BoardList();
        done.setName("Done");
        done.setDescription("List with things done");
        done.setId(board.getId());

        lists.add(todo);
        lists.add(inProgress);
        lists.add(done);
    }
}
