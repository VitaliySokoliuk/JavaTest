package ua.lviv.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    @Column(name = "mex_speed")
    private int maxSpeed;
    @Column(name = "is_new")
    private boolean isNew;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "Car_Owner_FK"))
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