package ProMan;

import java.util.HashMap;

public class Month {
	public Month(int month) {
		super();
		Month = month;
		sals = new HashMap<String,Double>();
	}
	private int Month;
	private HashMap<String,Double> sals;
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public HashMap<String, Double> getSals() {
		return sals;
	}
	public void setSals(HashMap<String, Double> sals) {
		this.sals = sals;
	}
	public void addProsales(String pid, double amount)
	{
		if(sals.containsKey(pid))
		{
			System.out.println("Alreay exist product");
			return;
		}
		else
		{
			this.sals.put(pid, amount);
		}
	}
	public double getProSals(String pid)
	{
		if(sals.containsKey(pid))
		{
			return sals.get(pid);
		}
		else
		{
			System.out.println("do not have this product");
			return 0.0;
		}
	}
}
