package com.jh.admin.dao;

import com.jh.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminDao {

    /**
     * 管理员登录模块
     * 查询用户名与密码
     * @param username
     * @param password
     * @return
     */
    Admin selectByNameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 查询所有店铺
     * @return
     */
    List<Merchant> selectFindAllMerchant();

    /**
     * 根据id查询店铺
     * @param cid
     * @return
     */
    List<Merchant> selectFindMerchant(@Param("cid") long cid);

    /**
     * 查询所有分类
     * @return
     */
    List<Category> findAllCategory();

    /**
     * 添加店铺
     */
    int addMerchant(Merchant merchant);

    /**
     * 查询所有订单
     * @return
     */
    List<Orders> findAllOrders();

    /**
     * 查询订单详细
     * @param oid
     * @return
     */
    List<OrderItem> findOrders(@Param("oid") long oid);

    /**
     * 添加食物
     * @param food
     * @return
     */
    int addFood(Food food);

    /**'
     * 查找食物
     * @param mid
     * @return
     */
    List<Food> findFoodDetail(@Param("mid") long mid);

    /**
     * 删除店铺
     * @param mid
     * @return
     */
    int deleteMerchant(@Param("mid") long mid);

    /**
     * 删除食物
     * @param fid
     * @return
     */
    int deleteFood(@Param("fid") long fid);

    /**
     * 查询订单
     * @param oid
     * @return
     */
    Orders findOrder(@Param("oid") long oid);

}
