package baidu.giftshop.entity;

/**
 * ClassifySubbranch entity. @author MyEclipse Persistence Tools
 */

public class ClassifySubbranch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Subbranch subbranch;
	private Classify classify;

	// Constructors

	/** default constructor */
	public ClassifySubbranch() {
	}

	/** full constructor */
	public ClassifySubbranch(Subbranch subbranch, Classify classify) {
		this.subbranch = subbranch;
		this.classify = classify;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subbranch getSubbranch() {
		return this.subbranch;
	}

	public void setSubbranch(Subbranch subbranch) {
		this.subbranch = subbranch;
	}

	public Classify getClassify() {
		return this.classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

}