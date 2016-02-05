package com.fantasybabymg.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.ArrayUtils;

import com.fantasybabymg.enumerate.EncodeTypeEnum;
import com.fantasybabymg.enumerate.EncryptionType;

public final class EncryptUtil {
	/**
	 * 进行MD5加密
	 * 
	 * @param info
	 *            要加密的信息
	 * @return String 加密后的字符串
	 */
	public static final String encryptToMD5(String info) {
		byte[] digesta = null;
		try {
			// 得到一个md5的消息摘要
			MessageDigest alga = MessageDigest.getInstance("MD5");
			// 添加要进行计算摘要的信息
			alga.update(info.getBytes());
			// 得到该摘要
			digesta = alga.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 将摘要转为字符串
		return byte2hex(digesta);
		
	}

	/**
	 * 进行SHA加密
	 * 
	 * @param info
	 *            要加密的信息
	 * @return String 加密后的字符串
	 */
	public static final String encryptToSHA(String info) {
		byte[] digesta = null;
		try {
			// 得到一个SHA-1的消息摘要
			MessageDigest alga = MessageDigest.getInstance("SHA-1");
			// 添加要进行计算摘要的信息
			alga.update(info.getBytes());
			// 得到该摘要
			digesta = alga.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 将摘要转为字符串
		return byte2hex(digesta);
	}

	
	private static String IV = "AAAAAAAAAAAAAAAA";
	  static String plaintext = "123"; /*Note null padding*/
	  static String encryptionKey = "0123456789abcdef";
	  public static void main(String [] args) {
	    try {
	      
	      System.out.println("==Java==");
	      System.out.println("plain:   " + plaintext);

	      byte[] cipher = encrypt_AES_ECB(plaintext);
	      System.out.println(byte2hex(cipher));
	      System.out.println(ArrayUtils.toString(cipher));;
	      String encrypt = encrypt(plaintext,"123");
	      System.out.println(encrypt);
	      System.out.print("cipher:  ");
	      StringBuffer sb = new StringBuffer();
	      String parseByte2HexStr = parseByte2HexStr(cipher);
	      String byte2hex = byte2hex(cipher);
	      String decrypt = decrypt(encrypt, "123");
	      System.out.println(decrypt+" decrypt ");
	      System.out.println(parseByte2HexStr+"--------1");
	      System.out.println(byte2hex+"--------2");
	      System.out.println("-------------------------");
	      System.out.println(ArrayUtils.toString(parseHexStr2Byte(parseByte2HexStr)));
	      System.out.println(ArrayUtils.toString(hex2byte(byte2hex)));
	      
	      String decrypted = decrypt_AES(cipher, encryptionKey);

	      System.out.println("decrypt: " + decrypted);

	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	  }
private static Cipher cipher;
private final static String KEY_ALGORITHM = "AES";
private static SecretKey secretKey;  
/**
 * use aes to encrypt a string
 * @param plainText
 * @param encryptionKey
 * @return
 * @throws Exception
 */
  public synchronized  static byte[] encrypt_AES_ECB(String plainText) throws Exception {
	 return encrypt_AES_ECB(plainText,EncryptionType.ENCRYP.getValue());
  }
/**
 * use aes to encrypt a string
 * @param plainText
 * @param encryptionKey
 * @return
 * @throws Exception
 */
  public synchronized  static byte[] encrypt_AES_ECB(String plainText,int type) throws Exception {
	  cipher = Cipher.getInstance(KEY_ALGORITHM);  
      secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();
	  if(type == EncryptionType.ENCRYP.getValue()){
		  cipher.init(Cipher.ENCRYPT_MODE, secretKey);//使用加密模式初始化 密钥
	  }else{
		  cipher.init(Cipher.DECRYPT_MODE, secretKey);
		  
	  }
	  return cipher.doFinal(plainText.getBytes(EncodeTypeEnum.UTF8.getValue()));
  }
  public static String decrypt(String aft_aes, String password) {  
      try {  
          byte[] content = parseHexStr2Byte(aft_aes);  
          SecretKey secretKey = getKey(password);  
          byte[] enCodeFormat = secretKey.getEncoded();  
          SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
          Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
          cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
          byte[] result = cipher.doFinal(content);  
          String bef_aes = new String(result);  
          return bef_aes; // 加密  
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
      }  
      return null;  
  }  
  public static String encrypt(String bef_aes, String password) {  
      byte[] byteContent = null;  
      try {  
          byteContent = bef_aes.getBytes("utf-8");  
      } catch (UnsupportedEncodingException e) {  
          e.printStackTrace();  
      }  
      return encrypt(byteContent,password);  
  }  
  public static String encrypt(byte[] content, String password) {  
      try {  
          SecretKey secretKey = getKey(password);  
          byte[] enCodeFormat = secretKey.getEncoded();  
          SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
          Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
          cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
          byte[] result = cipher.doFinal(content);  
          String aft_aes = parseByte2HexStr(result);  
          return aft_aes; // 加密  
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
      }  
      return null;  
  }  
/**
 * use aes to decrypt
 * @param cipherText
 * @param encryptionKey
 * @return
 * @throws Exception
 */
  public static String decrypt_AES(byte[] cipherText, String encryptionKey) throws Exception{
    Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding", "SunJCE");
    SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(EncodeTypeEnum.UTF8.getValue()), "AES");
    cipher.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes(EncodeTypeEnum.UTF8.getValue())));
    return new String(cipher.doFinal(cipherText),EncodeTypeEnum.UTF8.getValue());
  }
  /**
	 * 将二进制转化为16进制字符串
	 * 
	 * @param b
	 *            二进制字节数组
	 * @return String
	 */
	private static final String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
public static byte[] parseHexStr2Byte(String hexStr) {     
      if (hexStr.length() < 1)     
              return null;     
      byte[] result = new byte[hexStr.length()/2];     
      for (int i = 0;i< hexStr.length()/2; i++) {     
              int value = Integer.parseInt(hexStr.substring(i*2, i*2+2), 16);     
              result[i] = (byte)value;     
      }     
      return result;     
	}    
private static final byte[] hex2byte(String hex) {
		byte[] ret = new byte[8];
		byte[] tmp = hex.getBytes();
		for (int i = 0; i < 8; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}
private static final byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
				.byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
				.byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}
public static SecretKey getKey(String strKey) {  
    try {             
        KeyGenerator _generator = KeyGenerator.getInstance("AES");  
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");  
        secureRandom.setSeed(strKey.getBytes());  
        _generator.init(128,secureRandom);  
        return _generator.generateKey();  
    } catch (Exception e) {  
        throw new RuntimeException("初始化密钥出现异常");  
    }  
  }   
public static String parseByte2HexStr(byte buf[]) {  
    StringBuffer sb = new StringBuffer();  
    for (int i = 0; i < buf.length; i++) {  
        String hex = Integer.toHexString(buf[i] & 0xFF);  
        if (hex.length() == 1) {  
            hex = '0' + hex;  
        }  
        sb.append(hex.toUpperCase());  
    }  
    return sb.toString();  
}  
//	// //////////////////////////////////////////////////////////////////////////
//	
//	private static final SecretKey key = createSecretKey("DES");
//	/**
//	 * 创建密匙
//	 * 
//	 * @param algorithm
//	 *            加密算法,可用 DES,DESede,Blowfish
//	 * @return SecretKey 秘密（对称）密钥
//	 */
//	public static final SecretKey createSecretKey(String algorithm) {
//		// 声明KeyGenerator对象
//		KeyGenerator keygen;
//		// 声明 密钥对象
//		SecretKey deskey = null;
//		try {
//			// 返回生成指定算法的秘密密钥的 KeyGenerator 对象
//			keygen = KeyGenerator.getInstance(algorithm);
//			// 生成一个密钥
//			deskey = keygen.generateKey();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		// 返回密匙
//		return deskey;
//	}
//
//	/**
//	 * 根据密匙进行DES加密
//	 * 
//	 * @param key
//	 *            密匙
//	 * @param info
//	 *            要加密的信息
//	 * @return String 加密后的信息
//	 */
//	public static final String encryptToDES(SecretKey key, String info) {
//		// 定义 加密算法,可用 DES,DESede,Blowfish
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG),(可以不写)
//		SecureRandom sr = new SecureRandom();
//		// 定义要生成的密文
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
//			c1.init(Cipher.ENCRYPT_MODE, key, sr);
//			// 对要加密的内容进行编码处理,
//			cipherByte = c1.doFinal(info.getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// 返回密文的十六进制形式
//		return byte2hex(cipherByte);
//	}
//	
//	/**
//	 * 根据密匙进行DES加密
//	 * 
//	 * @param key
//	 *            密匙
//	 * @param info
//	 *            要加密的信息
//	 * @return String 加密后的信息
//	 */
//	public static final String encryptToDES(String info) {
//		// 定义 加密算法,可用 DES,DESede,Blowfish
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG),(可以不写)
//		SecureRandom sr = new SecureRandom();
//		// 定义要生成的密文
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher cipher = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			// 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
//			cipher.init(Cipher.ENCRYPT_MODE, key, sr);
//			// 对要加密的内容进行编码处理,
//			cipherByte = cipher.doFinal(info.getBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// 返回密文的十六进制形式
//		return byte2hex(cipherByte);
//	}
//
//	/**
//	 * 根据密匙进行DES解密
//	 * 
//	 * @param key
//	 *            密匙
//	 * @param sInfo
//	 *            要解密的密文
//	 * @return String 返回解密后信息
//	 */
//	public static final String decryptByDES(SecretKey key, String sInfo) {
//		// 定义 加密算法,
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG)
//		SecureRandom sr = new SecureRandom();
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			c1.init(Cipher.DECRYPT_MODE, key, sr);
//			// 对要解密的内容进行编码处理
//			cipherByte = c1.doFinal(hex2byte(sInfo));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// return byte2hex(cipherByte);
//		return new String(cipherByte);
//	}
//	
//	/**
//	 * 根据密匙进行DES解密
//	 * 
//	 * @param key
//	 *            密匙
//	 * @param sInfo
//	 *            要解密的密文
//	 * @return String 返回解密后信息
//	 */
//	public static final String decryptByDES(String sInfo) {
//		// 定义 加密算法,
//		String Algorithm = "DES";
//		// 加密随机数生成器 (RNG)
//		SecureRandom sr = new SecureRandom();
//		byte[] cipherByte = null;
//		try {
//			// 得到加密/解密器
//			Cipher c1 = Cipher.getInstance(Algorithm);
//			// 用指定的密钥和模式初始化Cipher对象
//			c1.init(Cipher.DECRYPT_MODE, key, sr);
//			// 对要解密的内容进行编码处理
//			cipherByte = c1.doFinal(hex2byte(sInfo));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// return byte2hex(cipherByte);
//		return new String(cipherByte);
//	}
//
//	// /////////////////////////////////////////////////////////////////////////////
//	/**
//	 * 创建密匙组，并将公匙，私匙放入到指定文件中
//	 * 
//	 * 默认放入mykeys.bat文件中
//	 */
//	public void createPairKey() {
//		try {
//			// 根据特定的算法一个密钥对生成器
//			KeyPairGenerator keygen = KeyPairGenerator.getInstance("DSA");
//			// 加密随机数生成器 (RNG)
//			SecureRandom random = new SecureRandom();
//			// 重新设置此随机对象的种子
//			random.setSeed(1000);
//			// 使用给定的随机源（和默认的参数集合）初始化确定密钥大小的密钥对生成器
//			keygen.initialize(512, random);// keygen.initialize(512);
//			// 生成密钥组
//			KeyPair keys = keygen.generateKeyPair();
//			// 得到公匙
//			PublicKey pubkey = keys.getPublic();
//			// 得到私匙
//			PrivateKey prikey = keys.getPrivate();
//			// 将公匙私匙写入到文件当中
//			doObjToFile("mykeys.bat", new Object[] { prikey, pubkey });
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 利用私匙对信息进行签名 把签名后的信息放入到指定的文件中
//	 * 
//	 * @param info
//	 *            要签名的信息
//	 * @param signfile
//	 *            存入的文件
//	 */
//	public void signToInfo(String info, String signfile) {
//		// 从文件当中读取私匙
//		PrivateKey myprikey = (PrivateKey) getObjFromFile("mykeys.bat", 1);
//		// 从文件中读取公匙
//		PublicKey mypubkey = (PublicKey) getObjFromFile("mykeys.bat", 2);
//		try {
//			// Signature 对象可用来生成和验证数字签名
//			Signature signet = Signature.getInstance("DSA");
//			// 初始化签署签名的私钥
//			signet.initSign(myprikey);
//			// 更新要由字节签名或验证的数据
//			signet.update(info.getBytes());
//			// 签署或验证所有更新字节的签名，返回签名
//			byte[] signed = signet.sign();
//			// 将数字签名,公匙,信息放入文件中
//			doObjToFile(signfile, new Object[] { signed, mypubkey, info });
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * 读取数字签名文件 根据公匙，签名，信息验证信息的合法性
//	 * 
//	 * @return true 验证成功 false 验证失败
//	 */
//	public boolean validateSign(String signfile) {
//		// 读取公匙
//		PublicKey mypubkey = (PublicKey) getObjFromFile(signfile, 2);
//		// 读取签名
//		byte[] signed = (byte[]) getObjFromFile(signfile, 1);
//		// 读取信息
//		String info = (String) getObjFromFile(signfile, 3);
//		try {
//			// 初始一个Signature对象,并用公钥和签名进行验证
//			Signature signetcheck = Signature.getInstance("DSA");
//			// 初始化验证签名的公钥
//			signetcheck.initVerify(mypubkey);
//			// 使用指定的 byte 数组更新要签名或验证的数据
//			signetcheck.update(info.getBytes());
//			System.out.println(info);
//			// 验证传入的签名
//			return signetcheck.verify(signed);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
//
	

