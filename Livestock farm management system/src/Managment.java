import java.util.Scanner;

public class Managment {
    private static WorkerManager workerManager = new WorkerManager();
    private static StorageManager storageManager = new StorageManager();

    public static void managment(){
        Scanner s1 = new Scanner(System.in);
        int choice;
        boolean isRunning = true ;
        while (isRunning) {
        System.out.println("*****************");
        System.out.println("1. Mannage the Workers");
        System.out.println("*****************");
        System.out.println("2. Mannage the Storage");
        System.out.println("*****************");
        System.out.println("3. History of Midical Treatments");
        System.out.println("*****************");
        System.out.println("4. Type of Animals");
        System.out.println("*****************");
        System.out.println("5. Mannage the History of buy and sell");
        System.out.println("*****************");
        System.out.println("6.Tracking Of Animal");
        System.out.println("*****************");
        System.out.println("exit");
        System.out.println("*****************");
        System.out.printf("- enter your choice (1-7) - ");
        choice = s1.nextInt();
        switch (choice) {
            case 1 -> workerManager.manageWorkers();
            case 2 -> storageManager.manageStorages();
            case 3 -> System.out.println("History of Medical Treatments");
            case 4 -> System.out.println("Type of Animals");
            case 5 -> System.out.println("Manage the History of buy and sell");
            case 6 -> System.out.println("Tracking Of Animal");
            case 7 -> isRunning = false;
            default -> System.out.println("invalid choice");


            }
        }
        s1.close();
    }
        

}
