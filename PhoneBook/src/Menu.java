import java.util.NoSuchElementException;

public enum Menu {

    SHOW_ALL("Show all contacts"),ADD("Add new contact"), SEARCH("Search"),
    REMOVE("Remove"), EXIT("Exit");

    private int number;
    private String description;

    private Menu(String description) {
        this.number = ordinal();
        this.description = description;
    }

    public static Menu getOption(int option) {
        if (option < values().length && option >= 0) {
            return values()[option];
        }

        throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        return number + " - " + description + ".";
    }

    public static void printMenu(){

        System.out.println("Chose option:");

        for(Menu option : Menu.values()) {
            System.out.println(option);
        }
    }

}
