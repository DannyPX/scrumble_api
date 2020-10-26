package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.BoardService;
import com.scrumble.boardapi.Models.Board;
import com.scrumble.boardapi.Resources.CreateBoardResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/boards")
    public Iterable<Board> all() {
        return boardService.getAll();
    }

    @GetMapping("/boards/{id}")
    ResponseEntity<Board> getById(@PathVariable("id") int id) {
        Board board = boardService.getById(id);
        return board != null ? new ResponseEntity<>(board, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/boards")
    ResponseEntity<Board> newBoard(@RequestBody final CreateBoardResource board) {
        Board newBoard = new Board.Builder(board.getName())
                .description(board.getDescription())
                .build();

        return new ResponseEntity<>(boardService.createBoard(newBoard), HttpStatus.OK);
    }

//    @DeleteMapping("/boards/{id}")
//    ResponseEntity<Board> deleteBoard(@PathVariable int id) {
//        Optional<Board> board = boardRepository.findById(id);
//
//        if (board.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//
//        boardRepository.delete(board.get());
//        return new ResponseEntity<>(board.get(), HttpStatus.OK);
//    }
//
//    @PutMapping("/boards/{id}")
//    ResponseEntity<Board> updateBoard(@RequestBody Board updatedBoard, @PathVariable int id) {
//        Optional<Board> board = boardRepository.findById(id);
//
//        if (board.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//
//        boardRepository.save(board.get());
//        return new ResponseEntity<>(board.get(), HttpStatus.OK);
//    }
}
