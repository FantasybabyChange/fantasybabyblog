/*package com.fantasybabymg.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.bean.BlogUserDetail;
import com.fantasybabymg.bean.Category;
import com.fantasybabymg.bean.Privilege;
import com.fantasybabymg.context.SystemContext;
import com.fantasybabymg.service.back.IUserDetailService;
import com.fantasybabymg.service.back.IUserService;
import com.fantasybabymg.service.back.vo.UserLoginVO;
import com.fantasybabymg.ubean.CategoryPrivilegeT;
import com.fantasybabymg.ubean.Criterion;
import com.fantasybabymg.util.AttributeUtil;
import com.fantasybabymg.util.CollectionUtil;
import com.fantasybabymg.util.constant.ConfigurationFilePath;
import com.fantasybabymg.util.constant.XMLNodeNameConstant;
public class UserTest {
	private IUserService userService;
	private IUserDetailService userDetailService;
	private ReloadableResourceBundleMessageSource messageSource;
	@Before
	public void before(){
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("classpath:spring-back-application.xml");
		userService = (IUserService) cx.getBean("userService");
		userDetailService = (IUserDetailService) cx.getBean("userDetailService");
//		messageSource = (ReloadableResourceBundleMessageSource) cx.getBean("messageSource");
	}
	@Test
	public void testAddUser(){
		BlogUser user = new BlogUser();
		Category category = new Category();
		category.set_id(1);
		user.setCategory(category);
		user.setPassWord("123");
		user.setUserName("FantasyBaby");
		user.setStatus(0);
		BlogUserDetail ud = new BlogUserDetail();
		ud.setAddress("上海虹口");
		ud.setEmail("fantasybabymg@gmail.com");
		ud.setHometown("陕西宝鸡");
		ud.setImage("head.jpg");
		ud.setName("刘");
		ud.setNickname("FantasyBaby");
		ud.setPhone("123456");
		ud.setProfession("程序猿");
		ud.setSex(0);
		user.setUserDetail(ud);
		try {
		userService.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testFindUser(){
//		BlogUser user = new BlogUser();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("username", "f");
//			map.put("userid",'1');
			map.put("status", "");
			Criterion<Object> cri = new Criterion<Object>();
			cri.setCriterion(map);
			SystemContext.setCriterionMap(cri);
			
			List<BlogUser> findUsers = userService.findUsers();
		findUsers.forEach(user -> System.out.println(user.getUserName()+ user.getCategory().getCategoryName()+"" +user.getUserDetail().getAddress()));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testdelUser(){
//		BlogUser user = new BlogUser();
		try {
		boolean deleteUser = userService.deleteUser(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testFindUserDetail(){
//		BlogUser user = new BlogUser();
		try {
		BlogUserDetail userDetail = userDetailService.findUserDetail(1);
		System.out.println(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	@Test
	public void testinitUserDetail(){
//		BlogUser user = new BlogUser();
		try {
		String filePath = UserTest.class.getClassLoader().getResource(ConfigurationFilePath.INITDB_XML_FILE_PATH).getPath();
		List<Category> convertXMLtoList = (List<Category>) AttributeUtil.convertXMLtoList(Category.class,filePath , XMLNodeNameConstant.CATEGORY_ROOT_ELEMENT_NAME,"parentCategory");
		List<Privilege> privileges = (List<Privilege>) AttributeUtil.convertXMLtoList(Privilege.class,filePath , XMLNodeNameConstant.PRIVILEGE_ROOT_ELEMENT_NAME,"parentPrivilege");
		List<BlogUser> blogUsers = (List<BlogUser>) AttributeUtil.convertXMLtoList(BlogUser.class,filePath , XMLNodeNameConstant.USER_ROOT_ELEMENT_NAME,"users");
		CategoryPrivilegeT cp = new CategoryPrivilegeT();
		if (CollectionUtil.isNotEmptyCollection(blogUsers)) {
			cp.setBlogUser(blogUsers.get(0));
		}
		cp.setCategorys(convertXMLtoList);
		cp.setPrivileges(privileges);
		SystemContext.setCategoryPrivilege(cp);
		userService.batchInitUserCategoryPrivilege();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testPropertyFile(){
		UserLoginVO user = new UserLoginVO();
		user.setUsername("");
		ValidatorFactory facotry = Validation.buildDefaultValidatorFactory();
		//get validator
		Validator validator = facotry.getValidator();
		//validtor
		Set<ConstraintViolation<UserLoginVO>> validate = validator.validate(user);
		System.out.println(validate);  
//		System.out.println(messageSource.getMessage("form.username.password.empty", null, null));
//		String filePath = UserTest.class.getClassLoader().getResource(ConfigurationFilePath.USER_MESSAGE_FILE_PATH).getPath();
//		PropertyUtil.initPeoperty(filePath);
//		String propertyVale = PropertyUtil.getPropertyVale("FORM_USERNAME_PASSWORD_EMPTY");
//		System.out.println(propertyVale);
//		PropertyUtil.close();
	}
	@Test
	public void testFindUserMap(){
		UserLoginVO userLogin = new UserLoginVO();
		userLogin.setUsername("FantasyBaby");
		Criterion<Object> userCriterion = new Criterion<Object>();
		userCriterion.setCriterion(userLogin);
		SystemContext.setCriterionMap(userCriterion);
		BlogUser findUser = userService.findUser();
		System.out.println(findUser);
	}
}
*/