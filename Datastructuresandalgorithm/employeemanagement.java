class Employee{
    int employeeid;
    String name;
    String position;
    double salary;
    Employee(int employeeid,String name,String position,double salary){     
        this.employeeid=employeeid;
        this.name=name;
        this.position=position;
        this.salary=salary;
    }
    static void display(Employee employee){
        System.out.println("Employee ID: "+employee.employeeid);
        System.out.println("Name: "+employee.name);
        System.out.println("Position: "+employee.position);
        System.out.println("Salary: "+employee.salary);
    }
}
public class employeemanagement{
    static Employee[] employees=new Employee[5];
    static int count=0;
    static void addEmployee(Employee employee){
        if(count<employees.length){
            employees[count]=employee;
            count++;
            System.out.println("Employee added successfully");
        }
        else{
            System.out.println("Array is  full");
        }
    }
    static Employee searchEmployee(int employeeeid) {
        for(int i=0;i<count;i++){
            if(employees[i].employeeid==employeeeid){
                return employees[i];
            }
            }
        return null;
    }
    static void traverseEmployees(){
        System.out.println("Employee List:");
        for(int i=0;i<count;i++){
            employees[i].display(employees[i]);
        }
    }
    static void deleteEmployee(int id) {

        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeid == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee Not Found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee Deleted.");
    }
    public static void main(String args[]){
        addEmployee(new Employee(1,"Chiranjevee","Intern",50000));
        addEmployee(new Employee(2,"Rohit","Manager",100000));
        addEmployee(new Employee(3,"Ramesh","Team Lead",80000));
        System.out.println("Searching for Employee with ID 2:");
        Employee emp=searchEmployee(2); 
        deleteEmployee(2);
        if(emp!=null){
            emp.display(emp);
        }
        else{
            System.out.println("Employee not found");
        }
        traverseEmployees();
    
    }
}