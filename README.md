**Creating list of Employee objects**

```java
List<Employee> empList = new ArrayList<>();
empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
```
##

**1.Group the Employees by city.**

```java
Map<String, List<Employee>> empByCity;
empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
System.out.println("Employees grouped by city :: \n" + empByCity);
```
##
**2. Group the Employees by age.**

```java
Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.
                                        groupingBy(Employee::getAge));
System.out.println("Employees grouped by age :: \n" + empByAge);
```

##
**3. Find the count of male and female employees present in the organization.**

```java
Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
                                              .collect(Collectors.groupingBy
                                              (Employee::getGender, Collectors.counting()));
System.out.println("Count of male and female employees present in the 
                    organization:: \n" + noOfMaleAndFemaleEmployees);
```
##

**4. Print the names of all departments in the organization.**

```java
System.out.println("Names of all departments in the organization ");
empList.stream().map(Employee::getDeptName).distinct().
forEach(System.out::println);
```
##

**5. Print employee details whose age is greater than 28.**

```java
System.out.println("Employee details whose age is greater than 28");
empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList()).
forEach(System.out::println);
```
##

**6. Find maximum age of employee.**

```java
OptionalInt max = empList.stream().mapToInt(Employee::getAge).max();
if (max.isPresent()) 
System.out.println("Maximum age of Employee: " + max.getAsInt());
```
##

**7. Print Average age of Male and Female Employees.**

```java
Map<String, Double> avgAge = empList.stream().collect(Collectors.groupingBy
                             (Employee::getGender,Collectors.averagingInt
                              Employee::getAge)));
System.out.println("Average age of Male and Female Employees:: " + avgAge);
```
##

**8. Print the number of employees in each department.**

```java
Map<String, Long> countByDept = empList.stream().collect(Collectors.groupingBy
                        (Employee::getDeptName,Collectors.counting()));
System.out.println("No of employees in each department");
for(Map.Entry<String, Long> entry : countByDept.entrySet()) 
{
   System.out.println(entry.getKey() + " : " + entry.getValue());
}
```
##

**9. Find oldest employee.**

```java
Optional<Employee> oldestEmp = empList.stream().max(Comparator.comparingInt(Employee::getAge));
Employee oldestEmployee = oldestEmp.get();
System.out.println("Oldest employee details:: \n" + oldestEmployee);
```
##

**10. Find youngest female employee.**

```java
//can use anyMatch also
Optional<Employee> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
                                  .min(Comparator.comparingInt(Employee::getAge));
Employee youngestEmployee = youngestEmp.get();
System.out.println("Youngest Female employee details:: \n" + youngestEmployee);
```
##

**11. Find employees whose age is greater than 30 and less than 30.**

```java
System.out.println("Employees whose age is greater than 25 and less than 25");
Map<Boolean, List<Employee>> partitionEmployeesByAge =
                empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

Set<Map.Entry<Boolean, List<Employee>>> empSet = partitionEmployeesByAge.entrySet();
for (Map.Entry<Boolean, List<Employee>> entry : empSet) {
  if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }
```
##

**12. Find the department name which has the highest number of employees.**
```java
Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
                                                 entrySet().stream().max(Map.Entry.comparingByValue()).get();
System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());
```
##

**13. Find if there any employees from HR Department.**
```java
Optional<Employee> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                         .findAny();
emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));
```
##

**14. Find the department names that these employees work for, where the number of employees in the department is over 3.**
```java
System.out.println("Department names where the number of employees in the department is over 3 :: ");
empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);
```
##


**15.Find distinct department names that employees work for.**
```java
System.out.println("Distinct department names that employees work for:: ");
 empList.stream().map(Employee::getDeptName).distinct().
 forEach(System.out::println);
```
##



**16.Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.**
```java
empList.stream().filter(e -> e.getCity().equalsIgnoreCase("Blore"))
.sorted(Comparator.comparing(Employee::getName))
.forEach(e -> System.out.println("Employees staying in Blore:: " + e.getName()));
```
##


**17. No of employees in the organisation.**
```java
System.out.println("No of employees in the organisation :: " + empList.stream().count());

```
##


**18. Find employee count in every department**
```java
Map<String, Long> employeeCountInDepartmentMap = empList.stream().collect(Collectors.
                                                 groupingBy(Employee::getDeptName, Collectors.counting()));
 System.out.print("Employee department and its count :- \n"
                + employeeCountInDepartmentMap);

```
##


