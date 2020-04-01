package com.fire.back.util;

import com.fire.back.config.MyShiroRealm;
import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.util.Date;

/**
 * shiro 工具类
 * 
 * @author fire
 */
public class ShiroUtils
{
    public static Subject getSubject()
    {
        return SecurityUtils.getSubject();
    }

    public static Session getSession()
    {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout()
    {
        getSubject().logout();
    }

    public static SysUserExtend getSysUser()
    {
        SysUserExtend user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj))
        {
            user = new SysUserExtend();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }

    public static void setSysUser(SysUserExtend user)
    {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static void clearCachedAuthorizationInfo()
    {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    public static Long getUserId()
    {
        return getSysUser().getUserId().longValue();
    }

    public static String getLoginName()
    {
        return getSysUser().getLoginName();
    }

    public static String getIp()
    {
        return getSubject().getSession().getHost();
    }

    public static String getSessionId()
    {
        return String.valueOf(getSubject().getSession().getId());
    }

    /**
     * 生成随机盐
     */
    public static String randomSalt()
    {
        // 一个Byte占两个字节，此处生成的3字节，字符串长度为6
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }

    public static  void  createAdmin(){
        SysUser user = new SysUser();
        Date now = new Date();
        user.setUserId(1l);
        user.setLoginName("admin");
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setDelFlag("0");
        user.setStatus("0");
        user.setCreateBy("admin");
        user.setEmail("fire@163.com");
        user.setPhonenumber("18888888888");
        user.setRemark("超级管理员系统创建，不可修改");
        user.setUserName("超级管理员");
        user.setSex("0");
        user.setSalt(randomSalt());
        user.setUserType("00");
        user.setPassword(new Md5Hash("admin",user.getSalt(),2).toHex()
        );
        System.out.println(user.getSalt());
        System.out.println(user.getPassword());

    }
}
