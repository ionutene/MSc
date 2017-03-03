package project;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Matrix read = new Matrix();
        Route mp = new Route();
       // StringBuilder sb = Matrix.sb();


        // matrix gets OD data possibilities from file.txt with the static method getMatrix specific Class Matrix
        String[][] matrix = Matrix.getMatrix();

      /*   using matrix from previous declaration, route represents the possibilities of reacheble destinations from each point
                ex: K(m1)= [a1, a2, a3, m2, m3, c1, b1, i1, e1, d1]*/

        Map<String, String[]> route = mp.getRoute(matrix);

        System.out.println("__________________________________1__________________________________");

        for (String[] str : matrix) {
            for (String elem : str) {
                System.out.print(elem + "\t");
            }
            System.out.println("");
        }
        int size = 0;
        System.out.println("__________________________________2__________________________________");
        for (String b : route.keySet()) {
            //Arrays.toString(Object[] a)
            System.out.println("K(" + b + ")= " + Arrays.asList(route.get(b)));
            size++;
        }

        System.out.println("__________________________________3__________________________________");
        int i = 0;
        //System.out.println(sb);
        String[] set = new String[size];
        for (String b : route.keySet()) {
            set[i] = b;
            i++;
        }
        Subset m = new Subset();
        m.printSubsets(set);

        System.out.println("__________________________________Final______________________________");


    }



}
