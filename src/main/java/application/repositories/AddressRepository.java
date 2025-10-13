package application.repositories;

import application.entities.Address;
import application.entities.Client;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AddressRepository {

  @PersistenceContext(unitName = "AddressPU")
  private EntityManager em;

  public void save(Address address) {
    em.persist(address);
  }

  public Address findById(Long id) {
    return em.find(Address.class, id);
  }

  public List<Address> listAll() {
    return em.createQuery("SELECT c FROM Address", Address.class)
        .getResultList();
  }
}

