package com.comit;

import java.io.ByteArrayOutputStream;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

public class GenerarCodigoDeBarra {
	
	public static byte[] getBarCodeImage(String text, int width, int height) {

	      

	       try { 
	    	  
	    	   Code128Writer crear = new Code128Writer();
	    	   BitMatrix bitMatrix = crear.encode(text, BarcodeFormat.CODE_128, 500,300);
	    	   ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    	   MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
	    	   
	           return byteArrayOutputStream.toByteArray();
	       } catch (Exception e) {
	           System.out.println("Error mientras se crea codigo de barra");
	           return null;
	       }
	   }
}
