package app.dao;

import app.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void deleteUser(long id);

}
