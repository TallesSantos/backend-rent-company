package application.repositories;

import application.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class UserRepository {

  @PersistenceContext(unitName = "UserPU")
  private EntityManager em;

  public void save(User user) {
    em.persist(user);
  }

  public User findById(Long id) {
    return em.find(User.class, id);
  }

  public List<User> listAll() {
    return em.createQuery("SELECT c FROM User",User.class)
        .getResultList();
  }

  public User findUserByUsernameAndPassword(String userName, String password) {
    String stringBuilder = "SELECT u FROM User u "
        + " WHERE u.username = '" + userName + "' "
        + " AND u.password = '" + password + "' ";

    return em.createQuery(stringBuilder,User.class)
        .getResultList().stream().findFirst().orElseThrow();
  }
}
