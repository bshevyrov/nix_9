package ua.com.alevel.dao;

import ua.com.alevel.db.PublisherDB;
import ua.com.alevel.entity.Publisher;

public class PublisherDao {

    public void create(Publisher publisher) {
        PublisherDB.getInstance().create(publisher);
    }

    public void update(Publisher publisher) {
        PublisherDB.getInstance().update(publisher);
    }

    public void delete(String name) {
        PublisherDB.getInstance().delete(name);
    }

    public Publisher findByName(String name) {
        return PublisherDB.getInstance().findByNameOrNull(name);
    }

    public Publisher[] findAll() {
        return PublisherDB.getInstance().findAll();
    }
}


