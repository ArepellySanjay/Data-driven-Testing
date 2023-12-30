package OrangeHRM_TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AppUtils.UtilsDemo;
import AppUtils.XL_Utils_Next;
import OrangeHRM_Libreary.Login;

public class AdminLoginTest_WithInvalidData extends Login
{
	
	String datafile ="E:\\Qedge\\Data.Driven.testing.xlsx";
	String datasheet = "AdminLogin_InvalidData";

     @Test
	public void CheckadminLogin() throws IOException 
	{
		
    int rowcount =	XL_Utils_Next.getRowcount(datafile, datasheet); 
    	 
    
    
    Login san = new Login();
	   
    
       for(int i=1;i<=rowcount;i++)
       {
    	   
    	   String ui = XL_Utils_Next.getStringData(datafile, datasheet, i, 0);
    	   String pwd = XL_Utils_Next.getStringData(datafile, datasheet, i, 1);
    	   
    	   
    	  
    	   san.login(ui, pwd);
    	  boolean res = san.isErrMsgDisplayed();
    	  Assert.assertTrue(res);
    	  
    	   if(res)
    	   {
    		   XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "Pass");
    		   XL_Utils_Next.FillGreenColour(datafile, datasheet, i, 2);
    		   
    	   }else
    	   {
    		   XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "Fail");
    		   XL_Utils_Next.FillRedColour(datafile, datasheet, i, 2);
    	   }
    	
    	   
    	   
       }
    
    	 
	}
	
	
	
	
}
