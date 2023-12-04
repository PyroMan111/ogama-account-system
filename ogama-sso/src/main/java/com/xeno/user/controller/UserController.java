package com.xeno.user.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xeno.user.entity.User;
import com.xeno.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 作者
 * @since 2023-12-04
 */
@RestController
@RequestMapping("/user")
@EnableSwagger2WebMvc
public class UserController {
    @Autowired
    private IUserService userService;

    // 会话登录接口
    @PostMapping("doLogin")
    public SaResult doLogin(String loginName, String pwd) {
        User user = userService.getOne(
                Wrappers.lambdaQuery(User.class)
                        .eq(Objects.nonNull(loginName),User::getLoginName,loginName)
                        .eq(Objects.nonNull(pwd),User::getPassword,pwd));


        // 第一步：比对前端提交的账号名称、密码
        if(Objects.nonNull(user)) {
            // 第二步：根据账号id，进行登录
            StpUtil.login(user.getId());
            return SaResult.ok("登录成功");
        }
        return SaResult.error("登录失败");
    }

    // 查询登录状态  ---- http://localhost:8081/acc/isLogin
    @GetMapping("isLogin")
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    // 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
    @GetMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    // 测试注销  ---- http://localhost:8081/acc/logout
    @GetMapping("logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }


}

