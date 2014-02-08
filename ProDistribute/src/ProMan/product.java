package ProMan;

import java.util.HashMap;

public class product {
	public product(String proID, double price, String name) {
		super();
		this.proID = proID;
		this.price = price;
		this.name = name;
		this.disTime = new HashMap<Integer,Integer>();
		this.disCost = new HashMap<Integer,Double>();
		
	}
	private String proID;
	private double price;
	private String name;
	private HashMap<Integer	,Integer> disTime ;
	private HashMap<Integer,Double> disCost;
	
	
	
	
	public String getProID() {
		
		return proID;
	}
	public void setProID(String proID) {
		this.proID = proID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<Integer, Integer> getDisTime() {
		return disTime;
	}
	public void setDisTime(HashMap<Integer, Integer> disTime) {
		this.disTime = disTime;
	}
	public HashMap<Integer, Double> getDisCost() {
		return disCost;
	}
	public void setDisCost(HashMap<Integer, Double> disCost) {
		this.disCost = disCost;
	}
	
}
