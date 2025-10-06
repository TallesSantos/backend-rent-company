CREATE TABLE movie (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX) NULL,
    is_rented BIT NULL,
    rented_time DATETIME NULL
);