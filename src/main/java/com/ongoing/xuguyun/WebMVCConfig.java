package com.ongoing.xuguyun;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 出现404解决
 * 1、地址是否正确
 * 2、注解是否对了
 * 3、包路径是否正确，能否被扫描到加载到
 * 4、Spring Boot提供的默认配置和自定义的配置并存(扩展Spring Boot默认配置)
 * @author Administrator
 * @date 2017-4-21 下午9:08:54 
 * @version V1.3.1
 */
@Configuration
//@EnableWebMvc//无需使用该注解，否则会覆盖掉SpringBoot的默认配置值
public class WebMVCConfig extends WebMvcConfigurerAdapter {
	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/index").setViewName("/index");
//	}
	
	 /**
     * 添加第三方json工具
     * 1、需要再pom.xml加入相关以来
     * 2、需要再APP 继承 WeWebMvcConfigurerAdapter  重写configureMessageConverters
     * 3、或者使用bean注入fastJsonHttpMessageConverters
     * 
     * 
     * 配置fastjson支持两种方法
     * 一：1、启动继承 WebMvcConfigurerAdapter 2、覆盖方法configureMessageConverters
     * 二：使用bean注入fastJsonHttpMessageConverters
     * 这里使用@Bean注入 HttpMessageConverters
     * @Description 
     * @author Administrator
     * @return
     */
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters(){
//        //1、定义convert转换消息对象
//        FastJsonHttpMessageConverter fasConverter  = new  FastJsonHttpMessageConverter();
//        //2、添加fastJson的配置信息，比如：是否要格式化返回json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        //3、再convert中添加配置信息
//        fasConverter.setFastJsonConfig(fastJsonConfig);
//        HttpMessageConverter<?> converter = fasConverter;
//        return new HttpMessageConverters(converter); 
//    }
}
