DROP TABLE IF EXISTS  product;
CREATE TABLE IF NOT EXISTS product (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO product (title, cost)
VALUES ('Orange', 13);
INSERT INTO product (title, cost)
VALUES ('Milk', 4);
INSERT INTO product (title, cost)
VALUES ('Apple', 12);
