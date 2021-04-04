package annotations.spring.services;

import org.springframework.stereotype.Service;
import annotations.spring.model.User;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String,User> users;

    @PostConstruct
    public void fillUsers() {
        users=new HashMap<>();
        User u;
        u=new User("Albert");
        users.put(u.getLogin(),u);
        u=new User("Berthe");
        users.put(u.getLogin(),u);
        u=new User("Claude");
        users.put(u.getLogin(),u);
    }

    public User exists(String login) {
        return users.get(login);
    }
}
