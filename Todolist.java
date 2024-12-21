import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    private ArrayList<String> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask() {
        System.out.print("Enter task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("--- To-Do List ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
            System.out.println("------------------");
        }
    }

    public void removeTask() {
        viewTasks(); // Display tasks with numbers for easy removal
        if (tasks.isEmpty()) {
            return; // Nothing to remove
        }
        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner mainScanner = new Scanner(System.in); // Separate scanner for main menu

        int choice;
        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(mainScanner.nextLine());

                switch (choice) {
                    case 1:
                        todoList.addTask();
                        break;
                    case 2:
                        todoList.viewTasks();
                        break;
                    case 3:
                        todoList.removeTask();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = 0; // Force loop to continue
            }
        } while (choice != 4);

        mainScanner.close(); // Close the main scanner
    }
}
