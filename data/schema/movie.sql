CREATE TABLE movie (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    description NVARCHAR(MAX) NULL,
    is_rented BIT NULL,
    rented_time DATETIME NULL
);

ALTER TABLE movie
ADD client_id BIGINT NULL;


ALTER TABLE movie
ADD image_url VARCHAR(255) NULL;
