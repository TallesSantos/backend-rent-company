package application.endpoints_rest;

import application.endpoints_rest.request.CommentRequest;
import application.entities.Comment;
import application.entities.Movie;
import application.services.ClientService;
import application.services.MovieService;
import application.services.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/movies")
public class MovieController {

  @Inject
  private UserService userService;

  @Inject
  private MovieService movieService;

  @Inject
  private ClientService clientService;

  @Path("/{movie-id}/comments")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public void createCommentInMovie(@PathParam("movie-id") Long movieId,CommentRequest request){
    movieService.createMovieComment(movieId, request);
  }

  @Path("/{movie-id}/comments/{comment-id}/comments")
  @POST
  @Produces({MediaType.APPLICATION_JSON})
  @Consumes({MediaType.APPLICATION_JSON})
  public void createChildrenComment(@PathParam("movie-id") Long movieId, @PathParam("comment-id") Long commentId, CommentRequest request){

   movieService.createChildrenComment(movieId, commentId, request);
  }

}
