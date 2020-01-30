package cn.mju.admintle;

import cn.mju.admintle.controller.EmpController;
import cn.mju.admintle.domain.*;
import cn.mju.admintle.mapper.*;
import cn.mju.admintle.service.AdminService;
import cn.mju.admintle.service.UserService;
import cn.mju.admintle.service.WagesService;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class AdmintleApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private JobMapper jobMapper;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private EmpController empController;
    @Autowired
    private WagesService wagesService;


    @Test
    void contextLoads() {
        PageInfo<User> pageInfo = adminService.getUserByCondition("@", "技术", "", 1, 5);
        System.out.println(pageInfo.getList());
    }

    @Test
    void test() {
        PageInfo<User> usersByPage = userService.getUsersByPage(1,5);
        System.out.println("页码。。。。。。"+usersByPage.getNavigatepageNums().length);
    }



    @Test
    void test3(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("deptId",4);
        List<User> users= userMapper.getUserByName(map);
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    void test4() {
        HashMap<String,String> map = new HashMap<>();
        map.put("w","oo");
        map.put("w","pp");
        for (String key: map.keySet()){
            System.out.println("键："+key+"值："+map.get(key));
        }
    }



    @Test
    void test5() {
        PageInfo<Role> admin = adminService.getRolesByName(1, 10, "admin");
        List<Role> adminList = admin.getList();
        for (Role role : adminList) {
            System.out.println(role);
        }
    }


    @Test
    void test6(){
        Notice notice = new Notice();
        notice.setHead("文章");
        notice.setCreateTime(new Date());
        notice.setContent("内容器文件了气温将企稳");
        notice.setUserId(53l);
        noticeMapper.addNotice(notice);
    }
    @Test
    void test7(){
        List<Notice> all = noticeMapper.findAll();
        for (Notice notice : all) {
            System.out.println(notice.toString());
        }

    }

    @Test
    void test8(){
        User user = new User();
        user.setUsername("1@qq.com");
        user.setPassword("123");
        user.setJobId(1);
        user.setDeptId(2);
        user.setAddress("woooooooooo");
        user.setState(1);
        user.setEmail("1@qq.com");
        user.setBirthday(new Date());
        user.setPhone(3333333333l);
        adminService.addUser(user,"admin");

    }




}
