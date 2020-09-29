package com.scrumble.boardapi;

import javax.persistence.*;
import java.awt.*;
@Entity @Table
public class Label {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String description;
    @Column
    private String colorHex;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    private boolean updateLabel(Label label){

    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
}
