package ua.com.alevel.db;

import ua.com.alevel.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDB {

    private final List<User> users;
    private static UserDB instance;

    private UserDB() {
        users = new ArrayList<>();
    }

    public static UserDB getInstance() {
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
        users.add(user);
    }

    public void update(User user) {
        User current = findById(user.getId());
        current.setAge(user.getAge());
        current.setName(user.getName());
    }

    public void delete(String id) {

        for (int i = 0; i < users.size(); i++) {
            if (id.equals(users.get(i).getId())) {
                users.remove(i);
                break;
            }
        }
    }

    public User findById(String id) {
        for (User user : users) {
            if (id.equals(user.getId())) {
                return user;
            }
        }
        //todo какой НАЛЛ АЛЛЕЕ
        return null;
    }

    public List<User> findAll() {
        return users;
    }

    private String generateId() {

        String id = UUID.randomUUID().toString();
        for (User user : users) {
            if (user.getId().equals(id)) {
                generateId();
            }
        }
        return id;
    }
}
