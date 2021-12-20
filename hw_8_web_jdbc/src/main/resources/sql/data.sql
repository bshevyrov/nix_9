INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (1, 'green', 12);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (2, 'yellow', 13);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (3, 'black', 14);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (4, 'white', 15);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (5, 'torques', 16);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (6, 'red', 10);
INSERT INTO minimal_cinema.halls (id, name, num_of_seat) VALUES (7, 'orange', 12);

INSERT INTO minimal_cinema.movies (id, name, description) VALUES (1, 'matrix', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (2, 'matrix2', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (3, 'matrix3', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (4, 'resident evil', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (5, 'resident evil2', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (6, 'resident evil3', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (7, 'resident evil4', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (8, 'resident evil5', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (9, 'star wars', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (10, 'star wars2', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (11, 'star wars3', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (12, 'star wars4', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (13, 'star wars5', 'asdasd');
INSERT INTO minimal_cinema.movies (id, name, description) VALUES (14, 'star wars6', 'asdasd');

INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (1,1);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (1,7);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (1,8);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (2,2);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (3,1);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (3,8);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (4,3);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (5,4);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (6,5);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (7,8);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (7,6);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (1,9);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (2,10);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (3,11);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (2,12);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (7,14);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (3,14);
INSERT INTO minimal_cinema.hall_movie(hall_id, movie_id) VALUES (4,14);