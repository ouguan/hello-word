package com.ongoing.xuguyun;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ongoing.xuguyun.login.DAO.T_Role;
import com.ongoing.xuguyun.login.DAO.T_User;

/**
 * 注解全名：
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author Administrator
 * @date 2017-4-21 下午9:06:28
 * @version V1.3.1
 */
// 相当于 @Controller + @ResponseBody
// 该注解 方法method 返回类型是String时候则返回string,返回对象时候则讲json_encode 该对象的json字符串
@RestController
// @EnableAutoConfiguration
@RequestMapping("/test")
public class HelloController {

    /**
     * 请求： http://localhost:8800/test/ http方式：get 请求返回contentType: text/plain
     * 请求responseBody: "Hello page"
     * 
     * @Description
     * @author Administrator
     * @return
     */
//    @RequestMapping("/")
//    public String index() {
//        return "Hello page";
//    }

    /**
     * 请求：http://localhost:8800/test/hello/ http方式：get 请求返回contentType:
     * text/plain 请求responseBody: "Hello 123 abc 123 123 !!!"
     * 
     * @Description
     * @author Administrator
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        return "Hello 123 abc 123 123 !!!";
    }

    /**
     * 请求：http://localhost:8800/test/hello/testname http方式：get 请求返回contentType:
     * text/plain 请求responseBody: "Hello testname!!!"
     * 
     * @Description
     * @author Administrator
     * @param myName
     * @return
     */
    @RequestMapping("/hello3/{myName}")
    public String hello3(@PathVariable String myName) {
        return "Hello " + myName + "!!!";
    }

    /**
     * 请求：http://localhost:8800/test/hello4?id=123&name=abc http方式：get
     * 请求返回contentType: text/plain 请求responseBody: ""id:123 name:abc""
     * 
     * @Description
     * @author Administrator
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/hello4")
    public String hello3(int id, String name) {
        System.out.println("id:" + id + " name:" + name);
        return "id:" + id + " name:" + name;
    }

    /**
     * /** 请求：http://localhost:8800/test//getDemo/testname http方式：get
     * 请求返回contentType: application/json 请求responseBody: { "createTime":
     * 1495640486000, "id": 123, "name": "good122223" } fastjson支持
     * 返回对象则自动解析为json字符串 因为spring boot
     * 默认使用json解析框架自动返回，返回头是Content-Type:application/json;charset=UTF-8
     * 
     * @Description
     * @author Administrator
     * @param myName
     * @return {"id":123,"name":"good","createTime":1492782569909}
     */
    @RequestMapping("/getDemo/{myName}")
    T_Role getDemo(@PathVariable String myName) {
    	T_Role role = new T_Role();
    	role.setRoleType(110);
    	role.setRoleName("Role Name");
    	role.setRoleURL("/role");
        System.out.println("Hello " + myName + "!!!");
        return role;
    }

    /**
     * 请求：http://localhost:8800/test//getDemo/testname http方式：get
     * 请求返回contentType: application/json 请求responseBody: { "createTime":
     * "2017-05-24 23:43:02", "id": 123, "name": "sss" }
     * 
     * spring boot 默认使用jackjson来解析json 使用fastjson返回json 因为spring boot
     * 默认使用json解析框架自动返回， 返回头是Content-Type:application/json;charset=UTF-8
     * 
     * @Description
     * @author Administrator
     * @param myName
     * @return {"createTime":"2017-05-20 13:23:57","id":123,"name":"sss"}
     */
    @RequestMapping("/getJson")
    public T_User getJson() {
    	T_User user = new T_User();
        user.setUserID(1100);
        user.setUserName("WUSHENGYONG");
        user.setUserPwd("1qaz@WSX");
        return user;
    }

