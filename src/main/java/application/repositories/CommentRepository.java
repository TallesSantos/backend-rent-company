package application.repositories;

import application.entities.Comment;
import application.entities.Movie;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CommentRepository {

  @PersistenceContext(unitName = "CommentPU")
  private EntityManager em;

  public void save(Comment comment) {
    em.persist(comment);
  }

  public Comment findById(Long id) {
    return em.find(Comment.class, id);
  }

  public void removeById(Long id){
    Comment comment = findById(id);
    em.remove(comment);
  }
}
