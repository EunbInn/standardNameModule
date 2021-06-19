package standardName;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class ReadCSV {
    
    public ArrayList<String[]> readStdFile() {
        CSVReader cr = null;
        String filePath = "";
        File file = null;
        ArrayList<String[]> arr = new ArrayList<String[]>();
        try {
            while (true) {
                filePath = "standard.csv";
                file = new File(filePath);
                cr = new CSVReader(new InputStreamReader(new FileInputStream(file)));
                
                String[] fieldName = cr.readNext();
                if (fieldName == null) {
                    break;
                }
                
                String[] field;
                while ((field = cr.readNext()) != null) {
                    arr.add(field);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public void readNumberingFile() {
        // get -> 0: cu, 1: gs
        ArrayList<String[]> arr = readStdFile();
        CSVReader cr = null;
        String filePath = "";
        File file = null;
        String[] cu = arr.get(0);
        String[] gs = arr.get(1);
        
        try {
            int cnt = 1;
            while (true) {
                filePath = cnt + ".csv";
                file = new File(filePath);
                cr = new CSVReader(new InputStreamReader(new FileInputStream(file)));
                String[] line;
                while ((line = cr.readNext()) != null) {
                    
                }
                cnt++;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (String cuName : cu) {
            
        }
        
        for (String gsName : gs) {
            
        }
    }
}
