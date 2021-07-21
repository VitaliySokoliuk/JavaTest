package ua.lviv.daos;

import org.hibernate.Session;
import ua.lviv.SessionUtil;
import ua.lviv.entities.Car;
import ua.lviv.entities.Owner;

import java.util.List;

public class CarDao {

    public CarDao() {
    }

    @SuppressWarnings(value = "unchecked")
    public List<Car> selectAll(){
        Session session = SessionUtil.getSession();
        List<Car> carList = session.createQuery("Select c from Car c").getResultList();
        session.close();
        return carList;
    }

    public Car selectById(int id){
        Session session = SessionUtil.getSession();
        Car car = session.find(Car.class, id);
        session.close();
        return car;
    }

    public boolean deleteById(int id){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Car car = session.find(Car.class, id);
        if (car != null){
            session.delete(car);
            isSuccess = true;
        }
        session.getTransaction().commit();
        session.close();
        return isSuccess;
    }

    public boolean updateAllFields(int id, String model, int maxSpeed, boolean isNew, Owner owner){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Car car = session.find(Car.class, id);
        if (car != null){
            car.setModel(model);
            car.setMaxSpeed(maxSpeed);
            car.setIsNew(isNew);
            car.setOwner(owner);
            isSuccess = true;
        }
        session.getTransaction().commit();
        session.close();
        return isSuccess;
    }

    public int insert(String model, int maxSpeed, boolean isNew, Owner owner){
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        Car car = new Car(model, maxSpeed, isNew, owner);
        session.save(car);
        session.flush();
        int id = car.getId();
        session.getTransaction().commit();
        session.close();
        return id;
    }

    public boolean existsById(int id){
        boolean isSuccess = false;
        Session session = SessionUtil.getSession();
        if (session.find(Car.class, id) != null){
            isSuccess = true;
        }
        session.close();
        return isSuccess;
    }

}
