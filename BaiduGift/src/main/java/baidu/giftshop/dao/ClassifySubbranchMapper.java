package baidu.giftshop.dao;

import baidu.giftshop.model.ClassifySubbranch;

public interface ClassifySubbranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassifySubbranch record);

    int insertSelective(ClassifySubbranch record);

    ClassifySubbranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassifySubbranch record);

    int updateByPrimaryKey(ClassifySubbranch record);
}