**19. Find the department which has the highest number of employees.**
```java
Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
if (deptNameWithHighestEmp.isPresent()) {
    System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
}

```
##

**20. Sorting a Stream by age and name fields.**
```java
System.out.println("Sorting based on name and age:: ");
Comparator<Employee> comparator1 = Comparator.comparing(Employee::getName);
Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::getAge);
empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);
```
##


**21. Highest experienced employees in the organization..**
```java
Optional<Employee> seniorEmp = empList.stream().sorted(Comparator
                               .comparingInt(Employee::getYearOfJoining)).findFirst();
System.out.println("Senior Employee Details :" + seniorEmp.get());
```
##

**22. Print average and total salary of the organization.**
```java
DoubleSummaryStatistics empSalary = empList.stream().collect(Collectors
                                    .summarizingDouble(Employee::getSalary));
System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
System.out.println("Total Salary in the organisation  = " + empSalary.getSum());
```
##

**23. Print Average salary of each department.**
```java
System.out.println("Print Average salary of each department");
Map<String, Double> avgSalary = empList.stream().collect(Collectors.groupingBy
                               (Employee::getDeptName,
                                Collectors.averagingDouble(Employee::getSalary)));
 Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
 for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
 }
```
##

**24. Find Highest salary in the organisation.**
```java
Optional<Employee> empHighest = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .findFirst();
System.out.println("Highest Salary in the organisation : " + empHighest.get().getSalary());
```
##

**25. Find Second Highest salary in the organisation.**
```java
optional<Employee> emp2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                         .reversed()).skip(1).findFirst();
System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());
```
##

**26. Nth Highest salary.**
```java
int n = 10;// this can be any nth number highest salary
Optional<Employee> emp2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                         .reversed()).skip(n-1).findFirst();
System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());
```
##

**27. Find highest paid salary in the organisation based on gender.**
```java
Map<String, Optional<Employee>> highestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender, 
                                                        Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
System.out.println("Highest paid male and female employee : " + highestPaidMFEmployee);
```
##

**28. Find lowest paid salary in the organisation based in the organisation.**
```java
Map<String, Optional<Employee>> lowestPaidMFEmployee = empList.stream().collect(Collectors.groupingBy(Employee::getGender, 
                                                       Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);

```
##


**29. Sort the employees salary in the organisation in ascending order.**
```java
System.out.println("Sorting the organisation's employee salary in ascending order ");
empList.stream().sorted(Comparator.comparingLong(Employee::getSalary)).toList().forEach(System.out::println);

```
##

**31. Highest salary based on department.**
```java
System.out.println("Highest salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
list -> list.stream().max(Comparator.comparingDouble(Employee::getSalary))))));
```
##

**32. Print list of employee’s second highest record based on department.**
```java
System.out.println("Highest second salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                   Collectors.collectingAndThen(Collectors.toList(),
                   list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst()))));
```
##


**34. Sort the employees salary in each department in descending order**
```java
System.out.println("Sorting the department wise employee salary in descending order ");
        Map<String, Stream<Employee>> sortedEmployeeDesc = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, 
                                                            Collectors.collectingAndThen(Collectors.toList(),
                                                            list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()))));
sortedEmployeeDesc.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });
```
##

**Find the highest salary employee for each department.**
```java
        Map<String, Optional<Employee>> highestPaidEmployees = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName,
                        Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))));

        highestPaidEmployees.forEach((department, employee) ->
                System.out.println("Department: " + department + ", Highest Paid Employee: " + employee.get()));
```

**Collectors.maxBy() collector**
The signature of Collectors.maxBy() factory method looks as follows:

Collector<T, ?, Optional<T>> maxBy​(Comparator<T> comparator)

It creates a Collector that calculates the max element according to a given Comparator, described as an Optional.
There is no guarantee that the max element will be found (if a stream is empty, for example), so the operation returns result wrapped by an Optional object.


**Collectors.minBy() collector**

The signature of Collectors.minBy() factory method looks as follows:

Collector<T, ?, Optional<T>> minBy​(Comparator<T> comparator)

It creates a Collector that calculates the min element according to a given Comparator, described as an Optional.

##













