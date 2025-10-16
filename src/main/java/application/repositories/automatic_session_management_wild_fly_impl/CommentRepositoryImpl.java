package application.repositories.automatic_session_management_wild_fly_impl;

import application.entities.Comment;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CommentRepositoryImpl {

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
