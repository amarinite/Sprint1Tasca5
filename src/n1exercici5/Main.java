package n1exercici5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        Instrument oboe = new Instrument("oboe", 400);
        serialize(oboe);
        deserialize("instrument.ser");
    }

    public static void serialize(Instrument ins) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("instrument.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(ins);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Could not serialize object");
        }
    }

    public static void deserialize(String fileName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Instrument i2 = (Instrument) objectInputStream.readObject();
            System.out.println(i2.toString());
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not deserialize file");
        }
    }
}
