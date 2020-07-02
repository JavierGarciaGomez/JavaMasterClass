package S16Lambdas.l294LambdaNestedBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 294

    SUMMARY
        -Assign lambdas to variables and reuse them (return)
        -Lambdas witch classess that aren't static

    NOTES
        -Assign lambdas to variables and reuse them, but if it has more than one statement, We need to use the return keyword.
        -the lambda expression isnt a class, instead is threated as a nested code of block
        -

    CODE
        -1: lambda to a variable and return
        -2: lambda with classes that arent static

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
        new Thread(() -> System.out.println("Printing from the Lambda Runnable")).start();

        // Lambda with multiple lines
        new Thread(() -> {
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

        for (Employee e : employees) {
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
                employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        //293 The same using lambda
        UpperConcat uc = (s1, s2) -> (s1.toUpperCase()) + s2.toUpperCase();
        sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);


        // ********************************** 294 *************************************** //

        // 294 lambda with return
        // implementing the method with a lambda and assigning it to a variable
        UpperConcat uc2 = (s1, s2) -> {
            System.out.println("*********** 294 ********************");
            String result = "l294 Lambda with a return " + s1.toUpperCase() +" "+ s2.toUpperCase();
            return result;
        };
        sillyString = doStringStuff(uc2, employees.get(0).getName(), employees.get(1).getName());
        System.out.println("\n294 PRINTING DOSTRING STUFF "+sillyString);


        //294
        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println("\n294 PRINTING FROM ANOTHER CLASS: \n"+s);

        // 294
        s = anotherClass.doSomethingLambda();
        System.out.println(s);

        s=anotherClass.doSomethingLambdaBis();
        System.out.println(s);

        s=anotherClass.doSomethingLambdaTer();
        System.out.println(s);


    }

    //293
    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class CodeToRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

class Employee {
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
interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

// 294
class AnotherClass {
    public String doSomething() {
        System.out.println("DO SMTH The another class name is : " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("DO SMTH The anonymous class name is : " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1 FROM doSmth ", "String2 FROM doSmth");
    }

    public String doSomethingLambda() {
        System.out.println("\n 294 DO SOMETHING LAMBDA");
        UpperConcat uc = (s1, s2) -> {
            System.out.println("294 DO SMTHLAMBDA The lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
        System.out.println("DO SMTHLAMBDA The another class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");
    }

    public String doSomethingLambdaBis() {
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    return s1.toUpperCase()+s2.toUpperCase();
                }
            };
            System.out.println("\n294 DO SMTHLAMBDABIS The another class's name is " + getClass().getSimpleName());
            return Main.doStringStuff(uc, "String 1", "String 2");
        }
    }

    public String doSomethingLambdaTer() {
        final int i = 0;
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("i within anonymous "+i);
                    return s1.toUpperCase()+s2.toUpperCase();
                }
            };
            System.out.println("DO SMTHLAMBDATER class name"+getClass().getSimpleName());
            System.out.println("i ="+i);
            return Main.doStringStuff(uc,"String 1", "String 2");
        }
    }

}