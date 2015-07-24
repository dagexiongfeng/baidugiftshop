package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Goods;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
 /*================================自己写的方法===================================*/
    List<Goods> selectByClassifyid(Integer subbranch_id,Integer classify_id,Integer startIndex, Integer requestAmount);
    
    List<Goods> selectAllGoods(Integer subbranch_id,Integer startIndex, Integer requestAmount);
    
    List<Goods> queryAllGoods(Integer subbranch_id,Integer startIndex, Integer requestAmount,String name);
    
    List<Goods> queryByClassifyId(Integer subbranch_id,Integer classify_id,Integer startIndex, Integer requestAmount,String name);
}