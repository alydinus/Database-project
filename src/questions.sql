-- retrive books with price more than 10
SELECT 
    b.ISBN,
    b.Title,
    b.PublicationYear,
    b.Price,
    a.Name AS AuthorName,
    a.Surname AS AuthorSurname
FROM 
    Book b
JOIN 
    Author a
ON 
    b.AuthorID = a.AuthorID
WHERE 
    b.Price > 10
ORDER BY 
    b.Price DESC;
-- find books with author name
SELECT 
    b.Title AS BookTitle,
    a.Name AS AuthorName,
    a.Surname AS AuthorSurname
FROM 
    Book b
JOIN 
    Author a
ON 
    b.AuthorID = a.AuthorID;
	-- find price of book by its name
	SELECT 
    b.Title AS BookTitle,
    SUM(b.Price * oi.Quantity) AS TotalPrice
FROM 
    Order_Items oi
JOIN 
    Book b
ON 
    oi.BookISBN = b.ISBN
WHERE 
    b.Title = 'The Shining'
GROUP BY 
    b.Title;

	--find top n books by name length
	SELECT 
    Title,
    LENGTH(Title) AS TitleLength
FROM 
    Book
ORDER BY 
    LENGTH(Title) DESC
LIMIT 4;

-- find authors with surname less than 5 letters
SELECT 
    Name, 
    Surname
FROM 
    Author
WHERE 
    LENGTH(Name) < 5;

	-- fin customer where name start with a certain letter ex: J
	SELECT 
    Name, 
    Address
FROM 
    Customer
WHERE 
    Name ILIKE 'J%';
-- find last order by date
SELECT 
    MAX(OrderDate) AS LatestOrderDate
FROM 
    Orders;




