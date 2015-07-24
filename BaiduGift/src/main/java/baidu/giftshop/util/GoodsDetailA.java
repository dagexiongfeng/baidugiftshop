package baidu.giftshop.util;

import java.util.List;

import baidu.giftshop.model.GoodsDetailPicture;

public class GoodsDetailA {
	public Integer id;
	public List<GoodsDetailPicture> pictures;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<GoodsDetailPicture> getPictures() {
		return pictures;
	}
	public void setPictures(List<GoodsDetailPicture> pictures) {
		this.pictures = pictures;
	}
	public GoodsDetailA(Integer id, List<GoodsDetailPicture> pictures) {
		super();
		this.id = id;
		this.pictures = pictures;
	}
	public GoodsDetailA() {
		super();
	}
}
