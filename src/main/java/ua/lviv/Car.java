package ua.lviv;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {

    private int carId;
    private String model;
    private int maxSpeed;
    private boolean isNew;

    public Car(int carId, String model, int maxSpeed, boolean isNew) {
        this.carId = carId;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.isNew = isNew;
    }

    public Car() {
    }

    public static Car of(ResultSet resultSet) {
        Car car = new Car();
        try {
            int car_id = resultSet.getInt("car_id");
            String model = resultSet.getString("model");
            int max_speed = resultSet.getInt("max_speed");
            boolean is_new = resultSet.getBoolean("is_new");
            car = new Car(car_id, model, max_speed, is_new);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot put data to car object in method \"of\"");
        }
        return car;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Override
    public String toString() {
        return "CarDAO{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", isNew=" + isNew +
                '}';
    }
}
