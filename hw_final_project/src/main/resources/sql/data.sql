INSERT INTO private_cinema_new.users (DTYPE, id, first_name, last_name, email, enabled, password, phone, role_type)
VALUES ('USER', 1, 'Ivan', 'Ivanov', 'q@mail.ru', true, '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6',
        '+380991234567', 'ROLE_USER');
INSERT INTO private_cinema_new.users (DTYPE, id, first_name, last_name, email, enabled, password, phone, role_type)
VALUES ('ADMIN', 2, null, null, 'a@mail.ru', true, '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6', null,
        'ROLE_ADMIN');
INSERT INTO private_cinema_new.users (DTYPE, id, first_name, last_name, email, enabled, password, phone, role_type)
VALUES ('USER', 3, 'Oleg', 'Olegov', 'b@mail.ru', true, '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6',
        '+380991234563', 'ROLE_USER');
INSERT INTO private_cinema_new.users (DTYPE, id, first_name, last_name, email, enabled, password, phone, role_type)
VALUES ('USER', 4, 'Vanya', 'Vavnya', 'c@mail.ru', false,
        '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6', '+380991234560', 'ROLE_USER');


INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (1,
        'Return to a world of two realities: one, everyday life; the other, what lies behind it. To find out if his reality is a construct, to truly know himself, Mr. Anderson will have to choose to follow the white rabbit once more.',
        '    Lana Wachowski', '02:28:00', 'Action, Sci-Fi',
        'https://m.media-amazon.com/images/M/MV5BMGJkNDJlZWUtOGM1Ny00YjNkLThiM2QtY2ZjMzQxMTIxNWNmXkEyXkFqcGdeQXVyMDM2NDM2MQ@@._V1_.jpg',
        2021, 'The Matrix Resurrections');
INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (2,
        'Twenty-five years after the original series of murders in Woodsboro, a new Ghostface emerges, and Sidney Prescott must return to uncover the truth.',
        '    Matt Bettinelli-Olpin, Tyler Gillett', '01:54:00', 'Horror, Mystery, Thriller',
        'https://m.media-amazon.com/images/M/MV5BM2E4ZGFmZTgtMDVkYS00ZTk0LWIzYWMtODk5OGVmYmEyMzEzXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_FMjpg_UX1000_.jpg',
        2022, 'Scream');
INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (3,
        'Two low-level astronomers must go on a giant media tour to warn mankind of an approaching comet that will destroy planet Earth.',
        '    Adam McKay', '02:18:00', 'Comedy, Drama, Sci-Fi',
        'https://ae01.alicdn.com/kf/H0937c23f19c84a3882c14d9fd97896b5b/Hot-Rare-MOVIE-Don-t-Look-Up-2021-Art-SILK-POSTER-Wall-Art-Home-Decorative-painting.jpg_Q90.jpg_.webp',
        2021, 'Don''t Look Up');
INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (4,
        'After one experiment, Johnny turns into a monster and everyone else becomes human. Now it has to be seen whether they will be able to reverse this experiment.',
        '    Derek Drymon, Jennifer Kluska', '01:27:00', 'Animation, Adventure, Comedy',
        'https://m.media-amazon.com/images/M/MV5BZWM4MzUyYTAtMGFiYy00MmRkLWIyNDktMWFlMDlmZjJmNWZmXkEyXkFqcGdeQXVyMTM1MTE1NDMx._V1_.jpg',
        2022, 'Hotel Transylvania: Transformania');
INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (5,
        'When a top-secret weapon falls into mercenary hands, a wild card CIA agent joins forces with three international agents on a lethal mission to retrieve it, while staying a step ahead of a mysterious woman who''s tracking their every move.',
        '    Simon Kinberg', '02:02:00', 'Action, Thriller',
        'https://m.media-amazon.com/images/M/MV5BNjRjMjk1MTItZGRjOC00NDhmLWExMTItY2Y4YTI2MGNmNTlkXkEyXkFqcGdeQXVyMTA3MDk2NDg2._V1_.jpg',
        2022, 'The 355');
