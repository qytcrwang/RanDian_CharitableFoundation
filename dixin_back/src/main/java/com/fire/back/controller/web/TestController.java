package com.fire.back.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fire.back.dto.SysUserExtend;
import com.fire.back.entity.SysUser;
import com.fire.back.service.SysUserService;
import com.fire.back.util.ShiroUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.fire.back.common.FireResult;
import com.fire.back.util.ParamUtil;
/**
 *
 * @author dragon
 * 可依照getInfo规范开发 接口统一返回FireResult
 * Feb 18, 2020
 */
@Controller
public class TestController {
	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private SysUserService ss;

	@GetMapping("/")
	@RequiresAuthentication
	public String index(ModelMap map){
		String name = ShiroUtils.getSysUser().getUserName();
		map.put("name",name!=null?name:"未登录");
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model, HttpServletRequest req){
		// 登录失败从request中获取shiro处理的异常信息。
		// shiroLoginFailure:就是shiro异常类的全类名.
		String exception = (String) req.getAttribute("shiroLoginFailure");
		if (exception != null) {
			if (UnknownAccountException.class.getName().equals(exception)) {
				model.addAttribute("msg", "账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exception)) {
				model.addAttribute("msg","密码不正确：");
			} else if ("kaptchaValidateFailed".equals(exception)) {
				model.addAttribute("msg","验证码错误");
			} else {
				model.addAttribute("msg","else >> "+exception);
			}
		}
		// 此方法不处理登录成功,由shiro进行处理
		//shiro 将记录将要登录前要前往的地址
		return "/login/login";
	}


	@GetMapping("/test1")
	public String test1() {
		return "index";
	}

	@GetMapping("/tab")
	public String tab() {
		return "tab";
	}

	@GetMapping("/table")
	public String table() {
		return "table";
	}

	@GetMapping("/add")
	public String add() {return "add";
	}

	@GetMapping("/contriInfo")
	public String contriInfo() {
		return "contriInfo";
	}

	@GetMapping("/contriInfoDetail")
	public String contriInfoDetail() {
		return "contriInfoDetail";
	}

	@GetMapping("/activityManage")
	public String activityManage() {
		return "activityManage";
	}

	@GetMapping("/rentManager")
	public String rentManager() {
		return "rentManager";
	}
	@GetMapping("/rentManagerNew")
	public String rentManagerNew() {
		return "rentManagerNew";
	}

	@GetMapping("/noticeManage")
	public String noticeManage() {
		return "noticeManage";
	}

	@GetMapping("/managerInfo")
	public String managerInfo() {
		return "managerInfo";
	}

	@PostMapping("/getInfo")
	@ResponseBody
	public FireResult getInfo(HttpServletRequest request, @RequestBody Map<String, Object> paramMap) {
		try {
			Double param1 = ParamUtil.getDouble(paramMap, "param1", 0.00);
			Long param2 = ParamUtil.getLong(paramMap, "param2", 0L);
			Integer param3 = ParamUtil.getInteger(paramMap, "param3", 16);
			String param4 = ParamUtil.getString(paramMap, "param4", "规范示例");
			Map<String,Object> shili = new HashMap<>();
			shili.put("a", param1);
			shili.put("b", param2);
			shili.put("c", param3);
			shili.put("d", param4);
			return FireResult.build(1, "数据获取成功", shili);
		} catch (Exception e) {
			logger.error("",e);
			return FireResult.build(0, "获取信息失败，请稍后再试");
		}
	}
}
