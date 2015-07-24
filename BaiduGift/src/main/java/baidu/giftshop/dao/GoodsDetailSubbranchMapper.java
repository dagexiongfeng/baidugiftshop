package baidu.giftshop.dao;

import baidu.giftshop.model.GoodsDetailSubbranch;

public interface GoodsDetailSubbranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDetailSubbranch record);

    int insertSelective(GoodsDetailSubbranch record);

    GoodsDetailSubbranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsDetailSubbranch record);

    int updateByPrimaryKey(GoodsDetailSubbranch record);
    
    int queryAmount(Integer goods_detail_id,Integer subbranch_id);
    void updateAmount(Integer goodsDetailId,Integer subbranchId,Integer amount);
}