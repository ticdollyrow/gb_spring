DROP TABLE product IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS product (id bigserial, title VARCHAR(255), cost FLOAT, PRIMARY KEY (id));
INSERT INTO product (title, cost) VALUES ('Milk', 80), ('Orange', 80), ('Meal', 80);


DROP TABLE buyer IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS buyer ( id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO buyer (name) VALUES ('John'), ('Rikki');

DROP TABLE orders IF EXISTS CASCADE;
CREATE TABLE IF NOT EXISTS orders ( id bigserial, info VARCHAR(255), PRIMARY KEY (id));
INSERT INTO orders (info) VALUES ('one'), ('two'), ('three');

DROP TABLE orders_history IF EXISTS CASCADE;
CREATE TABLE orders_history (order_id bigint, buyer_id bigint, product_id bigint, FOREIGN KEY (order_id) REFERENCES orders (id), FOREIGN KEY (buyer_id) REFERENCES buyer (id), FOREIGN KEY (product_id) REFERENCES product (id));
INSERT INTO orders_history (order_id, buyer_id, product_id) VALUES (1,1,1), (1,1,3), (2,2,2), (3,1,2);