
insert into [user](name, email, document_number, username, password, user_type)
					values('admin','admin@gmail', '123','admin', '123', 'ADMIN');

insert into client(name)values('client');

insert into [user](name, email, document_number, username, password, user_type, client_id)
					values('client','client@gmail', '123','client', '123', 'CLIENT', 1);

insert into client(name)values('siclano')

insert into [user](name, email, document_number, username, password, user_type, client_id)
			values('siclano','siclano@gmail', '1234', 'siclano','123', 'CLIENT', 2)

 insert into movie(name, description, is_rented)values('Senhor dos aneis 1', 'Desc senhor dois aneis 1', 0);
 insert into movie(name, description, is_rented)values('Senhor dos aneis 2', 'Desc senhor dois aneis 2', 0);
 insert into movie(name, description, is_rented)values('Senhor dos aneis 3', 'Desc senhor dois aneis 3', 0);


--Adicionando comentarios aos movies
 insert into comment(client_id, comment_text, movie_comment_id)
 			 values(1, 'comentario raiz 1',1);

 insert into comment(client_id, comment_text, movie_comment_id, comment_parent_id)
 			 values(1, 'comentario filho 2',1, 1 );

 insert into comment(client_id, comment_text, movie_comment_id,comment_parent_id )
 			 values(2, 'comentario filho 3 ', 1, 2);

 insert into comment(client_id, comment_text, movie_comment_id)
 			 values(1, 'comentario raiz 2',1);



--Adicionando like aos movies
insert into movie_like(movie_id, client_id)values(1, 1);
insert into movie_like(movie_id, client_id)values(1, 2);

--Adicionando like aos comentários

insert into comment_like(comment_id, client_id)values(2, 1);
insert into comment_like(comment_id, client_id)values(2, 2);

insert into comment_like(comment_id, client_id)values(3, 1);