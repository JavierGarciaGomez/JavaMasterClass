package S16Lambdas.l299ChainingFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

/*
 298

    SUMMARY
        -Chaining functions
        -andThen
        -BiFunction
        -

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

        // 299
        System.out.println("--------------299------------------------------");
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName2 = name -> name.substring(0, name.indexOf(' '));
        Function chainedFunction = upperCase.andThen(firstName2);
        System.out.println(chainedFunction.apply(employees.get(0)));

        //299 BiFunction
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");




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
