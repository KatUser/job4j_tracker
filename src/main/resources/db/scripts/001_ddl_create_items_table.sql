create table items if not exists (
    id serial primary key,
    name text,
    created timestamp
);