-- liquibase formatted sql

-- changeset denieva:1

CREATE TABLE IF NOT EXISTS customers
(
    id         BIGSERIAL PRIMARY KEY,
    costumer_full_name       varchar NOT NULL,
    email      varchar NOT NULL,
    number_of_phone varchar NOT NULL
);
