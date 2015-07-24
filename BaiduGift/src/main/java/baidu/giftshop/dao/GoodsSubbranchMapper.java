package baidu.giftshop.dao;

import baidu.giftshop.model.GoodsSubbranch;

public interface GoodsSubbranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsSubbranch record);

    int insertSelective(GoodsSubbranch record);

    GoodsSubbranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsSubbranch record);

    int updateByPrimaryKey(GoodsSubbranch record);
}