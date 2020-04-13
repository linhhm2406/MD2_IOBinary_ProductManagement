import java.io.*;
import java.util.*;

public class ProductManagement {
    ArrayList<Product> listProduct = new ArrayList<>();
    ArrayList<Product> resultOfFinding = new ArrayList<>();
    private int idInputFromUser = 0;

    public File getTargetOfAllList() {
        return new File("management.txt");
    }

    public File getTargetOfFindList() {
        return new File("findingResult.txt");
    }

    public void inputProduct() {
        listProduct.add(new Product(1, "Television", "SamSung", 30, "Black Color"));
        listProduct.add(new Product(2, "WashingMachine", "Toshiba", 50, "Grey Color"));
        listProduct.add(new Product(3, "Dryer", "Canon", 30, "White Color"));
        listProduct.add(new Product(4, "Cleaner", "Panasonic", 10, "Black Color"));
        listProduct.add(new Product(5, "Cutter", "Vietnam", 20, "Green Color"));
    }

    public void writeProductToFile(File target, ArrayList<Product> list) {
        OutputStream os = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            os = new FileOutputStream(target);
            objectOutputStream = new ObjectOutputStream(os);

            for (Product product : list) {
                objectOutputStream.writeObject(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readProductFromFile(File target) {
        InputStream is = null;
        ObjectInputStream objectInputStream = null;

        try {
            is = new FileInputStream(target);
            objectInputStream = new ObjectInputStream(is);

            Product product;
            while ((product = (Product) objectInputStream.readObject()) != null) {
                System.out.println(product);
            }

        } catch (Exception ignored) {
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    Scanner scanner = new Scanner(System.in);

    public int inputId() {
        System.out.print("Input Product ID : ");
        return scanner.nextInt();
    }

    public String inputName() {
        scanner.nextLine();
        System.out.print("Input Product Name : ");
        return scanner.nextLine();
    }

    public String inputManufacturer() {
        System.out.print("Input Product Manufacturer : ");
        return scanner.nextLine();
    }

    public String inputDescription() {
        scanner.nextLine();
        System.out.print("Input Product Description : ");
        return scanner.nextLine();
    }

    public double inputPrice() {
        System.out.print("Input Product Price : ");
        return scanner.nextDouble();
    }

    public void writeThenReadAllList() {
        File fileToExport = getTargetOfAllList();
        writeProductToFile(fileToExport, listProduct);
        File fileToImport = getTargetOfAllList();
        readProductFromFile(fileToImport);
    }

    public void writeThenReadFindingList() {
        File fileToExport = getTargetOfFindList();
        writeProductToFile(fileToExport, resultOfFinding);
        File fileToImport = getTargetOfFindList();
        readProductFromFile(fileToImport);
    }

    public void addMoreProducts() {
        listProduct.add(new Product(inputId(), inputName(), inputManufacturer(), inputPrice(), inputDescription()));
    }

    public int getIdFromUser() {
        System.out.println("Please input id to Find/Delete : ");
        return scanner.nextInt();
    }

    public void buildFindingList() {
        idInputFromUser = getIdFromUser();
        for (Product product : listProduct) {
            if (idInputFromUser == product.getId()) {
                resultOfFinding.add(product);
            }
        }
    }

    public void findByIdThenDisplay() {
        buildFindingList();
        if (resultOfFinding.size() != 0) {
            writeThenReadFindingList();
        } else {
            System.out.println("Product not found!");
        }
    }

    public boolean isCompleteDelete() {
        idInputFromUser = getIdFromUser();
        boolean confirm = false;
        for (int i = 0; i < listProduct.size(); i++) {
            if (idInputFromUser == listProduct.get(i).getId()) {
                listProduct.remove(i);
                confirm = true;
            }
        }
        return confirm;
    }

    public void deleteThenDisplay() {
        if (isCompleteDelete()) {
            System.out.println("Delete complete!");
            writeThenReadAllList();
        } else {
            System.out.println("Product not found!");
        }
    }

    public void sortByPrice() {
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getPrice() > o2.getPrice()) ? 1 : -1;
            }
        });
    }

    public void sortByName() {
        listProduct.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
    }
}