    /**
     * 请求：http://localhost:8800/test//getMapping?id=123&name=abc http方式：get
     * 请求返回contentType: application/json 请求responseBody: { "id": 123, "name":
     * "abc" }
     * 
     * @Description
     * @param user
     * @return
     */
    // 只有get方式能成功,发送post会报错。@GetMapping = @RequestMapping(method = {
    // RequestMethod.GET }
    @GetMapping("/getMapping")
    public T_User getMapping(T_User user) {
        return user;
    }

    /**
     * 请求：http://localhost:8800/test//getMapping2?id=123&name=abc http方式：get
     * 请求返回contentType: application/json 请求responseBody: { "id": 123, "name":
     * "abc" } 请求boty设置为 application/x-www-form-urlencoded 也可以接受参数 body :
     * id=123&name=abc @RequestMapping(value="/getMapping" )
     * 等于 @RequestMapping(value="/getMapping" ,
     * method={RequestMethod.GET,RequestMethod.POST})
     * 
     * @Description
     * @param user
     * @return
     */
    @RequestMapping(value = "/getMapping2", method = { RequestMethod.GET, RequestMethod.POST })
    public T_User getMapping2(T_User user) {
        return user;
    }

    /**
     * @RequestBody String 直接获取请求体， 不封装 请求：http://localhost:8800/test/get2
     *              http方式：post
     *              {"createTime":1495640486000,"name":"good122223","id":123}
     *              请求返回contentType: application/json 请求responseBody:
     *              {"createTime":1495640486000,"name":"good122223","id":123}
     * @Description
     * @param user
     * @return
     */
    @RequestMapping("/get2")
    public T_User get2(@RequestBody String reqContent, @RequestBody T_User user) {
        // {"name":"abc","id":123}
        System.out.println("reqContent:" + reqContent);
        System.out.println(user.toString());
        return user;
    }

    /**
     * 对json数据进行实体类封装 请求：http://localhost:8800/test/user http方式：post
     * {"createTime":1495640486000,"name":"good122223","id":123}
     * 请求返回contentType: application/json 请求responseBody:
     * {"createTime":1495640486000,"name":"good122223","id":123}
     * 
     * @Description
     * @param user
     * @return
     */
    // {"id":2,"username":"user2","name":"李四","age":20,"balance":100.00}
    // 发送格式没application/json
    @PostMapping("/user")
    public T_User postUser(@RequestBody T_User user) {
        System.out.println(user);
        return user;
    }

    /**
     * 请求：http://localhost:8800/test/list-all http方式：get 请求返回contentType:
     * 请求responseBody: [ { "createTime": 1495641815658, "id": 1, "name":
     * "zhangsan" }, { "createTime": 1495641815658, "id": 1, "name": "zhangsan"
     * }, { "createTime": 1495641815658, "id": 1, "name": "zhangsan" } ]
     * 
     * @Description
     * @param user
     * @return
     */
    @GetMapping("list-all")
    public List<T_User> listAll() {
        ArrayList<T_User> list = new ArrayList<T_User>();
        T_User user = new T_User(100, 1101, "user1", "123456");
        T_User user2 = new T_User(100, 1102, "user2", "123456");
        T_User user3 = new T_User(100, 1103, "user3", "123456");
        list.add(user);
        list.add(user2);
        list.add(user3);
        return list;

    }

    /**
     * 会自动使用fastjson进行数据解析 请求：http://localhost:8800/test/list-all2 http方式：get
     * 请求返回contentType: 请求responseBody: [ { "createTime": "2017-05-25 00:11:11",
     * "id": 1, "name": "zhangsan" }, { "createTime": "2017-05-25 00:11:11",
     * "id": 1, "name": "zhangsan" } ]
     * 
     * @Description
     * @param user
     * @return
     */
    @GetMapping("list-all2")
    public List<T_User> listAll2() {
        ArrayList<T_User> list = new ArrayList<T_User>();
        T_User user = new T_User(100, 1104, "user4", "123456");
        T_User user2 = new T_User(100, 1105, "user5", "123456");
        list.add(user);
        list.add(user2);
        return list;

    }
}