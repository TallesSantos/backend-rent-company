package application.endpoints_soap;


import application.dtos.MovieDTO;
import application.services.MovieService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
@Stateless
public class MovieSoapService {

  @Inject
  private  MovieService movieService;

  @WebMethod
  public List<MovieDTO> listarTodos() {
    return movieService.listarTodos();
  }
}
