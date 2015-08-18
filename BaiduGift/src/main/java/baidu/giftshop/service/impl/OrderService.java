package baidu.giftshop.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import baidu.giftshop.dao.GoodsDetailSubbranchMapper;
import baidu.giftshop.dao.OrdersMapper;
import baidu.giftshop.dao.UserMapper;
import baidu.giftshop.dao.UserOrderMapper;
import baidu.giftshop.model.Base;
import baidu.giftshop.model.BaseList;
import baidu.giftshop.model.Orders;
import baidu.giftshop.model.UserOrder;
import baidu.giftshop.service.IOrderService;
import baidu.giftshop.util.A;
import baidu.giftshop.util.OrderListA;
import baidu.giftshop.util.OrderListB;
@Service("orderService")
public class OrderService implements IOrderService {
	
	@Autowired
	private OrdersMapper ordersDao;
	@Autowired
	private UserOrderMapper userorderDao;
	@Autowired
	private GoodsDetailSubbranchMapper goodsDSDao;
	@Autowired
	private UserMapper userDao;
	
	List<String> baselist = new ArrayList<String>();
	
	@Transactional
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@Override
	public Base addOrder(String user_id, String subbranch_id,
			String goods_detail_id, String num, String state, Integer addressid){
		
		String[] detailId = goods_detail_id.split(";");
		String[] Number = num.split(";");
		String[] subbranchId = subbranch_id.split(";");
		for(int i = 0;i<detailId.length;i++){
			String[] DetailId = detailId[i].split(",");
			String[] number = Number[i].split(",");
			String[] SubbranchId = subbranchId[i].split(",");
			
			String orderid = getOrderids();
			
	    
			for(int j =0 ; j < DetailId.length; j++){
				if(true){
					UserOrder userorder = new UserOrder();
					userorder.setOrderid(orderid);
		//			Integer uid = userDao.selectByUid(user_id);
	//				userorder.setUserid(uid);
					userorder.setUserid(user_id);
				    Orders orders = new Orders();
				    orders.setOrderid(orderid);
				    orders.setGoodDetailId(Integer.parseInt(DetailId[j]));
				    orders.setAddressid(addressid);
				    orders.setNum(Integer.parseInt(number[j]));
				    orders.setState(state);
				    orders.setData(new Date());
				    orders.setSubbranchId(Integer.parseInt(SubbranchId[j]));
				    
				   
					if(this.adduserorder(userorder, orderid)){
						ordersDao.insert(orders);
						this.changeamount(Integer.parseInt(DetailId[j]), Integer.parseInt(SubbranchId[j]), Integer.parseInt(number[j]));
						baselist.add("OK");
					}else{
						baselist.add("Error");
					}
					
				}else{
					baselist.add("Error");
				}
			}
		} 
		Base base = new Base();
		BaseList listbase = new BaseList();
		listbase.setList(baselist);
		base.setContent(listbase);
		base.setResult("OK");
		return base;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Base queryOrder(String user_id, Integer startIndex,
			Integer requestAmount) {
	//	Integer userid = userDao.selectByUid(user_id);
		
		List<String> list = userorderDao.queryOrderid(user_id);
		
		List<OrderListA> prolist = new ArrayList<OrderListA>();
		for(int i = 0 ; i < list.size() ; i++){
			OrderListA orderlista = new OrderListA();
			String subOrderid = list.get(i);
			orderlista.setOrderid(subOrderid);
			
			List<OrderListB> prelist = ordersDao.queryOrder(user_id, subOrderid);
			orderlista.setState(prelist.get(0).getState());
			orderlista.setAddressid(prelist.get(0).getAddressid());
			orderlista.setOrderitem(prelist);
			prolist.add(orderlista);
		}
		Base base = new Base();
		A a = new A();
		a.setSubbranchs(prolist);
		base.setContent(a);
		base.setCode(101);
		base.setResult("Ok");
		return base;
	}
	
	
	private String getOrderids(){
		Date date=new Date();
		String df=new SimpleDateFormat("yyyyMMddHHmmss").format(date);
		Random rad=new Random();
		String rd= rad.nextInt(1000)+"";
		return df+rd;
		
		
	}
	
	public Integer setorderid(){
		Integer orderid = (int)(Math.random()*10000)+1;
		List<Orders> list = ordersDao.checkByOrderid(orderid);
		if(list.size()<1){
			return orderid;
		}else{
			setorderid();
		}
		return orderid;
	}
	
	public Boolean adduserorder(UserOrder userorder,String orderid){
		List<UserOrder> list = userorderDao.queryByOrderid(orderid);
		if(list.size()<1){
			userorderDao.insert(userorder);
		}else{
		}
		return true;
	}
	
	public synchronized void changeamount(Integer goodsDetailId,Integer subbranchId,Integer amount){
		goodsDSDao.updateAmount(goodsDetailId, subbranchId,amount);
	}

	
}
