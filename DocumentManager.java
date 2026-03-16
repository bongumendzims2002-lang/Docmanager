public class DocumentManager {

    static String fileName = "document.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Document Manager =====");
            System.out.println("1. Create Document");
            System.out.println("2. View Document");
            System.out.println("3. Edit Document");
            System.out.println("4. Delete Document");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createDocument(scanner);
                    break;

                case 2:
                    viewDocument();
                    break;

                case 3:
                    editDocument(scanner);
                    break;

                case 4:
                    deleteDocument();
                    break;

                case 5:
                    System.out.println("Program closed.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static void createDocument(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter(fileName);
            System.out.print("Enter document text: ");
            String text = scanner.nextLine();
            writer.write(text);
            writer.close();
            System.out.println("Document created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating the document.");
        }
    }

    public static void viewDocument() {
        try {
            FileReader reader = new FileReader(fileName);
            int character;
            System.out.println("\nDocument Content:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            reader.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println("Document not found.");
        }
    }

    public static void editDocument(Scanner scanner) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            System.out.print("Enter text to add: ");
            String text = scanner.nextLine();
            writer.write("\n" + text);
            writer.close();
            System.out.println("Document updated successfully.");
        } catch (IOException e) {
            System.out.println("Error editing the document.");
        }
    }

    public static void deleteDocument() {
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Document deleted successfully.");
            } else {
                System.out.println("Unable to delete the document.");
            }
        } else {
            System.out.println("Document does not exist.");
        }
    }
}
