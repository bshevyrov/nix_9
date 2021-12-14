package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.dao.HallDao;
import ua.com.alevel.entity.Hall;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.dao.query.JpaQueryUtil.*;

@Service
public class HallDaoImpl implements HallDao {

    private final JpaConfig jpaConfig;

    public HallDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    @Override
    public void create(Hall hall) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_HALL_QUERY)) {
            preparedStatement.setString(1, hall.getName());
            preparedStatement.setInt(2, hall.getNumOfSeats());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Some sql problem " + e.getMessage());
        }
    }

    @Override
    public void update(Hall hall) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(UPDATE_HALL_QUERY)) {
            preparedStatement.setString(1, hall.getName());
            preparedStatement.setInt(2, hall.getNumOfSeats());
            preparedStatement.setLong(3, hall.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL problem " + e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_HALL_BY_ID_QUERY + id)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Some sql problem " + e.getMessage());
        }
    }

    @Override
    public boolean existById(Long id) {
        Long count = 0L;
        try {
            ResultSet resultSet = jpaConfig.getStatement().executeQuery(EXIST_HALL_BY_ID_QUERY + id);
            while (resultSet.next()) {
                count = resultSet.getLong("COUNT(*)");
            }
        } catch (SQLException throwables) {
            System.out.println("SQL problem " + throwables.getMessage());
        }
        return count == 1;
    }

    @Override
    public Hall findById(Long id) {
        // НОРМ??
        Hall hall = new Hall();
        if (existById(id)) {
            try {
                ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_HALL_QUERY);
                while (resultSet.next()) {
                    hall = initHallByResultSet(resultSet);
                }
            } catch (SQLException e) {
                System.out.println("Sql problem " + e.getMessage());
            }
        }
        return hall;

    }

    @Override
    public List<Hall> findAll() {
        List<Hall> halls = new ArrayList<>();
        try {
            ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_HALL_QUERY);
            while (resultSet.next()) {
                halls.add(initHallByResultSet(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Sql problem " + e.getMessage());
        }
        return halls;
    }

    private Hall initHallByResultSet(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int numOfSeat = resultSet.getInt("num_of_seat");
        Hall hall = new Hall();
        hall.setId(id);
        hall.setName(name);
        hall.setNumOfSeats(numOfSeat);
        return hall;
    }
}
