package baidu.giftshop.model;

import java.math.BigDecimal;

public class GoodsDetail {
    private Integer id;

    private Integer goodsId;

    private String name;

    private String goodsCode;

    private String shopCode;

    private String barCode;

    private String type1;

    private String type2;

    private String type3;

    private String type4;

    private Integer picGroupId;

    private BigDecimal stockPrice;

    private BigDecimal baiduPrice;

    public BigDecimal getBaiduPrice() {
		return baiduPrice;
	}

	public void setBaiduPrice(BigDecimal baiduPrice) {
		this.baiduPrice = baiduPrice;
	}

	private BigDecimal retailPrice;

    private BigDecimal costPrice;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1 == null ? null : type1.trim();
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2 == null ? null : type2.trim();
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3 == null ? null : type3.trim();
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4 == null ? null : type4.trim();
    }

    public Integer getPicGroupId() {
        return picGroupId;
    }

    public void setPicGroupId(Integer picGroupId) {
        this.picGroupId = picGroupId;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
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
}