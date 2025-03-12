package HomeWork2.Task3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee("Иванов Иван Иванович", 20, "Marketing", 60000d);
        Employee emp2 = new Employee("Артемов Артем Артемович", 24, "IT", 90000d);
        Employee emp3 = new Employee("Семенов Семен Семенович", 22, "Sales", 70000d);
        Employee emp4 = new Employee("Максимов Максим Максимович", 26, "Analytics", 80000d);
        Employee emp5 = new Employee("Васин Григорий Борисович", 36, "Boss Department", 250000d);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);

        // Преобразуем список, как "Имя - Отдел"
        List<String> result = list.stream()
                .map(employee -> employee.getFullname() + " - " + employee.getDepartment())
                .collect(Collectors.toList());

        System.out.println("Результат преобразования:");
        result.forEach(System.out::println);
    }
}
