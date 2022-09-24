package tests;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import drivers.BaseDriver;
import drivers.PageDriver;
import pages.HomePage;

public class Logcsv extends BaseDriver {

	@Test
	public void Login() throws IOException, InterruptedException, CsvValidationException

	{
		
		String CSV_PATH = "C:\\Users\\madhu\\eclipse-workspace\\testcsv\\TestData\\csvfiling.csv";
		String outputFile = "C:\\Users\\madhu\\eclipse-workspace\\testcsv\\TestData\\data.csv";

		CSVReader csvReader;
		String[] csvCell;
		csvReader = new CSVReader(new FileReader(CSV_PATH));
		CSVWriter csvOutput = new CSVWriter(new FileWriter(outputFile, true));
		boolean CheckTrue = true;
		String Result = null;
		

		HomePage homePage = new HomePage();
		

//			int Cellno = row.getLastCellNum();
//			System.out.println("The Total column no's are : " + Cellno);

		while ((csvCell = csvReader.readNext()) != null) {
			
            String Username1 = csvCell[0];
            String Pass = csvCell[1];
//            String Result = csvCell[2];
			homePage.clickOnSignIn();
			homePage.sendEmailLog(Username1);
			homePage.SendPass(Pass);
			homePage.SubmitClick();
			Thread.sleep(5000);
			try {
				homePage.LogOut();
				
//				boolean Signout = homePage.CheckLogout();
//				Assert.assertEquals(Signout, CheckTrue);

				System.out.println(Username1 + " and Password: " + Pass + " is Passed");
				Result = "Pass";

				List<String[]> data = new ArrayList<String[]>();
				data.add(new String[] {Username1,Pass,Result});
				csvOutput.writeAll(data);
				
//				Result = "PASS";
				


//				cell = row.createCell(2);
//				cell.setCellValue(Result);

			} catch (Exception e) {
//					boolean Msg = homePage.Errordisplay();
//					boolean CheckFalse = true;
//					Assert.assertEquals(Msg, CheckFalse)

				Result = "Fail";
				System.out.println(Username1 + " and Password: " + Pass + " is Failed");
//				Result = "FAIL";
				homePage.clickOnSignIn();

				List<String[]> data = new ArrayList<String[]>();
				data.add(new String[] {Username1,Pass,Result});
				csvOutput.writeAll(data);
				
			
		}
		}
		csvOutput.close();
//				cell = row.createCell(2);
//				cell.setCellValue(Result);
//				homePage.clickOnSignIn();
			
			

//			homePage.clickOnSignIn();
//			homePage.sendEmailLog(Username);
//			homePage.SendPass(Password);
//			homePage.SubmitClick();
//			Thread.sleep(5000);
//
//			try {
//				boolean Signout = homePage.CheckLogout();
//				Assert.assertEquals(Signout, CheckTrue);
//				System.out.println(Username + " and Password: " + Password + " is Passed");
//				Result = "PASS";
//				homePage.LogOut();
//				cell = row.createCell(2);
//				cell.setCellValue(Result);
//
//			} catch (Exception e) {
////					boolean Msg = homePage.Errordisplay();
////					boolean CheckFalse = true;
////					Assert.assertEquals(Msg, CheckFalse);
//				System.out.println(Username + " and Password: " + Password + " is Failed");
//				Result = "FAIL";
//				cell = row.createCell(2);
//				cell.setCellValue(Result);
//				homePage.clickOnSignIn();
//			}

//		}
//		FileOutputStream fos = new FileOutputStream(file);
//		wb.write(fos);
//		fos.close();

	}

	@BeforeClass
	public void startUrl() {
		PageDriver.getCurrentDriver().get(baseURL);
		PageDriver.getCurrentDriver().manage().window().maximize();
	}

	//
//			String username = cell.getStringCellValue();
//			System.out.println("UserName is " + username);

}
