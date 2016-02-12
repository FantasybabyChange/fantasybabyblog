package com.fantasybabymg.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

public class FileUtils {
 public static void copyFile(String inputFile,String outPutFile){
	 copyFile(new File(inputFile), new File(outPutFile));
 }
 public static void copyFile(File inputFile,File outPutFile){
	 try {
		org.apache.commons.io.FileUtils.copyFile(inputFile, outPutFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
 }
 public static void copyFile(InputStream input,OutputStream ouput){
		 try {
			IOUtils.copy(input, ouput);
		} catch (IOException e) {
			e.printStackTrace();
		}
 }
 public static void isFileWork(File srcFile, File destFile)throws IOException{
	 if (srcFile == null) {
         throw new NullPointerException("Source must not be null");
     }
     if (destFile == null) {
         throw new NullPointerException("Destination must not be null");
     }
     if (srcFile.exists() == false) {
         throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
     }
     if (srcFile.isDirectory()) {
         throw new IOException("Source '" + srcFile + "' exists but is a directory");
     }
     if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {
         throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
     }
     if (destFile.getParentFile() != null && destFile.getParentFile().exists() == false) {
         if (destFile.getParentFile().mkdirs() == false) {
             throw new IOException("Destination '" + destFile + "' directory cannot be created");
         }
     }
     if (destFile.exists() && destFile.canWrite() == false) {
         throw new IOException("Destination '" + destFile + "' exists but is read-only");
     }
 }
 
}