//	/**
//	 * 十六进制字符串转化为2进制
//	 * 
//	 * @param hex
//	 * @return
//	 */
//	private static final byte[] hex2byte(String hex) {
//		byte[] ret = new byte[8];
//		byte[] tmp = hex.getBytes();
//		for (int i = 0; i < 8; i++) {
//			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
//		}
//		return ret;
//	}
//
//	/**
//	 * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
//	 * 
//	 * @param src0
//	 *            byte
//	 * @param src1
//	 *            byte
//	 * @return byte
//	 */
//	private static final byte uniteBytes(byte src0, byte src1) {
//		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
//				.byteValue();
//		_b0 = (byte) (_b0 << 4);
//		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
//				.byteValue();
//		byte ret = (byte) (_b0 ^ _b1);
//		return ret;
//	}
//
//	/**
//	 * 将指定的对象写入指定的文件
//	 * 
//	 * @param file
//	 *            指定写入的文件
//	 * @param objs
//	 *            要写入的对象
//	 */
//	public void doObjToFile(String file, Object[] objs) {
//		ObjectOutputStream oos = null;
//		try {
//			FileOutputStream fos = new FileOutputStream(file);
//			oos = new ObjectOutputStream(fos);
//			for (int i = 0; i < objs.length; i++) {
//				oos.writeObject(objs[i]);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				oos.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	/**
//	 * 返回在文件中指定位置的对象
//	 * 
//	 * @param file
//	 *            指定的文件
//	 * @param i
//	 *            从1开始
//	 * @return
//	 */
//	public Object getObjFromFile(String file, int i) {
//		ObjectInputStream ois = null;
//		Object obj = null;
//		try {
//			FileInputStream fis = new FileInputStream(file);
//			ois = new ObjectInputStream(fis);
//			for (int j = 0; j < i; j++) {
//				obj = ois.readObject();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ois.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return obj;
//	}
}
