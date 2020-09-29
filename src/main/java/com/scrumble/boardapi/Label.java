package com.scrumble.boardapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
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

    private boolean updateLabel(Label label) throws Exception {
        throw new Exception("Not implemented");
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
}
