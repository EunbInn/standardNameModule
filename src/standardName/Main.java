package standardName;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ReadCSV rc = new ReadCSV();
        WriterCSV wc = new WriterCSV();
        
        List<Result> resultList = rc.readNumberingFile();
        wc.writeResult(resultList);

    }

}
