package baidu.giftshop.entity;

/**
 * UserOrder entity. @author MyEclipse Persistence Tools
 */

public class UserOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Integer orderid;
	private String paytime;
	private String shipnum;
	private String fedex;
	private String deliverytime;

	// Constructors

	/** default constructor */
	public UserOrder() {
	}

	/** full constructor */
	public UserOrder(User user, Integer orderid) {
		this.user = user;
		this.orderid = orderid;
	}
	

	public UserOrder(Integer id, User user, Integer orderid, String paytime,
			String shipnum, String fedex, String deliverytime) {
		super();
		this.id = id;
		this.user = user;
		this.orderid = orderid;
		this.paytime = paytime;
		this.shipnum = shipnum;
		this.fedex = fedex;
		this.deliverytime = deliverytime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getPaytime() {
		return paytime;
	}

	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}

	public String getShipnum() {
		return shipnum;
	}

	public void setShipnum(String shipnum) {
		this.shipnum = shipnum;
	}

	public String getFedex() {
		return fedex;
	}

	public void setFedex(String fedex) {
		this.fedex = fedex;
	}

	public String getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}

}