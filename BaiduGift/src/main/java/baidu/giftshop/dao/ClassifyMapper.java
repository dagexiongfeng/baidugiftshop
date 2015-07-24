package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Classify;

public interface ClassifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    int insertSelective(Classify record);

    Classify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
    
/*================================自己写的方法===================================*/
    List<Classify> getAllClassify(Integer subbranch_id);
}