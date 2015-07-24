package baidu.giftshop.util;

import java.util.List;

import baidu.giftshop.model.GoodsPicture;

public class BriefGoodsBean {
	
	private Integer id;
	
	private String unit;
	
	private Integer classify_id;
	
	private String name;
	
	public List<GoodsPicture> pictures;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getClassify_id() {
		return classify_id;
	}

	public void setClassify_id(Integer classify_id) {
		this.classify_id = classify_id;
	}

	public List<GoodsPicture> getPictures() {
		return pictures;
	}

	public void setPictures(List<GoodsPicture> pictures) {
		this.pictures = pictures;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BriefGoodsBean(Integer id, String unit, Integer classify_id,
			String name, List<GoodsPicture> pictures) {
		super();
		this.id = id;
		this.unit = unit;
		this.classify_id = classify_id;
		this.name = name;
		this.pictures = pictures;
	}

	public BriefGoodsBean() {
		super();
	}
}
