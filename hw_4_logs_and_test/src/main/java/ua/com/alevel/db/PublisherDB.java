package ua.com.alevel.db;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import ua.com.alevel.entity.Publisher;

public final class PublisherDB {

    private final Publisher[] publishers;
    private static PublisherDB instance;

    private PublisherDB() {
        publishers = new Publisher[0];
    }

    public static PublisherDB getInstance() {
        if (instance == null) {
            instance = new PublisherDB();
        }
        return instance;
    }

    public void create(Publisher publisher) {
        ArrayUtils.add(publishers, publisher);
    }

    public void update(Publisher publisher) {
        Publisher current = ArrayUtils.get(publishers, findIndexByName(publisher.getName()));
       // current.setPhone(publisher.getPhone());
        current.setBooksName(publisher.getBooksName());
        current.setName(publisher.getName());
    }

    public void delete(String name) {
        ArrayUtils.remove(publishers, findIndexByName(name));
    }

    private int findIndexByName(String name) {
        return ArrayUtils.indexOf(publishers, findByNameOrNull(name));
    }

    public Publisher findByNameOrNull(String name) {
        for (Publisher publisher : publishers) {
            if (StringUtils.equals(publisher.getName(), name)) {
                return publisher;
            }
        }
        return null;
    }

    public Publisher[] findAll() {
        return publishers;
    }

}

