package baidu.giftshop.service;

import java.util.List;

import baidu.giftshop.bean.PageBean;
import baidu.giftshop.entity.Classify;
import baidu.giftshop.entity.GoodsPicture;

public interface IBriefGoodsService {
	
	public Boolean savegoods(Integer classifyId,String unit,String name);
    public Integer findGoodsId(Integer classifyId,String unit,String name);
    public List<GoodsPicture> queryAllBrief(PageBean pageBean);
    public String DeleteBrief(Integer goods_id);
    public String querygoodsById(Integer Id,PageBean pageBean);
    public List<Classify> ListClassify();
    public void deleteBriefById(Integer goodsId,Integer subbranchId);
    public String subBundlbrief(Integer goodsId,Integer subbranchId);
	public String querySubBrief(Integer subbranchId);
	public String deletesubBriefGoods(Integer goodsId,Integer subbranchId);
	public String querySubgoods(Integer Id,Integer subbranchId);
}
