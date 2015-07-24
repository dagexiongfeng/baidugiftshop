package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.GoodsDetail;
import baidu.giftshop.util.GoodsDetailB;

public interface GoodsDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    GoodsDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);
    
    @SuppressWarnings("rawtypes")
	List Type1(Integer goods_id);
    
    @SuppressWarnings("rawtypes")
	List Type2(Integer goods_id);
    
    @SuppressWarnings("rawtypes")
	List Type3(Integer goods_id);
    
    @SuppressWarnings("rawtypes")
	List Type4(Integer goods_id);
    
    int selectGroupId(Integer goods_id);
    
    List<GoodsDetailB> selectBySubIdAndGoodsId(Integer subbranch_id,Integer goods_id);
}