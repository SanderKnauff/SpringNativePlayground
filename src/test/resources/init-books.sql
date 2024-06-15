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

INSERT INTO Author (name, bio)
VALUES
    ('Rick Riordan', 'Uncle Rick'),
    ('Robert C. Martin', 'Uncle Bob');

INSERT INTO Book (isbn, title, author)
VALUES
    ('1', 'Percy Jackson and the Lightning Thief', (SELECT id FROM Author WHERE name = 'Rick Riordan')),
    ('2', 'Clean Code', (SELECT id FROM Author WHERE name = 'Robert C. Martin'));