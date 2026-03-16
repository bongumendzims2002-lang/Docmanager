public class DocumentManager {

    public static void main(String[] args) { Scanner scanner = new Scanner(System.in); String 
        fileName = "document.txt";

        while (true) { System.out.println("\nDocument Manager"); System.out.println("1. Create 
            Document"); System.out.println("2. Edit Document"); System.out.println("3. Delete 
            Document"); System.out.println("4. Exit"); System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) { case 1:
                    createDocument(fileName, scanner); break;
                case 2: editDocument(fileName, scanner); break;
                case 3:
                    deleteDocument(fileName); break;
                case 4:
                    System.out.println("Exiting program..."); scanner.close(); return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void createDocument(String fileName, Scanner scanner) { try {
            FileWriter writer = new FileWriter(fileName); System.out.print("Enter text for the 
            document: "); String text = scanner.nextLine(); writer.write(text); writer.close(); 
            System.out.println("Document created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating document.");
        }
    }

    public static void editDocument(String fileName, Scanner scanner) { try {
            FileWriter writer = new FileWriter(fileName, true); System.out.print("Enter text to 
            add: "); String text = scanner.nextLine(); writer.write("\n" + text); 
            writer.close(); System.out.println("Document edited successfully.");
        } catch (IOException e) {
            System.out.println("Error editing document.");
        }
    }

    public static void deleteDocument(String fileName) { File file = new File(fileName); if 
        (file.delete()) {
            System.out.println("Document deleted successfully.");
        } else {
            System.out.println("Document not found.");
        }
    }
}
