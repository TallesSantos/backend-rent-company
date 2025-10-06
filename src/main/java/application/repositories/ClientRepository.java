package application.repositories;

import application.entities.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClientRepository {

  @PersistenceContext(unitName = "ClientPU")
  private EntityManager em;

  public void salvar(Client cliente) {
    em.persist(cliente);
  }

  public Client buscar(Long id) {
    return em.find(Client.class, id);
  }

  public List<Client> listarTodos() {
    return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
  }
}
