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


**1.Group the Employees by city.**

```java
Map<String, List<Employee>> empByCity;
empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
System.out.println("Employees grouped by city :: \n" + empByCity);
```

**2. Group the Employees by age..**

```java
Map<Integer, List<Employee>> empByAge = empList.stream().collect(Collectors.
                                        groupingBy(Employee::getAge));
System.out.println("Employees grouped by age :: \n" + empByAge);
```

**3. Find the count of male and female employees present in the organization...**

```java
Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream()
                                              .collect(Collectors.groupingBy
                                              (Employee::getGender, Collectors.counting()));
System.out.println("Count of male and female employees present in the 
                    organization:: \n" + noOfMaleAndFemaleEmployees);
```
