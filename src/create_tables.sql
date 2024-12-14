CREATE TABLE Author
(
    AuthorID SERIAL PRIMARY KEY,
    Name     VARCHAR(100),
    Surname  VARCHAR(100)
);

CREATE TABLE Book
(
    ISBN            VARCHAR(20) PRIMARY KEY,
    Title           VARCHAR(100),
    PublicationYear INT,
    Price           NUMERIC(10, 2),
    AuthorID        INT,
    FOREIGN KEY (AuthorID) REFERENCES Author (AuthorID)
);

CREATE TABLE Customer
(
    CustomerID SERIAL PRIMARY KEY,
    Name       VARCHAR(100),
    Address    VARCHAR(255)
);


CREATE TABLE Order_Items
(
    OrderID  SERIAL,
    BookISBN VARCHAR(20),
    Quantity INT,
    PRIMARY KEY (OrderID, BookISBN),
    FOREIGN KEY (BookISBN) REFERENCES Book (ISBN)
);






