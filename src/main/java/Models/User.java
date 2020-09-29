package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public void register(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean singIn(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public boolean createBoard(User user) throws Exception {
        throw new Exception("Not implemented");
    }

    public Board[] getBoards() throws Exception {
        throw new Exception("Not implemented");
    }
}
