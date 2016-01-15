package com.fantasybabymg.util;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.fantasybabymg.util.constant.CaptchaConst;

public class CaptchaUtil {
	 private static Random random = new Random();
    /**
     * 绘制字符串
     */
    public static String getRandomString(BufferedImage image,int positionHeight,boolean drawBackgroundLine,int backgrounLevel){
    	Graphics g = image.getGraphics();
    	int imagewidth = image.getWidth();
    	int iamgeHeight = image.getHeight();
    	g.fillRect(0, 0, imagewidth,iamgeHeight);
    	if(drawBackgroundLine){
    		g.setColor(CaptchaConst.PURPLE_COLOR);
		 for (int i = 0; i < backgrounLevel; i++) {         
	            int x = random.nextInt(imagewidth);         
	            int y = random.nextInt(iamgeHeight);         
	            int xl = random.nextInt(CaptchaConst.BACKGROUN_LINE_LENGTH);         
	            int yl = random.nextInt(CaptchaConst.BACKGROUN_LINE_LENGTH);         
	            g.drawLine(x, y, x + xl, y + yl);         
	        }         
    	}
        g.setFont(CaptchaConst.BASE_FONTS[random.nextInt(4)]);
        g.setColor(CaptchaConst.PURPLE_COLOR);
        StringBuffer randomString = new StringBuffer("");
        String rand = null;
        int stringPoint = CaptchaConst.TRANSLATE_START*random.nextInt(3);
        int imageHeight = image.getHeight();
        int heightPostion = imageHeight/2 + positionHeight;
        for(int i=1;i<=CaptchaConst.RANDOM_STRING_NUM;i++){
        	g.setColor(getRandomColor());
            rand = String.valueOf(CaptchaConst.RAND_STRING.charAt(random.nextInt(CaptchaConst.RAND_STRING.length()-1)));
            randomString.append(rand);
            g.translate(0,0);
            g.drawString(rand,stringPoint+CaptchaConst.FONT_SPACING*i , heightPostion);
        }
        g.dispose();
        g=null;
        return randomString.toString();
    }
    public static String getRandomString(BufferedImage image,int positionHeight){
    		return getRandomString(image, positionHeight,false,0);
    }
    /**
     * 生成随机字符串
     */
    public static String getRandomString(){
    	 Random random = new Random();
        StringBuffer randomString = new StringBuffer("");
        String rand = null;
        for(int i=1;i<=CaptchaConst.RANDOM_STRING_NUM;i++){
            rand = String.valueOf(CaptchaConst.RAND_STRING.charAt(random.nextInt(CaptchaConst.RAND_STRING.length()-1)));
            randomString.append(rand);
        }
        return randomString.toString();
    }
    
    /**
     * 生成随机字符串
     */
    public static String getRandomString(int randomLength){
    	 Random random = new Random();
        StringBuffer randomString = new StringBuffer("");
        String rand = null;
        for(int i=1;i<=randomLength;i++){
            rand = String.valueOf(CaptchaConst.RAND_STRING.charAt(random.nextInt(CaptchaConst.RAND_STRING.length()-1)));
            randomString.append(rand);
        }
        return randomString.toString();
    }
    
    /**
     * 生成随机数字字符串
     */
    public static String getRandomNumString(int randomLength){
    	 Random random = new Random();
        StringBuffer randomString = new StringBuffer("");
        String rand = null;
        for(int i=1;i<=randomLength;i++){
            rand = String.valueOf(CaptchaConst.RAND_NUM_STRING.charAt(random.nextInt(CaptchaConst.RAND_NUM_STRING.length()-1)));
            randomString.append(rand);
        }
        return randomString.toString();
    }
    private static Color getRandomColor(){
    	int red = random.nextInt(225);
        int green = random.nextInt(225);
        int blue = random.nextInt(225);
    	return new Color(red, green, blue);
    }
}