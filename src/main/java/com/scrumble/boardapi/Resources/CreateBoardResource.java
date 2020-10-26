package com.scrumble.boardapi.Resources;

public class CreateBoardResource {
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private String name;
    private String description;

    public CreateBoardResource() {

    }

    public CreateBoardResource(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
