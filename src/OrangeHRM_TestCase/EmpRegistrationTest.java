package OrangeHRM_TestCase;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import AppUtils.XL_Utils_Next;
import OrangeHRM_Libreary.AdminUtils;
import OrangeHRM_Libreary.EmpRegistration;

public class EmpRegistrationTest extends  AdminUtils
{

	String datafile = "E:\\Qedge\\Data.Driven.testing.xlsx";
	String datasheet = "EmoployeReg";
	
	
	@Test
	public void addemoployee() throws IOException 
	{
		
	 int rowcount =  XL_Utils_Next.getRowcount(datafile, datasheet);
		
	 EmpRegistration san;
	 
	 for(int i=1;i<=rowcount;i++)
	 {
		 
		 String ui = XL_Utils_Next.getStringData(datafile, datasheet, i, 0);
		 String pwd = XL_Utils_Next.getStringData(datafile, datasheet, i, 1);
		 
		  san = new EmpRegistration();
		 
		boolean sanju = san.addemployee(ui, pwd);
		  Assert.assertTrue(sanju);
		  if(sanju)
		  {
			  XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "pass");
			  XL_Utils_Next.FillGreenColour(datafile, datasheet, i, 2);
		  }else
		  {
			  XL_Utils_Next.getsetData(datafile, datasheet, i, 2, "Fail");
			  XL_Utils_Next.FillRedColour(datafile, datasheet, i, 2);
		  }
		  
		  
		 
	 }
	 
	 
		
	}
	
	
}
