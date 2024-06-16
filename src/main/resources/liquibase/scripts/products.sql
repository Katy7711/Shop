-- liquibase formatted sql

-- changeset denieva:1

CREATE TABLE IF NOT EXISTS products
(
    id         BIGSERIAL PRIMARY KEY,
    product_name      varchar NOT NULL,
    description      varchar NOT NULL,
    price       float NOT NULL,
    amount       integer,
    order_id     integer REFERENCES orders (id)

);