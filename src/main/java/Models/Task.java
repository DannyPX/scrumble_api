package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

    @Column
    private LocalDateTime deadline;

    @Column
    private int scrumPoints;


}
