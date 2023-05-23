create table patients(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    identityDocument varchar(14) not null unique,
    phone varchar(20) not null,
    street varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    number varchar(100),
    complement varchar(20),
    primary key(id)


);