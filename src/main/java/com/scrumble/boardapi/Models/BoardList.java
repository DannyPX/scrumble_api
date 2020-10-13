package com.scrumble.boardapi.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BoardList {
    @Id
    @GeneratedValue
    private int Id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

}
