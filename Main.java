import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define an Item class to represent inventory items
class Item {
    private String itemName;
    private int quantity;
    private String unitOfMeasurement;

    public Item(String itemName, int quantity, String unitOfMeasurement) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }
}

// Define an InventoryManager class to manage the inventory
class InventoryManager {
    private List<Item> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void updateItemQuantity(String itemName, int newQuantity) {
        for (Item item : inventory) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void removeItem(String itemName) {
        inventory.removeIf(item -> item.getItemName().equals(itemName));
    }

    public List<Item> listItems() {
        return new ArrayList<>(inventory);
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Update Item Quantity");
            System.out.println("3. Remove Item");
            System.out.println("4. List Items");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter unit of measurement: ");
                    String unitOfMeasurement = scanner.nextLine();
                    Item item = new Item(name, quantity, unitOfMeasurement);
                    inventoryManager.addItem(item);
                    System.out.println("Item added to inventory.");
                    break;
                case 2:
                    System.out.print("Enter item name to update: ");
                    String itemNameToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();
                    inventoryManager.updateItemQuantity(itemNameToUpdate, newQuantity);
                    System.out.println("Item quantity updated.");
                    break;
                case 3:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    inventoryManager.removeItem(itemToRemove);
                    System.out.println("Item removed from inventory.");
                    break;
                case 4:
                    List<Item> items = inventoryManager.listItems();
                    if (items.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.println("Inventory Items:");
                        for (Item i : items) {
                            System.out.println("Item: " + i.getItemName() + ", Quantity: " + i.getQuantity() + " " + i.getUnitOfMeasurement());
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }
}


