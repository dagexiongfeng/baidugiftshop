package baidu.giftshop.entity;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private String addressee;
	private String phone;
	private String address;
	private String zipCode;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Integer userid, String addressee, String phone,
			String address) {
		this.userid = userid;
		this.addressee = addressee;
		this.phone = phone;
		this.address = address;
	}

	/** full constructor */
	public Address(Integer userid, String addressee, String phone,
			String address, String zipCode) {
		this.userid = userid;
		this.addressee = addressee;
		this.phone = phone;
		this.address = address;
		this.zipCode = zipCode;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getAddressee() {
		return this.addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}