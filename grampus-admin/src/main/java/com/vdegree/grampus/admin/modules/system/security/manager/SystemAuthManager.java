package com.vdegree.grampus.admin.modules.system.security.manager;

//import com.vdegree.grampus.admin.modules.system.security.users.SystemUser;
//import com.vdegree.grampus.admin.modules.system.security.users.SystemUserDetails;
//import com.vdegree.grampus.admin.modules.system.service.SysRoleService;
//import com.vdegree.grampus.common.auth.AuthManager;
//import com.vdegree.grampus.common.auth.exception.AccessException;
//import com.vdegree.grampus.common.auth.model.Permission;
//import com.vdegree.grampus.common.auth.model.User;
//import com.vdegree.grampus.common.core.exception.BaseException;
//import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Builtin access control entry of System.
 *
 * @author nkorange
 * @since 1.2.0
 */
@Slf4j
@Component
public class SystemAuthManager {
//
//    private static final String TOKEN_PREFIX = "Bearer ";
//
//    private static final String SYSTEM_USER_KEY = "systemuser";
//
//    @Autowired
//    private JwtTokenManager tokenManager;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private SysRoleService sysRoleService;
//
//    @Override
//    public SystemUserDetails login(Object request) throws AccessException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String token = resolveToken(req);
//        if (StringUtils.isBlank(token)) {
//            throw new BaseException("user not found!");
//        }
//
//        try {
//            tokenManager.validateToken(token);
//        } catch (ExpiredJwtException e) {
//            throw new BaseException("token expired!");
//        } catch (Exception e) {
//            throw new BaseException("token invalid!");
//        }
//
//        Authentication authentication = tokenManager.getAuthentication(token);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String username = authentication.getName();
//        req.setAttribute(SYSTEM_USER_KEY, user);
//        return user;
//    }
//
//    @Override
//    public void auth(Permission permission, User user) throws AccessException {
//        if (!roleService.hasPermission(user.getUserName(), permission)) {
//            throw new AccessException("authorization failed!");
//        }
//    }
//
//    /**
//     * Get token from header.
//     */
//    private String resolveToken(HttpServletRequest request) throws AccessException {
//        String bearerToken = request.getHeader(NacosAuthConfig.AUTHORIZATION_HEADER);
//        if (StringUtils.isNotBlank(bearerToken) && bearerToken.startsWith(TOKEN_PREFIX)) {
//            return bearerToken.substring(7);
//        }
//        bearerToken = request.getParameter(Constants.ACCESS_TOKEN);
//        if (StringUtils.isBlank(bearerToken)) {
//            String userName = request.getParameter("username");
//            String password = request.getParameter("password");
//            bearerToken = resolveTokenFromUser(userName, password);
//        }
//
//        return bearerToken;
//    }
//
//    private String resolveTokenFromUser(String userName, String rawPassword) throws AccessException {
//
//        try {
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName,
//                    rawPassword);
//            authenticationManager.authenticate(authenticationToken);
//        } catch (AuthenticationException e) {
//            throw new BaseException("unknown user!");
//        }
//
//        return tokenManager.createToken(userName);
//    }
}
