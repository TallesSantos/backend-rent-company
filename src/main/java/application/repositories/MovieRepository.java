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

  public void save(Movie movie) {
    em.persist(movie);
  }

  public Movie findById(Long id) {
    return em.find(Movie.class, id);
  }

  public void removeById(Long id){
    Movie movie = findById(id);
    em.remove(movie);
  }

  public List<Movie> listarTodos() {
    return em.createQuery("SELECT m FROM Movie m LEFT JOIN FETCH m.client", Movie.class).getResultList();
  }
}
