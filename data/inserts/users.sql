INSERT INTO [User] (name, email, documentNumber)
VALUES ('admin','admin@test.com', '1');

INSERT INTO [User] (name, email, documentNumber)
VALUES ('fulano_da_silva','fulano_da_silva@test.com', '123');

INSERT INTO phone (phoneNumber, user_id)values ('(51) 99999-9999', 2)

INSERT INTO address(country, state, city, street_address, number, comment, user_id)values(
'Brasil','RS','Tramandaí','Emancipação','999', 'Ao lado do Stock Center', 2
)

insert into permission(name, description)values('movies_CRUD','Can manage movies');
insert into permission(name, description)values('user_CRUD','Can manage users');

INSERT into user_permission(user_id, permission_id)values(2, 1);
INSERT into user_permission(user_id, permission_id)values(2, 2);

