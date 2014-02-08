package ProMan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

public class outputHandler {
	public outputHandler(districtManager dm) {
		super();
		this.dm = dm;
	}
	private districtManager dm;
	public void printOut(String FileName)
	{
		FileWriter fw;
		try {
			fw = new FileWriter(FileName);
			BufferedWriter bw=new BufferedWriter(fw);
			Iterator<Entry<String, district>> iter = this.dm.getDistrictMap().entrySet().iterator();
			while(iter.hasNext())
			{
				Entry<String,district> entry = iter.next();
				System.out.println("Distribute for District"+entry.getKey());
				bw.write("Distribute for District"+entry.getKey());
				bw.newLine();
				district dic = entry.getValue();
				bw.write(dic.outputDis());
				
				String string = dic.outputDis();
				System.out.println(string);
				bw.newLine();
			}
			bw.flush(); 
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
}
