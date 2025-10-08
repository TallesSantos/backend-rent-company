package application.endpoints_soap;


import application.dtos.MovieDTO;
import application.dtos.request.CreateMovieRequest;
import application.dtos.request.UpdateMovieRequest;
import application.services.MovieService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class MovieSoapService {

  @Inject
  private  MovieService movieService;

  @WebMethod
  public List<MovieDTO> listAll() {
    return movieService.listAll();
  }

  @WebMethod
  public void createMovie(@WebParam CreateMovieRequest request) {
     movieService.createMovie(request);
  }

  @WebMethod
  public void updateMovie(@WebParam UpdateMovieRequest request) throws Exception {
    movieService.updateMovie(request);
  }


  @WebMethod
  public void deleteMovie(@WebParam Long id) throws Exception {
    movieService.deleteMovie(id);
  }

}
