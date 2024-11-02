import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    // Init
    Employee[] employees;
    private final int length;

    // Constructor
    public EmployeeBook(int length) {
        this.employees = new Employee[length];
        this.length = length;
    }

    // Main
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook(10);

        Employee e1 = new Employee("Ivanov", "Ivan", "Ivanovich", 3, 135000);
        Employee e2 = new Employee("S", "N", "P", 1, 90000);

        boolean answerAddEmployee;

        answerAddEmployee= book.addEmployee(e1);
        System.out.println(answerAddEmployee);

        answerAddEmployee = book.addEmployee(e2);
        System.out.println(answerAddEmployee);

        book.displayEmployees();

        System.out.println();

        book.getEmployeeById(0);
    }

    // Get
    public int getLength() {
        return length;
    }

    public void getEmployeeById(int id) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                System.out.println(employees[i].toString());
                return;
            }
        }
    }

    // Methods
    public boolean addEmployee(Employee e) {
        for (int i = 0; i < length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                return true;
            }
        }

        return false;
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
    }

    // Display methods
    public void displayEmployees() {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public void displayFullNameEmployees() {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null) {
                String name = employees[i].getName();
                String surname = employees[i].getSurname();
                String patronymic = employees[i].getPatronymic();

                String fullName = name + " " + surname + " " + patronymic;

                System.out.println(fullName);
            }
        }
    }

    public void displayEmployeesByDepartment(int department) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                String output =
                        employees[i].getSurname() + " " + employees[i].getName() + " " + employees[i].getPatronymic() +
                        "\nSalary: " + employees[i].getSalary() +
                        "\nID: " + employees[i].getId();

                System.out.println(output);
            }
        }
    }

    public void displayEmployeesByMaximumLimitSalary(int maximumLimitSalary) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getSalary() < maximumLimitSalary) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public void displayEmployeesByMinimumLimitSalary(int minimumSalary) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getSalary() <= minimumSalary) {
                System.out.println(employees[i].toString());
            }
        }
    }

    // Calculate methods
    public float calculateEmployeeSalaries() {
        float total = 0;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null) {
                total += employees[i].getSalary();
            }
        }

        return total;
    }

    public float calculateEmployeeSalariesByDepartment(int department) {
        float total = 0;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                total += employees[i].getSalary();
            }
        }

        return total;
    }

    public float calculateEmployeeAverageSalary() {
        return calculateEmployeeSalaries() / length;
    }

    public float calculateEmployeeAverageSalaryByDepartment(int department) {
        return calculateEmployeeAverageSalary() / department;
    }

    // Find methods
    public float findEmployeeWithMinSalary() {
        float minSalary = 100_000_000;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }

        return minSalary;
    }

    public float findEmployeeWithMinSalaryByDepartment(int department) {
        float minSalary = 100_000_000;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
            }
        }

        return minSalary;
    }

    public float findEmployeeWithMaxSalary() {
        float maxSalary = 0;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
            }
        }

        return maxSalary;
    }

    public float findEmployeeWithMaxSalaryByDepartment(int department) {
        float maxSalary = 0;

        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getId() == department && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
            }
        }

        return maxSalary;
    }

    // Index methods
    public void IndexSalaries(int percent) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(employees[i].getSalary() * (100 + percent) / 100);
            }
        }
    }

    public void IndexSalariesByDepartment(int percent, int department) {
        for (int i = 0; i < length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                employees[i].setSalary(employees[i].getSalary() * (100 + percent) / 100);
            }
        }
    }

    // Base methods
    @Override
    public String toString() {
        return "EmployeeBook {\n" +
                "employees = " + Arrays.toString(employees) +
                "\nlength = " + length +
                '\n'+ '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return length == that.length && Objects.deepEquals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(employees), length);
    }
}
