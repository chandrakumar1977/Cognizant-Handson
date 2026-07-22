class Task {

    int taskId;
    String taskName;
    String status;

    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    void display() {
        System.out.println("Task ID : " + taskId);
        System.out.println("Task Name : " + taskName);
        System.out.println("Status : " + status);
        System.out.println("----------------------");
    }
}

public class Taskmanagement {

    static Task head = null;

   
    static void addTask(int id, String name, String status) {

        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added.");
    }

   
    static Task searchTask(int id) {

        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }


    static void traverse() {

        Task temp = head;

        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    static void deleteTask(int id) {

        if (head == null) {
            System.out.println("List is Empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted.");
            return;
        }

        Task temp = head;

        while (temp.next != null &&
               temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted.");
        }
    }

    public static void main(String[] args) {

        addTask(101, "Design UI", "Pending");
        addTask(102, "Write Code", "In Progress");
        addTask(103, "Testing", "Pending");

        System.out.println("\nTasks:");

        traverse();

        System.out.println("\nSearching Task 102:");

        Task result = searchTask(102);

        if (result != null)
            result.display();
        else
            System.out.println("Task Not Found.");

        System.out.println("\nDeleting Task 102:");

        deleteTask(102);

        System.out.println("\nAfter Deletion:");

        traverse();
    }
}