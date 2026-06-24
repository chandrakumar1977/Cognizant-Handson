//singleton pattern
class Logger {

    // Create single instance
    private static Logger instance;

    // Private constructor
    private Logger() {
        System.out.println("Logger instance created");
    }

    // Method to get single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class singleton{

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();
        logger2.log("Application Running");

        System.out.println("\nChecking instances:");

        System.out.println("Logger1 HashCode: " + logger1.hashCode());
        System.out.println("Logger2 HashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Only one Logger object exists (Singleton)");
        } else {
            System.out.println("Different Logger objects created");
        }
    }
}
//Concept Summary
//private constructor
//
//→ Outside object create prevent
//
//static instance
//
//→ One shared object store
//
//getInstance()
//
//→ Object create/reuse
//
//log()
//
//→ Work perform
//
//==
//
//→ Same object check
//
//One line memory trick:
//
//Singleton = Constructor private + Static object + getInstance() + Same object for everyone