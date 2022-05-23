create table if not exists products (id bigserial primary key, title varchar(255), price float);

insert into products (title, price)
values
    ('Milk', 100),
    ('Coffee', 80),
    ('Tea', 90),
    ('Bread', 21.9),
    ('Butter', 40.7);