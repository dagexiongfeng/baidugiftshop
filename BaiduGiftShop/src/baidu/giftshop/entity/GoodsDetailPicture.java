package baidu.giftshop.entity;

/**
 * GoodsDetailPicture entity. @author MyEclipse Persistence Tools
 */
public class GoodsDetailPicture implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	private Integer id;
	private String groupId;
	private String path;
	private String thumbPath;
	private Double ratio;
	private String picGroupName;
	public String getPicGroupName() {
		return picGroupName;
	}

	public void setPicGroupName(String picGroupName) {
		this.picGroupName = picGroupName;
	}

	// Constructor
	/** default constructor */
	public GoodsDetailPicture() {
	}

	/** full constructor */
	public GoodsDetailPicture(Integer id, String groupId, String path,
			String thumbPath, Double ratio) {
		super();
		this.id = id;
		this.groupId = groupId;
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

	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
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