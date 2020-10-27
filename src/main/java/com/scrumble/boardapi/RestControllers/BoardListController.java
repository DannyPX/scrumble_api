package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.BoardListService;
import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Resources.CreateBoardListResource;
import com.scrumble.boardapi.Resources.UpdateBoardListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

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
        BoardList boardList = new BoardList.Builder(newBoardList.getName())
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
}
