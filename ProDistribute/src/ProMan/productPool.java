package ProMan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class productPool {
	public productPool() {
		super();
		amount = 0;
		productBag = new HashMap<String,product>();
	}
	private int amount;
	private HashMap<String,product> productBag;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public HashMap<String, product> getProductBag() {
		return productBag;
	}
	public void setProductBag(HashMap<String, product> productBag) {
		this.productBag = productBag;
	}
	public void addProduct(product pro)
	{
		if(productBag.containsKey(pro.getProID()))
		{
			System.out.println("Alreay in the pool");
			return;
		}
		else
		{
			productBag.put(pro.getProID(),pro);
			this.amount++;
		}
	}
	public product getProduct(String ID)
	{
		if(productBag.containsKey(ID))
		{
			return productBag.get(ID);
		}
		else
			return null;
	}
	public ArrayList<product> getAllproduct()
	{
		ArrayList<product> arr = new ArrayList<product>();
		Iterator<product> iter = this.productBag.values().iterator();
		while(iter.hasNext())
		{	
			product ad = (product) iter.next();
			arr.add(ad);
		}
		return arr;
	}
}
