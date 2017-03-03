//comm
package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TransformOperations {


    public static String [][] getMatrix(){

        try(BufferedReader br = new BufferedReader(new InputStreamReader(TransformOperations.class.getResourceAsStream("/file.txt")))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            String[] index = line.split("\\s+");
            String [][] matrix = new String[index.length+1][index.length+1];
            /**
             for(int i = 0; i<index.length; i++){
             for(int j = 0; j<index.length; j++){
             matrice[i][j]=""+i+j;
             }
             //System.out.println("");
             }
             */

            if(line != null || line == "0"){

                // line = br.readLine();
                matrix[0][0] = "" + index.length + " X " + index.length;

                for (int i = 1; i < index.length+1; i++) {
                    // You may want to check for a non-word character before blindly
                    // performing a replacement
                    // It may also be necessary to adjust the character class
                    index[i-1] = index[i-1].replaceAll("[^\\w]", "");
                    matrix[0][i] = index[i-1];
                    matrix[i][0] = matrix[0][i];
                }

                /**
                 for(String element : index){
                 System.out.print(element +" ");
                 }
                 System.out.println("");

                 */
            }
            int j = 0;

            while (line != null && !line.trim().equals("")) {
                j++;
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                index = line.split("\\s+");

                for (int i=1; i < index.length+1; i++) {
                    // You may want to check for a non-word character before blindly
                    // performing a replacement
                    // It may also be necessary to adjust the character class
                    index[i-1] = index[i-1].replaceAll("[^\\w]", "");
                    matrix[j][i] = index[i-1];
                }
                String everything = sb.toString();
            }


            for(int i = 1; i< index.length+1; i++){
                System.out.println("matrice["+i+"][0]= "+ matrix[i][0]+ "<-- matrice[0]["+i+"]= "+ matrix[0][i]);
                matrix[i][0] = matrix[0][i];
            }






            br.close();
            /**
             for(String [] str : matrice){
             for(String elem : str){
             System.out.print(elem+" ");
             }
             System.out.println("");
             }
             */

            return matrix;
        } catch(IOException a){
            System.out.println("Fisierul nu a fost gasit");
            return new String[0][0];
        }



    }

    public static Map<String,String[]> getRoute(String[][] matrix) {

        int sum;
        int pozition = 0;
        String a = "" ;
        Map <String,String[]> route = new HashMap<String,String[]>();

        for(int i = 1; i<matrix.length; i++){
            a = matrix[0][i];
            sum = 0;
            for(int j = 1 ; j<matrix.length; j++){
                if(!matrix[i][j].equals("0") && !matrix[i][j].equals("1"))
                    sum++;
            }
            pozition = 0;
            String [] individualRoute = new String [sum];
            for(int j = 1 ; j<matrix.length; j++){
                if(!matrix[i][j].equals("0") && !matrix[i][j].equals("1")){
                    individualRoute[pozition] = matrix[0][j];
                    pozition++;
                }
            }
            route.put(a,individualRoute);
            // System.out.println("K("+a+")= "+Arrays.asList(parcursIndividual));
        }

        return route;

    }


//    public StringBuilder sb(){
//        return this.sb;
//    }
}
