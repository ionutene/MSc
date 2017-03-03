package project;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*TransformOperations read = new TransformOperations();
        TransformOperations mp = new TransformOperations();
        StringBuilder sb = TransformOperations.sb();*/


        // matrix gets OD data possibilities from file.txt with the static method getMatrix specific Class TransformOperations
        String[][] matrix = TransformOperations.getMatrix();

      /*   using matrix from previous declaration, route represents the possibilities of reacheble destinations from each point
                ex: K(m1)= [a1, a2, a3, m2, m3, c1, b1, i1, e1, d1]*/

        Map<String, String[]> route = TransformOperations.getRoute(matrix);


        //This 1st step shows us the OD matrix

        System.out.println("__________________________________1__________________________________");

        for (String[] str : matrix) {
            for (String elem : str) {
                System.out.print(elem + "\t");
            }
            System.out.println("");
        }
        int size = 0;



        //This 2nd step shows us the possibilities of reacheble destinations from each point
        System.out.println("__________________________________2__________________________________");
        for (String b : route.keySet()) {
            //Arrays.toString(Object[] a)
            System.out.println("K(" + b + ")= " + Arrays.asList(route.get(b)));
            size++;
        }


        //This 3rd step is responsable for generating each event and giving a output from  Subset.getPrintResult
        // case == 1 --> save result to file
        // case == 0 --> just print specific comparison to console
        System.out.println("__________________________________3__________________________________");
        int i = 0;
        //System.out.println(sb);
        String[] set = new String[size];
        for (String b : route.keySet()) {
            set[i] = b;
            i++;
        }
        Subset m = new Subset();
        m.printSubsetsVerified(set);

        System.out.println("__________________________________Final______________________________");


    }



}
