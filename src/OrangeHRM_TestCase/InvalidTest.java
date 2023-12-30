package OrangeHRM_TestCase;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import AppUtils.UtilsDemo;
import AppUtils.XL_Utils_Next;
import OrangeHRM_Libreary.Login;

public class InvalidTest extends UtilsDemo
{

	String  datafile = "E:\\Qedge\\Data.Driven.testing.xlsx";
	String datasheet = "Sheet1";
	
	
	@Test
	public void CheckAdminLogin() throws IOException
	{
		
    int rowcount =		XL_Utils_Next.getRowcount(datafile, datasheet);
		
    
    
	Login ram;
    for(int i=1;i<=rowcount; i++)
    {
    	
    	String ui = XL_Utils_Next.getStringData(datafile, datasheet, i, 0);
    	String pwd = XL_Utils_Next.getStringData(datafile, datasheet, i, 1);
    	
          ram = new Login();
          
          ram.login(ui, pwd);
         boolean res = ram.isErrMsgDisplayed();
         Assert.assertTrue(res);
         if(res)
         {
        	 XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "pass");
        	XL_Utils_Next.FillGreenColour(datafile, datasheet, i, 2);
        	 
         }else
        	 XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "fail");
         XL_Utils_Next.FillRedColour(datafile, datasheet, i, 2);
    	
    }
    
   
	}
	
	
}
