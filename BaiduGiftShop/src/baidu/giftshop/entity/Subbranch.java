package baidu.giftshop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Subbranch entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class Subbranch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String name;
	private String country;
	private String province;
	private String city;
	private String county;
	private String street;
	private Set goodsDetailSubbranchs = new HashSet(0);
	private Set goodsSubbranchs = new HashSet(0);
	private Set classifySubbranchs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subbranch() {
	}

	/** full constructor */
	public Subbranch(String code, String name, String country, String province,
			String city, String county, String street,
			Set goodsDetailSubbranchs, Set goodsSubbranchs,
			Set classifySubbranchs) {
		this.code = code;
		this.name = name;
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
		this.street = street;
		this.goodsDetailSubbranchs = goodsDetailSubbranchs;
		this.goodsSubbranchs = goodsSubbranchs;
		this.classifySubbranchs = classifySubbranchs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Set getGoodsDetailSubbranchs() {
		return this.goodsDetailSubbranchs;
	}

	public void setGoodsDetailSubbranchs(Set goodsDetailSubbranchs) {
		this.goodsDetailSubbranchs = goodsDetailSubbranchs;
	}

	public Set getGoodsSubbranchs() {
		return this.goodsSubbranchs;
	}

	public void setGoodsSubbranchs(Set goodsSubbranchs) {
		this.goodsSubbranchs = goodsSubbranchs;
	}

	public Set getClassifySubbranchs() {
		return this.classifySubbranchs;
	}

	public void setClassifySubbranchs(Set classifySubbranchs) {
		this.classifySubbranchs = classifySubbranchs;
	}

}