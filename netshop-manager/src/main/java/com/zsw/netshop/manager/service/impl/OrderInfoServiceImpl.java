package com.zsw.netshop.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.zsw.netshop.manager.mapper.OrderStatisticsMapper;
import com.zsw.netshop.manager.service.OrderInfoService;
import com.zsw.netshop.model.dto.order.OrderStatisticsDto;
import com.zsw.netshop.model.entity.order.OrderStatistics;
import com.zsw.netshop.model.vo.order.OrderStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;

    @Override
    public OrderStatisticsVo getOrderStatisticsData(OrderStatisticsDto orderStatisticsDto) {

        //根据dto条件查询统计结果数据，返回list集合
        List<OrderStatistics> orderStatisticsList = orderStatisticsMapper.selectList(orderStatisticsDto);

        //遍历list集合，得到所有日期，把所有日期封装list新集合里面

        List<String> dateList = orderStatisticsList.stream().map(orderStatistics ->
                DateUtil.format(orderStatistics.getOrderDate(), "yyy-MM-dd"))
                .collect(Collectors.toList());

        //遍历list集合，得到所有日期对应金额，把总金额封装list新集合里面
        List<BigDecimal> decimalList = orderStatisticsList.stream()
                .map(OrderStatistics::getTotalAmount)
                .collect(Collectors.toList());

        //把两个list集合封装OrderStatisticsVo，返回OrderStatisticsVo
        OrderStatisticsVo orderStatisticsVo = new OrderStatisticsVo();
        orderStatisticsVo.setDateList(dateList);
        orderStatisticsVo.setAmountList(decimalList);
        return orderStatisticsVo;
    }
}
