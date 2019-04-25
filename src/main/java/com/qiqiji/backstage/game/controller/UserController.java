package com.qiqiji.backstage.game.controller;

import com.qiqiji.backstage.game.entity.User;
import com.qiqiji.backstage.game.service.UserService;
import com.qiqiji.backstage.game.tool.GetTotalPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "会员信息查询接口")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/MemberQuery", method= RequestMethod.POST)
    public List<User> MemberQuery(@RequestBody Map<String,String> map){
        System.out.println(map);
        String flag = (String) map.get("flag");
        int page = 0;
        int pageSize = 0;
        if ("0".equals(flag)){
            page = Integer.parseInt(map.get("page"));//页数
            pageSize = Integer.parseInt(map.get("pageSize"));//页大小
        }
        int count = 0;//总条数
        int totalPage = 0;//总页数
        Map<String,Integer> pageMap = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//字符串转日期
        List<User> userList = null;
        if("0".equals(flag)){
            //查询所有的会员的信息
            pageMap = queryCount(pageSize,flag);
            page =getPage(page,pageSize,flag);
            userList = userService.getUserByAll(page,pageSize);
        }else if("1".equals(flag)){
            //按照会员id精确查找会员信息
            userList = userService.getUserByMemberNo(Integer.parseInt((String) map.get("memberNo")));
        }
        if(userList==null){
            User user = new User();
            user.setQqjCode("0001");
            user.setQqjDesc("查询会员信息异常！");
            userList.add(user);
            return userList;
        }else if(userList.size()==0){
            User user = new User();
            user.setQqjCode("0002");
            user.setQqjDesc("查询会员信息为空！");
            userList.add(user);
            return userList;
        }
        if ("0".equals(flag)){
            count = pageMap.get("count");
            totalPage = pageMap.get("totalPage");
            userList.get(0).setCount(count);
            userList.get(0).setTotalPage(totalPage);
        }
        System.out.println(userList.get(0).toString());
        return userList;
    }

    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/MemberDelete", method= RequestMethod.POST)
    public String MemberDelete(@RequestBody HashMap<String,String> map){
        System.out.println(map);
        int memberNo = Integer.valueOf(map.get("memberNo"));
        try {
            userService.deleteUserByMemberNo(memberNo);
            return "0000";
        }catch (Exception e){
            e.printStackTrace();
            userService.deleteUserByMemberNo(memberNo);
            return "0001";
        }

    }

    @ApiOperation(value = "调用测试" ,  notes="调用测试")
    @RequestMapping(value = "/MemberUpdate", method= RequestMethod.POST)
    public String MemberUpdate(@RequestBody User user){
        System.out.println(user);
        try {
            userService.saveMemberNo(user);
            return "0000";
        }catch (Exception e){
            return "0001";
        }
    }

    //获取组局的总条数和总页数
    public Map queryCount(int pageSize, String flag){
        Map<String,Integer> map = new HashMap();
        int count = 0;
        int totalPage = 0;
        if("0".equals(flag)){
            //0-组满预约完成的总条数
            count = userService.getAllUserCount();
            totalPage = GetTotalPage.getTotalPage(pageSize,count);
        }
        map.put("count", count);
        map.put("totalPage", totalPage);
        return map;
    }
    //页数判断
    public int getPage(int page, int pageSize, String flag){
        Map<String,Integer> pageMap = null;
        pageMap = queryCount(pageSize,flag);
        int tPage = pageMap.get("totalPage");
        if (page>tPage){
            page = (tPage - 1) * pageSize;
        }else if(page==0){
            page = 0;
        }else{
            page = page * pageSize;
        }
        return page;
    }
}
