package baidu.giftshop.util;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class GoodsDetailB {
	public Integer id;
	public String name;
	public String goods_code;
	public String shop_code;
	public String bar_code;
	public String type1;
	public String type2;
	public String type3;
	public String type4;
	public Integer pic_group_id;
	public String   stock_price;
	public String   last_stock_price;
	public String   retail_price;
	public String   cost_price;
	public Integer amount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getShop_code() {
		return shop_code;
	}
	public void setShop_code(String shop_code) {
		this.shop_code = shop_code;
	}
	public String getBar_code() {
		return bar_code;
	}
	public void setBar_code(String bar_code) {
		this.bar_code = bar_code;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public Integer getPic_group_id() {
		return pic_group_id;
	}
	public void setPic_group_id(Integer pic_group_id) {
		this.pic_group_id = pic_group_id;
	}

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public GoodsDetailB(Integer id, String name, String goods_code,
			String shop_code, String bar_code, String type1, String type2,
			String type3, String type4, Integer pic_group_id,
			String stock_price, String last_stock_price, String retail_price,
			String cost_price, Integer amount) {
		super();
		this.id = id;
		this.name = name;
		this.goods_code = goods_code;
		this.shop_code = shop_code;
		this.bar_code = bar_code;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.pic_group_id = pic_group_id;
		this.stock_price = stock_price;
		this.last_stock_price = last_stock_price;
		this.retail_price = retail_price;
		this.cost_price = cost_price;
		this.amount = amount;
	}
	public String getStock_price() {
		return stock_price;
	}
	public void setStock_price(String stock_price) {
		this.stock_price = stock_price;
	}
	public String getLast_stock_price() {
		return last_stock_price;
	}
	public void setLast_stock_price(String last_stock_price) {
		this.last_stock_price = last_stock_price;
	}
	public String getRetail_price() {
		return retail_price;
	}
	public void setRetail_price(String retail_price) {
		this.retail_price = retail_price;
	}
	public String getCost_price() {
		return cost_price;
	}
	public void setCost_price(String cost_price) {
		this.cost_price = cost_price;
	}
	public GoodsDetailB() {
		super();
	}
}
