package ProMan;

import java.io.IOException;


public class main {
	public static void main(String args[])
	{
		productPool pool = new productPool();
		districtManager disM = new districtManager();
		productInputHandler pInput = new productInputHandler(pool);
		try {
			pInput.readFileByLine("/Users/Anastasia/Desktop/product.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		salesHisInputHandler sInput = new salesHisInputHandler(disM);
		try {
			sInput.readFileByLines("/Users/Anastasia/Desktop/districtSalesHis.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productWareHouse pWH = new productWareHouse(pool);
		disbributeController disControl = new disbributeController(pool,disM,pWH);
		disControl.calculateCriteria();
		outputHandler outhandler = new outputHandler(disM);
		outhandler.printOut("/Users/Anastasia/Desktop/output.txt");
		
	}
}
