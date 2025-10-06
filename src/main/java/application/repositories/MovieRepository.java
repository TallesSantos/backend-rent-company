package application.repositories;

import application.entities.Movie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MovieRepository {

  @PersistenceContext(unitName = "MoviePU")
  private EntityManager em;

  public void salvar(Movie movie) {
    em.persist(movie);
  }

  public Movie buscar(Long id) {
    return em.find(Movie.class, id);
  }

  public List<Movie> listarTodos() {
    return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
  }
}
