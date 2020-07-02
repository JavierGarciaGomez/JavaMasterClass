package S16Lambdas.l292LambdaExpressionsIntro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 292

    SUMMARY
        -Lambdas
        -Funcional interfaces

    NOTES
        -In the runnable examples We write a bunch of code just yo print a few words, all the rest is just
               just to instantiate. Lambda We can reduce all that
        -Every Lambda Expression has three parts: 1-the argument list, 2-arrow token, 3-body
               in the example there is an empty argument list, the token and in the body is the code We want to run

        -How does it work? The compiler knows that one of the thread classes constructor accepts a Runnable
            parameter and in addition knows that the Runnable interface only accepts one method wich doesnt take
            any parameters. So it works when interfaces that contains just need one method to be implemented. this
            interfaces are called FUNCTIONAL INTERFACES


        *
        *
               *

    CODE
        -0 two runnable examples
        -7: lambda with multiple lines

    *
    *
* */
public class Main {
    public static void main(String[] args) {
        new Thread(new CodeToRun()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from the main Runnable");
            }
        }).start();

        // Lambda
        new Thread(()-> System.out.println("Printing from the Lambda Runnable")).start();

        // Lambda with multiple lines
        new Thread(()-> {
            System.out.println("Printing from the Lambda Runnable");
            System.out.println("Lambda line 2");
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee javier = new Employee("Javier García", 35);
        Employee alvaro = new Employee("Álvaro García", 45);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(javier);
        employees.add(alvaro);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Employee e:employees){
            System.out.println(e.getName());
        }

        // Comparator with lambda



    }
}

class CodeToRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
