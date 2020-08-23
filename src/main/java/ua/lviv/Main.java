package ua.lviv;

import ua.lviv.DAOs.CarDAO;
import ua.lviv.DAOs.OwnerDAO;
import ua.lviv.entities.Car;
import ua.lviv.entities.Owner;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Owner obj = new Owner(2, "qwe", "asd");
//        Car car = new Car("roadster", 250, true, obj);
//
//        EntityManager entityManager = EntityManagerUtils.getEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(obj);
//        entityManager.persist(car);
//        entityManager.getTransaction().commit();
//        entityManager.close();

        CarDAO carDAO = new CarDAO();
//        List<Car> cars = carDAO.selectAll();
//        System.out.println(cars);

//        System.out.println(carDAO.selectById(3));
//        boolean b = carDAO.deleteById(2);
//        System.out.println(b);
//        boolean b = carDAO.updateAllFields(2, "roadster 3b", 290, false, obj);
//        System.out.println(b);
//        System.out.println(carDAO.selectById(3));

//        int cyber_truckId = carDAO.insert("cyber truck", 300, false, obj);
//        System.out.println(cyber_truckId);

//        System.out.println(carDAO.existsById(1) + " - 1");
//        System.out.println(carDAO.existsById(2) + " - 2");
//        System.out.println(carDAO.existsById(3) + " - 3");
//        System.out.println(carDAO.existsById(4) + " - 4");
//        System.out.println(carDAO.existsById(5) + " - 5");

        OwnerDAO ownerDAO = new OwnerDAO();

//        List<Owner> owners = ownerDAO.selectAll();
//        System.out.println(owners);
//
//        Owner owner = ownerDAO.selectById(3);
//        System.out.println(owner);
//
//        boolean b = ownerDAO.deleteById(2);
//        boolean b1 = ownerDAO.deleteById(4);
//        System.out.println(b);
//        System.out.println(b1);

//        boolean b = ownerDAO.updateAllFields(3, "qwerty", "asdfgh");
//        boolean b1 = ownerDAO.updateAllFields(2, "qwerty", "asdfgh");
//        System.out.println(b);
//        System.out.println(b1);

//        int insert = ownerDAO.insert("ytre", "gfdd");
//        System.out.println(insert);

        boolean b = ownerDAO.existsById(2);
        boolean b1 = ownerDAO.existsById(3);
        System.out.println(b);
        System.out.println(b1);
    }
}
