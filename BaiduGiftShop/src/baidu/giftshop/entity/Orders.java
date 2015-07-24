package baidu.giftshop.entity;

import java.util.Date;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private GoodsDetai goodsDetail;
	private Integer orderid;
	private Integer num;
	private String state;
    private Date data;
    private Integer subbranchId;
	// Constructors

	/** default constructor */
	public Orders() {
	}
	

	public Orders(Integer id, Address address, GoodsDetai goodsDetail,
			Integer orderid, Integer num, String state, Date data,
			Integer subbranchId) {
		super();
		this.id = id;
		this.address = address;
		this.goodsDetail = goodsDetail;
		this.orderid = orderid;
		this.num = num;
		this.state = state;
		this.data = data;
		this.subbranchId = subbranchId;
	}


	public Orders(Integer id, Address address, GoodsDetai goodsDetail,
			Integer orderid, Integer num, String state) {
		super();
		this.id = id;
		this.address = address;
		this.goodsDetail = goodsDetail;
		this.orderid = orderid;
		this.num = num;
		this.state = state;
	}
   
	public Orders(Integer id, Address address, GoodsDetai goodsDetail,
			Integer orderid, Integer num, String state, Date data) {
		super();
		this.id = id;
		this.address = address;
		this.goodsDetail = goodsDetail;
		this.orderid = orderid;
		this.num = num;
		this.state = state;
		this.data = data;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

	public GoodsDetai getGoodsDetail() {
		return goodsDetail;
	}



	public void setGoodsDetail(GoodsDetai goodsDetail) {
		this.goodsDetail = goodsDetail;
	}



	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
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