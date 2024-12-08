CREATE TABLE Users (
    UserID SERIAL PRIMARY KEY,
    Username VARCHAR(50) UNIQUE NOT NULL, -- Уникальное имя пользователя
    Password VARCHAR(255) NOT NULL, -- Хэшированный пароль
    CustomerID INT, -- Связь с таблицей клиентов
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);