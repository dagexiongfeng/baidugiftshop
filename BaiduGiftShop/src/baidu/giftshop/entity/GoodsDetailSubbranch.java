package baidu.giftshop.entity;

/**
 * GoodsDetailSubbranch entity. @author MyEclipse Persistence Tools
 */
public class GoodsDetailSubbranch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Subbranch subbranch;
	private GoodsDetai goodsDetai;
	private Integer amount;

	// Constructors

	/** default constructor */
	public GoodsDetailSubbranch() {
	}

	/** full constructor */
	public GoodsDetailSubbranch(Subbranch subbranch, GoodsDetai goodsDetai,
			Integer amount) {
		this.subbranch = subbranch;
		this.goodsDetai = goodsDetai;
		this.amount = amount;
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

	public GoodsDetai getGoodsDetai() {
		return this.goodsDetai;
	}

	public void setGoodsDetai(GoodsDetai goodsDetai) {
		this.goodsDetai = goodsDetai;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}