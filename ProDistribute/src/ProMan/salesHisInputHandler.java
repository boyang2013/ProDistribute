package ProMan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class salesHisInputHandler {
	public salesHisInputHandler(districtManager disM) {
		super();
		this.disM = disM;
	}

	private districtManager disM ;
	public void readFileByLines(String fileName) throws IOException
	{
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String tempString = null;
			while((tempString=br.readLine())!=null)
			{
				handleEachLine(tempString);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void handleEachLine(String eachLine)
	{
		String[] termArray = eachLine.split(",");
		district dis = disM.getDistirct(termArray[0]);
		Month month = dis.getMonth(Integer.valueOf(termArray[1]));
		month.addProsales(termArray[2], Double.valueOf(termArray[3]));
	}
	public districtManager getDisM() {
		return disM;
	}
	public void setDisM(districtManager disM) {
		this.disM = disM;
	}
	
}
