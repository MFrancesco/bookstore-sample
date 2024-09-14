CREATE TABLE author (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    biography TEXT NOT NULL DEFAULT ''
);


CREATE TABLE publisher (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address TEXT NOT NULL DEFAULT ''
);

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    price float(4) NOT NULL,
    quantity_in_stock INT NOT NULL,
    quantity_sold INT NOT NULL,
    author_id BIGINT NOT NULL,
    publisher_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE,
    FOREIGN KEY (publisher_id) REFERENCES publisher(id) ON DELETE CASCADE
);

CREATE INDEX idx_quantity_in_stock ON book(quantity_in_stock);