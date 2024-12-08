INSERT INTO Author (Name, Surname)
VALUES
  ('J.K.', 'Rowling'),
  ('Stephen', 'King'),
  ('J.R.R.', 'Tolkien'),
  ('Agatha', 'Christie'),
  ('Dan', 'Brown'),
  ('Jane', 'Austen'),
  ('Fyodor', 'Dostoevsky'),
  ('Leo', 'Tolstoy'),
  ('Franz', 'Kafka'),
  ('Haruki', 'Murakami');

INSERT INTO Book (ISBN, Title, PublicationYear, Price, AuthorID)
VALUES
  ('978-0-54513965-0', 'Harry Potter and the Sorcerers Stone', 1997, 12.99, 1),
  ('978-0-38550420-6', 'The Shining', 1977, 9.99, 2),
  ('978-0-547928050', 'The Lord of the Rings', 1954, 14.99, 3),
  ('978-0-00722302-1', 'Murder on the Orient Express', 1934, 8.99, 4),
  ('978-0-38550421-6', 'The Da Vinci Code', 2003, 15.99, 5),
  ('978-0-14143941-9', 'Pride and Prejudice', 1813, 10.99, 6),
  ('978-0-14018686-9', 'Crime and Punishment', 1866, 13.99, 7),
  ('978-0-14017738-6', 'War and Peace', 1869, 19.99, 8),
  ('978-0-14017739-6', 'The Trial', 1925, 11.99, 9),
  ('978-0-06088133-0', 'Norwegian Wood', 1987, 12.99, 10);

INSERT INTO Customer (Name, Address)
VALUES
  ('John Doe', '123 Main St'),
  ('Jane Smith', '456 Elm St'),
  ('Alice Johnson', '789 Oak Ave'),
  ('Bob Brown', '101 Pine St'),
  ('Emily Davis', '234 Cedar Ln'),
  ('David Miller', '567 Maple Rd'),
  ('Sarah Wilson', '890 Birch Ct'),
  ('Michael Lee', '123 Willow Ln'),
  ('Olivia Taylor', '456 Spruce St'),
  ('Ethan Clark', '789 Fir Ave');

INSERT INTO Orders (OrderDate, CustomerID)
VALUES
  ('2023-11-25', 1),
  ('2023-12-01', 2),
  ('2023-12-10', 3),
  ('2023-12-15', 4),
  ('2023-12-20', 5),
  ('2023-12-25', 6),
  ('2024-01-01', 7),
  ('2024-01-05', 8),
  ('2024-01-10', 9),
  ('2024-01-15', 10);


INSERT INTO Order_Items (OrderID, BookISBN, Quantity)
VALUES
  (1, '978-0-54513965-0', 2),
  (2, '978-0-38550420-6', 1),
  (3, '978-0-547928050', 3),
  (4, '978-0-00722302-1', 2),
  (5, '978-0-38550421-6', 1),
  (6, '978-0-14143941-9', 2),
  (7, '978-0-14018686-9', 1),
  (8, '978-0-14017738-6', 2),
  (9, '978-0-14017739-6', 1),
  (10, '978-0-06088133-0', 2);
