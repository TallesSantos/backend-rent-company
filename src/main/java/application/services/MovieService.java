package application.services;


import application.converters.MovieConverter;
import application.dtos.MovieDTO;
import application.endpoints_rest.request.CommentRequest;
import application.endpoints_soap.request.CreateMovieRequest;
import application.endpoints_soap.request.UpdateMovieRequest;
import application.entities.Client;
import application.entities.Comment;
import application.entities.Movie;
import application.repositories.automatic_session_management_wild_fly_impl.ClientRepositoryImpl;
import application.repositories.automatic_session_management_wild_fly_impl.CommentRepositoryImpl;
import application.repositories.automatic_session_management_wild_fly_impl.MovieRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class MovieService {

  @Inject
  private MovieRepositoryImpl movieRepositoryImpl;

  @Inject
  private ClientRepositoryImpl clientRepositoryImpl;

  @Inject
  private CommentRepositoryImpl commentRepositoryImpl;

  public List<MovieDTO> listAll() {
    return movieRepositoryImpl.listarTodos().stream()
        .map(MovieConverter::toDto).collect(
        Collectors.toList());
  }

  public Movie findById(Long id){
    return  movieRepositoryImpl.findById(id);
  }

  public void createMovie(CreateMovieRequest request){
      Movie movie = new Movie();
      movie.setName(request.getName());
      movie.setDescription(request.getDescription());
      movie.setImageUrl(request.getImageUrl());
      movie.setRented(false);
      movieRepositoryImpl.save(movie);
  }

  public void updateMovie(UpdateMovieRequest request) throws Exception {

    if(request.getId() == null){
      throw new Exception("property id cannot be null");
    }

    Movie movie = movieRepositoryImpl.findById((long)request.getId());

    if(request.getName() != null){
      movie.setName(request.getName());
    }

    if(request.getDescription() != null){
      movie.setDescription(request.getDescription());
    }

    if(request.getImageUrl() != null){
      movie.setImageUrl(request.getImageUrl());
    }
    movieRepositoryImpl.save(movie);

  }

  public void deleteMovie(Long id) throws Exception {
    if(id == null){
      throw new Exception("id cannot be null");
    }
    movieRepositoryImpl.removeById(id);
  }

  public Comment findCommentById(Long commentId){
    return commentRepositoryImpl.findById(commentId);
  }
  public void saveComment(Comment comment){
    commentRepositoryImpl.save(comment);
  }

  public void createMovieComment(Long movieId, CommentRequest request) {
    Movie movie =  movieRepositoryImpl.findByIdWichComments(movieId);
    Client client = clientRepositoryImpl.findById(request.getClientId());

    Comment comment = new Comment();
    comment.setPublishedAt(LocalDateTime.now());
    comment.setClient(client);
    comment.setCommentText(request.getCommentText());
    comment.setMovie(movie);
    movie.getComments().add(comment);

    commentRepositoryImpl.save(comment);
    movieRepositoryImpl.save(movie);
  }

  public void createChildrenComment(Long movieId, Long commentId, CommentRequest request) {
    Movie movie = movieRepositoryImpl.findById(movieId);
    Client client = clientRepositoryImpl.findById(request.getClientId());
    Comment parentComment = commentRepositoryImpl.findById(commentId);

    Comment newComment = new Comment();
    newComment.setPublishedAt(LocalDateTime.now());
    newComment.setClient(client);
    newComment.setCommentText(request.getCommentText());
    newComment.setMovie(movie);

    newComment.setParent(parentComment);
    parentComment.getChildren().add(newComment);

    commentRepositoryImpl.save(newComment);
    commentRepositoryImpl.save(parentComment);
  }
}
