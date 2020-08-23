package ua.lviv.DAOs;

import ua.lviv.EntityManagerUtils;
import ua.lviv.entities.Car;
import ua.lviv.entities.Owner;
import javax.persistence.EntityManager;
import java.util.List;

public class CarDAO {

    public CarDAO() {
    }

    public List<Car> selectAll(){
        EntityManager em = EntityManagerUtils.getEntityManager();
        List<Car> resultList = (List<Car>) em.createQuery("Select c from Car c").getResultList();
        em.close();
        return resultList;
    }

    public Car selectById(int id){
        EntityManager em = EntityManagerUtils.getEntityManager();
        Car car = em.find(Car.class, id);
        em.close();
        return car;
    }

    public boolean deleteById(int id){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        em.getTransaction().begin();
        Car car = em.find(Car.class, id);
        if (car != null) {
            em.remove(car);
            isSuccess = true;
        }
        em.getTransaction().commit();
        em.close();
        return isSuccess;
    }

    public boolean updateAllFields(int carId, String model, int maxSpeed, boolean isNew, Owner owner){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        Car car = em.find(Car.class, carId);
        if (car != null){
            em.getTransaction().begin();
            car.setModel(model);
            car.setMaxSpeed(maxSpeed);
            car.setNew(isNew);
            car.setOwner(owner);
            em.getTransaction().commit();
            em.close();
            isSuccess = true;
        }
        return isSuccess;
    }

    public int insert(String model, int maxSpeed, boolean isNew, Owner owner){
        EntityManager em = EntityManagerUtils.getEntityManager();
        Car car = new Car(model, maxSpeed, isNew, owner);
        em.getTransaction().begin();
        em.persist(car);
        em.flush();
        int carId = car.getCarId();
        em.getTransaction().commit();
        em.close();
        return carId;
    }

    public boolean existsById(int id){
        boolean isSuccess = false;
        EntityManager em = EntityManagerUtils.getEntityManager();
        if(em.find(Car.class, id) != null)
            isSuccess = true;
        return isSuccess;
    }

}
