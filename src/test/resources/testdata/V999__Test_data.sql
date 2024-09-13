-- Sample Data for Authors
INSERT INTO author (id, name, biography) VALUES (1, 'Author One', 'Biography of Author One');
INSERT INTO author (id, name, biography) VALUES (2, 'Author Two', 'Biography of Author Two');

-- Sample Data for Publishers
INSERT INTO publisher (id, name, address) VALUES (1, 'Publisher One', '123 Main St');
INSERT INTO publisher (id, name, address) VALUES (2, 'Publisher Two', '456 Side St');

-- Sample Data for Books Author One
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book1', 'Book1_ISIN', 1.1, 1, 1, 1, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book2', 'Book2_ISIN', 2.2, 2, 2, 1, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book3', 'Book3_ISIN', 3.3, 3, 3, 1, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book4', 'Book4_ISIN', 4.4, 4, 4, 1, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book5', 'Book5_ISIN', 5.5, 5, 5, 1, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book6', 'Book6_ISIN', 6.6, 6, 6, 1, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book7', 'Book7_ISIN', 7.7, 7, 7, 1, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book8', 'Book8_ISIN', 8.8, 8, 8, 1, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book9', 'Book9_ISIN', 9.9, 9, 9, 1, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book10', 'Book10_ISIN', 10.10, 10, 10, 1, 2);

-- Sample Data for Books Author Two
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book11', 'Book11_ISIN', 11.11, 11, 11, 2, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book12', 'Book12_ISIN', 12.12, 12, 12, 2, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book13', 'Book13_ISIN', 13.13, 13, 13, 2, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book14', 'Book14_ISIN', 14.14, 14, 14, 2, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book15', 'Book15_ISIN', 15.15, 15, 15, 2, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book16', 'Book16_ISIN', 16.16, 16, 16, 2, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book17', 'Book17_ISIN', 17.17, 17, 17, 2, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book18', 'Book18_ISIN', 18.18, 18, 18, 2, 2);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book19', 'Book19_ISIN', 19.19, 19, 19, 2, 1);
INSERT INTO book (title, isbn, price, quantity_in_stock, quantity_sold, author_id, publisher_id) VALUES ('Book20', 'Book20_ISIN', 20.20, 20, 20, 2, 2);