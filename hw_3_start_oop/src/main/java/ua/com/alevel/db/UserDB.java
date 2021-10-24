package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import ua.com.alevel.entity.User;


import java.util.UUID;

public final class UserDB {

    private  User[] users;
    private static UserDB instance;

    private UserDB() {

        users = new User[0];
    }

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    public void create(User user) {
        user.setId(generateId());
       // if(DBAdditionMethods.isFull(users)){
          users = ArrayUtils.add(users,user);
      //  } else {
      //      users[DBAdditionMethods.getFirstEmptyCellIndex(users)] = user;
      //  }
    }

    public void update(User user) {
        User current = findById(user.getId());
        if (current != null) {
            current.setAge(user.getAge());
            //TODO if not found ADD NEW USER
        } else throw new NullPointerException(" User Not found in DB");
        current.setName(user.getName());
    }

    public void delete(String id) {
        for (int i = 0; i < users.length; i++) {
            if (id.equals(users[i].getId())) {
                users = ArrayUtils.remove(users,i);
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

    public User[] findAll() {
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
