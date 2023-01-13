package app.dao;

import app.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void addUser(User user);

    boolean deleteUser(long id);

    boolean updateUser(User user);


}
