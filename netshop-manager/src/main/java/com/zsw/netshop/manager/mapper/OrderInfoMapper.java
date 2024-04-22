package com.zsw.netshop.manager.mapper;

import com.zsw.netshop.model.entity.order.OrderStatistics;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderInfoMapper {

    //统计前一天交易金额
    OrderStatistics selectStatisticsByDate(String createDate);
}
