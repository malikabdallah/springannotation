package annotations.spring.model;

import javax.validation.constraints.Size;

public class User {
    @Size(min = 5,message = "Au - 5 caractères...")
    private String login;

    public User() {
    }

    public User(String login) {
        this.login=login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
