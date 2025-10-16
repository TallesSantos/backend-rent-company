package application.repositories.automatic_session_management_wild_fly_impl;

import application.entities.Movie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

@Stateless
public class MovieRepositoryImpl {

  @PersistenceContext(unitName = "MoviePU")
  private EntityManager em;


  private Session getSession(){
    return em.unwrap(Session.class);
  }
  public void save(Movie movie) {
    getSession().persist(movie);
  }

  public Movie findById(Long id) {
    return getSession().find(Movie.class, id);
  }

  public void removeById(Long id){
    Movie movie = findById(id);
    getSession().remove(movie);
  }
  public List<Movie> listarTodos() {

    String sql = "SELECT m.* FROM movie m LEFT JOIN client c ON m.client_id = c.id";
    NativeQuery<Movie> query = getSession().createNativeQuery(sql, Movie.class);
    return query.getResultList();
  }


  public Movie findByIdWichComments(Long movieId) {

    Query<Movie> query = getSession().createQuery(
        "SELECT m FROM Movie m LEFT JOIN FETCH m.client LEFT JOIN FETCH m.comments WHERE m.id = :id",
        Movie.class);
    query.setParameter("id", movieId);
    return query.uniqueResult();
  }
}
