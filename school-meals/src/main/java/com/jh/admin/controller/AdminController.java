package com.jh.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.jh.admin.service.AdminService;
import com.jh.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class  AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 管理员登录页面
     */
    @RequestMapping(value = "login",method=RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes redirectAttributes) throws Exception {


        //2.验证用户名和密码
        Admin admin = new Admin();
        admin.setAname(username);
        admin.setApassword(password);
        Admin adminLogin = adminService.selectByNameAndPwd(username,password);

        //用户名或密码失败的情况下
        if(adminLogin == null){

            redirectAttributes.addFlashAttribute("errMsg","用户名或密码错误！");
            System.out.println("用户名或密码错误");
            return "redirect:/admin/login2";
        }

        //放入用户实体到Session中
        session.setAttribute("adminLogin",adminLogin);
        return "admin/index";
    }

    /**
     * 用于配合管理员登录页面的错误反馈
     * redirectAttributes.addFlashAttribute("errMsg","用户名或密码错误！");
     * 需要先重定向至controller再跳转才能传递参数
     * @return
     */
    @RequestMapping(value = "login2")
    public String redirect()throws Exception{
        return "admin/login";
    }

    /**
     * 退出功能
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "admin/login";
    }

    /**
     * 查询所有店铺
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findAll")
    public String selectFindAllMerchant(HttpSession session) throws Exception{
        List<Merchant> list = adminService.selectFindAllMerchant();
        session.setAttribute("list",list);
        return "admin/list";
    }

    /**
     * 查询餐厅分类
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findAllCategory")
    public String findAllCategory(HttpSession session)throws Exception{

        List<Category> list1 = adminService.findAllCategory();
        session.setAttribute("list1",list1);
        return "admin/body";
    }

    /**
     * 添加店铺
     * @param merchant
     * @throws Exception
     */
    @RequestMapping(value = "addMerchant",method=RequestMethod.POST)
    public String addMerchant(Merchant merchant,
                              RedirectAttributes redirectAttributes,
                              @RequestParam("file") CommonsMultipartFile file,
                              HttpServletRequest request)throws Exception{

        Merchant mer = new Merchant();

        String fileName = file.getOriginalFilename();
        String path = "C:\\Users\\Administrator\\Desktop\\school-meals\\src\\main\\webapp\\page\\merchant_image\\";
//        String path = "\\user\\tomcat\\webapps\\meal\\page\\merchant_image\\";
        File newFile=new File(path);

        //如果保存文件的地址不存在，就先创建目录
        if(!newFile.exists()){
            newFile.mkdirs();
        }

        mer.setMname(merchant.getMname());
        mer.setMimage("../page/merchant_image/" + fileName);
        mer.setCid(merchant.getCid());

        try{
            file.transferTo(new File(path+fileName));

            int i = adminService.addMerchant(mer);
            if(i <= 0){
                redirectAttributes.addFlashAttribute("Msg","添加失败");
            } else{
                redirectAttributes.addFlashAttribute("Msg","添加成功");
            }
        }catch(Exception e){
            e.printStackTrace();

        }
            return "redirect:/admin/findAll";
    }

    /**
     * 查询所有订单
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findAllOrders")
    public String findAllOrders(HttpSession session)throws Exception{
        List<Orders> list2 = adminService.findAllOrders();
        session.setAttribute("list2",list2);

        return "admin/orders";
    }

    /**
     * 查询订单详细信息
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findOrders")
    public String findOrders(@RequestParam("oid") long oid, HttpSession session)throws Exception{
        Orders order = adminService.findOrder(oid);
        session.setAttribute("order",order);

        List<OrderItem> list3 = adminService.findOrders(oid);
        session.setAttribute("list3",list3);

        return "admin/orderItem";
    }

    /**
     * 查询餐厅分类
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findCategory")
    public String findCategory(HttpSession session)throws Exception{

        List<Category> list3 = adminService.findAllCategory();
        session.setAttribute("list3",list3);
        return "admin/food";
    }

    /**
     * 查询店铺
     * @param cid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "findMerchant",method = RequestMethod.POST)
    public List<Merchant> selectFindMerchant(@RequestParam("cid") long cid)throws Exception{
        List<Merchant> list4 = adminService.selectFindMerchant(cid);

        return list4;
    }

    /**
     * 添加食物
     * @param food
     * @param redirectAttributes
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addFood",method = RequestMethod.POST)
    public String addFood(Food food, RedirectAttributes redirectAttributes,
                          @RequestParam("file") CommonsMultipartFile file,
                          HttpServletRequest request)throws Exception{

        Food f = new Food();
        String fileName = file.getOriginalFilename();
        String path = "C:\\Users\\Administrator\\Desktop\\school-meals\\src\\main\\webapp\\page\\food_image\\";
//        String path = "\\user\\tomcat\\webapps\\meal\\page\\food_image\\";
        File newFile=new File(path);

        //如果保存文件的地址不存在，就先创建目录
        if(!newFile.exists()){
            newFile.mkdirs();
        }

        f.setFname(food.getFname());
        f.setPrice(food.getPrice());
        f.setMid(food.getMid());
        f.setFimage("../page/food_image/" + fileName);

        try{
            file.transferTo(new File(path+fileName));

            int i = adminService.addFood(f);
            if(i <= 0){
                redirectAttributes.addFlashAttribute("msg","添加失败");
            } else{
                redirectAttributes.addFlashAttribute("msg","添加成功");
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        return "redirect:/admin/findCategory";
    }

    /**
     * 查看食物
     * @param mid
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "findFoodDetail")
    public String findFoodDetail(@RequestParam("mid") long mid,
                                 HttpSession session)throws Exception{

        List<Food> list5 = adminService.findFoodDetail(mid);
        session.setAttribute("list5",list5);
        return "admin/foodDetail";
    }


    /**
     * 删除店铺
     * @param mid
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "deleteMerchant",method = RequestMethod.POST)
    public JSONObject deleteMerchant(@RequestParam("mid") long mid,
                                     RedirectAttributes redirectAttributes)throws Exception{

        JSONObject j = new JSONObject();
        int i = adminService.deleteMerchant(mid);
        if(i <= 0){
            j.put("mmsg","删除失败");
            return j;
        }
        j.put("mmsg","删除成功");
        return j;
    }

    /**
     * 删除食物
     * @param fid
     * @param redirectAttributes
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "deleteFood",method = RequestMethod.POST)
    public JSONObject deleteFood(@RequestParam("fid") long fid,
                                     RedirectAttributes redirectAttributes)throws Exception{

        JSONObject s = new JSONObject();
        int i = adminService.deleteFood(fid);
        if(i <= 0){
            s.put("mmsg","删除失败");
            return s;
        }
        s.put("mmsg","删除成功");
        return s;
    }



}
