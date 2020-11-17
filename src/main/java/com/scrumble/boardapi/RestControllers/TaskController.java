package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.BoardListService;
import com.scrumble.boardapi.Logic.StoryService;
import com.scrumble.boardapi.Logic.TaskService;
import com.scrumble.boardapi.Models.BoardList;
import com.scrumble.boardapi.Models.Story;
import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Resources.CreateTaskResource;
import com.scrumble.boardapi.Resources.UpdateTaskResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private BoardListService boardListService;

    @Autowired
    private StoryService storyService;

    @Autowired
    private TaskService TaskService;

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
            BoardList boardList = boardListService.getById(newTask.getListId());

            if (boardList == null && newTask.getListId() != 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Story story = storyService.getById(newTask.getStoryId());

            if (story == null && newTask.getStoryId() != 0) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Task task = new Task.Builder(newTask.getName())
                    .story(story)
                    .list(boardList)
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

    @PutMapping("/lists/{id}/{TaskId}")
    public ResponseEntity<Task> assignTask(@PathVariable("id") int id, @PathVariable("TaskId") int taskId)
    {
        BoardList list = boardListService.getById(id);
        Task task = TaskService.getById(taskId);

        if (list == null && task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // TODO: check if tasks belongs to the correct board

        list.addTasks(TaskService.getById(taskId));
        return new ResponseEntity<>(TaskService.update(task), HttpStatus.OK);
    }
}
