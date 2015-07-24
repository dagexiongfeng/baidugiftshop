package baidu.giftshop.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classify entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("rawtypes")
public class Classify implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String code;
	private String name;
	private Set classifySubbranchs = new HashSet(0);
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classify() {
	}

	/** full constructor */
	public Classify(String code, String name, Set classifySubbranchs,
			Set goodses) {
		this.code = code;
		this.name = name;
		this.classifySubbranchs = classifySubbranchs;
		this.goodses = goodses;
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

	public Set getClassifySubbranchs() {
		return this.classifySubbranchs;
	}

	public void setClassifySubbranchs(Set classifySubbranchs) {
		this.classifySubbranchs = classifySubbranchs;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}