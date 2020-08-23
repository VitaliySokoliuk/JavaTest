package ua.lviv.DAOs;

import ua.lviv.EntityManagerUtils;
import ua.lviv.entities.Owner;
import javax.persistence.EntityManager;
import java.util.List;

public class OwnerDAO {

    public OwnerDAO() {
    }

    public List<Owner> selectAll(){
        EntityManager em = EntityManagerUtils.getEntityManager();
        List<Owner> resultList = (List<Owner>) em.createQuery("Select o from Owner o").getResultList();
        em.close();
        return resultList;
    }

    public Owner selectById(int id){
        EntityManager em = EntityManagerUtils.getEntityManager();
        Owner owner = em.find(Owner.class, id);
        em.close();
        return owner;
    }

    public boolean deleteById(int id){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        em.getTransaction().begin();
        Owner owner = em.find(Owner.class, id);
        if (owner != null) {
            em.remove(owner);
            isSuccess = true;
        }
        em.getTransaction().commit();
        em.close();
        return isSuccess;
    }

    public boolean updateAllFields(int id, String fName, String lName){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        Owner owner = em.find(Owner.class, id);
        if (owner != null){
            em.getTransaction().begin();
            owner.setFirstName(fName);
            owner.setLastName(lName);
            em.getTransaction().commit();
            em.close();
            isSuccess = true;
        }
        return isSuccess;
    }

    public int insert(String fName, String lName){
        EntityManager em = EntityManagerUtils.getEntityManager();
        Owner owner = new Owner(fName, lName);
        em.getTransaction().begin();
        em.persist(owner);
        em.flush();
        int ownerId = owner.getId();
        em.getTransaction().commit();
        em.close();
        return ownerId;
    }

    public boolean existsById(int id){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        if(em.find(Owner.class, id) != null)
            isSuccess = true;
        return isSuccess;
    }

}
