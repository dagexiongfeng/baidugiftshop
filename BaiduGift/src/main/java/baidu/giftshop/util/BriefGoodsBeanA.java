package baidu.giftshop.util;

import java.util.List;

public class BriefGoodsBeanA<T> {
	
	private Integer subbranch_id;
	
	private Integer startIndex;
	
	private Integer requestAmount;
	
	private List<T> goodes;

	public Integer getSubbranch_id() {
		return subbranch_id;
	}

	public void setSubbranch_id(Integer subbranch_id) {
		this.subbranch_id = subbranch_id;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getRequestAmount() {
		return requestAmount;
	}

	public void setRequestAmount(Integer requestAmount) {
		this.requestAmount = requestAmount;
	}

	public List<T> getGoodes() {
		return goodes;
	}

	public void setGoodes(List<T> goodes) {
		this.goodes = goodes;
	}

	public BriefGoodsBeanA(Integer subbranch_id, Integer startIndex,
			Integer requestAmount, List<T> goodes) {
		super();
		this.subbranch_id = subbranch_id;
		this.startIndex = startIndex;
		this.requestAmount = requestAmount;
		this.goodes = goodes;
	}

	public BriefGoodsBeanA() {
		super();
	}
}
