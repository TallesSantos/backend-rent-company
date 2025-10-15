package application.services;


import application.converters.MovieConverter;
import application.dtos.MovieDTO;
import application.endpoints_rest.request.CommentRequest;
import application.endpoints_soap.request.CreateMovieRequest;
import application.endpoints_soap.request.UpdateMovieRequest;
import application.entities.Client;
import application.entities.Comment;
import application.entities.Movie;
import application.repositories.ClientRepository;
import application.repositories.CommentRepository;
import application.repositories.MovieRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class MovieService {

  @Inject
  private MovieRepository movieRepository;

  @Inject
  private ClientRepository clientRepository;

  @Inject
  private CommentRepository commentRepository;

  public List<MovieDTO> listAll() {
    return movieRepository.listarTodos().stream()
        .map(MovieConverter::toDto).collect(
        Collectors.toList());
  }

  public Movie findById(Long id){
    return  movieRepository.findById(id);
  }

  public void createMovie(CreateMovieRequest request){
      Movie movie = new Movie();
      movie.setName(request.getName());
      movie.setDescription(request.getDescription());
      movie.setImageUrl(request.getImageUrl());
      movie.setRented(false);
      movieRepository.save(movie);
  }

  public void updateMovie(UpdateMovieRequest request) throws Exception {

    if(request.getId() == null){
      throw new Exception("property id cannot be null");
    }

    Movie movie = movieRepository.findById((long)request.getId());

    if(request.getName() != null){
      movie.setName(request.getName());
    }

    if(request.getDescription() != null){
      movie.setDescription(request.getDescription());
    }

    if(request.getImageUrl() != null){
      movie.setImageUrl(request.getImageUrl());
    }
    movieRepository.save(movie);

  }

  public void deleteMovie(Long id) throws Exception {
    if(id == null){
      throw new Exception("id cannot be null");
    }
    movieRepository.removeById(id);
  }

  public Comment findCommentById(Long commentId){
    return commentRepository.findById(commentId);
  }
  public void saveComment(Comment comment){
    commentRepository.save(comment);
  }

  public void createMovieComment(Long movieId, CommentRequest request) {
    Movie movie =  movieRepository.findByIdWichComments(movieId);
    Client client = clientRepository.findById(request.getClientId());

    Comment comment = new Comment();
    comment.setPublishedAt(LocalDateTime.now());
    comment.setClient(client);
    comment.setCommentText(request.getCommentText());
    comment.setMovie(movie);
    movie.getComments().add(comment);

    commentRepository.save(comment);
    movieRepository.save(movie);
  }

  public void createChildrenComment(Long movieId, Long commentId, CommentRequest request) {
    Movie movie = movieRepository.findById(movieId);
    Client client = clientRepository.findById(request.getClientId());
    Comment parentComment =commentRepository.findById(commentId);

    Comment newComment = new Comment();
    newComment.setPublishedAt(LocalDateTime.now());
    newComment.setClient(client);
    newComment.setCommentText(request.getCommentText());
    newComment.setMovie(movie);

    newComment.setParent(parentComment);
    parentComment.getChildren().add(newComment);

    commentRepository.save(newComment);
    commentRepository.save(parentComment);
  }
}
