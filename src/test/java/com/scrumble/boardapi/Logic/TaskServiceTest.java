package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Task;
import org.hibernate.cfg.NotYetImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    TaskService taskService = new TaskService();

    @Test
    void create() {
        Task task = new Task();
        task.setArchived(false);
        task.setDeadline(LocalDate.now());
        task.setDescription("CreateTaskDescriptionTest");
        task.setName("CreateTaskNameTest");
        task.setScrumPoints(22);
        Task returnTask = taskService.create(task);

        Assert.isTrue(task.getDeadline() == returnTask.getDeadline(), "Deadline mismatch");
        Assert.isTrue(task.getDescription() == returnTask.getDescription(), "Description mismatch");
        Assert.isTrue(task.getName() == returnTask.getName(), "Name mismatch");
        Assert.notNull(task.getId(), "Id not Valid");
        Assert.isTrue(task.getScrumPoints() == returnTask.getScrumPoints(), "Scrumpoints mismatch");
        Assert.isTrue(task.isArchived() == returnTask.isArchived(), "IsArchived mismatch");
    }

    @Test
    void getAll() {
        Task task = new Task();
        task.setArchived(false);
        task.setDeadline(LocalDate.now());
        task.setDescription("CreateTaskDescriptionTestgetAll");
        task.setName("CreateTaskNameTestgetAll");
        task.setScrumPoints(33);
        Task returnTask = taskService.create(task);
        Assert.isTrue(taskService.getAll().contains(returnTask), "Task not in getAll method");
    }

    @Test
    void getById() {
        Task task = new Task();
        task.setArchived(false);
        task.setDeadline(LocalDate.now());
        task.setDescription("CreateTaskDescriptionTestgetById");
        task.setName("CreateTaskNameTestgetById");
        task.setScrumPoints(33);
        Task returnTask = taskService.create(task);
        Task SecondReturnTask = taskService.getById(returnTask.getId());
        Assert.isTrue(returnTask == SecondReturnTask, "Tasks mismatch in getById");
    }


    @Test
    void update() {
        Task task = new Task();
        task.setArchived(false);
        task.setDeadline(LocalDate.now());
        task.setDescription("CreateTaskDescriptionTestupdate");
        task.setName("CreateTaskNameTestupdate");
        task.setScrumPoints(69);
        Task returnTask = taskService.create(task);
        returnTask.setScrumPoints(420);
        Assert.isTrue(taskService.getById(returnTask.getId()).getScrumPoints() == 420,"Update Task Failed");
    }

    @Test
    void assignTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void removeAssignment() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void updateTask() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void assignLabel() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void removeLabel() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }

    @Test
    void getLabels() {
        throw new NotYetImplementedException("This method is not yet implemented");
    }
}
