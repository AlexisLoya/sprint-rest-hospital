-- create table doctors
CREATE TABLE doctors (
    id bigint not null auto_increment,
    name varchar(255) not null,
    email varchar(255) not null,
    document varchar(6) not null,
    specialty varchar(255) not null,
    street varchar(255) not null,
    city varchar(255) not null,
    state varchar(255) not null,
    number varchar(255) not null,
    complement varchar(255) not null,
    primary key (id)
);