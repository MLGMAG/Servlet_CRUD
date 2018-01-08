CREATE DATABASE products;

USE products;

CREATE TABLE manufacturers (
  id   BINARY(16)   NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE products (
  id              BINARY(16)     NOT NULL PRIMARY KEY,
  name            VARCHAR(100)   NOT NULL,
  price           DECIMAL(16, 2) NOT NULL,
  manufacturer_id BINARY(16)     NOT NULL,
  FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
);