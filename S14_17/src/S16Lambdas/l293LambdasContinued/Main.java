package S16Lambdas.l293LambdasContinued;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 293

    SUMMARY


    NOTES
        -lambda can also infer the type of the variables

    CODE
        -0 Finish previous code
        -4: JavaFX
        -9: interface UpperConcat

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
        Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));

        // Comparator with lambda simplified
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));

        //293 implements the interface
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        },
                employees.get(0).getName(),employees.get(1).getName());
        System.out.println(sillyString);

        //293 The same using lambda
        UpperConcat uc = (s1, s2) -> (s1.toUpperCase())+s2.toUpperCase();
        sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

    }

    //293
    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1,s2);
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

//293
interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}