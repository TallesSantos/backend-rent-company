package application.repositories.jakarta_automatic_session_management_wild_fly_impl;

import application.entities.User;
import application.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Named("jakartaRepo")
public class UserRepositoryJakartaImpl implements UserRepository {

  @PersistenceContext(unitName = "UserPU")
  private EntityManager em;

  public void save(User user) {
    em.persist(user);
  }

  public User findById(Long id) {
    return em.find(User.class, id);
  }

  public List<User> listAll() {
    return em.createQuery("SELECT c FROM User", User.class)
        .getResultList();
  }

  public User findUserByUsernameAndPassword(String userName, String password) {
    String stringBuilder = "SELECT u FROM User u "
        + " WHERE u.username = '" + userName + "' "
        + " AND u.password = '" + password + "' ";

    return em.createQuery(stringBuilder, User.class)
        .getResultList().stream().findFirst().orElseThrow();
  }
}