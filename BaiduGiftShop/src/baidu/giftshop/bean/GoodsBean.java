package baidu.giftshop.bean;

public class GoodsBean {
	
	private Integer goods_id;
	
	private Integer goods_picture_id;

	public Integer getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}

	public Integer getGoods_picture_id() {
		return goods_picture_id;
	}

	public void setGoods_picture_id(Integer goods_picture_id) {
		this.goods_picture_id = goods_picture_id;
	}

	public GoodsBean(Integer goods_id, Integer goods_picture_id) {
		super();
		this.goods_id = goods_id;
		this.goods_picture_id = goods_picture_id;
	}

	public GoodsBean() {
		super();
	}
}
