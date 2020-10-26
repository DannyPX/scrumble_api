package com.scrumble.boardapi.Logic;

import com.scrumble.boardapi.Models.Task;
import com.scrumble.boardapi.Models.User;
import com.scrumble.boardapi.Repositories.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public List<Task> getAll() {
        var tasks = new ArrayList<Task>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getById(int id) {
        Optional<Task> task =  taskRepository.findById(id);

        return task.isEmpty() ? null : task.get();
    }

    public Task create(Task task) {
        task.setScrumPoints(0);

        return taskRepository.save(task);
    }

    public Task update(Task updated) {
        return taskRepository.save(updated);
    }

    public boolean assignTask(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeAssignment(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Task updateTask(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Task assignLabel(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Task removeLabel(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Task getLabels(User user) throws Exception {
        throw new Exception("Not implemented");
    }
}
