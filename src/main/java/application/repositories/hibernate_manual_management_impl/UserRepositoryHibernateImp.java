package application.repositories.hibernate_manual_management_impl;

import application.entities.Address;
import application.entities.Client;
import application.entities.Comment;
import application.entities.Movie;
import application.entities.Phone;
import application.entities.RentHistory;
import application.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import application.entities.User;

@ApplicationScoped
@Named("HibernateRepo")
public class UserRepositoryHibernateImp implements UserRepository {

  // SessionFactory não é mais estática inicializada na carga da classe
  private SessionFactory sessionFactory;

  // Construtor: inicializa a SessionFactory quando a instância do repositório é criada
  public UserRepositoryHibernateImp() {
    this.sessionFactory = buildSessionFactory();
  }

  // Criação da SessionFactory
  private SessionFactory buildSessionFactory() {
    try {
      Configuration cfg = new Configuration();

      // Configurações JDBC
      cfg.setProperty("hibernate.connection.driver_class", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
      cfg.setProperty("hibernate.connection.url", "jdbc:sqlserver://localhost:1433;databaseName=banco_wild_fly;encrypt=true;trustServerCertificate=true;");
      cfg.setProperty("hibernate.connection.username", "sa");
      cfg.setProperty("hibernate.connection.password", "123");

      // Dialeto SQL Server
      cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");

      // Opções recomendadas
      cfg.setProperty("hibernate.show_sql", "true");
      cfg.setProperty("hibernate.format_sql", "true");
      cfg.setProperty("hibernate.hbm2ddl.auto", "update"); // só para dev, não usar em prod

      // Mapeia suas entidades
      cfg.addAnnotatedClass(User.class);
      cfg.addAnnotatedClass(Client.class);
      cfg.addAnnotatedClass(Address.class);
      cfg.addAnnotatedClass(Comment.class);
      cfg.addAnnotatedClass(Movie.class);
      cfg.addAnnotatedClass(Phone.class);
      cfg.addAnnotatedClass(RentHistory.class);

      return cfg.buildSessionFactory();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao criar SessionFactory", e);
    }
  }

  // Método para obter sessão
  public Session openSession() {
    return sessionFactory.openSession();
  }

  // Exemplo: listar todos os usuários
  @Override
  public List<User> listAll() {
    try (Session session = openSession()) {
      return session.createQuery("FROM User", User.class).list();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao listar usuários", e);
    }
  }

  // Exemplo: salvar um usuário
  @Override
  public void save(User user) {
    try (Session session = openSession()) {
      session.beginTransaction();
      session.persist(user);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new RuntimeException("Erro ao salvar usuário", e);
    }
  }

  @Override
  public User findById(Long id) {
    try (Session session = openSession()) {
      return session.get(User.class, id);
    }
  }

  @Override
  public User findUserByUsernameAndPassword(String username, String password) {

    try (Session session = openSession()) {
      User user =  session.createQuery(
              "FROM User u  WHERE u.username = :username AND u.password = :password",
              User.class)
          .setParameter("username", username)
          .setParameter("password", password)
          .getSingleResult();

      user.getAddresses().size();
      user.getPhone().size();
      return  user;

    }
  }
}
