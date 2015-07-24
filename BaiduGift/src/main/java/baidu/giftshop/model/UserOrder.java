package baidu.giftshop.model;

public class UserOrder {
    private Integer id;

    private Integer userid;

    private Integer orderid;

    private String paytime;

    private String shipnum;

    private String fedex;

    private String deliverytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime == null ? null : paytime.trim();
    }

    public String getShipnum() {
        return shipnum;
    }

    public void setShipnum(String shipnum) {
        this.shipnum = shipnum == null ? null : shipnum.trim();
    }

    public String getFedex() {
        return fedex;
    }

    public void setFedex(String fedex) {
        this.fedex = fedex == null ? null : fedex.trim();
    }

    public String getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(String deliverytime) {
        this.deliverytime = deliverytime == null ? null : deliverytime.trim();
    }
}