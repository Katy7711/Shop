-- liquibase formatted sql

-- changeset denieva:1

CREATE TABLE IF NOT EXISTS orders
(
    id         BIGSERIAL PRIMARY KEY,
    customer_id   integer REFERENCES customers (id),
    address varchar NOT NULL,
    price_order float,
    status       varchar NOT NULL
    );
