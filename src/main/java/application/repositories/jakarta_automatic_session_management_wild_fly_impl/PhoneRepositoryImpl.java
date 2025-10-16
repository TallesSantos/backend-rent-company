package application.repositories.jakarta_automatic_session_management_wild_fly_impl;

import application.entities.Phone;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PhoneRepositoryImpl {
  @PersistenceContext(unitName = "PhonePU")
  private EntityManager em;

  public void save(Phone phone) {
    em.persist(phone);
  }

  public Phone findById(Long id) {
    return em.find(Phone.class, id);
  }

  public List<Phone> listAll() {
    return em.createQuery("SELECT c FROM Phone",Phone.class)
        .getResultList();
  }
}
