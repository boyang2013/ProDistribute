package ProMan;

import java.util.HashMap;
import java.util.Iterator;

public class productWareHouse {
	public productWareHouse(productPool pool) {
		super();
		this.productCount = new HashMap<String,Integer>();
		this.pool = pool;
		this.initialWareHouse();
	}

	private HashMap<String,Integer> productCount ;
	private productPool pool;
	
	
	public void initialWareHouse()
	{
		Iterator<String> iter = pool.getProductBag().keySet().iterator();
		while(iter.hasNext())
		{
			this.productCount.put(iter.next(),10000);
		}
	}


	public HashMap<String, Integer> getProductCount() {
		return productCount;
	}


	public void setProductCount(HashMap<String, Integer> productCount) {
		this.productCount = productCount;
	}


	public productPool getPool() {
		return pool;
	}


	public void setPool(productPool pool) {
		this.pool = pool;
	}
}
