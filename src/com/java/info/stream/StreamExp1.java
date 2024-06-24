package com.java.info.stream;

import com.java.info.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExp1 {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 28, 160, "M", "IT", "Blore", 2010));


        //1.Group the Employees by city.
        Map<String, List<Employee>> empByCity;
        empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        //System.out.println("Employees grouped by city :: \n" + empByCity);

//        empByCity.forEach((city, employees) -> {
//            System.out.println(city + " :: ");
//            employees.forEach(employee -> System.out.println("\t" + employee));
//        });


       //2. Group the Employees by age.

        Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.
                groupingBy(Employee::getAge));
        //System.out.println("Employees grouped by age :: \n" + empByAge);

        empByAge.forEach((age, employees) -> {
//            System.out.println(age + " :: ");
//            employees.forEach(employee -> System.out.println("\t" + employee));
        });


        //3. Find the count of male and female employees present in the organization.
        Map<String, Long> noOfMaleAndFemaleEmployees  =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
       // System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);

        //4. Print the names of all departments in the organization.
//        System.out.println("Names of all departments in the organization ");
//        empList.stream().map(Employee::getDeptName).distinct().
//                forEach(System.out::println);


        //5. Print employee details whose age is greater than 28.
        List<Employee> empListAbove28 = empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList());
       // System.out.println("empListAbove28 :: " + empListAbove28);


       // 6. Find maximum age of employee.
        OptionalInt maxAgeMethod1 = empList.stream()
                .mapToInt(Employee::getAge)
                //.peek(e-> System.out.println(e))
                .max();
//        if (maxAgeMethod1.isPresent())
//            System.out.println("Maximum age of Employee: " + maxAgeMethod1.getAsInt());

        int maxAgeMethod2 = empList.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .get()
                .getAge();
       // System.out.println("Maximum age of Employee: " + maxAgeMethod2);


        // 7. Print Average age of Male and Female Employees

        //Method 1
        Map<String, Double> avgAge = empList.stream().collect(Collectors.groupingBy
                (Employee::getGender,Collectors.averagingInt(
                        Employee::getAge)));
       // System.out.println("Average age of Male and Female Employees:: " + avgAge);

        //Method 2
        Map<String, Double> averageAges = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
//        System.out.println("Average age of male employees: " + averageAges.get("M"));
//        System.out.println("Average age of female employees: " + averageAges.get("F"));


       // 8. Print the number of employees in each department.

        Map<String, Long> countByDept = empList.stream().collect(Collectors.groupingBy
                (Employee::getDeptName,Collectors.counting()));
//        System.out.println("No of employees in each department");
//        for(Map.Entry<String, Long> entry : countByDept.entrySet())
//        {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }


       // 9. Find oldest employee.
        Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
        Employee oldestEmployee = oldestEmp.get();
        //System.out.println("Oldest employee details:: \n" + oldestEmployee);


        //10. Find youngest female employee.
        Employee youngestFemaleEmp = empList.stream()
                .filter(e->e.getGender().equals("F"))
                .min(Comparator.comparingInt(Employee::getAge))
                .get();

      //  System.out.println("youngestFemaleEmp :: " + youngestFemaleEmp);

        //12. Find the department name which has the highest number of employees.
        Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting()))
                .entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .get();
        //System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());

        //13. Find if there any employees from HR Department
        Optional<Employee> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
       // emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));

       // 14. Find the department names that these employees work for, where the number of
        // employees in the department is over 3.

//        System.out.println("Department names where the number of employees in the department is over 3 :: ");
//        empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
//                entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);

        //15 . Find distinct department names that employees work for.
//        System.out.println("Distinct department names that employees work for:: ");
//        empList.stream().map(Employee::getDeptName).distinct().
//                forEach(System.out::println);

        //16. Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
//        empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
//                .sorted(Comparator.comparing(Employee::getName))
//                .forEach(e -> System.out.println("Employees staying in Blore order by Asc:: " + e.getName()));

        //reversed
//        empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
//                .sorted(Comparator.comparing(Employee::getName).reversed())
//                .forEach(e -> System.out.println("Employees staying in Blore order by Desc:: " + e.getName()));

        //18. Find employee count in every department
//        Map<String, Long> employeeCountInDepartmentMap = empList.stream().collect(Collectors.
//                groupingBy(Employee::getDeptName, Collectors.counting()));
//        System.out.print("Employee department and its count :- \n"
//                + employeeCountInDepartmentMap);
//
//
//        //19. Find the department which has the highest number of employees.
//        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
//        if (deptNameWithHighestEmp.isPresent()) {
//            System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
//        }


       // 20. Sorting a Stream by age and name fields.

        //Method 1
        System.out.println("Sorting based on name and age:: ");
       Comparator<Employee> comparator1 = Comparator.comparingInt(Employee::getAge);
       Comparator<Employee> comparator2 = Comparator.comparing(Employee::getName);
       empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        System.out.println("\n");
        //Method 2
        empList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);


    }
}
