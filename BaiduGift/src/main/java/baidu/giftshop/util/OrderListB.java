package baidu.giftshop.util;

import java.math.BigDecimal;
import java.util.Date;

public class OrderListB {

	private Integer goods_detail_id;
	private Integer num;
	private String name;
	private String data;
	private Integer subbranchid;
	public Integer getSubbranchid() {
		return subbranchid;
	}

	public void setSubbranchid(Integer subbranchid) {
		this.subbranchid = subbranchid;
	}


	private BigDecimal retail_price;
    private BigDecimal cost_price;
    private BigDecimal baidu_price;
    public BigDecimal getBaidu_price() {
		return baidu_price;
	}

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public void setBaidu_price(BigDecimal baidu_price) {
		this.baidu_price = baidu_price;
	}


	private String path;
    private String thum_path;
    private String state;
    private Integer addressid;
    
	public OrderListB(Integer goods_detail_id, Integer num, String name,
			BigDecimal retail_price, BigDecimal cost_price, String path,
			String thum_path, String state, Integer addressid) {
		super();
		this.goods_detail_id = goods_detail_id;
		this.num = num;
		this.name = name;
		this.retail_price = retail_price;
		this.cost_price = cost_price;
		this.path = path;
		this.thum_path = thum_path;
		this.state = state;
		this.addressid = addressid;
	}


	public Integer getGoods_detail_id() {
		return goods_detail_id;
	}


	public void setGoods_detail_id(Integer goods_detail_id) {
		this.goods_detail_id = goods_detail_id;
	}


	public Integer getNum() {
		return num;
	}


	public void setNum(Integer num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getRetail_price() {
		return retail_price;
	}


	public void setRetail_price(BigDecimal retail_price) {
		this.retail_price = retail_price;
	}


	public BigDecimal getCost_price() {
		return cost_price;
	}


	public void setCost_price(BigDecimal cost_price) {
		this.cost_price = cost_price;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getThum_path() {
		return thum_path;
	}


	public void setThum_path(String thum_path) {
		this.thum_path = thum_path;
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


	public OrderListB() {
		super();
	}
}
