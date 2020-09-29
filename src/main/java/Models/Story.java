package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Story {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean archived;

    public boolean updateStory() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean assignTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean removeTask() throws Exception {
        throw new Exception("Not implemented");
    }

    public Task[] getTasks() throws Exception {
        throw new Exception("Not implemented");
    }
}
