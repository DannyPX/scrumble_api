package com.scrumble.boardapi.RestControllers;

import com.scrumble.boardapi.Logic.StoryService;
import com.scrumble.boardapi.Models.Story;
import com.scrumble.boardapi.Resources.CreateStoryResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/stories")
    public Iterable<Story> getAll() {
        return storyService.getAll();
    }

    @GetMapping("/stories/{id}")
    public ResponseEntity<Story> getById(@PathVariable("id") int id) {
        Story story = storyService.getById(id);
        return story != null ? new ResponseEntity<>(story, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/stories")
    public ResponseEntity<Story> newStory(@RequestBody CreateStoryResource newStory) {
        Story story = new Story.Builder(newStory.getName())
                .description(newStory.getDescription())
                .archived(false)
                .build();

        return new ResponseEntity<>(storyService.create(story), HttpStatus.OK);
    }
}
