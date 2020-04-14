import java.util.Scanner;

public class Main {
    public static final int SHOW_ALL_PRODUCT = 1;
    public static final int ADD_MORE_PRODUCT = 2;
    public static final int FIND_PRODUCT_BY_ID = 3;
    public static final int DELETE_PRODUCT = 4;
    public static final int SORT_BY_PRICE = 5;
    public static final int SORT_BY_NAME = 6;

    public static void main(String[] args) {
        ProductManagement pm = new ProductManagement();
        pm.inputProduct();

        int userChoice = setMenu();
        switch (userChoice) {
            case SHOW_ALL_PRODUCT: {
                pm.writeThenReadAllList();
                break;
            }
            case ADD_MORE_PRODUCT: {
                pm.addMoreProducts();
                pm.writeThenReadAllList();
                break;
            }
            case FIND_PRODUCT_BY_ID: {
                pm.findByIdThenDisplay();
                break;
            }
            case DELETE_PRODUCT: {
                pm.deleteThenDisplay();
                break;
            }
            case SORT_BY_PRICE: {
                pm.sortByPrice();
                pm.writeThenReadAllList();
            }
            case SORT_BY_NAME: {
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
