
package project;// A Java program to print all subsets of a set
import java.util.*;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;


class Subset {

    // Print all subsets of given set[]

    static void printSubsetsVerified(String set[])
    {
        try{

        BufferedWriter bw = null;
        File file = new File("ParcursuriPosibile.txt");
        ArrayList first = new ArrayList();
        StringBuilder content = new StringBuilder("");

        int n = set.length;
        int countOk = 0;

        for (int i = 0; i < (1<<n); i++)
        {
//System.out.print(count++ +" { ");
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
//System.out.print(set[j] + " ");
                    first.add(set[j]);
                    content.append(set[j]).append(" ");
                }
//System.out.println("} = " + Subset.getSolveResult(first) );

            StringBuilder result = new StringBuilder("");
            result.append(countOk).append(". { ").append(content).append(" } = 1").toString();
            content = result;

            if(Subset.getSolveResult(first) == 1) {

                try {

                    FileWriter fw = new FileWriter(file, true);
                    bw = new BufferedWriter(fw);

                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    bw.write(String.valueOf(content));
                    countOk++;
                    bw.append("\r\n");

//System.out.println("Successfully added to file");

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

        public static int getSolveResult(ArrayList<String> first) {

            Map <String,String[]> route = TransformOperations.getRoute();

            SortedSet<String> sortedSet = new TreeSet<String>();
            sortedSet.addAll(first);

            for (Object a : first) {
                for (String s : route.get(a)) {
                    if (sortedSet.contains(s)) {
                        return 0;
                    }
                }
            }

            return 1;
        }



    }


