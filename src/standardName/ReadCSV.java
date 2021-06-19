package standardName;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSV {

	public ArrayList<String[]> readStdFile() {
		CSVReader cr = null;
		String filePath = "";
		File file = null;
		ArrayList<String[]> arr = new ArrayList<String[]>();
		try {

			filePath = "./standard.csv";
			file = new File(filePath);
			cr = new CSVReader(new InputStreamReader(new FileInputStream(file), "MS949"));

			String[] fieldName = cr.readNext();
			if (fieldName == null) {
				return null;
			}

			String[] field;
			while ((field = cr.readNext()) != null) {
				arr.add(field);
			}
			cr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("std file read complete!");
		return arr;
	}

	public List<Result> readNumberingFile() {
		// get -> 0: cu, 1: gs
		ArrayList<String[]> arr = readStdFile();
		CSVReader cr = null;
		String filePath = "";
		File file = null;
		String[] cu = arr.get(0);
		String[] gs = arr.get(1);
		List<Result> resultList = new ArrayList<Result>();

		try {
			int cnt = 1;
			while (true) {
				// 혹은 filePath를 String[]로 해서 저장하여 돌려도 됨
				filePath = "./" + cnt + ".csv";
				file = new File(filePath);
				// file이 존재하지 않으면 멈춤
				if (!file.exists())
					break;
				cr = new CSVReader(new InputStreamReader(new FileInputStream(file), "MS949"));
				String[] line;
				while ((line = cr.readNext()) != null) {
					Result result = new Result();
					for (int i = 0; i < line.length; i++) {
						//System.out.println(line[i]);
						for (String cuName : cu) {
							if ((line[i].replaceAll(" ", "").toLowerCase()).contains(cuName.toLowerCase())) {
								result.setCu(line[i]);
								break;
							}
						}

						for (String gsName : gs) {
							if ((line[i].replaceAll(" ", "").toLowerCase()).contains(gsName.toLowerCase())) {
								result.setGs(line[i]);
								break;
							}
						}
					}
					resultList.add(result);
				}
				System.out.println(cnt + ".csv read complete!");
				cnt++;
			}
			cr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;

	}
}
