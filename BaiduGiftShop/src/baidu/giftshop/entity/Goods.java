package baidu.giftshop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("rawtypes")
public class Goods implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Classify classify;
	private String unit;
	private String name;
	private Integer state;
	private Set goodsSubbranchs = new HashSet(0);
	private Set goodsPictures = new HashSet(0);
	private Set goodsDetais = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Classify classify) {
		this.classify = classify;
	}

	/** full constructor */
	public Goods(Classify classify, String unit, String name,
			Set goodsSubbranchs, Set goodsPictures, Set goodsDetais) {
		this.classify = classify;
		this.unit = unit;
		this.name = name;
		this.goodsSubbranchs = goodsSubbranchs;
		this.goodsPictures = goodsPictures;
		this.goodsDetais = goodsDetais;
	}
	
	public Goods(Integer id, Classify classify, String unit, String name,
			Integer state, Set goodsSubbranchs, Set goodsPictures,
			Set goodsDetais) {
		super();
		this.id = id;
		this.classify = classify;
		this.unit = unit;
		this.name = name;
		this.state = state;
		this.goodsSubbranchs = goodsSubbranchs;
		this.goodsPictures = goodsPictures;
		this.goodsDetais = goodsDetais;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Classify getClassify() {
		return this.classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getGoodsSubbranchs() {
		return this.goodsSubbranchs;
	}

	public void setGoodsSubbranchs(Set goodsSubbranchs) {
		this.goodsSubbranchs = goodsSubbranchs;
	}

	public Set getGoodsPictures() {
		return this.goodsPictures;
	}

	public void setGoodsPictures(Set goodsPictures) {
		this.goodsPictures = goodsPictures;
	}

	public Set getGoodsDetais() {
		return this.goodsDetais;
	}

	public void setGoodsDetais(Set goodsDetais) {
		this.goodsDetais = goodsDetais;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}