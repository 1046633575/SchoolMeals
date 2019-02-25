package com.jh.admin.service;

import com.jh.entity.*;

import java.util.List;

public interface AdminService {


    Admin selectByNameAndPwd(String username, String password);


    List<Merchant> selectFindAllMerchant();

    List<Merchant> selectFindMerchant(long cid);

    int addMerchant(Merchant merchant);

    List<Category> findAllCategory();

    List<Orders> findAllOrders();

    List<OrderItem> findOrders(long oid);

    int addFood(Food food);

    List<Food> findFoodDetail(long mid);

    int deleteMerchant(long mid);

    int deleteFood(long fid);

    Orders findOrder(long oid);
}
