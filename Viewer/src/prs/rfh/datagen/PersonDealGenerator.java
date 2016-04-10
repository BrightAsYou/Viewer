package prs.rfh.datagen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prs.rfh.crack.lqyc.model.CarDeal;
import prs.rfh.crack.lqyc.model.UserInfoResponse;
import prs.rfh.service.ToLogin;

public class PersonDealGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(PersonDealGenerator.class);
	public static Set set = null;
	static{
		set = CarNoReader.generateCarSet();
	}
	
//	public static List<CarDeal> list = new ArrayList<CarDeal>();
	/**
	 * 返回上送单个user的预约列表
	 * @param userinfo
	 * @return dealList
	 */
	public static List<CarDeal> buildPersonDeals(UserInfoResponse userinfo){
		Iterator<String> carCollection = set.iterator();
		List<CarDeal> list = new ArrayList<CarDeal>();
		while(carCollection.hasNext()){
			CarDeal cardeal = new CarDeal(carCollection.next());
			log.debug(cardeal.getCarNo());
			list.add(cardeal);
		}
		return list;
	}
	
}
