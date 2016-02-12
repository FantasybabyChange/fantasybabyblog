package com.fantasybabymg.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;

import com.fantasybabymg.enumerate.EncodeTypeEnum;
import com.fantasybabymg.enumerate.SymbolEnum;
import com.fantasybabymg.enumerate.crypto.AlgorithmInstanceEnum;
import com.fantasybabymg.enumerate.crypto.CryptoModeEnum;
import com.fantasybabymg.enumerate.crypto.PaddingTypeEnums;
import com.fantasybabymg.exception.FantasyBabyException;
import com.fantasybabymg.util.EncryptUtil;
import com.fantasybabymg.util.FileUtils;
import com.fantasybabymg.util.StringUtil;
/**
 * By encryption or decryption file or String value
 * PI   key
 * @author FantasyBaby
 *
 */
public class SymmetricCipher {
	 private static Logger _logger = Logger.getLogger(SymmetricCipher.class);
	  private static SymmetricCipher symmetricCipher = null;
	  private  static int KEY_SIZE = 128;
	  private  static String DEFAULT_PASSWORD_AES = "AAAAAAAAAAAAAAAA";
	  private  static String SECURERANDOM_ALGORITHM_NAME = "SHA1PRNG";
	private SymmetricCipher(){
	}
	public static SymmetricCipher getInstance(){
		if(symmetricCipher == null){
			symmetricCipher = new SymmetricCipher();
		}
		return symmetricCipher;
	}
	public static synchronized void initEncryptParam(int _keySize,String _iv,String securerandom_algorithm_name){
		  KEY_SIZE = _keySize;
		  DEFAULT_PASSWORD_AES = _iv;
		  SECURERANDOM_ALGORITHM_NAME = securerandom_algorithm_name;
	  }
/**
   * use default password to encode
   * @param bef_aes
   * @return
   */
  public  String encrypt(String bef_aes) {  
      return encrypt(bef_aes,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
    		  ,CryptoModeEnum.ECB.name(),PaddingTypeEnums.PKCS5Padding.name());  
  }  
  public String encrypt(String bef_aes, String password,String algorithmName,
		  String cryptoModeName,String paddingName) {  
      byte[] byteContent = null;
      try {  
          byteContent = bef_aes.getBytes(EncodeTypeEnum.UTF8.getValue());  
      } catch (UnsupportedEncodingException e) {  
          new FantasyBabyException(e, EncryptUtil.class);
      }  
      return encrypt(byteContent,password,algorithmName,cryptoModeName,paddingName);  
  }  
  private  IvParameterSpec getIV(){
	  return new IvParameterSpec(DEFAULT_PASSWORD_AES.getBytes());
  }
  private  String getCipherInstanceName(String algorithmName,
		  String cryptoModeName,String paddingName){
	  StringBuffer sb = new StringBuffer();
	  if(StringUtil.isNotEmpty(algorithmName)){
		  sb.append(algorithmName);
		  if(StringUtil.isNotBleank(cryptoModeName)){
			  sb.append(SymbolEnum.SLASH.getValue()+cryptoModeName);
		  }
		  if(StringUtil.isNotBleank(paddingName)){
			  sb.append(SymbolEnum.SLASH.getValue()+paddingName);
		  }
	  }
	  return sb.length() > 0 ? sb.toString():null;
	  
  }
 public void encryptFile(String encryptFilePath,String outputFilePath) throws IOException{
	  encryptFile(encryptFilePath,outputFilePath,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
    		  ,CryptoModeEnum.CBC.name(),PaddingTypeEnums.PKCS5Padding.name());
 }
 public void encryptFile(String encryptFilePath,String outputFilePath,String password,String algorithmName,
		  String cryptoModeName,String paddingName) throws IOException{
	  File encryptFile = new File(encryptFilePath);
	  File outPutFile = new File(outputFilePath);
	  encryptFile(encryptFile,outPutFile,password,algorithmName,cryptoModeName,paddingName);
  }
 public void encryptFile(File encryptFile,File outputFile){
		try {
			InputStream inputStream = new FileInputStream(encryptFile);
			OutputStream outpustStream = new FileOutputStream(outputFile);
			encryptFile(inputStream,outpustStream,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
		    		  ,CryptoModeEnum.CBC.name(),PaddingTypeEnums.PKCS5Padding.name());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
 }
  public  void encryptFile(File encryptFile,File outputFile,String password,String algorithmName,
		  String cryptoModeName,String paddingName){
		try {
			FileUtils.isFileWork(encryptFile, outputFile);
			InputStream inputStream = new FileInputStream(encryptFile);
			OutputStream outpustStream = new FileOutputStream(outputFile);
			encryptFile(inputStream,outpustStream,password,algorithmName,cryptoModeName,paddingName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
  }
  public  void encryptFile(InputStream encryptFile,OutputStream outputFile,String password,String algorithmName,
		  String cryptoModeName,String paddingName){
	  try {
		Cipher cipher = getCipher(password, algorithmName, cryptoModeName, paddingName,Cipher.ENCRYPT_MODE);
		CipherOutputStream cou = new CipherOutputStream(outputFile, cipher);
		StopWatch sw = new StopWatch();
		_logger.info("start encry file ");
		sw.start();
		FileUtils.copyFile(encryptFile, cou);
		sw.stop();
		_logger.info("end encry file "+sw.getTime());
	} catch (Exception e) {
		e.printStackTrace();
	} 
  }
  public  void decryptFile(String decryptFilePath,String outputFilePath) throws IOException{
	    decryptFile(decryptFilePath,outputFilePath,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
    		  ,CryptoModeEnum.CBC.name(),PaddingTypeEnums.PKCS5Padding.name());
 }
public  void decryptFile(String decryptFilePath,String outputFilePath,String password,String algorithmName,
		  String cryptoModeName,String paddingName) throws IOException{
	  File decryptFile = new File(decryptFilePath);
	  File outPutFile = new File(outputFilePath);
	  decryptFile(decryptFile,outPutFile,password,algorithmName,cryptoModeName,paddingName);
  }
public   void decryptFile(File decryptFile,File outputFile){
	  try {
		FileUtils.isFileWork(decryptFile, outputFile);
		InputStream inputStream = new FileInputStream(decryptFile);
		OutputStream outpustStream = new FileOutputStream(outputFile);
		decryptFile(inputStream,outpustStream,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
	    		  ,CryptoModeEnum.CBC.name(),PaddingTypeEnums.PKCS5Padding.name());
	} catch (Exception e) {
		e.printStackTrace();
	} 
}
  public  void decryptFile(File decryptFile,File outputFile,String password,String algorithmName,
		  String cryptoModeName,String paddingName){
	  try {
		FileUtils.isFileWork(decryptFile, outputFile);
		InputStream inputStream = new FileInputStream(decryptFile);
		OutputStream outpustStream = new FileOutputStream(outputFile);
		decryptFile(inputStream,outpustStream,password,algorithmName,cryptoModeName,paddingName);
	} catch (Exception e) {
		e.printStackTrace();
	} 
  }
  public void decryptFile(InputStream decryptFile,OutputStream outputFile,String password,String algorithmName,
		  String cryptoModeName,String paddingName){
	  try {
		Cipher cipher = getCipher(password, algorithmName, cryptoModeName, paddingName,Cipher.DECRYPT_MODE);
		CipherOutputStream cou = new CipherOutputStream(outputFile, cipher);
		StopWatch sw = new StopWatch();
		_logger.info("start decry file ");
		sw.start();
		FileUtils.copyFile(decryptFile, cou);
		sw.stop();
		_logger.info("end decry file "+sw.getTime());
	} catch (Exception e) {
		e.printStackTrace();
	} 
  }
  public Cipher getCipher(String password,String algorithmName,
	  String cryptoModeName,String paddingName,int encryptType) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException{
	  Cipher cipher = Cipher.getInstance(getCipherInstanceName(algorithmName, cryptoModeName, paddingName));// 创建密码器
      if(isNeedIV(cryptoModeName)){
    	  cipher.init(encryptType, getKey(password,algorithmName),getIV());
      }else{
    	  cipher.init(encryptType, getKey(password,algorithmName));  
      } 
	  return cipher;
  }
  public  String encrypt(byte[] content, String password,String algorithmName,
		  String cryptoModeName,String paddingName) {  
      try {  
          Cipher cipher = getCipher(password,algorithmName,cryptoModeName,paddingName,Cipher.ENCRYPT_MODE);
          byte[] result = cipher.doFinal(content);  
          return EncryptUtil.parseByte2HexStr(result); 
      } catch (NoSuchAlgorithmException e) {  
          e.printStackTrace();  
      } catch (NoSuchPaddingException e) {  
          e.printStackTrace();  
      } catch (InvalidKeyException e) {  
          e.printStackTrace();  
      } catch (IllegalBlockSizeException e) {  
          e.printStackTrace();  
      } catch (BadPaddingException e) {  
          e.printStackTrace();  
      } catch (InvalidAlgorithmParameterException e) {
		e.printStackTrace();
	}  
      return null;  
  }  
  public  String decrypt(String bef_aes) {  
      return decrypt(bef_aes,DEFAULT_PASSWORD_AES,AlgorithmInstanceEnum.AES.getValue()
    		  ,CryptoModeEnum.ECB.name(),PaddingTypeEnums.PKCS5Padding.name());  
  }
  public  String decrypt(String bef_aes, String password,String algorithmName,
		  String cryptoModeName,String paddingName) {  
      return decrypt(EncryptUtil.parseHexStr2Byte(bef_aes),password,algorithmName,cryptoModeName,paddingName);  
  }  
  /**解密 
   * @param content  待解密内容 
   * @param password 解密密钥 
   * @return 
   */  
  public String decrypt(byte[] content, String password,String algorithmName,
		  String cryptoModeName,String paddingName) {
      try {
          Cipher cipher = getCipher(password, algorithmName, cryptoModeName, paddingName,Cipher.DECRYPT_MODE);
          return new String(cipher.doFinal(content));
	} catch (Exception e) {
		throw new FantasyBabyException(e, EncryptUtil.class);
	} 
  }  
  public static boolean isNeedIV(String cryptoMode){
	  if(cryptoMode.equalsIgnoreCase(CryptoModeEnum.CBC.name())
			  ||cryptoMode.equalsIgnoreCase(CryptoModeEnum.CFB.name())||
			  cryptoMode.equalsIgnoreCase(CryptoModeEnum.OFB.name())
			  ){
		  return true;
	  }
	  return false;
  }
  /**
   * get SecretKey
   * @param strKey
   * @return
   */
  public static SecretKeySpec getKey(String strKey,String algorithmName) {  
	    try {             
	        KeyGenerator _generator = KeyGenerator.getInstance(algorithmName);  
	        SecureRandom secureRandom = SecureRandom.getInstance(SECURERANDOM_ALGORITHM_NAME);  
	        secureRandom.setSeed(strKey.getBytes(EncodeTypeEnum.UTF8.getValue()));  
	        _generator.init(KEY_SIZE,secureRandom);
	        SecretKeySpec skey = new SecretKeySpec(_generator.generateKey().getEncoded(), algorithmName);
	        return skey;  
	    } catch (Exception e) {  
	        throw new RuntimeException(e);  
	    }  
	  }

}
