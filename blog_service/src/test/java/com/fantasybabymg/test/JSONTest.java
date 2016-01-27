/*package com.fantasybabymg.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.fantasybabymg.bean.BlogUser;
import com.fantasybabymg.service.back.vo.UserLoginVO;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONTest {
	@Test
 public void test1(){
	 ObjectMapper om = new ObjectMapper();
	 ObjectNode createObjectNode = om.createObjectNode();
	 createObjectNode.put("name", "hello");
	 createObjectNode.put("age", 1);
	 System.out.println(createObjectNode.toString());
	 
	 List<UserLoginVO> list = new ArrayList<UserLoginVO>();
	 UserLoginVO ul = new UserLoginVO();
	 ul.setPassword("123");
	 ul.setRemember(0);
	 ul.setUsername("hehe");
	 list.add(ul);
	 try {
		String writeValueAsString = om.writeValueAsString(list);
		System.out.println(writeValueAsString);
		System.out.println(om.writeValueAsString(createObjectNode));
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
 }
	@Test  
    public void testTree2() throws JsonProcessingException, IOException {  
        String TREE_MODEL_BINDING = "{\"姑姑\":\"王姑姑1\",\"叔叔1\":\"王书\",\"叔叔2\":[{\"侄子1\":\"小明\"}]}";  
        ObjectMapper mapper = new ObjectMapper();  //定义转换类   
        ObjectNode root =mapper.createObjectNode();//创建根节点  
        root.put("爷爷", "老老王");  
        root.put("奶奶", "老老奶");  
          
        ObjectNode parents = mapper.createObjectNode();  //创建2级子节点  
        parents.put("爸爸", "老爸");  
        parents.put("妈妈","老妈");
        root.set("parents", parents);
//        root.put("parents", parents);      //绑定2级子节点  
          
        JsonNode uncles = mapper.readTree(TREE_MODEL_BINDING);
        root.set("antOruncles",uncles);
//        root.put("antOruncles",uncles);  
        System.out.println(mapper.writeValueAsString(root));//打印树  
    }  
}
*/