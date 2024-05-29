package n1exercici5;

import java.io.Serializable;

public class Instrument implements Serializable {
    private String name;
    private int price;

    public Instrument(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Selected instrument: " + name + ", " + price + "€";
    }
}
