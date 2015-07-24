package baidu.giftshop.entity;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String account;
	private String password;
	private Integer authority;
	private Integer subbranchId;
	private String email;
	private String tel;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** minimal constructor */
	public Account(String account, String password, Integer authority) {
		this.account = account;
		this.password = password;
		this.authority = authority;
	}

	/** full constructor */
	public Account(String account, String password, Integer authority,
			Integer subbranchId) {
		this.account = account;
		this.password = password;
		this.authority = authority;
		this.subbranchId = subbranchId;
	}

	
	public Account(Integer id, String account, String password,
			Integer authority, Integer subbranchId, String email, String tel) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.authority = authority;
		this.subbranchId = subbranchId;
		this.email = email;
		this.tel = tel;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Integer getSubbranchId() {
		return this.subbranchId;
	}

	public void setSubbranchId(Integer subbranchId) {
		this.subbranchId = subbranchId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}