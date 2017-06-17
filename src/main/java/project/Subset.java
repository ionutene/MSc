//comm
package project;// A Java program to print all subsets of a set
import java.util.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
class Subset
{





    // Print all subsets of given set[]

    //private static final String FILENAME = "filename.txt";
    static void printSubsetsVerified(String set[])
    {
        try{
            //Solve r = new Solve();
            BufferedWriter bw = null;
            File file = new File("ParcursuriPosibile.txt");


            //FileWriter fw = null;
            ArrayList first = new ArrayList();
            int n = set.length;
            int count = 0;
            int countOk = 0;
            StringBuilder content = new StringBuilder("");
            // Run a loop for printing all 2^n
            // subsets one by obe
            for (int i = 0; i < (1<<n); i++)
            {
                System.out.print(count++ +" { ");
                content.setLength(0);
                first.clear();
                // Print current subset
                for (int j = 0; j < n; j++)

                    // (1<<j) is a number with jth bit 1
                    // so when we 'and' them with the
                    // subset number we get which numbers
                    // are present in the subset and which
                    // are not
                    if ((i & (1 << j)) > 0) {
                        System.out.print(set[j] + " ");

                        //                    Optimization required!!!!!!!!!!!!!!!!!!!!!!!
                   /* if(isDeadEnd(first.add(set[j]))){
                        System.out.print(set[j] + " ");
                        first.add(set[j]);
                        content.append(set[j]).append(" ");
                    } else j++;*/



                        first.add(set[j]);
                        content.append(set[j]).append(",");
                    }



                System.out.println("} = " + Subset.getSolveResult(first) );
//                content.append("\n").append(countOk).append(". { ").append(content).append(" } = 1").toString();
                if(Subset.getSolveResult(first) == 1) {
                    //System.out.println(" ");
                    //System.out.println("Adica " + content);
                    //System.out.println(" ");
                    try {
                        //String mycontent = "This String would be written" +
                        //" to the specified File";
                        //Specify the file name and path here
                        FileWriter fw = new FileWriter(file, true);
                        bw = new BufferedWriter(fw);
                    /* This logic will make sure that the file
                       * gets created if it is not present at the
                         * specified location*/
                        if (!file.exists()) {
                            file.createNewFile();
                        }




                        bw.write(String.valueOf(content));
                        countOk++;
                        bw.append("\r\n");
                        //content = "";
                        System.out.println("Successfully added to file");

                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                    finally
                    {
                        try{
                            if(bw!=null)
                                bw.close();
                        }catch(Exception ex){
                            System.out.println("We found troubles in writing to file"+ex);
                        }
                    }
                }

            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBounds found in Suset");
        }

    }

    public static boolean isDeadEnd(ArrayList first){

        return Subset.getSolveResult(first) == 1 ? true :false;

    }


    public static int getSolveResult(ArrayList first){


/*        TransformOperations read = new TransformOperations();
        TransformOperations mp = new TransformOperations();*/

        //        String [][] matrix = TransformOperations.getMatrix();
        Map <String,String[]> route = TransformOperations.getRoute();

        ArrayList last = new ArrayList();
        for(Object a : first){
            //Arrays.toString(Object[] a)
            for( String b :route.get(a) ){
                last.add(b);
            }
        }


        for(Object a : first){
            //Arrays.toString(Object[] a)

            if(last.contains(a)){

                //System.out.println( a + "-------este continut ------" );
                return 0;}

        }


        return 1;

    }


}
