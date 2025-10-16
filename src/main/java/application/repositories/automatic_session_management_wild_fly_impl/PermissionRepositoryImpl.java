package application.repositories.automatic_session_management_wild_fly_impl;

import application.entities.Permission;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PermissionRepositoryImpl {
  @PersistenceContext(unitName = "PermissionPU")
  private EntityManager em;

  public void save(Permission permission) {
    em.persist(permission);
  }

  public Permission findById(Long id) {
    return em.find(Permission.class, id);
  }

  public List<Permission> listAll() {
    return em.createQuery("SELECT c FROM Permission",Permission.class)
        .getResultList();
  }
}
