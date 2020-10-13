package RestControllers;

import Models.Board;
import Repositories.BoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BoardController {
    private final BoardRepository boardRepository;

    BoardController(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/boards")
    List<Board> all(){
        // Get all board where the user has access to
    }

    @PostMapping("/board")
    Board newBoard(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }
}
