package ProMan;

import java.util.*;
import java.util.Map.Entry;

public class disbributeController {
	class MyComparator2 implements Comparator<Double>{
		@Override
		public int compare(Double o1, Double o2) {

			return o2.compareTo(o1);
		}
	}
		public disbributeController(productPool pool, districtManager dm,
			productWareHouse ph) {
		super();
		this.pool = pool;
		this.dm = dm;
		this.ph = ph;
		this.tempResult = new TreeMap<Double,String>(new MyComparator2());
	}
		//for each product calculate its sals amount for each district;//
		private productPool pool;
		private districtManager dm;
		private productWareHouse ph;
		private TreeMap<Double,String> tempResult;
		public void calculateCriteria(){
			Iterator<String> iterp = pool.getProductBag().keySet().iterator();
			
			
			
			while(iterp.hasNext())
			{
				Iterator<String> iterd = dm.getDistrictMap().keySet().iterator();
				String productName = iterp.next();
				while(iterd.hasNext())
				{
					district curr= dm.getDistirct((String)iterd.next());
					double average_amount = curr.getPeriodSalesAmount(productName, 1, 3)/3;
					this.tempResult.put(average_amount,curr.getDistricName());
					
				}
				this.assignProduct(productName);
				this.tempResult.clear();
				
				
			
			}
		}
		public void assignProduct(String product)
		{
			int allAmount = ph.getProductCount().get(product);
			Iterator<Entry<Double, String>> iter = tempResult.entrySet().iterator();
			while(allAmount>0&&iter.hasNext())
			{
				Entry<Double, String> entry = iter.next();
				if(entry.getKey()<=allAmount)
				{
					dm.getDistirct(entry.getValue()).putAssignRecord(product,entry.getKey());
					allAmount -= entry.getKey();
				}
				else
				{
					dm.getDistirct(entry.getValue()).putAssignRecord(product,allAmount);
					allAmount = 0;
				}
			
			}
			
		}
}
