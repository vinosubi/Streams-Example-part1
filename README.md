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



