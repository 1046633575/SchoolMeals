package com.jh.user.dao;

import com.jh.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * 用户登录模块
     * 用用户名与密码查询返回用户信息
     * @param username
     * @param password
     * @return
     */
    User selectByNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 分类查询店铺
     * @param cid
     * @return
     */
    List<Merchant> findMerchant(@Param("cid") long cid);

    /**
     * 查询食物
     * @return
     */
    List<Food> findFoodDetail(@Param("mid") long mid);

    /**
     * 加载食物信息
     * @param fid
     * @return
     */
    Food findFood(@Param("fid") long fid);

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
    Orders findOrder(@Param("oid") long oid);

    /**
     * 支付  余额 减 商品金额
     * @return
     */
    int pay(@Param("total") float total,@Param("uid") long uid);

    /**
     * 查询用户订单
     * @param uid
     * @return
     */
    List<Orders> findOrders(@Param("uid") long uid);

    /**
     * 确认收货
     * @param oid
     * @return
     */
    int over(@Param("oid")long oid);

    /**
     * 订单详情
     * @param oid
     * @return
     */
    List<OrderItem> orderDetail(@Param("oid") long oid);



}
