package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.dto.order.OrderStatisticsDto;
import com.zsw.netshop.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderStatisticsMapper {

    //把统计之后的数据，添加统计结果表里
    void insert(OrderStatistics orderStatistics);

    List<OrderStatistics> selectList(OrderStatisticsDto orderStatisticsDto);
}
