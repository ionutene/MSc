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
//        System.out.println("AAA");
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> rows = reader.readAll();
            String[] header = new String[rows.size()];
            for (String e : rows.get(0)) {
//                System.out.format("%s", e);
                header = e.split("\\W+");
               /* for (String column:header)
                {System.out.println("[" + column + "] ");
                }*/
            }
            ArrayList<String> holdWinners = new ArrayList();
            //            int count = 0;
            for (int i = 1; i < rows.size(); i++) {
                for (String e : rows.get(i)) {
                    String[] row = e.split("\\W+");
//                    System.out.format("Line " + i + "  \n" + "%s", e);
                    for (int j = 0; j < row.length; j++) {
//                        System.out.println(j + "   .");
                        if (row[j].equals("x")) {
                            //Add to map..to be continued
//                           System.out.println("\n row[" + j + "]= " + row[j] + "= " + header[j] + " ");
                            holdWinners.add(header[j]);
                           /* markedFields[count] = row[j];
                            System.out.println();
                            System.out.println("marked " + markedFields[count] + " count " + count + " row[" + j + "]= " + row[j] + " " + header[j]);
                            count++;
                            System.out.println("______________________________" + i + "__________________________________");
                            System.out.print("[" + row[j] + "] =  " + (j) + " ");
                            if(j + 1 == rows.size() || count+1 == rows.size()) {
                                route.put(header[i], markedFields);
                                markedFields = new String[rows.size()];
                                count = 0;*/
                        }
/*
                        for (String a:holdWinners
                             ) {System.out.print(a+" ");
                        }
*/
                    }
                    try {
                        if (header[i - 1] != null && i < rows.size() && !header[i - 1].equals(" ")) {
                            route.put(header[i - 1], holdWinners.toArray(new String[0]));
                            holdWinners.clear();
                       /* for (String st : markedFields) {
                            if(st!=null)System.out.print(st + " ");
                        }*/
                        }
                    } catch (ArrayIndexOutOfBoundsException e1) {
//                           System.out.println("Technical issue about bounds");
                    }
                }
//                    System.out.println();
            }
//                System.out.println();
               /* for (String key : route.keySet()) {
                    System.out.println(key + " --> " + route.get(key));
                }*/

        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit ");
        } finally {
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


