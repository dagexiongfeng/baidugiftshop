package baidu.giftshop.model;

import java.util.Date;

public class Orders {
    private Integer id;

    private Integer orderid;

    private Integer goodDetailId;

    private Integer addressid;

    private Integer num;

    private String state;

    private Date data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
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