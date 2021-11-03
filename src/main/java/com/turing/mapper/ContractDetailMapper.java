package com.turing.mapper;

import com.turing.entity.ContractDetail;
import com.turing.entity.ContractDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractDetailMapper {
    int countByExample(ContractDetailExample example);

    int deleteByExample(ContractDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContractDetail record);

    int insertSelective(ContractDetail record);

    List<ContractDetail> selectByExample(ContractDetailExample example);

    ContractDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContractDetail record, @Param("example") ContractDetailExample example);

    int updateByExample(@Param("record") ContractDetail record, @Param("example") ContractDetailExample example);

    int updateByPrimaryKeySelective(ContractDetail record);

    int updateByPrimaryKey(ContractDetail record);
}