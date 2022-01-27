INSERT INTO private_cinema_new.users (DTYPE, id, email, enabled, password, role_type)
VALUES ('CLIENT', 1, 'q@mail.ru', true, '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6', 'ROLE_CLIENT');
INSERT INTO private_cinema_new.users (DTYPE, id, email, enabled, password, role_type)
VALUES ('ADMIN', 2, 'a@mail.ru', true, '$2a$10$s56Kr5MkqxdsEHlW0dtHoeUzxX4BMIWWnQEoJ3zzewXMCK1z6q5w6', 'ROLE_ADMIN');



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
VALUES (1, 'TWO_D', 'GREEN', 36);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (2, 'THREE_D', 'BLUE', 40);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (3, 'TWO_D', 'YELLOW', 36);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (4, 'THREE_D', 'RED', 40);
INSERT INTO private_cinema_new.cinema_halls (id, cinema_hall_type, name, total_seats)
VALUES (5, 'IMAX', 'BLACK', 60);



INSERT INTO private_cinema_new.shows (id, date, end_time, start_time, cinema_hall_id, movie_id)
VALUES (1, '2022-01-12', '23:45:00', '22:00:00', 1, 4);
