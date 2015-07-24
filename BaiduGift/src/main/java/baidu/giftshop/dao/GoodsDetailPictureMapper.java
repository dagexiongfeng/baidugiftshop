package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.GoodsDetailPicture;

public interface GoodsDetailPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDetailPicture record);

    int insertSelective(GoodsDetailPicture record);

    GoodsDetailPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsDetailPicture record);

    int updateByPrimaryKey(GoodsDetailPicture record);
    
    List<GoodsDetailPicture> getPicGroup(Integer picId);
}