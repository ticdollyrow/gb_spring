DROP TABLE IF EXISTS  product;
CREATE TABLE IF NOT EXISTS product (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO product (title, cost) VALUES ('Orange', 80), ('Milk', 80), ('Brot', 80);
