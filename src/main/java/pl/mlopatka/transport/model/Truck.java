package pl.mlopatka.transport.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

public class Truck {

    @XmlElement(name = "id")
    private String id;
    @XmlElement(name = "capacity")
    private int capacity;

    public Truck() {
    }

    public Truck(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return capacity == truck.capacity &&
                Objects.equals(id, truck.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity);
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckId='" + id + '\'' +
                ", truckSize=" + capacity +
                '}';
    }
}
