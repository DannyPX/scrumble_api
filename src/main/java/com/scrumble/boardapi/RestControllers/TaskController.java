package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.TaskService;
import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Resources.CreateTaskResource;
import com.scrumble.boardapi.Resources.UpdateTaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") int id) {
        Task task = taskService.getById(id);
        return task != null ? new ResponseEntity<>( taskService.getById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> newTask(@RequestBody CreateTaskResource newTask) {
        Task task = new Task.Builder(newTask.getName())
                .description(newTask.getDescription())
                .deadline(newTask.getDeadline())
                .build();

        return new ResponseEntity<>(taskService.create(task), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody UpdateTaskResource newTask) {
        Task existing = taskService.getById(id);

        if (existing == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existing.setName(newTask.getName());
        existing.setDescription(newTask.getDescription());

        return new ResponseEntity<>(taskService.update(existing), HttpStatus.OK);
    }
}
