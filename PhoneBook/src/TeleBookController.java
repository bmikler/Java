
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TeleBookController {

    private Scanner scanner = new Scanner(System.in);
    private TeleBook teleBook = new TeleBook();

    public TeleBookController(){
        DataStorage storage = new DataStorage();
        HashMap<String, String> contacts = storage.loadData();

        for (String name : contacts.keySet()) {
            teleBook.addContact(name, contacts.get(name));
        }

    }

    public void loop() {

        Menu option = null;

        do {
            Menu.printMenu();
            try {
                option = getOption();

                switch (option) {
                    case SHOW_ALL -> {
                        teleBook.printAll();
                    }
                    case ADD -> {
                        addContact();
                    }
                    case SEARCH -> {
                        search();
                    }
                    case REMOVE -> {
                        remove();
                    }
                    case EXIT -> {
                        DataStorage storage = new DataStorage();
                        storage.save(teleBook.getPhoneBook());
                        break;
                    }
                }
            } catch (NoSuchElementException | NumberFormatException e) {
                System.out.println("Wrong input!");
            }

        } while (option != Menu.EXIT);
    }

    private Menu getOption() {

        int option = Integer.parseInt(scanner.nextLine());
        return Menu.getOption(option);

    }

    private void addContact() {
        System.out.println("Prompt name: ");
        String name = scanner.nextLine();
        System.out.println("Prompt number: ");
        String number = scanner.nextLine();

        if (teleBook.addContact(name, number)) {
            System.out.println("Number saved!");
        } else {
            System.out.println("Error! Number or name is empty!");
        }
    }

    private void search() {
        System.out.println("Prompt name or number: ");
        String input = scanner.nextLine();
        LinkedList<Contact> contacts = teleBook.search(input);
        if (!contacts.isEmpty()) {
            System.out.println(contacts);
        } else {
            System.out.println("No contatcts found");
        }
    }

    private void remove() {
        System.out.println("Prompt name to remove: ");
        String name = scanner.nextLine();
        if (teleBook.removeContact(name)) {
            System.out.println("Contact removed");
        } else {
            System.out.println("Contact not found");
        }

    }

}
