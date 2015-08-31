package baidu.giftshop.entity;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer addressid;
	private Integer goodsdetailid;
	private String orderid;
	private Integer num;
	private String totalMoney;
	public String getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}


	private String state;
    private Date data;
    private Integer subbranchId;
	// Constructors

	/** default constructor */
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}







	public Integer getAddressid() {
		return addressid;
	}


	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}




	public Integer getGoodsdetailid() {
		return goodsdetailid;
	}


	public void setGoodsdetailid(Integer goodsdetailid) {
		this.goodsdetailid = goodsdetailid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


	public Integer getSubbranchId() {
		return subbranchId;
	}


	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}
}