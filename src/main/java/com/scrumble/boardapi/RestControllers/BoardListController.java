package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.BoardListService;
import com.scrumble.boardapi.Logic.BoardService;
import com.scrumble.boardapi.Logic.TaskService;
import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Resources.CreateBoardListResource;
import com.scrumble.boardapi.Resources.UpdateBoardListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private TaskService TaskService;

    @GetMapping("/lists")
    public Iterable<BoardList> getAll() {
        return boardListService.getAll();
    }

    @GetMapping("/lists/{id}")
    public ResponseEntity<BoardList> getById(@PathVariable("id") int id) {
        BoardList boardlist = boardListService.getById(id);
        return boardlist != null ? new ResponseEntity<>(boardlist, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/lists")
    public ResponseEntity<BoardList> newBoardList(@RequestBody CreateBoardListResource newBoardList) {
        Board board = boardService.getById(newBoardList.getBoardId());

        if (board == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BoardList boardList = new BoardList.Builder(newBoardList.getName())
                .board(board)
                .description(newBoardList.getDescription())
                .archived(false)
                .build();

        return new ResponseEntity<>(boardListService.create(boardList), HttpStatus.OK);
    }

    @PutMapping("/lists/{id}")
    public ResponseEntity<BoardList> updateBoardList(@PathVariable("id") int id, @RequestBody UpdateBoardListResource newBoardList) {
        BoardList existing = boardListService.getById(id);

        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existing.setName(newBoardList.getName());
        existing.setDescription(newBoardList.getDescription());

        return new ResponseEntity<>(boardListService.update(existing), HttpStatus.OK);
    }

    @PutMapping("/lists/{id}/{Task}")
    public ResponseEntity<BoardList> assignTask(@PathVariable("Task") Task task, @PathVariable("id") int id, @RequestBody UpdateBoardListResource newBoardList)
    {
        BoardList listExists = boardListService.getById(id);
        Task taskExists = TaskService.getById(task.getId());

        if (listExists == null && taskExists == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        listExists.getTasks().add(task);
        return new ResponseEntity<>(boardListService.update(listExists), HttpStatus.OK);
    }
}
