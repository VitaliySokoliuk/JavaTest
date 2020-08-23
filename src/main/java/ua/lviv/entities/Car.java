package ua.lviv.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;
    private String model;
    @Column(name = "max_speed")
    private int maxSpeed;
    @Column(name = "is_new")
    private boolean isNew;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car() {
    }

    public Car(String model, int maxSpeed, boolean isNew, Owner owner) {
        this.carId = carId;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.isNew = isNew;
        this.owner = owner;
    }

    public Car(int carId, String model, int maxSpeed, boolean isNew, Owner owner) {
        this.carId = carId;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.isNew = isNew;
        this.owner = owner;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", isNew=" + isNew +
                ", owner=" + owner +
                '}';
    }
}
