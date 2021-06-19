package standardName;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class WriterCSV {
	public void writeResult(List<Result> resultList) {
		String filePath = "./result.csv";
		File file = new File(filePath);
		Result result;
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "MS949"));
			bw.write("CU_std,GS_std");
			bw.newLine();
			for (int i = 0; i < resultList.size(); i++) {
				result = resultList.get(i);
				bw.write(result.getCu() + "," + result.getGs());
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
