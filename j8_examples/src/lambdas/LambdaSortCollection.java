/**
 * @author Juha Peltomäki
 *
 *
 * Using lambda expressions of sorting Employees in List. Note the amount of
 * verbosity which has been reduced by using the Lambda expressions. Also the
 * code is much more clearer now than it was when we used Anonymous inner
 * classes.
 */
package lambdas;

import java.util.*;

class Employee {

    public Employee(String fn, String ln, int a) {
        first = fn;
        last = ln;
        age = a;
    }
    public String first, last;
    public int age;

    @Override
    public String toString() {
        return first + " " + last+" " + age;
    }
}

public class LambdaSortCollection {

    public static void sortEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Donald", "Duck", 54));
        list.add(new Employee("Mickey", "Mouse", 34));
        list.add(new Employee("Bill", "Gates", 65));
        list.add(new Employee("Steven", "Elop", 55));
        list.add(new Employee("Jack", "Nicklaus", 23));

        //sorting with Lambda expression. 
        Collections.sort(list, (Employee p1, Employee p2) -> p1.first.compareTo(p2.first));
        System.out.println("Collection sorted by first name:");
        System.out.println(list);
        //Lambda expression with type information removed.
        Collections.sort(list, (p1, p2) -> p2.last.compareTo(p1.last));
        System.out.println("Collection reverse sorted by last name:");
        System.out.println(list);
        //sort by age

        Collections.sort(list, (p1, p2) -> p1.age - p2.age);

        System.out.println("Collection sorted by age:");
        System.out.println(list);

    }

    public static void main(String args[]) {
        sortEmployees();
    }
}
