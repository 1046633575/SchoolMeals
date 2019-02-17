package com.jh.user.cart;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>();

    /**
     * 计算合计
     * @return
     */
    public double getTotal(){
        //合计
        BigDecimal total = new BigDecimal("0");
        for(CartItem cartItem : map.values()){
            BigDecimal subtotal = new BigDecimal("" + cartItem.getSubtotal());
            total = total.add(subtotal);
        }
        return total.doubleValue();
    }

    /**
     * 添加条目
     * @param cartItem
     */
    public void add(CartItem cartItem){
        //将long类型转化为String类型 方便操作map
        String a = Long.toString(cartItem.getFood().getFid());
        if(map.containsKey(a)){//判断原来的购物车session中是否存在该条目
            //返回原条目
            CartItem cartItem1 = map.get(a);
            cartItem1.setCount(cartItem1.getCount() + cartItem.getCount());
            //更新条目数
            map.put(Long.toString(cartItem.getFood().getFid()),cartItem1);
        } else{
            map.put(Long.toString(cartItem.getFood().getFid()),cartItem);
        }
    }

    /**
     * 清空
     */
    public void clear(){
        map.clear();
    }

    /**
     * 删除指定条目
     * @param fid
     */
    public void delete(long fid){
        //先将long类型转换为String类型
        String a = Long.toString(fid);
        map.remove(a);
    }

    /**
     * 获取所有条目
     * @return
     */
    public Collection<CartItem> getCartItems(){
        return map.values();
    }
}
