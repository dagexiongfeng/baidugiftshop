package baidu.giftshop.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * GoodsDetai entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class GoodsDetai implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer id;
	private Goods goods;
	private String name;
	private String goodsCode;//不同商品的唯一编号
	private String shopCode;
	private String barCode;//区分一件商品里的不同属性
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String picGroupId; //商品数量,艹
	private BigDecimal stockPrice;
	private BigDecimal baiduPrice;
	private BigDecimal retailPrice;
	private BigDecimal costPrice;
	private Integer state;
	private Set goodsDetailSubbranchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public GoodsDetai() {
	}

	/** minimal constructor */
	public GoodsDetai(Goods goods) {
		this.goods = goods;
	}

	/** full constructor */
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getShopCode() {
		return this.shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getType1() {
		return this.type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType3() {
		return this.type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public String getType4() {
		return this.type4;
	}

	public void setType4(String type4) {
		this.type4 = type4;
	}

	public String getPicGroupId() {
		return this.picGroupId;
	}

	public void setPicGroupId(String picGroupId) {
		this.picGroupId = picGroupId;
	}

	public Set getGoodsDetailSubbranchs() {
		return this.goodsDetailSubbranchs;
	}

	public void setGoodsDetailSubbranchs(Set goodsDetailSubbranchs) {
		this.goodsDetailSubbranchs = goodsDetailSubbranchs;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
	
		this.stockPrice = stockPrice;
	}



	public BigDecimal getBaiduPrice() {
		return baiduPrice;
	}

	public void setBaiduPrice(BigDecimal baiduPrice) {
		this.baiduPrice = baiduPrice;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
	
		this.costPrice = costPrice;
	}
	
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public GoodsDetai(Integer id, Goods goods, String name, String goodsCode,
			String shopCode, String barCode, String type1, String type2,
			String type3, String type4, String picGroupId,
			BigDecimal stockPrice, BigDecimal lastStockPrice,
			BigDecimal retailPrice, BigDecimal costPrice, Integer state,
			Set goodsDetailSubbranchs) {
		super();
		this.id = id;
		this.goods = goods;
		this.name = name;
		this.goodsCode = goodsCode;
		this.shopCode = shopCode;
		this.barCode = barCode;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.picGroupId = picGroupId;
		this.stockPrice = stockPrice;
		this.baiduPrice = baiduPrice;
		this.retailPrice = retailPrice;
		this.costPrice = costPrice;
		this.state = state;
		this.goodsDetailSubbranchs = goodsDetailSubbranchs;
	}

}