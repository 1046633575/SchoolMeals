package com.jh.user.service;

import com.jh.entity.*;

import java.util.List;

public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User selectByNameAndPwd(String username,String password);

    /**
     * 查询店铺
     * @param cid
     * @return
     */
    List<Merchant> findMerchant(long cid);

    /**
     * 查询食物
     * @param mid
     * @return
     */
    List<Food> findFoodDetail(long mid);

    /**
     * 加载食物
     * @param fid
     * @return
     */
    Food findFood(long fid);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Orders order);

    /**
     * 添加订单项
     * @param orderItem
     * @return
     */
    int addOrderItem(OrderItem orderItem);

    /**
     * 根据oid查询订单
     * @param oid
     * @return
     */
    Orders findOrder(long oid);

    /**
     * 支付
     * @return
     */
    int pay(float total,long uid);

    /**
     * 查询用户订单
     * @param uid
     * @return
     */
    List<Orders> findOrders(long uid);

    /**
     * 确认收货
     * @param oid
     * @return
     */
    int over(long oid);

    /**
     * 订单详情
     * @param oid
     * @return
     */
    List<OrderItem> orderDetail(long oid);
}
