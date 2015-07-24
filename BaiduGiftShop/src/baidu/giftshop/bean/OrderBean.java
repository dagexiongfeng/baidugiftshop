package baidu.giftshop.bean;

public class OrderBean {
	
	private Integer orderid;
    private String username;
    private String goodsname;
    private String num;
    private String goodscode;
    private String addressee;
    private String address;
    private String state;
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodscode() {
		return goodscode;
	}
	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public OrderBean(Integer orderid, String username, String goodsname,
			String num, String goodscode, String addressee, String address,
			String state) {
		super();
		this.orderid = orderid;
		this.username = username;
		this.goodsname = goodsname;
		this.num = num;
		this.goodscode = goodscode;
		this.addressee = addressee;
		this.address = address;
		this.state = state;
	}
	public OrderBean() {
		super();
	}
}
