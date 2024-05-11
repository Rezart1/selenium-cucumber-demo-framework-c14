package step_definitions;

import java.util.ArrayList;
import java.util.List;

public class TestDataStructures {
    public static void main(String[] args) {


        // [ Omar, Ramo, Jane ]
        List<String> names1 = new ArrayList<>(List.of("Omar", "Ramo", "Jane"));
        System.out.println(names1);
        System.out.println(names1.get(0));

        // [Ramo, Simpson, Jefferson]
        List<String> lastNames = new ArrayList<>(List.of("Ramo", "Simpson", "Jefferson"));
        System.out.println(lastNames);
        System.out.println(lastNames.get(0));


        List<List<String>> listsCombined = new ArrayList<>(List.of(names1, lastNames));


        System.out.println(listsCombined);

        for (int i = 0; i < listsCombined.size(); i++) {
            for (int j = 0; j < listsCombined.get(i).size(); j++) {
                if (j == 1) {
                    System.out.println(listsCombined.get(i).get(j));
                }
            }
        }


        for (List<String> temp : listsCombined) {
            System.out.println(temp.get(1));
        }


    }
}