import java.util.Collection;
import java.util.Scanner;

public class EmployeeManagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("WELCOME TO EMPLOYEE MANAGEMENT PROJECT");

        while(true){
            System.out.println("SELECT THE OPERATION TO PERFORM FROM THE FOLLOWING MENU:");
            System.out.println("1. ADD NEW EMPLOYEE DETAILS");
            System.out.println("2. DISPLAY ALL EMPLOYEE DETAILS");
            System.out.println("3. DISPLAY SINGLE EMPLOYEE DETAILS");
            System.out.println("4. UPDATE EMPLOYEE DETAILS");
            System.out.println("5. DELETE EMPLOYEE DETAILS");
            System.out.println("0. EXIT MENU");

            System.out.print("ENTER YOUR CHOICE: ");
            int choice = sc.nextInt();

            String name, email, role;
            int id;
            Employee emp;

            if(choice == 0)
                break;

            else{
                switch(choice){
                    case 1:System.out.print("Employee Name: ");
                    name = sc.next();
                    System.out.print("Employee Email: ");
                    email = sc.next();
                    System.out.print("Employee Role: ");
                    role = sc.next();
                    emp = new Employee(name, email, role);
                    EmployeeOperations.addEmployees(emp);
                    break;
                    case 2: Collection<Employee> Employees = EmployeeOperations.getAllEmployees();
                            System.out.println("ID\tNAME\tEMAIL\tROLE");
                            for(Employee s : Employees){
                                System.out.println(s.getId() + "\t" 
                                                + s.getName() + "\t" 
                                                + s.getEmail() + "\t"
                                                + s.getRole());
                            }
                            break;
                    case 3: System.out.print("Enter ID of the employee: ");
                            id = sc.nextInt();
                            emp = EmployeeOperations.getEmployeesById(id);
                            if(emp == null){
                                System.out.println("employee WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                System.out.println("ID: " + emp.getId()
                                                +"\nNAME: " + emp.getName()
                                                +"\nEMAIL: " + emp.getEmail()
                                                +"\nROLE1: " + emp.getRole());
                            }
                            break;
                    case 4: System.out.print("Enter ID of the employee: ");
                            id = sc.nextInt();
                            emp = EmployeeOperations.getEmployeesById(id);
                            if(emp == null){
                                System.out.println("employee WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                System.out.println("CHOOSE THE FIELD TO UPDATE:");
                                System.out.println("1. NAME");
                                System.out.println("2. EMAIL");
                                System.out.println("3. ROLE");
                                System.out.print("ENTER YOUR CHOICE: ");
                                choice = sc.nextInt();
                                switch(choice){
                                    case 1: System.out.print("employee Name: ");
                                            name = sc.next();
                                            emp.setName(name);
                                            break;
                                    case 2: System.out.print("employee Email: ");
                                            email = sc.next();
                                            emp.setEmail(email);
                                            break;
                                    case 3: System.out.print("employee Role: ");
                                            role = sc.next();
                                            emp.setRole(role);
                                            break;
                                }
                                EmployeeOperations.updateEmployees(id, emp);
                            }
                            break;
                    case 5: System.out.print("Enter ID of the Employee: ");
                            id = sc.nextInt();
                            emp = EmployeeOperations.getEmployeesById(id);
                            if(emp == null){
                                System.out.println("EMPLOYEE WITH THIS ID DOES NOT EXISTS");
                            }
                            else{
                                EmployeeOperations.deleteEmployees(id);
                            }
                            break;
                    default:System.out.println("INVALID CHOICE!");
                }
            }
        }

        sc.close();
    }
}
