package phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public void writeFileCSV(String path, List<PhoneBook> phoneBookList) {
        File fileWriter;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileWriter = new File(path);
            fileOutputStream = new FileOutputStream(fileWriter);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (PhoneBook phoneBook : phoneBookList) {
                objectOutputStream.writeObject(phoneBook);
            }
            System.out.println("Ghi file thanh công");

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PhoneBook> readFileCSV(String path) {
        List<PhoneBook> list = new ArrayList<>();
        File fileReader = new File(path);
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileReader);
            objectInputStream = new ObjectInputStream(fileInputStream);

            PhoneBook phoneBook = null;
            while ((phoneBook = (PhoneBook) objectInputStream.readObject()) != null) {
                list.add(phoneBook);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (EOFException e) {
            System.out.println("Hết file");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
