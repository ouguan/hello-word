package com.ongoing.xuguyun;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1、thymeleaf末班文件中 标签是需要闭合的 3.0之前需要不和 2、thymeleaf 3.0+ 是可以不强制要求闭合 3、支持多个模板
 * 比如thymeleaf 、freemarker可以并存
 * 
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author Administrator
 * @date 2017-4-21 下午9:06:28
 * @version V1.3.1
 */
// @Controller @ResponseBody
@Controller
public class MainController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 首页
	 *
	 * @return
	 */
	@GetMapping(value = { "", "/index" })
	public String index(HttpServletRequest request) {
		logger.debug("当前访问页面：" + request.getRequestURI());
		return "index";
	}

	/**
	 * 首页
	 *
	 * @return
	 */
	@GetMapping(value = "/{action}")
	public String index2(HttpServletRequest request, @PathVariable String action) {
		/***********************************************
		 * Log4j日志属性文件
		 *****************************************************/
		String logfile = System.getProperty("user.dir") + System.getProperty("file.separator")
				+ "url-define.properties";
		Properties log4jproperties = new Properties();
		if (!new File(logfile).exists()) {
			logfile = System.getProperty("user.dir") + System.getProperty("file.separator") + "src"
					+ System.getProperty("file.separator") + "main" + System.getProperty("file.separator") + "resources"
					+ System.getProperty("file.separator") + "url-define.properties";
		}
		try {
			logger.debug("url配置文件：" + logfile);
			FileInputStream in = new FileInputStream(logfile);
			log4jproperties.load(in);
			in.close();
			logger.debug("访问页面：" + action + "|" + log4jproperties.getProperty(action));
		} catch (IOException e) {
			logger.error("读取系统默认属性文件时发生IOException异常！", e);
		}
		/******************************************************************************************************************/

		return log4jproperties.getProperty(action);
	}

	/**
	 * javax.servlet.ServletException: Circular view path [hello]: would dispatch
	 * back to the current handler URL [/template/hello] again. Check your
	 * ViewResolver setup! (Hint: This may be the result of an unspecified view, due
	 * to default view name generation.)
	 * 
	 * 摘录答案中的话，When you don’t declare a ViewResolver, spring registers a default
	 * InternalResourceViewResolver which creates instances of JstlView for
	 * rendering the View.
	 * 当你没有声明ViewResolver时，spring会给你注册一个默认的ViewResolver，其是JstlView的实例。它通过RequestDispatcher寻找资源（视图），不过这个资源也可能是Servlet，也就是说，Controller中方法返回字符串（视图名），也可能会解析成Servlet。当你的请求路径与视图名相同时，就会发生死循环。
	 * 
	 * @Description
	 * @author Administrator
	 * @return
	 */
	// 报错this may be the result of an unspecified view, due to default view name
	// generation.)]
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}

	/**
	 * org.thymeleaf.exceptions.TemplateInputException: Error resolving template
	 * "hello-1", template might not exist or might not be accessible by any of the
	 * configured Template Resolvers
	 * 
	 * @Description
	 * @author Administrator
	 * @return
	 */
	@RequestMapping("/hello2")
	public String index2() {
		return "hello1";
	}

	@RequestMapping("/hello3")
	public ModelAndView hello3() {
		ModelAndView modelAndView = new ModelAndView("hello1");
		return modelAndView;
		// return "hello1"; 等价于 return modelAndView;
	}

	@RequestMapping("/hello4")
	public String hello4(Map<String, Object> map) {
		map.put("name", "Andy");
		return "hello1";
	}

	// freemarker 模板
	@RequestMapping("/helloFtl")
	public String hello5() {
		return "helloFtl";
	}

	// freemarker 模板
	@RequestMapping("/helloFtl2")
	public String hello6(Map<String, Object> map) {
		map.put("name", "Andy");
		return "helloFtl2";
	}
}
