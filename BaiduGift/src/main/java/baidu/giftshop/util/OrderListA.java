package baidu.giftshop.util;

import java.util.Date;
import java.util.List;

public class OrderListA {
	
	private String orderid;
	
	private String state;
	
	private Integer addressid;
	
	private String data;
	


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private List<OrderListB> orderitem;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public List<OrderListB> getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(List<OrderListB> orderitem) {
		this.orderitem = orderitem;
	}

	public OrderListA(String orderid, String state, Integer addressid,
			List<OrderListB> orderitem) {
		super();
		this.orderid = orderid;
		this.state = state;
		this.addressid = addressid;
		this.orderitem = orderitem;
	}

	public OrderListA() {
		super();
	}
}
