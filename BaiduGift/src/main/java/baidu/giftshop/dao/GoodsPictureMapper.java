package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.GoodsPicture;

public interface GoodsPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPicture record);

    int insertSelective(GoodsPicture record);

    GoodsPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsPicture record);

    int updateByPrimaryKey(GoodsPicture record);
    
    List<GoodsPicture> selectByGoodsId(Integer goods_id);
}