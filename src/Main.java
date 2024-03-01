import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDatabase userDatabase = new UserDatabase();

        while (true) {
            System.out.println("\nLibrary System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM: ");
                    String nim = scanner.nextLine();
                    if (userDatabase.studentLogin(nim)) {
                        System.out.println("Successful Login as Student");
                    } else {
                        System.out.println("User Not Found");
                    }
                    break;
                case 2:
                    System.out.print("Enter your username (admin): ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password (admin): ");
                    String password = scanner.nextLine();
                    if (userDatabase.adminLogin(username, password)) {
                        System.out.println("Successful Login as Admin");
                    } else {
                        System.out.println("Admin User Not Found");
                    }
                    break;
                case 3:
                    System.out.println("Tengkyu");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}

class UserDatabase {
    // Dummy data for user credentials
    private static final String ADMIN_USERNAME = "Aqil Nurfayz";
    private static final String ADMIN_PASSWORD = "12345678";
    private static final String STUDENT_NIM = "202310370311270";

    public boolean studentLogin(String nim) {
        // Validate student login
        return nim.equals(STUDENT_NIM) && nim.length() == 15;
    }

    public boolean adminLogin(String username, String password) {
        // Validate admin login
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }
}