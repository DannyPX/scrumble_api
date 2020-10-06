package Models;

import javax.persistence.*;

@Entity
@Table(name = "[User]")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
