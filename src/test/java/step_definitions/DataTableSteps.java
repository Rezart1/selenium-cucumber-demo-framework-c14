package step_definitions;

import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @Given("this is a data table as a list")
    public void data_table_as_list(List<String> names){
        System.out.println("Given names: " + names);
        System.out.println(names.get(0));
    }

    @Given("this is a data table as map")
    public void data_table_as_a_map(Map<String, String> employee){
        System.out.println("Employee: " + employee);
        System.out.println(employee.get("firstName"));
        System.out.println(employee.get("lastName"));
        System.out.println(employee.get("middleName"));
    }

    @Given("this a data table as list of lists")
    public void data_table_as_list_ofLists(List<List<String>> employees){
        System.out.println("Initial form of list: " + employees);

        for (List<String> employee : employees){
            String id = employee.get(0);
            String name = employee.get(1);
            String lastName = employee.get(2);
        }

    }

    @Given("this is a data table as a list of maps")
    public void data_table_as_a_list_of_maps(List<Map<String,String>> employees) {
        Map<String, String> employee1 = employees.get(0);
        Map<String, String> employee2 = employees.get(1);
        Map<String, String> employee3 = employees.get(2);

        System.out.println(employee2.get("id"));
        System.out.println(employee3.get("lastName"));
    }
}
