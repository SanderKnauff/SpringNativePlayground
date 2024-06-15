CREATE TABLE Director (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE Movie (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    director INTEGER NOT NULL,
    CONSTRAINT fk_director FOREIGN KEY(director) REFERENCES Director(id)
);

INSERT INTO Director (name)
VALUES
    ('Quentin Tarantino'),
    ('Chris Columbus');

INSERT INTO Movie (title, director)
VALUES
    ('Pulp Fiction', (SELECT id FROM Director WHERE name = 'Quentin Tarantino')),
    ('Home Alone', (SELECT id FROM Director WHERE name = 'Chris Columbus'));