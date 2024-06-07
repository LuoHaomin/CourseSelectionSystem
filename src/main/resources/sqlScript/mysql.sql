create table admin
(
    id       int auto_increment
        primary key,
    password varchar(128) not null
);

create table course
(
    id       int auto_increment
        primary key,
    number   varchar(60) charset utf8mb3 not null,
    time     varchar(40) charset utf8mb3 null,
    credit   float                       not null,
    periods  varchar(60) charset utf8mb3 not null comment 'the start time and end time of the course',
    capacity int                         null
);

create table student
(
    id            varchar(20) charset utf8mb3 not null
        primary key,
    name          varchar(8) charset utf8mb3  not null,
    password      varchar(60)                 not null,
    phoneNumber   varchar(14)                 null,
    major         varchar(20) charset utf8mb3 null,
    admissionYear int                         not null,
    gender        varchar(1) charset utf8mb3  not null
);

create table teacher
(
    id          varchar(20) charset utf8mb3 not null
        primary key,
    name        varchar(8) charset utf8mb3  null,
    password    varchar(60) charset utf8mb3 null,
    phoneNumber varchar(14)                 null,
    gender      varchar(1)                  not null
);

create table student_course
(
    student_id varchar(20) charset utf8mb3 not null,
    course_id  int                         not null,
    score      float                       null,
    primary key (student_id, course_id),
    constraint student_course_course_id_fk
        foreign key (course_id) references course (id),
    constraint student_course_student_id_fk
        foreign key (student_id) references student (id)
);

create table major_course
(
    course_number varchar(60) charset utf8mb3 not null,
    major         varchar(20) charset utf8mb3 not null,
    primary key (course_number, major)
);

create table teacher_course
(
    teacher_id nvarchar(20) not null,
    course_id  int         not null,
    constraint teacher_course_pk
        primary key (course_id, teacher_id),
    constraint teacher_course_course_id_fk
        foreign key (course_id) references course (id),
    constraint teacher_course_teacher_id_fk
        foreign key (teacher_id) references teacher (id)
);