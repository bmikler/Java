import java.io.*;
import java.util.*;

public class DataStorage {

    private final static String FILENAME = "./phonebook.csv";

    private File file = new File(FILENAME);

    public DataStorage() {

        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, String> loadData() {
        File file = new File(FILENAME);
        HashMap<String, String> loadedData = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String contact = scanner.nextLine();
                String[] nameAndNumber = contact.split(";");

                loadedData.put(nameAndNumber[0],nameAndNumber[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found!");
        }

        return loadedData;
    }

    public boolean save(Map<String, Contact> phonebook) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME));

            for (Contact contact : phonebook.values()) {
                writer.write(contact.getName() + ";" + contact.getPhoneNumber());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found!");
            return false;
        }

        return true;
    }


}
