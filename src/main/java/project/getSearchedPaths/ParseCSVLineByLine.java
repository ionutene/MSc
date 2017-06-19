package project.getSearchedPaths;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class ParseCSVLineByLine
{
    @SuppressWarnings("resource")
    public static LinkedHashSet<String> getParseCSVLineByLine() throws Exception
    {
        //Build reader instance
        //Read data.csv
        //Default seperator is comma
        //Default quote character is double quote
        //Start reading from line number 2 (line numbers start from zero)
        CSVReader reader = new CSVReader(new FileReader("ParcursuriPosibile.txt"), ',');

        //Read CSV line by line and use the string array as you want
        String[] nextLine;

        LinkedHashSet<String> list= new LinkedHashSet<>();
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                //Verifying the read data here
                String as = Arrays.toString(nextLine);

                if (as.length()>2)
                    list.add(as.substring(1,as.length()-3));
            }

        }
        /*for (String a:list) {
            System.out.println(a);
        }*/
        return list;
    }
}
