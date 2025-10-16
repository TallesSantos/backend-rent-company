package application.repositories.jakarta_automatic_session_management_wild_fly_impl;

import application.entities.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClientRepositoryImpl {

  @PersistenceContext(unitName = "ClientPU")
  private EntityManager em;

  public void save(Client cliente) {
    em.persist(cliente);
  }

  public Client findById(Long id) {
    return em.find(Client.class, id);
  }

  public List<Client> listAll() {
    return em.createQuery("SELECT c FROM Client c "
                                     + "LEFT JOIN FETCH c.movies "
       , Client.class).getResultList();
  }
}
