package ltd.newimg.service.impl;

import ltd.newimg.mapper.OrderMapper;
import ltd.newimg.pojo.Order;
import ltd.newimg.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:49
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order createOrder(Order order) {
        return orderMapper.save(order);
    }
}
