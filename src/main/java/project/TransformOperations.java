package project;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class TransformOperations {


    public static Map<String, String[]> getRoute() {
        Map<String, String[]> route = new LinkedHashMap<>();
        String fileName = "src/main/resources/file.txt";

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> rows = reader.readAll();
            String[] header = new String[rows.size()];
            for (String e : rows.get(0)) {

                header = e.split("\\W+");

            }
            ArrayList<String> holdWinners = new ArrayList();

            for (int i = 1; i < rows.size(); i++) {
                for (String e : rows.get(i)) {
                    String[] row = e.split("\\W+");

                    for (int j = 0; j < row.length; j++) {
                        if (row[j].equals("x")) {
                            holdWinners.add(header[j]);
                        }

                    }
                    try {
                        if (header[i - 1] != null && i < rows.size() && !header[i-1].equals(" ")) {
                            route.put(header[i - 1], holdWinners.toArray(new String[0]));
                            holdWinners.clear();

                        }
                    } catch (ArrayIndexOutOfBoundsException e1) {
                           System.out.println("Technical issue about bounds");
                    }
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit ");
        }finally {
            return route;
        }


    }

    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        Map<String, String[]> route = TransformOperations.getRoute();

        for (String key : route.keySet()) {
            System.out.println(key + " --> " + Arrays.deepToString(route.get(key)));
        }


    }
}


