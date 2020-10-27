package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Board;
import org.apache.tomcat.jni.Time;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardServiceTest {

    BoardService boardService = new BoardService();
    @Test
    void create() {
        Board board = new Board();
        board.setCreatedAt(LocalDate.now());
        board.setDescription("CreateBoardTestDescription");
        board.setName("CreateBoardTestName");
        Board returnBoard = boardService.create(board);
        Assert.isTrue(returnBoard.getCreatedAt() == board.getCreatedAt(), "CreatedAt Mismatch");
        Assert.isTrue(returnBoard.getDescription() == board.getDescription(), "Description Mismatch");
        Assert.isTrue(returnBoard.getName() == board.getName(), "Name Mismatch");
        Assert.notNull(returnBoard.getId(),"Id null");
    }

    @Test
    void getById() {
        Board board = new Board();
        board.setCreatedAt(LocalDate.now());
        board.setDescription("CreateBoardTestDescriptiongetById");
        board.setName("CreateBoardTestNamegetById");
        Board returnBoard = boardService.create(board);
       Board secondReturnBoard = boardService.getById(returnBoard.getId());
       Assert.isTrue(returnBoard.getName() == secondReturnBoard.getName(), "getById return different value");
    }

    @Test
    void getAll() {
        Board board = new Board();
        board.setCreatedAt(LocalDate.now());
        board.setDescription("CreateBoardTestDescriptiongetAll");
        board.setName("CreateBoardTestNamegetAll");
        Board returnBoard = boardService.create(board);
        Assert.isTrue(boardService.getAll().contains(returnBoard), "getAll board Mismatch");
    }

    @Test
    void joinBoard() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void updateRole() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void kickMember() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void leave() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void createList() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void createStory() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void createTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void createLabel() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void removeList() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getBoardMembers() {
        Assert.isTrue(boardService.getBoardMembers().stream().count() > 0, "Board should always have 1 or more members");

        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getLists() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getBurnDownChart() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }
}
