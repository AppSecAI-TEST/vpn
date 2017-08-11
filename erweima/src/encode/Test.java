package encode;

import java.io.IOException;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import com.google.zxing.WriterException;

public class Test {
	
	public  void setPicture(String content,String logurl, String outFileUrl){
		String outFileUri = outFileUrl;
		String logUri = logurl;
	    int[]  size=new int[]{430,430};
	    String format = "png";  
	
	try {
		new QRCodeFactory().CreatQrImage(content, format, outFileUri, logUri,size);
	} catch (IOException e) {
		e.printStackTrace();
	} catch (WriterException e) {
		e.printStackTrace();
	}
}
	

   
}
