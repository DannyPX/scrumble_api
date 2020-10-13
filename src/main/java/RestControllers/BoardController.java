package RestControllers;

import Models.Board;
import Repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/boards")
    public Iterable<Board> all(){
       return boardRepository.findAll();
    }

    @PostMapping("/board")
    ResponseEntity<Object> newBoard(@RequestBody Board newBoard) {
        return new ResponseEntity<>(boardRepository.save(newBoard),HttpStatus.I_AM_A_TEAPOT);
    }
}

