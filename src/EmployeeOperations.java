import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeOperations {
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static AtomicInteger atomic = new AtomicInteger();

    public static Collection<Employee> getAllEmployees(){
        return employees.values();
    }

    public static Employee getEmployeesById(Integer id){
        return employees.get(id);        
    }

    public static String addEmployees(Employee employee){
        employee.setId(atomic.incrementAndGet());
        employees.put(employee.getId(), employee);
        return "employee Added Successfully!";
    }

    public static String updateEmployees(Integer id, Employee employee){
        employees.put(id,employee);
        return "employee Updated Successfully!";
    }

    public static String deleteEmployees(Integer id){
        employees.remove(id);
        return "employee Deleted Successfully!";
    }
}
