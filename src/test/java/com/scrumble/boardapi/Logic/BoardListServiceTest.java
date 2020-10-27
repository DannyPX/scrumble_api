package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.BoardList;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.naming.Name;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardListServiceTest {
    private BoardListService boardListService = new BoardListService();

    @Test
    void create() {
        BoardList boardList = new BoardList();
        boardList.setName("TestBoardList");
        boardList.setArchived(false);
        boardList.setDescription("TestBoardDescription");

        BoardList returnBoardList = boardListService.create(boardList);
        Assert.isTrue(returnBoardList.getDescription() == boardList.getDescription(), "Descripion mismatch");
        Assert.isTrue(returnBoardList.getName() == boardList.getName(), "name mismatch");
        Assert.isTrue(returnBoardList.isArchived() == boardList.isArchived(), "archived state mismatch");
        Assert.notNull(returnBoardList.getId(), "id is null");
    }

    @Test
    void getAll() {
        BoardList boardList = new BoardList();
        boardList.setName("TestBoardListGetAll");
        boardList.setArchived(false);
        boardList.setDescription("TestBoardDescriptionGetAll");
        Assert.isTrue(boardListService.getAll().contains(boardListService), "Boarlist not present");
    }

    @Test
    void getById() {
        BoardList boardList = new BoardList();
        boardList.setName("TestBoardListGetById");
        boardList.setArchived(false);
        boardList.setDescription("TestBoardDescriptionGetById");
        BoardList returnBoardList = boardListService.create(boardList);
        Assert.isTrue(returnBoardList.getName() == boardListService.getById(returnBoardList.getId()).getName(), "GetById Returns Different list");
    }

    @Test
    void update() {
        BoardList boardList = new BoardList();
        boardList.setName("TestBoardListUpdate");
        boardList.setArchived(false);
        boardList.setDescription("TestBoardDescriptionUpdate");
        BoardList returnBoardList = boardListService.create(boardList);
        returnBoardList.setName("TestBoardNameNewUpdate");
        boardListService.update(boardList);
        BoardList secondReturnBoardList = boardListService.getById(returnBoardList.getId());

        Assert.isTrue(secondReturnBoardList.getName() == returnBoardList.getName(), "Board is not updated");
    }

    @Test
    void updateList() {
      throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void assignTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void removeTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getTasks() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getStories() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }
}
