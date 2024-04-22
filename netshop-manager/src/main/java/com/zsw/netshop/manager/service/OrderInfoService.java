package com.zsw.netshop.manager.service;

import com.zsw.netshop.model.dto.order.OrderStatisticsDto;
import com.zsw.netshop.model.vo.order.OrderStatisticsVo;

public interface OrderInfoService {

    OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto);
}
