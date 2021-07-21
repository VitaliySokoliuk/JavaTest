package ua.lviv;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.lviv.daos.CarDao;
import ua.lviv.daos.OwnerDao;
import ua.lviv.entities.Car;
import ua.lviv.entities.Owner;

public class Main {
    public static void main( String[] args ) {

        Session session = SessionUtil.getSession();

        Transaction transaction = session.beginTransaction();
        Owner owner = session.find(Owner.class, 1);
        session.persist(new Car("model3", 220, true, owner));
//        session.persist(new Car("model2", 320, true, owner));
//
        transaction.commit();
        session.close();

//        CarDao carDao = new CarDao();
//        List<Car> cars = carDao.selectAll();
//        System.out.println(cars);
//
//        Car car = carDao.selectById(2);
//        System.out.println(car);

//        boolean b = carDao.deleteById(3);
//        boolean b2 = carDao.deleteById(4);
//        System.out.println(b);
//        System.out.println(b2);

//        boolean mod = carDao.updateAllFields(3, "mod", 235, false, owner);
//        System.out.println(mod);
//
//        int mod34 = carDao.insert("mod34", 270, false, owner);
//        System.out.println(mod34);

//        System.out.println(carDao.existsById(3));
//        System.out.println(carDao.existsById(4));

        OwnerDao ownerDao = new OwnerDao();

//        List<Owner> ownerList = ownerDao.selectAll();
//        System.out.println(ownerList);
//
//        Owner owner = ownerDao.selectById(1);
//        System.out.println(owner);
//
//        boolean b = ownerDao.deleteById(1);
//        boolean b2 = ownerDao.deleteById(2);
//        System.out.println(b);
//        System.out.println(b2);
//
//        boolean b1 = ownerDao.updateAllFields(1, "qweee", "asssassa");
//        boolean b3 = ownerDao.updateAllFields(2, "qweee", "asssassa");
//        System.out.println(b1);
//        System.out.println(b3);
//
        int insert = ownerDao.insert("mjnhbgvfcd", "jnhbgvf");
        System.out.println(insert);

//        boolean b4 = ownerDao.existsById(1);
//        boolean b5 = ownerDao.existsById(2);
//        System.out.println(b4);
//        System.out.println(b5);

    }
}
