package ProMan;

import java.util.HashMap;


public class districtManager {
	public districtManager() {
		super();
		this.districtMap = new HashMap<String,district>();
		this.size = 4;
		this.initialDistrict();
	}
	private int size;
	private HashMap<String,district> districtMap;
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public HashMap<String, district> getDistrictMap() {
		return districtMap;
	}
	public void setDistrictMap(HashMap<String, district> districtMap) {
		this.districtMap = districtMap;
	}
	public void initialDistrict()
	{
		this.districtMap.put("Mountain", new district("Mountain"));
		this.districtMap.put("Middle", new district("Middle"));
		this.districtMap.put("West", new district("West"));
		this.districtMap.put("East", new district("East"));
	}
	public district getDistirct(String disName)
	{
		if(this.districtMap.containsKey(disName))
		{
			return this.districtMap.get(disName);
		}
		else
			return null;
	}
	
}
