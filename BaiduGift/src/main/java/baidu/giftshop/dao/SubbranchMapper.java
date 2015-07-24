package baidu.giftshop.dao;

import java.util.List;

import baidu.giftshop.model.Subbranch;

public interface SubbranchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subbranch record);

    int insertSelective(Subbranch record);

    Subbranch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subbranch record);

    int updateByPrimaryKey(Subbranch record);
    
    List<Subbranch> getAllSubbranch();
}