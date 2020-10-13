package Models;

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

}
