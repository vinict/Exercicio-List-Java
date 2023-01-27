package Lists;
import java.util.Scanner;
import java.util.Locale;
import ListsEntities.Employee;
import java.util.ArrayList;
import java.util.List;

public class ListFunc {
    public static void main(String[] args){
        
        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);
        
        Integer i, n, id, newId;
        String name;
        boolean check;
        double salary, percentage;
        
        Employee employee = new Employee();
        List<Employee> list = new ArrayList<>();
        
        System.out.print("How many employees will be registered? ");
        n = ler.nextInt();
        
        
    
        for(i=0; i<n; i++){
            System.out.printf("\nEmployee #%d:\n", i+1 );
            System.out.print("Id: ");
            id = ler.nextInt();
            
            while(hasId(list, id)){
                System.out.println("Id already taken! Try again: ");
		id = ler.nextInt();
            }
            
            
            System.out.print("Name: ");
            ler.nextLine();
            name = ler.nextLine();
            
            System.out.print("Salary: ");
            salary = ler.nextDouble();
            
            
            employee = new Employee(id, name, salary);            
            list.add(i, employee);
        }    
        
        System.out.print("\nEnter the employee id that will have salary increase: ");
        newId = ler.nextInt();
        
        employee = list.stream().filter(x -> x.getId() == newId).findFirst().orElse(null);
         
        if(employee == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.print("Enter the percentage: ");
            percentage = ler.nextDouble();
            employee.increaseSalary(percentage);
        } 
 
        System.out.println("\nList of employees: ");
        for(Employee x: list){
            System.out.println(x);
        }
  
        ler.close();

    }
        public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee employee = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return employee != null;
	}
}
