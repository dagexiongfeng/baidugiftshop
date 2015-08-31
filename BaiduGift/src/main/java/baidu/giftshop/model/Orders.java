package baidu.giftshop.model;

import java.util.Date;

public class Orders {
    private Integer id;

    private String orderid;

    private Integer goodDetailId;

    private Integer addressid;

    private Integer num;

    private String state;
    
    private String totalMoney;

	private Date data;
    
    private Integer subbranchId;

    public Integer getSubbranchId() {
		return subbranchId;
	}

	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}
    public String getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(String totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getGoodDetailId() {
        return goodDetailId;
    }

    public void setGoodDetailId(Integer goodDetailId) {
        this.goodDetailId = goodDetailId;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}