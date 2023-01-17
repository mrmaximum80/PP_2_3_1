package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    @Transactional
    public User getUser(long id) {

        User user = entityManager.find(User.class, id);
//        Query query = entityManager.createQuery("from User where id = :userid");
//        query.setParameter("userid", id);
//        if (!query.getResultList().isEmpty()) {
//            return (User) query.getSingleResult();
//        } else {
//            return null;
//        }
        return user;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        Query query = entityManager.createQuery("delete from User where id = :userid");
        query.setParameter("userid", id);
        query.executeUpdate();
    }

}
