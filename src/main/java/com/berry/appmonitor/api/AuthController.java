package com.berry.appmonitor.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.berry.appmonitor.common.Result;
import com.berry.appmonitor.common.ResultCode;
import com.berry.appmonitor.common.ResultFactory;
import com.berry.appmonitor.common.exceptions.BaseException;
import com.berry.appmonitor.security.dao.service.IUserInfoDaoService;
import com.berry.appmonitor.security.filter.AuthFilter;
import com.berry.appmonitor.security.filter.TokenProvider;
import com.berry.appmonitor.security.vm.LoginMo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author Berry_Cooper.
 * Description:
 * Date: 2018/05/03
 * fileName MultyTestController
 */
@RestController
@RequestMapping("/ajax/auth")
@Api(value = "授权", tags = "授权")
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private AuthenticationManager authenticationManager;

    private final IUserInfoDaoService userDaoService;

    public AuthController(IUserInfoDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }


    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<LoginSuccessVo> authorize(@Valid @RequestBody LoginMo loginMo, HttpServletResponse response) {
        // 用户是否存在
        com.berry.appmonitor.security.dao.entity.UserInfo user = userDaoService.getOne(new QueryWrapper<com.berry.appmonitor.security.dao.entity.UserInfo>().eq("username", loginMo.getUsername()));
        if (user == null) {
            throw new BaseException(ResultCode.ACCOUNT_NOT_EXIST);
        }
        // 密码是否正确
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginMo.getUsername(), loginMo.getPassword());

        try {
            Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            boolean rememberMe = (loginMo.getRememberMe() == null) ? false : loginMo.getRememberMe();
            String jwt = TokenProvider.createAndSignToken(authentication, user.getId(), rememberMe);
            long expires = TokenProvider.TOKEN_VALIDITY_IN_MILLISECONDS / 1000;
            if (rememberMe) {
                expires = TokenProvider.TOKEN_VALIDITY_IN_MILLISECONDS_FOR_REMEMBER_ME / 1000;
            }
            Cookie cookie = new Cookie(AuthFilter.AUTHORIZATION_HEADER, jwt);
            cookie.setMaxAge(Integer.valueOf(String.valueOf(expires)));
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            response.addHeader(AuthFilter.AUTHORIZATION_HEADER, jwt);
            response.addHeader("expires", String.valueOf(expires));
            return ResultFactory.wrapper(new LoginSuccessVo(jwt, expires, new UserInfo(user.getId(), user.getUsername())));
        } catch (AuthenticationException e) {
            if (e instanceof DisabledException) {
                throw new BaseException(ResultCode.ACCOUNT_DISABLE);
            } else if (e instanceof LockedException) {
                throw new BaseException(ResultCode.ACCOUNT_LOCKED);
            } else if (e instanceof BadCredentialsException) {
                throw new BaseException(ResultCode.USERNAME_OR_PASSWORD_ERROR);
            }
            logger.error(e.getLocalizedMessage());
            throw new BaseException(ResultCode.FAIL);
        }

    }

    // 创建用户使用此方式设置密码
//    public static void main(String[] args) {
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//    }

    /**
     * Object to return as body in JWT Authentication.
     */
    @Data
    static class LoginSuccessVo {

        private String token;

        private long expires;

        private AuthController.UserInfo userInfo;

        LoginSuccessVo(String token, long expires, AuthController.UserInfo userInfo) {
            this.token = token;
            this.expires = expires;
            this.userInfo = userInfo;
        }

    }

    @Data
    private static class UserInfo {
        private String id;
        private String username;

        UserInfo(String id, String username) {
            this.id = id;
            this.username = username;
        }
    }
}
