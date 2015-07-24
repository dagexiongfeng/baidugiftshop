package baidu.giftshop.util;

import java.util.List;
@SuppressWarnings("rawtypes")
public class GoodsDetailC {

	public Integer subbranch_id;
	public Integer classify_id;
	public Integer goods_id;
	public List<GoodsDetailB> detailGoods;
	public List<GoodsDetailA> groupPictures;

	public List type1;
	public List type2;
	public List type3;
	public List type4;
	
	public Integer getSubbranch_id() {
		return subbranch_id;
	}
	public void setSubbranch_id(Integer subbranch_id) {
		this.subbranch_id = subbranch_id;
	}
	public Integer getClassify_id() {
		return classify_id;
	}
	public void setClassify_id(Integer classify_id) {
		this.classify_id = classify_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public List<GoodsDetailB> getDetailGoods() {
		return detailGoods;
	}
	public void setDetailGoods(List<GoodsDetailB> detailGoods) {
		this.detailGoods = detailGoods;
	}
	public List<GoodsDetailA> getGroupPictures() {
		return groupPictures;
	}
	public void setGroupPictures(List<GoodsDetailA> groupPictures) {
		this.groupPictures = groupPictures;
	}

	public List getType1() {
		return type1;
	}
	public void setType1(List type1) {
		this.type1 = type1;
	}
	public List getType2() {
		return type2;
	}
	public void setType2(List type2) {
		this.type2 = type2;
	}
	public List getType3() {
		return type3;
	}
	public void setType3(List type3) {
		this.type3 = type3;
	}
	public List getType4() {
		return type4;
	}
	public void setType4(List type4) {
		this.type4 = type4;
	}
	
	public GoodsDetailC(Integer subbranch_id, Integer classify_id,
			Integer goods_id, List<GoodsDetailB> detailGoods,
			List<GoodsDetailA> groupPictures, List type1, List type2,
			List type3, List type4) {
		super();
		this.subbranch_id = subbranch_id;
		this.classify_id = classify_id;
		this.goods_id = goods_id;
		this.detailGoods = detailGoods;
		this.groupPictures = groupPictures;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
	}
	public GoodsDetailC() {
		super();
	}
}
