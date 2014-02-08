package ProMan;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class district {
	public district(String districName) {
		super();
		this.districName = districName;
		this.salesHisMonth = new HashMap<Integer,Month>();
		this.currentAmountproduct = new HashMap<String,Double>();
		this.initialMonth();
	}
	private String districName;
	private HashMap<Integer,Month> salesHisMonth;
	private HashMap<String,Double> currentAmountproduct;
	
	
	public void putAssignRecord(String product, double num)
	{
		if(!this.currentAmountproduct.containsKey(product))
			this.currentAmountproduct.put(product, num);
		
	}
	public String getDistricName() {
		return districName;
	}
	public void setDistricName(String districName) {
		this.districName = districName;
	}
	public HashMap<Integer, Month> getSalesHistory() {
		return salesHisMonth;
	}
	public void setSalesHistory(HashMap<Integer, Month> salesHistory) {
		this.salesHisMonth = salesHistory;
	}
	public Month getMonth(int month)
	{
		if(this.salesHisMonth.containsKey(month))
		{
			return this.salesHisMonth.get(month);
		}
		else return null;
	}
	public void initialMonth()
	{
		for(int i = 1; i<=12; i++)
		{
			this.salesHisMonth.put(i,new Month(i));
		}
	}
	public double getPeriodSalesAmount(String product, int start, int end)
	{
		double sum = 0.0;
		for(int i = start; i<= end; i++)
		{
			sum += this.getMonth(i).getProSals(product);
		}
		return sum;
	}
	
	
	public String outputDis()
	{
		
		Iterator<Entry<String, Double>> iter = this.currentAmountproduct.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while(iter.hasNext())
		{
			Entry<String, Double> entry = iter.next();
			sb.append("Assign product ");
			sb.append(entry.getKey());
			sb.append("with amount: ");
			sb.append(entry.getValue());
			sb.append("**");
		}
		return sb.toString();
	}
}
