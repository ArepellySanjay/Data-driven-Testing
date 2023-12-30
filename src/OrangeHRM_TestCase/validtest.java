package OrangeHRM_TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AppUtils.UtilsDemo;
import AppUtils.XL_Utils_Next;
import OrangeHRM_Libreary.Login;


public class validtest extends UtilsDemo
{

	String datafile ="E:\\Qedge\\Data.Driven.testing.xlsx";
	String datasheet = "Sheet3";
	
	
	@Test
 public void CheckadminLogin() throws IOException 
 {
	
     int rowcount =	XL_Utils_Next.getRowcount(datafile, datasheet);
		
		
        String ui, pwd;
        Login sanju;
     
       for(int i=1;i<=rowcount;i++)
       {
    	   
        ui =  XL_Utils_Next.getStringData(datafile, datasheet, i, 0); 
    	 pwd = XL_Utils_Next.getStringData(datafile, datasheet, i, 1);  
    	   
    	   
    	  sanju = new Login();
    	  
    	  
    	  sanju.login(ui, pwd);
    	  
    	 boolean res = sanju.isdisplayed();
    	 Assert.assertTrue(res);
    	 if(res)
    	 {
    		 
    		 XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "pass");
    		 XL_Utils_Next.FillGreenColour(datafile, datasheet, i, 2);
    	 }else
    	 {
    		 
    		 XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "fail");
    		 XL_Utils_Next.FillRedColour(datafile, datasheet, i, 2);
    		 
    	 }
    	 
    	 sanju.logout();
    	 
       }
     
     
		
}	
	
	
	
	
	
}
