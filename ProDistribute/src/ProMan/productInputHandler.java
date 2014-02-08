package ProMan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class productInputHandler {
	public productInputHandler(productPool pool) {
		super();
		this.pool = pool;
	}
	
	

	private productPool pool;
	
	public productPool getPool() {
		return pool;
	}
	public void setPool(productPool pool) {
		this.pool = pool;
	}
	public void readFileByLine(String fileName) throws IOException
	{
		File file = new File(fileName);
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String tempString = null;
			while((tempString=br.readLine())!=null)
			{
				pool.addProduct(this.createProduct(tempString));
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public product createProduct(String eachLine)
	{
		String[] termArray = eachLine.split(",");
		product product = new product(termArray[0],Double.valueOf(termArray[2]),termArray[1]);
		for(int i = 3; i<=18; i++)
		{
			product.getDisCost().put(i-2, Double.valueOf(termArray[i]));
		}
		for(int j = 19; j<=34; j++)
		{
			product.getDisTime().put(j-18,Integer.valueOf(termArray[j]));
		}
		return product;
		
	}
	
}
