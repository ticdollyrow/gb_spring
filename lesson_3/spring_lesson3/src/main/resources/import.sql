DROP TABLE product IF EXISTS;
CREATE TABLE IF NOT EXISTS product (id bigserial, title VARCHAR(255), cost FLOAT, PRIMARY KEY (id));
INSERT INTO product (title, cost) VALUES ('Milk', 80), ('Orange', 80), ('Meal', 80);


DROP TABLE buyer IF EXISTS;
CREATE TABLE IF NOT EXISTS buyer ( id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO buyer (name) VALUES ('John'), ('Rikki');