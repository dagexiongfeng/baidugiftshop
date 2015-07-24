package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Evaluation;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
    
    List<Evaluation> queryByUIdAndGId(Integer user_id,Integer goods_id);
    List<Evaluation> queryByGId(Integer goods_id,Integer startIndex,Integer requestAmount);
}