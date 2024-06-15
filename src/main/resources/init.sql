CREATE TABLE Author (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    bio TEXT NOT NULL
);

CREATE TABLE Book (
    isbn TEXT PRIMARY KEY,
    title TEXT NOT NULL,
    author INTEGER NOT NULL,
    CONSTRAINT fk_author FOREIGN KEY(author) REFERENCES Author(id)
);

CREATE TABLE Director (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE Movie (
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    director INTEGER REFERENCES Director(id)
);