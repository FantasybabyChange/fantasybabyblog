package com.fantasybabymg.servert;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.util.CaptchaUtil;
import com.fantasybabymg.util.ConvertUtil;
import com.fantasybabymg.util.EncryptUtil;
import com.fantasybabymg.util.StringUtil;
import com.fantasybabymg.util.constant.CaptchaConst;
import com.fantasybabymg.util.constant.CaptchaSessionConst;

public class CaptchaServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6861101035066329043L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	String type = request.getParameter("type");
        	BufferedImage image = null;
        	int positionHeight = 0;
    		if(!StringUtils.isEmpty(type)){
    			String[] types = type.split("_");
    			image = new BufferedImage(ConvertUtil.stringToInteger(types[0]),ConvertUtil.stringToInteger(types[1]),BufferedImage.TYPE_INT_BGR);
    			if(types.length >= 3){
    				positionHeight = Integer.parseInt(types[2]);
    			}
    		}else{
    			image = CaptchaConst.DEFAULT_IMAGE;
    		}
    		String initParameter = this.getInitParameter(CaptchaConst.INIT_PARAME_OPEN_BACKGROUD);
    		String randomString = null;
    		if(StringUtil.isNotBleank(initParameter)){
    			if(Boolean.parseBoolean(initParameter)){
    				randomString = CaptchaUtil.getRandomString(image,positionHeight,Boolean.parseBoolean(initParameter),CaptchaConst.CAPTCHLEVEL_DIFF);
    			}else{
    				randomString = CaptchaUtil.getRandomString(image,positionHeight);
    			}
    		}else{
    			randomString = CaptchaUtil.getRandomString(image,positionHeight);
    		}
            HttpSession session = request.getSession();
            session.removeAttribute(CaptchaSessionConst.ADMIN_CAPTCHA_KEY);
            session.setAttribute(CaptchaSessionConst.ADMIN_CAPTCHA_KEY, EncryptUtil.encryptToMD5(randomString.toLowerCase()));
            response.setHeader("Pragma", "no-cache");         
            response.setHeader("Cache-Control", "no-cache");         
            response.setDateHeader("Expires", 0);         
            response.setContentType("image/jpeg"); 
            ImageIO.write(image, CaptchaConst.JPEG, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            new FantasyBabyException("生成验证码发生错误",CaptchaServlet.class);
        }
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    }
}