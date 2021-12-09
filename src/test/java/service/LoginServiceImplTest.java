package service;

import com.group11.service.LoginService;
import com.group11.service.LoginServiceImpl;
import org.junit.Test;

public class LoginServiceImplTest {
    private final LoginService loginService = new LoginServiceImpl();
    private final LoginServiceImpl loginServiceImpl = new LoginServiceImpl();

    @Test
    public void login(){
        String username = "ZZY";
        String password = "password";
        boolean type = true;
        int num = loginService.login(username, password, type);
        assert num == 0 || num == 1 || num == 2;
    }

    // 用户名字母数字下划线，密码字母数字，长度均小于17
    // type = true代表Customer, type = false代表Administrator
    // Customer注册成功返回0, Administrator注册成功返回1, 注册失败返回2
    @Test
    public void register(){
        String username = "ZhangZhuoyi123";
        String password = "password";
        String confirm_password = "password";
        boolean type = true;
        int num = loginService.register(username, password, confirm_password, type);
        assert num == 0 || num == 1 || num == 2;
    }

    public void registerCustomer(){
        String username = "hhhhhhhh";
        String password = "password";
        loginServiceImpl.registerCustomer(username, password);
    }

    public void registerAdministrator(){
        String username = "gggggggg";
        String password = "password";
        loginServiceImpl.registerCustomer(username, password);
    }

    public void isUsername() {
        boolean flag = loginServiceImpl.isUsername("uuuuuuuu");
    }

    public void isPassword(String password) {
        boolean flag = loginServiceImpl.isPassword("zhangzhang");
    }

    @Test
    public void changeCustomer() {
        String username = "ZhangZhuoyi";
        String origin = "password";
        String password = "password123";
        String confirm_password = "password123";
        boolean flag = loginService.changeCustomer(username, origin, password, confirm_password);
    }

    @Test
    public void changeAdministrator() {
        String username = "ZhangZhuoyi123";
        String origin = "password";
        String password = "password123";
        String confirm_password = "password123";
        boolean flag = loginService.changeAdministrator(username, origin, password, confirm_password);
    }
}
