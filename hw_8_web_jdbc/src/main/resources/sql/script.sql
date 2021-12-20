create schema if not exists minimal_cinema collate utf8_general_ci;
use minimal_cinema;
create table if not exists halls
(
    id bigint auto_increment
        primary key,
    name varchar(255) null,
    num_of_seat int null
);

create table if not exists movies
(
    id bigint auto_increment
        primary key,
    name varchar(255) null,
    description varchar(255) null,
    hall_id bigint null
);

create table if not exists hall_movie
(
    id bigint auto_increment,
    hall_id bigint null,
    movie_id bigint null,
    constraint hall_movie_id_uindex
        unique (id),
    constraint hall_id
        foreign key (hall_id) references halls (id),
    constraint movie_id
        foreign key (movie_id) references movies (id)
);

alter table hall_movie
    add primary key (id);

