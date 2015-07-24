package baidu.giftshop.entity;

/**
 * GoodsPicture entity. @author MyEclipse Persistence Tools
 */

public class GoodsPicture implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Goods goods;
	private String path;
	private String thumbPath;
	private Double ratio;

	// Constructors

	/** default constructor */
	public GoodsPicture() {
	}

	/** minimal constructor */
	public GoodsPicture(Goods goods) {
		this.goods = goods;
	}

	/** full constructor */
	public GoodsPicture(Integer id, Goods goods, String path, String thumbPath,
			Double ratio) {
		super();
		this.id = id;
		this.goods = goods;
		this.path = path;
		this.thumbPath = thumbPath;
		this.ratio = ratio;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getThumbPath() {
		return this.thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	
}