package ua.com.alevel.dao.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.config.jpa.JpaConfig;
import ua.com.alevel.dao.MovieDao;
import ua.com.alevel.entity.Hall;
import ua.com.alevel.entity.Movie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.com.alevel.dao.query.JpaQueryUtil.*;

@Service
public class MovieDaoImpl implements MovieDao {

    private final JpaConfig jpaConfig;

    public MovieDaoImpl(JpaConfig jpaConfig) {
        this.jpaConfig = jpaConfig;
    }

    @Override
    public void create(Movie movie) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(CREATE_MOVIE_QUERY)) {
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setLong(3, movie.getHall().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("SQL problem " + throwables.getMessage());
        }
    }

    @Override
    public void update(Movie movie) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(UPDATE_MOVIE_QUERY + movie.getId())) {
            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getDescription());
            preparedStatement.setLong(3, movie.getHall().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("SQL problem " + throwables.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_MOVIE_BY_ID_QUERY + id)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("SQL problem " + e.getMessage());
        }
    }

    @Override
    public boolean existById(Long id) {
        long count = 0L;

        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(EXIST_MOVIE_BY_ID_QUERY + id)) {
            while (resultSet.next()) {
                count = resultSet.getLong("COUNT (*)");
            }
        } catch (SQLException e) {
            System.out.println("SQL problem " + e.getMessage());
        }
        return count == 1;
    }

    @Override
    public Movie findById(Long id) {
        Movie movie = new Movie();
        //норм
        if (existById(id)) {
            try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_MOVIE_BY_ID_QUERY + id)) {
                while (resultSet.next()) {
                    movie = initMovieByResultSet(resultSet);
                }
            } catch (SQLException throwables) {
                System.out.println("SQL problem " + throwables.getMessage());
            }
        }
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_MOVIE_QUERY)) {
           while (resultSet.next()) {
               movies.add(initMovieByResultSet(resultSet));
           }
        } catch (SQLException throwables) {
            System.out.println("SQL problem " + throwables.getMessage());
        }
        return movies;
    }

    @Override
    public void deleteAllByHallId(Long hallId) {
        try (PreparedStatement preparedStatement = jpaConfig.getConnection().prepareStatement(DELETE_MOVIE_BY_HALL_ID_QUERY + hallId)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("SQL problem " + e.getMessage());
        }
    }

    @Override
    public List<Movie> findAllByHallId(Long hallId) {
        List<Movie> movies = new ArrayList<>();
        try (ResultSet resultSet = jpaConfig.getStatement().executeQuery(FIND_ALL_MOVIE_BY_HALL_ID_QUERY + hallId)) {
            movies.add(initMovieByResultSet(resultSet));
        } catch (SQLException throwables) {
            System.out.println("SQL problem " + throwables.getMessage());
        }
        return movies;
    }

    private Movie initMovieByResultSet(ResultSet resultSet) throws SQLException {
        long movieId = resultSet.getLong("m.id");
        String movieName = resultSet.getString("m.name");
        String movieDescription = resultSet.getString("description");
        long hallId = resultSet.getLong("h.id");
        String hallName = resultSet.getString("h.name");
        int hallNumOfSeat = resultSet.getInt("num_of_seat");
        Hall hall = new Hall();
        hall.setId(hallId);
        hall.setName(hallName);
        hall.setNumOfSeats(hallNumOfSeat);
        Movie movie = new Movie();
        movie.setId(movieId);
        movie.setName(movieName);
        movie.setDescription(movieDescription);
        movie.setHall(hall);
        return movie;
    }
}
//TODO sub method