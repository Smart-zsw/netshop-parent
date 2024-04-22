package com.zsw.netshop.manager.task;

import cn.hutool.core.date.DateUtil;
import com.zsw.netshop.manager.mapper.OrderInfoMapper;
import com.zsw.netshop.manager.mapper.OrderStatisticsMapper;
import com.zsw.netshop.model.entity.order.OrderStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderStatisticsTask {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;

    //每天凌晨两点，查询前一天统计数据，把统计之后数据添加统计结果表里
    @Scheduled(cron = "0 0 2 * * ?")
    public void orderTotalAmountStatistics() {
        //1 获取前一天日期
        String createDate = DateUtil.offsetDay(new Date(), -1).toString("yyyy-MM-dd");

        //2 根据前一天日期进行统计功能，（分组操作）
        //统计前一天交易金额
        OrderStatistics orderStatistics = orderInfoMapper.selectStatisticsByDate(createDate);

        //3 把统计之后的数据，添加统计结果表里
        if (orderStatistics != null){
            orderStatisticsMapper.insert(orderStatistics);
        }
    }
}
