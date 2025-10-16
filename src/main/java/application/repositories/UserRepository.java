package application.repositories;

import application.entities.User;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public interface UserRepository {

  List<User> listAll();

  void save(User user);

  User findById(Long id);

  User findUserByUsernameAndPassword(String username, String password);
}
