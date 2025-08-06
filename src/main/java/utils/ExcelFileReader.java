package utils;	
import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
    static HashMap<String, String> hmap = null;

    public static HashMap<String, String> getExcelData(String SheetName, String tcID) throws Exception {
      
    	try{
    		hmap = new HashMap<String, String>();
    	

        String path = System.getProperty("user.dir") + "//TestData//RGdata.xlsx";
        
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(SheetName);
        int lastRowCount = sheet.getLastRowNum();

        for (int i = 0; i < lastRowCount; i=i+2)
        {
            String temp = sheet.getRow(i).getCell(0).getStringCellValue();
            if (temp.equalsIgnoreCase(tcID))
            {
            	
                XSSFRow targetKeyRow = sheet.getRow(i);
                XSSFRow targetValueRow=sheet.getRow(i+1);
                int lastColumn = targetKeyRow.getLastCellNum();
                
                for (int j = 1; j < lastColumn-1; j++)
                {
                 String ktemp = targetKeyRow.getCell(j).getStringCellValue();
                 String vtemp = targetValueRow.getCell(j).getStringCellValue();
                 
                 String k = ktemp.replaceAll("\"","");
                 String v = vtemp.replaceAll("\"", "");
                 
                 hmap.put(k, v);
              
                }
            }
        

        
    }
    	}
    catch(Exception e)
    {
        System.out.println("Exception Occured While Reading the Excel Data: " + e);
    }
    
    	
    	return hmap;
    	} 
   
    }
    