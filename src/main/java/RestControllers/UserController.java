package RestControllers;

import Models.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final User user;

    UserController(User user)
    {
        this.user = user;
    }
}
