-- Tabela principal de usuários
CREATE TABLE [user] (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL
);

ALTER TABLE [user]
ADD document_number NVARCHAR(100);

ALTER TABLE [user]
ADD username NVARCHAR(100) NOT NULL;

ALTER TABLE [user]
ADD password NVARCHAR(10); NOT NULL



-- Tabela de endereços (Address), com relação 1:N com User
CREATE TABLE address (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    country NVARCHAR(100),
    state NVARCHAR(100),
    city NVARCHAR(100),
    streetAddress NVARCHAR(200),
    number NVARCHAR(20),
    comment NVARCHAR(255),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES [User](id)
);

-- Tabela de telefones (Phone), com relação 1:N com User
CREATE TABLE phone (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    phoneNumber NVARCHAR(20),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES [User](id)
);

-- Tabela de permissões
CREATE TABLE permission (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    name NVARCHAR(50) NOT NULL UNIQUE,
    description NVARCHAR(255)
);

-- Tabela de associação entre usuário e permissão (N:N)
CREATE TABLE user_permission (
    user_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, permission_id),
    FOREIGN KEY (user_id) REFERENCES [User](id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES Permission(id) ON DELETE CASCADE
);

