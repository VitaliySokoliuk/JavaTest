package ua.lviv.entities;

public class Car {

    private int id;
    private String model;
    private int maxSpeed;
    private boolean isNew;
    private Owner owner;

    public Car() {
    }

    public Car(String model, int maxSpeed, boolean isNew, Owner owner) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.isNew = isNew;
        this.owner = owner;
    }

    public Car(int id, String model, int maxSpeed, boolean isNew, Owner owner) {
        this.id = id;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.isNew = isNew;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
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
                "id=" + id +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", isNew=" + isNew +
                ", owner=" + owner +
                '}';
    }
}