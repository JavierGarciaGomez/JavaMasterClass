package S16Lambdas.l298Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 298

    SUMMARY
        -Function interfaces
        -apply()

    NOTES


    CODE

* */
public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);


        // 298 Function getLastName
        Function<Employee, String> getLastName = (Employee employee) ->{
            return employee.getName().substring(employee.getName().indexOf(' ')+1);
        };
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        // 298 Function getFirstName
        Function<Employee, String> getFirstName = (Employee employee) ->{
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };
        String firstName = getFirstName.apply(employees.get(1));
        System.out.println(firstName);

        // 298 random getting first or last name
        Random random = new Random();
        for(Employee employee:employees){
            if(random.nextBoolean()){
                System.out.println("Getting first name" + getName(getFirstName, employee));
            } else{
                System.out.println("Getting last name" + getName(getLastName, employee));
            }
        }






    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {

        System.out.println(ageText);
        System.out.println("==================");
        for(Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

    // 298
    private static String getName (Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }
}