package baidu.giftshop.entity;

/**
 * GoodsSubbranch entity. @author MyEclipse Persistence Tools
 */

public class GoodsSubbranch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Goods goods;
	private Subbranch subbranch;

	// Constructors

	/** default constructor */
	public GoodsSubbranch() {
	}

	/** full constructor */
	public GoodsSubbranch(Goods goods, Subbranch subbranch) {
		this.goods = goods;
		this.subbranch = subbranch;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Subbranch getSubbranch() {
		return this.subbranch;
	}

	public void setSubbranch(Subbranch subbranch) {
		this.subbranch = subbranch;
	}

}