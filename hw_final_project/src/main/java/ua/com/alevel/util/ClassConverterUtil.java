package ua.com.alevel.util;

import ua.com.alevel.persistence.entity.CinemaHall;
import ua.com.alevel.persistence.entity.Movie;
import ua.com.alevel.persistence.entity.Show;
import ua.com.alevel.view.dto.request.ShowRequestDto;
import ua.com.alevel.view.dto.response.CinemaHallResponseDto;
import ua.com.alevel.view.dto.response.MovieResponseDto;
import ua.com.alevel.view.dto.response.ShowResponseDto;

public final class ClassConverterUtil {

    private ClassConverterUtil() {
    }
//
//    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto) {
//        Student student = new Student();
//        student.setCreateDate(studentRequestDto.getCreateDate());
//        student.setId(studentRequestDto.getId());
//        student.setEmail(studentRequestDto.getEmail());
//        student.setBirthDate(studentRequestDto.getBirthDate());
//        student.setFirstName(studentRequestDto.getFirstName());
//        student.setLastName(studentRequestDto.getLastName());
//        student.setPhone(studentRequestDto.getPhone());
//        return student;
//    }
//
//    public static Student resultSetToStudent(ResultSet resultSet) {
//        Student student = new Student();
//        try {
//            student.setId(resultSet.getLong("id"));
//            student.setCreateDate(resultSet.getDate("create_date"));
//            student.setFirstName(resultSet.getString("first_name"));
//            student.setLastName(resultSet.getString("last_name"));
//            student.setEmail(resultSet.getString("email"));
//            student.setPhone(resultSet.getString("phone"));
//            student.setBirthDate(resultSet.getDate("birth_date"));
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//        return student;
//    }

//
//    public static Course courseRequestDtoToCourse(CourseRequestDto courseRequestDto) {
//        Course course = new Course();
//        course.setId(courseRequestDto.getId());
//        course.setCreateDate(courseRequestDto.getCreateDate());
//        course.setDescription(courseRequestDto.getDescription());
//        course.setName(courseRequestDto.getName());
//        course.setCourseType(courseRequestDto.getCourseType());
//        return course;
//    }

//    public static Course resultSetToCourse(ResultSet resultSet) {
//        Course course = new Course();
//        try {
//            course.setId(resultSet.getLong("id"));
//            course.setCreateDate(resultSet.getDate("create_date"));
//            course.setCourseType(CourseType.valueOf(resultSet.getString("course_type")));
//            course.setName(resultSet.getString("name"));
//            course.setDescription(resultSet.getString("description"));
//        } catch (SQLException e) {
//            e.getMessage();
//        }
//        return course;
//    }


//    public static CourseResponseDto courseToCourseResponseDto(Course course) {
//        CourseResponseDto courseResponseDto = new CourseResponseDto();
//        courseResponseDto.setId(course.getId());
//        courseResponseDto.setCreateDate((Date) course.getCreateDate());
//        courseResponseDto.setCourseType(course.getCourseType());
//        courseResponseDto.setName(course.getName());
//        courseResponseDto.setDescription(course.getDescription());
//        return courseResponseDto;
//    }

    public static MovieResponseDto movieToMovieResponseDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setId(movie.getId());
//        movieResponseDto.setCreateDate((Date) movie.getCreateDate());
        movieResponseDto.setDescription(movie.getDescription());
        movieResponseDto.setImageUrl(movie.getImageUrl());
        movieResponseDto.setGenre(movie.getGenre());
        movieResponseDto.setDuration(movie.getDuration());
        movieResponseDto.setDirector(movie.getDirector());
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setReleaseYear(movie.getReleaseYear());
        return movieResponseDto;
    }

    public static CinemaHallResponseDto cinemaHallToCinemaHallResponseDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCinemaHallType(cinemaHall.getCinemaHallType());
        cinemaHallResponseDto.setName(cinemaHall.getName());
        cinemaHallResponseDto.setTotalSeats(cinemaHall.getTotalSeats());
        return cinemaHallResponseDto;
    }

    public static ShowResponseDto showToShowResponseDto(Show show) {

        ShowResponseDto responseDto = new ShowResponseDto();
        responseDto.setId(show.getId());
        responseDto.setDate(show.getDate());
        responseDto.setCinemaHall(show.getCinemaHall());
        responseDto.setMovie(show.getMovie());
        responseDto.setEndTime(show.getEndTime());
        responseDto.setStartTime(show.getStartTime());
        return responseDto;

    }

    public static Show SRDtoToEntity(ShowRequestDto showRequestDto) {

        Show show = new Show();
        show.setId(showRequestDto.getId());
        show.setCinemaHall(showRequestDto.getCinemaHall());
        show.setMovie(showRequestDto.getMovie());
        show.setDate(showRequestDto.getDate());
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        return show;
    }
}
