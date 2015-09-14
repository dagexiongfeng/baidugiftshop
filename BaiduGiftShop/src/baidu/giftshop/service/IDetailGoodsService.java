package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.Goods;
import baidu.giftshop.entity.GoodsDetai;

public interface IDetailGoodsService {
	
	public void saveDetailGoods(GoodsDetai goodsDetai);
	public Goods queryGoods(String classifyId,String goodsId);
	public GoodsDetai queryDetaiGoods(String barCode,Integer goodsDetailId);
	public GoodsDetai queryDetaiGoods(String barCode);
	public List<GoodsDetai> listallDetailGoods(PageBean pageBean);
	public String deleteDetail(Integer goodsDetailId);
	public String listDetailByGid(Integer goodsId,Integer subbranch_id,PageBean pageBean);
	public String subDetailGoods(Integer goods_detail_id,Integer subbranch_id,Integer amount);
	public String querySubDetail(Integer subbranchId);
	public String deleteSubDetGoods(Integer goods_detail_id,Integer subbranch_id);
	public String checkGoodsCode(String goodsCode);
	public String listDetailBysubgood(int classifyId, Integer subbranchId);
	public String checkbarcode(String barCode);
	public Goods querygood(String classifyId, String goodsId);
	public String deleteBriefgood(String goodsId);
	public List<GoodsDetai> queryDetailGoods(PageBean pageBean, String goodsCode);
}
