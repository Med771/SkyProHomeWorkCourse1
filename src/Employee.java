import java.util.Objects;

public class Employee {
    // Init
    private static int idGenerator = 0;

    private String surname;
    private String name;
    private String patronymic;

    private final int id;
    private int department;
    private float salary;

    // Constructor
    public Employee(String surname,
                    String name,
                    String patronymic,
                    int department,
                    int salary) {

        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;

        this.id = idGenerator++;
    }

    // Get
    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public float getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    // Set
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setDepartment(byte department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    // Base methods
    @Override
    public String toString() {
        return this.surname + " " + this.name + " " + this.patronymic + "\n" +
        "Department: " + this.department + "\n" +
        "Salary: " + this.salary + "\n" +
        "ID: " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && department == employee.department && salary == employee.salary && Objects.equals(surname, employee.surname) && Objects.equals(name, employee.name) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, id, department, salary);
    }
}
