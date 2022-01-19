create schema if not exists private_school collate utf8_general_ci;
use private_school;

create table if not exists courses
(
    id bigint auto_increment
        primary key not null ,
    create_date date null,
        name varchar(256) null,
    course_type varchar(256) null,
    description varchar(256) null
);

create table  if not exists students
(
    id bigint auto_increment
        primary key not null ,
    create_date date null,
    first_name varchar(255) null,
    last_name varchar(255) null,
    birth_date date null,
    email varchar(255) null,
    phone varchar(255) null
);

create table  if not exists course_student
(
    course_id  bigint not null ,
    student_id bigint not null ,
    PRIMARY KEY (course_id, student_id) ,
    constraint course_student_courses_id_fk
        foreign key (course_id) references courses (id)
            on update cascade on delete cascade,
    constraint course_student_students_id_fk
        foreign key (student_id) references students (id)
            on update cascade on delete cascade
);






