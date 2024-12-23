import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileMonitor fileMonitor = new FileMonitor("D:\\Anul II\\files\\");

        while (true) {
            System.out.println("Enter a command (commit, info, status, checkout, exit):");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "commit":
                    fileMonitor.commit();
                    break;
                case "info":
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    fileMonitor.info(filename);
                    break;
                case "status":
                    fileMonitor.status();
                    break;
                case "checkout":
                    System.out.print("Enter commit number: ");
                    if (scanner.hasNextInt()) {
                        int commitNumber = scanner.nextInt();
                        scanner.nextLine();
                        fileMonitor.checkout(commitNumber);
                    } else {
                        System.out.println("Invalid commit number.");
                        scanner.nextLine();
                    }
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }
}