INSERT INTO private_cinema_new.movies (id, description, director, duration, genre, image_url, relese_year, title)
VALUES (6,
        'Story of Pushpa Raj, a lorry driver in Seshachalam forests of South India, set in the backdrop of red sandalwood smuggling. Red Sandalwood is endemic to South-Eastern Ghats (mountain range) of India.',
        '    Sukumar', '02:59:00', 'Action, Adventure, Crime',
        'https://m.media-amazon.com/images/M/MV5BMmQ4YmM3NjgtNTExNC00ZTZhLWEwZTctYjdhOWI4ZWFlMDk2XkEyXkFqcGdeQXVyMTI1NDEyNTM5._V1_FMjpg_UX1000_.jpg',
        2021, 'Pushpa: The Rise - Part 1');


INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (1, 'TWO_D', 'GREEN', 35);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (2, 'THREE_D', 'BLUE', 40);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (3, 'TWO_D', 'YELLOW', 35);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (4, 'THREE_D', 'RED', 40);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (5, 'IMAX', 'BLACK', 60);



INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (1, '2022-01-12', '23:45:00', '22:00:00', 1, 4);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (2, '2022-01-17', '12:40:00', '10:00:00', 1, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (3, '2022-01-27', '15:11:00', '11:11:00', 2, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (4, '2022-02-15', '12:40:00', '10:00:00', 5, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (6, '2022-02-22', '15:40:00', '13:00:00', 5, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (7, '2022-03-01', '18:40:00', '16:00:00', 5, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (8, '2022-03-08', '21:40:00', '19:00:00', 5, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (9, '2022-02-24', '15:40:00', '13:00:00', 1, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (10, '2022-03-03', '18:40:00', '16:00:00', 1, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (11, '2022-03-10', '21:40:00', '19:00:00', 1, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (12, '2022-02-16', '12:40:00', '10:00:00', 2, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (13, '2022-02-23', '15:40:00', '13:00:00', 2, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (14, '2022-03-02', '18:40:00', '16:00:00', 2, 1);
INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (15, '2022-03-09', '21:40:00', '19:00:00', 2, 1);


INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (1, 'ECONOMY_CLASS', 1, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (2, 'ECONOMY_CLASS', 2, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (3, 'ECONOMY_CLASS', 3, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (4, 'ECONOMY_CLASS', 4, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (5, 'ECONOMY_CLASS', 5, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (6, 'ECONOMY_CLASS', 6, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (7, 'ECONOMY_CLASS', 7, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (8, 'ECONOMY_CLASS', 8, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (9, 'ECONOMY_CLASS', 9, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (10, 'ECONOMY_CLASS', 10, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (11, 'ECONOMY_CLASS', 11, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (12, 'ECONOMY_CLASS', 12, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (13, 'ECONOMY_CLASS', 13, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (14, 'ECONOMY_CLASS', 14, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (15, 'ECONOMY_CLASS', 15, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (16, 'ECONOMY_CLASS', 16, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (17, 'ECONOMY_CLASS', 17, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (18, 'ECONOMY_CLASS', 18, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (19, 'ECONOMY_CLASS', 19, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (20, 'ECONOMY_CLASS', 20, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (21, 'ECONOMY_CLASS', 21, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (22, 'ECONOMY_CLASS', 22, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (23, 'ECONOMY_CLASS', 23, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (24, 'ECONOMY_CLASS', 24, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (25, 'ECONOMY_CLASS', 25, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (26, 'ECONOMY_CLASS', 26, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (27, 'ECONOMY_CLASS', 27, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (28, 'ECONOMY_CLASS', 28, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (29, 'ECONOMY_CLASS', 29, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (30, 'ECONOMY_CLASS', 30, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (31, 'ECONOMY_CLASS', 31, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (32, 'ECONOMY_CLASS', 32, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (33, 'ECONOMY_CLASS', 33, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (34, 'ECONOMY_CLASS', 34, 1);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (35, 'ECONOMY_CLASS', 35, 1);


INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (36, 'ECONOMY_CLASS', 1, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (37, 'ECONOMY_CLASS', 2, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (38, 'ECONOMY_CLASS', 3, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (39, 'ECONOMY_CLASS', 4, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (40, 'ECONOMY_CLASS', 5, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (41, 'ECONOMY_CLASS', 6, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (42, 'ECONOMY_CLASS', 7, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (43, 'ECONOMY_CLASS', 8, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (44, 'ECONOMY_CLASS', 9, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (45, 'ECONOMY_CLASS', 10, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (46, 'ECONOMY_CLASS', 11, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (47, 'ECONOMY_CLASS', 12, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (48, 'ECONOMY_CLASS', 13, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (49, 'ECONOMY_CLASS', 14, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (50, 'ECONOMY_CLASS', 15, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (51, 'ECONOMY_CLASS', 16, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (52, 'ECONOMY_CLASS', 17, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (53, 'ECONOMY_CLASS', 18, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (54, 'ECONOMY_CLASS', 19, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (55, 'ECONOMY_CLASS', 20, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (56, 'ECONOMY_CLASS', 21, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (57, 'ECONOMY_CLASS', 22, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (58, 'ECONOMY_CLASS', 23, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (59, 'ECONOMY_CLASS', 24, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (60, 'ECONOMY_CLASS', 25, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (61, 'ECONOMY_CLASS', 26, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (62, 'ECONOMY_CLASS', 27, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (63, 'ECONOMY_CLASS', 28, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (64, 'ECONOMY_CLASS', 29, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (65, 'ECONOMY_CLASS', 30, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (66, 'ECONOMY_CLASS', 31, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (67, 'ECONOMY_CLASS', 32, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (68, 'ECONOMY_CLASS', 33, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (69, 'ECONOMY_CLASS', 34, 3);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (70, 'ECONOMY_CLASS', 35, 3);


INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (71, 'ECONOMY_CLASS', 1, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (72, 'ECONOMY_CLASS', 2, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (73, 'ECONOMY_CLASS', 3, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (74, 'ECONOMY_CLASS', 4, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (75, 'ECONOMY_CLASS', 5, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (76, 'ECONOMY_CLASS', 6, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (77, 'ECONOMY_CLASS', 7, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (78, 'ECONOMY_CLASS', 8, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (79, 'ECONOMY_CLASS', 9, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (80, 'ECONOMY_CLASS', 10, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (81, 'ECONOMY_CLASS', 11, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (82, 'ECONOMY_CLASS', 12, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (83, 'ECONOMY_CLASS', 13, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (84, 'ECONOMY_CLASS', 14, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (85, 'ECONOMY_CLASS', 15, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (86, 'ECONOMY_CLASS', 16, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (87, 'ECONOMY_CLASS', 17, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (88, 'ECONOMY_CLASS', 18, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (89, 'ECONOMY_CLASS', 19, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (90, 'ECONOMY_CLASS', 20, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (91, 'FIRST_CLASS', 21, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (92, 'FIRST_CLASS', 22, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (93, 'FIRST_CLASS', 23, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (94, 'FIRST_CLASS', 24, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (95, 'FIRST_CLASS', 25, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (96, 'FIRST_CLASS', 26, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (97, 'FIRST_CLASS', 27, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (98, 'FIRST_CLASS', 28, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (99, 'FIRST_CLASS', 29, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (100, 'FIRST_CLASS', 30, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (101, 'FIRST_CLASS', 31, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (102, 'FIRST_CLASS', 32, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (103, 'FIRST_CLASS', 33, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (104, 'FIRST_CLASS', 34, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (105, 'FIRST_CLASS', 35, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (106, 'FIRST_CLASS', 36, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (107, 'FIRST_CLASS', 37, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (108, 'FIRST_CLASS', 38, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (109, 'FIRST_CLASS', 39, 2);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (110, 'FIRST_CLASS', 40, 2);



INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (111, 'ECONOMY_CLASS', 1, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (112, 'ECONOMY_CLASS', 2, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (113, 'ECONOMY_CLASS', 3, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (114, 'ECONOMY_CLASS', 4, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (115, 'ECONOMY_CLASS', 5, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (116, 'ECONOMY_CLASS', 6, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (117, 'ECONOMY_CLASS', 7, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (118, 'ECONOMY_CLASS', 8, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (119, 'ECONOMY_CLASS', 9, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (120, 'ECONOMY_CLASS', 10, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (121, 'ECONOMY_CLASS', 11, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (122, 'ECONOMY_CLASS', 12, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (123, 'ECONOMY_CLASS', 13, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (124, 'ECONOMY_CLASS', 14, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (125, 'ECONOMY_CLASS', 15, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (126, 'ECONOMY_CLASS', 16, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (127, 'ECONOMY_CLASS', 17, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (128, 'ECONOMY_CLASS', 18, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (129, 'ECONOMY_CLASS', 19, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (130, 'ECONOMY_CLASS', 20, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (131, 'FIRST_CLASS', 21, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (132, 'FIRST_CLASS', 22, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (133, 'FIRST_CLASS', 23, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (134, 'FIRST_CLASS', 24, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (135, 'FIRST_CLASS', 25, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (136, 'FIRST_CLASS', 26, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (137, 'FIRST_CLASS', 27, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (138, 'FIRST_CLASS', 28, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (139, 'FIRST_CLASS', 29, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (140, 'FIRST_CLASS', 30, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (141, 'FIRST_CLASS', 31, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (142, 'FIRST_CLASS', 32, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (143, 'FIRST_CLASS', 33, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (144, 'FIRST_CLASS', 34, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (145, 'FIRST_CLASS', 35, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (146, 'FIRST_CLASS', 36, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (147, 'FIRST_CLASS', 37, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (148, 'FIRST_CLASS', 38, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (149, 'FIRST_CLASS', 39, 4);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (150, 'FIRST_CLASS', 40, 4);


INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (151, 'FIRST_CLASS', 1, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (152, 'FIRST_CLASS', 2, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (153, 'FIRST_CLASS', 3, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (154, 'FIRST_CLASS', 4, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (155, 'FIRST_CLASS', 5, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (156, 'FIRST_CLASS', 6, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (157, 'FIRST_CLASS', 7, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (158, 'FIRST_CLASS', 8, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (159, 'FIRST_CLASS', 9, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (160, 'FIRST_CLASS', 10, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (161, 'FIRST_CLASS', 11, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (162, 'FIRST_CLASS', 12, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (163, 'FIRST_CLASS', 13, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (164, 'FIRST_CLASS', 14, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (165, 'FIRST_CLASS', 15, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (166, 'FIRST_CLASS', 16, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (167, 'FIRST_CLASS', 17, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (168, 'FIRST_CLASS', 18, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (169, 'FIRST_CLASS', 19, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (170, 'FIRST_CLASS', 20, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (171, 'FIRST_CLASS', 21, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (172, 'FIRST_CLASS', 22, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (173, 'FIRST_CLASS', 23, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (174, 'FIRST_CLASS', 24, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (175, 'FIRST_CLASS', 25, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (176, 'FIRST_CLASS', 26, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (177, 'FIRST_CLASS', 27, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (178, 'FIRST_CLASS', 28, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (179, 'FIRST_CLASS', 29, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (180, 'FIRST_CLASS', 30, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (181, 'FIRST_CLASS', 31, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (182, 'FIRST_CLASS', 32, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (183, 'FIRST_CLASS', 33, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (184, 'FIRST_CLASS', 34, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (185, 'FIRST_CLASS', 35, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (186, 'FIRST_CLASS', 36, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (187, 'FIRST_CLASS', 37, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (188, 'FIRST_CLASS', 38, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (189, 'FIRST_CLASS', 39, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (190, 'FIRST_CLASS', 40, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (191, 'FIRST_CLASS', 41, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (192, 'FIRST_CLASS', 42, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (193, 'FIRST_CLASS', 43, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (194, 'FIRST_CLASS', 44, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (195, 'FIRST_CLASS', 45, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (196, 'FIRST_CLASS', 46, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (197, 'FIRST_CLASS', 47, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (198, 'FIRST_CLASS', 48, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (199, 'FIRST_CLASS', 49, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (200, 'FIRST_CLASS', 50, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (201, 'FIRST_CLASS', 51, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (202, 'FIRST_CLASS', 52, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (203, 'FIRST_CLASS', 53, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (204, 'FIRST_CLASS', 54, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (205, 'FIRST_CLASS', 55, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (206, 'FIRST_CLASS', 56, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (207, 'FIRST_CLASS', 57, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (208, 'FIRST_CLASS', 58, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (209, 'FIRST_CLASS', 59, 5);
INSERT INTO private_cinema_new.cinema_seats (id, cinema_seat_type, seat_number, cinema_hall_id)
VALUES (210, 'FIRST_CLASS', 60, 5);


INSERT INTO private_cinema_new.bookings (id, booking_status, number_of_seats, timestamp, total_price, show_id, user_id)
VALUES (1, 'SUCCESS', 1, '2022-02-08 00:57:16', 50, 3, 3);

INSERT INTO private_cinema_new.show_seats (id, price, show_seat_status, booking_id, cinema_seat_id, show_id)
VALUES (1, 50, 'UNAVAILABLE', 1, 1, 3);

