package ua.lviv.daos;

import org.hibernate.Session;
import ua.lviv.SessionUtil;
import ua.lviv.entities.Car;
import ua.lviv.entities.Owner;

import java.util.List;

public class OwnerDao {

    public OwnerDao() {
    }

    @SuppressWarnings(value = "unchecked")
    public List<Owner> selectAll(){
        Session session = SessionUtil.getSession();
        List<Owner> ownerList = session.createQuery("Select o from Owner o").getResultList();
        session.close();
        return ownerList;
    }

    public Owner selectById(int id){
        Session session = SessionUtil.getSession();
        Owner owner = session.find(Owner.class, id);
        session.close();
        return owner;
    }

    public boolean deleteById(int id){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Owner owner = session.find(Owner.class, id);
        if (owner != null){
            session.delete(owner);
            isSuccess = true;
        }
        session.getTransaction().commit();
        session.close();
        return isSuccess;
    }

    public boolean updateAllFields(int id, String firstName, String lastName){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Owner owner = session.find(Owner.class, id);
        if (owner != null){
            owner.setFirstName(firstName);
            owner.setLastName(lastName);
            isSuccess = true;
        }
        session.getTransaction().commit();
        session.close();
        return isSuccess;
    }

    public int insert(String firstName, String lastName){
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Owner owner = new Owner(firstName, lastName);
        session.save(owner);
        session.flush();
        int id = owner.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public boolean existsById(int id){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        if (session.find(Owner.class, id) != null){
            isSuccess = true;
        }
        session.close();
        return isSuccess;
    }
}
