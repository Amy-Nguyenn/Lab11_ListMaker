import java.util.ArrayList;

public class ListMaker {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        boolean quit = false;

        do {
            printList(myList);
            String choice = SafeInput.getRegExString("Choose an option [A|D|I|P|Q]: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(myList);
                    break;
                case "D":
                    deleteItem(myList);
                    break;
                case "I":
                    insertItem(myList);
                    break;
                case "P":
                    printList(myList);
                    break;
                case "Q":
                    quit = quitProgram();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!quit);
    }


    private static void addItem(ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString("Enter item to add: ");
        list.add(item);
        System.out.println("Item added.");
    }


    private static void deleteItem(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        int itemNumber = SafeInput.getRangedInt("Enter item number to delete: ", 1, list.size()) - 1;
        list.remove(itemNumber);
        System.out.println("Item deleted.");
    }


    private static void insertItem(ArrayList<String> list) {
        String item = SafeInput.getNonZeroLenString("Enter item to insert: ");
        int position = SafeInput.getRangedInt("Enter position to insert at: ", 1, list.size() + 1) - 1;
        list.add(position, item);
        System.out.println("Item inserted.");
    }


    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }


    private static boolean quitProgram() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ");
    }
}
