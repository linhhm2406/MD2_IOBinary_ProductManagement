import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        pm.inputProduct();

        int userChoice = setMenu();
        switch (userChoice) {
            case 1: {
                pm.writeThenReadAllList();
                break;
            }
            case 2: {
                pm.addMoreProducts();
                pm.writeThenReadAllList();
                break;
            }
            case 3: {
                pm.findByIdThenDisplay();
                break;
            }
            case 4: {
                pm.deleteThenDisplay();
                break;
            }
            case 5: {
                pm.sortByPrice();
                pm.writeThenReadAllList();
            }
            case 6: {
                pm.sortByName();
                pm.writeThenReadAllList();
            }
        }
    }

    public static int setMenu() {
        System.out.print("Menu : \n" +
                "1. Show all product list\n" +
                "2. Add more Product\n" +
                "3. Find Product by Id\n" +
                "4. Delete Product\n" +
                "5. Sort by Price (Low -> High)\n" +
                "6. Sort by Name (A->Z)\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Please select your choice : ");
        return scanner.nextInt();
    }
}
