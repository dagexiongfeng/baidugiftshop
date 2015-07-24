package baidu.giftshop.util;

import java.util.List;

import baidu.giftshop.model.Classify;

public class ClassifyBean {
	
	private Integer subbranch_id;
	
	private List<Classify> classifications;

	public Integer getSubbranch_id() {
		return subbranch_id;
	}

	public void setSubbranch_id(Integer subbranch_id) {
		this.subbranch_id = subbranch_id;
	}

	public List<Classify> getClassifications() {
		return classifications;
	}

	public void setClassifications(List<Classify> classifications) {
		this.classifications = classifications;
	}

	public ClassifyBean(Integer subbranch_id, List<Classify> classifications) {
		super();
		this.subbranch_id = subbranch_id;
		this.classifications = classifications;
	}

	public ClassifyBean() {
		super();
	}
}
