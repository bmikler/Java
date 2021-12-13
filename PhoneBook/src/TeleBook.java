import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TeleBook {

    private Map<String, Contact> phoneBook = new TreeMap<>();

    public Map<String, Contact> getPhoneBook() {

        return Collections.unmodifiableMap(phoneBook);
    }

    public boolean addContact(String name, String phoneNumber) {

        if (name.length() != 0 && phoneNumber.length() != 0) {
            phoneBook.put(name, new Contact(name, phoneNumber));
            return true;
        } else {
            return false;
        }

    }

    public boolean removeContact(String name) {
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            return true;
        } else {
            return false;
        }

    }

    public LinkedList<Contact> search(String search) {

        LinkedList<Contact> contacts = new LinkedList<>();

        for (String name : phoneBook.keySet()) {
            if (name.contains(search) || phoneBook.get(name).getPhoneNumber().contains(search)) {
                contacts.add(phoneBook.get(name));
            }
        }

        return contacts;
    }

    public void printAll(){
        System.out.println("All contacts:");
        for (String name : phoneBook.keySet()){
            System.out.println(phoneBook.get(name));
        }
    }


}
