package com.jh.user.controller;

import com.jh.user.cart.Cart;
import com.jh.entity.*;
import com.jh.user.cart.CartItem;
import com.jh.user.service.UserService;
import com.jh.user.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String selectByNameAndPwd(@RequestParam("username") String username, @RequestParam("password") String password,
                                     HttpSession session, RedirectAttributes redirectAttributes)throws Exception{

        User user = userService.selectByNameAndPwd(username,password);

        //验证用户名密码失败时
        if(user == null){
            redirectAttributes.addFlashAttribute("errMsg","用户名或密码错误");
            return "redirect:/user/login2";
        }

        //将用户信息放入实体中
        session.setAttribute("user",user);
        return "user/index";
    }


    @RequestMapping(value = "login2")
    public String redirect(){

        return "user/login";
    }

    /**
     * 用户退出
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session)throws Exception{
        //销毁session
        session.invalidate();
        return "user/login";
    }

    /**
     * 查询店铺
     * @param cid
     * @param session
     * @return
     */
    @RequestMapping(value = "findMerchant")
    public String findMerchant(@RequestParam("cid") long cid,HttpSession session){

        List<Merchant> list =  userService.findMerchant(cid);
        session.setAttribute("list",list);
        return "user/list";
    }

    /**
     * 用户查询食物
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findFoodDetail")
    public String findFoodDetail(@RequestParam("mid") long mid,
                                  HttpSession session)throws Exception{

        List<Food> list2 = userService.findFoodDetail(mid);
        session.setAttribute("list2",list2);
        return "user/foodDetail";
    }

    /**
     * 添加到购物车
     * @param request
     * @param fid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addCart")
    public String addCart(HttpServletRequest request,
                          @RequestParam("fid") long fid)throws Exception{
        int count = 1;
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }

        Food food = userService.findFood(fid);
        CartItem cartItem = new CartItem();
        cartItem.setFood(food);
        cartItem.setCount(count);

        cart.add(cartItem);

        return "user/cart";
    }

    /**
     * 删除指定条目
     * @param fid
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete")
    public String delete(long fid,HttpServletRequest request)throws Exception{

        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cart.delete(fid);

        return "user/cart";
    }

    /**
     * 清空购物车
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "deleteAll")
    public String deleteAll(HttpServletRequest request)throws Exception{
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        cart.clear();
        return "user/cart";
    }

    /**
     * 判断用户余额是否充足
     * @param session
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "judge")
    public String judge(HttpSession session,HttpServletRequest request)throws Exception{
        //从session中获取用户账户余额
        User user = (User)session.getAttribute("user");
        float balance = user.getBalance();
        //获取购物车商品总价
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        float total = (float)cart.getTotal();
        //账户余额必须大于购物车商品总价
        if(balance < total){
            session.setAttribute("msg","账户余额不足");
            return "user/payFail";
        }
        return "user/pay";
    }


    /**
     * 添加订单
     * @param request
     * @param phone
     * @param address
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addOrder")
    public String addOrder(HttpServletRequest request,@RequestParam("phone") String phone,
                       @RequestParam("address") String address,RedirectAttributes redirectAttributes)throws Exception{

        //session获取购物车
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        //创建订单对象并设置属性
        Orders order = new Orders();
        //随机创建5位数字串
        order.setOid(Long.parseLong(Uuid.randomNum1(5)));
        Timestamp d = new Timestamp(System.currentTimeMillis());
        order.setOrdertime(d);
        order.setState(1);//收货状态   1：未付款 2：未收货 3：已收货
        order.setTotal((float)cart.getTotal());
        User user = (User)request.getSession().getAttribute("user");
        order.setUid(user.getUid());
        order.setPhone(phone);
        order.setAddress(address);

        userService.addOrder(order);

        //将oid传到pay方法中
        redirectAttributes.addAttribute("oid",order.getOid());

        //循环遍历cart,用orderItem替换cartItem
        for(CartItem cartItem : cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(cartItem.getCount());
            orderItem.setFid(cartItem.getFood().getFid());
            orderItem.setSubtotal((float)cartItem.getSubtotal());
            orderItem.setOid(order.getOid());

            userService.addOrderItem(orderItem);

        }
        //清空购物车
        cart.clear();

        return "redirect:/user/pay";
    }

    /**
     * 支付功能
     * @param oid
     * @param request
     * @param session
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "pay")
    public String pay(@RequestParam("oid") long oid,HttpServletRequest request,HttpSession session,
                      RedirectAttributes redirectAttributes)throws Exception{
        Orders order = userService.findOrder(oid);
        //获取订单总金额
        float total = order.getTotal();
        //获取session中的用户id
        User user = (User)session.getAttribute("user");
        long uid = user.getUid();
        request.setAttribute("order",order);
        int a = userService.pay(total,uid);
        if(a <= 0){
            return "user/payFail";
        }
        return "user/paySuccess";
    }


    /**
     * 根据用户id查询订单
     * @param uid
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findOrders")
    public String findOrders(@RequestParam("uid") long uid,HttpSession session)throws Exception{

        List<Orders> listOrders = userService.findOrders(uid);
        session.setAttribute("listOrders",listOrders);
        return "user/orders";
    }

    /**
     * 确认收货
     * @param oid
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "over")
    public String over(@RequestParam("oid") long oid,HttpSession session)throws Exception{

        int a = userService.over(oid);
        if(a <= 0){
            return "user/payFail";
        }
        return "redirect:/user/over2";
    }

    /**
     * 查询用户订单  配合确认收货后页面的更新
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "over2")
    public String over2(HttpSession session)throws Exception{

        User user = (User)session.getAttribute("user");
        long uid = user.getUid();
        List<Orders> listOrders = userService.findOrders(uid);
        session.setAttribute("listOrders",listOrders);
        return "user/orders";
    }

    /**
     * 查看订单详情
     * @param oid
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "orderDetail")
    public String orderDetail(@RequestParam("oid") long oid,HttpSession session)throws Exception{
        //查找订单并放入sesison中
        Orders order = userService.findOrder(oid);
        session.setAttribute("order",order);

        //查询订单详情
        List<OrderItem> listOrderItem = userService.orderDetail(oid);
        session.setAttribute("listOrderItem",listOrderItem);

        List<Food> listFood = new ArrayList<Food>();
        //遍历List查找食物id
        for (OrderItem orderItem : listOrderItem) {
            long fid = orderItem.getFid();
            //根据食物id查找到食物对象
            Food food = userService.findFood(fid);
            //将食物对象添加到List集合中
            listFood.add(food);
        }
        //将List集合保存到session
        session.setAttribute("listFood",listFood);


        return "user/orderItem";
    }

}
