CREATE TABLE PERSONS
(
    name           varchar(20) NOT NULL,
    surname        varchar(20) NOT NULL,
    age            int         NOT NULL,
    phone_number   varchar(20) NOT NULL,
    city_of_living varchar(30) NOT NULL,
    PRIMARY KEY (name, surname, age)
);

