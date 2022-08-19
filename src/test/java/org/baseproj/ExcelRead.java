package org.baseproj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {
public static  void main(String[] args) throws IOException {
	File f=new File("C:\\Users\\saheen\\eclipse-workspace\\NewFrameWorkProj\\src\\test\\resources\\Testdata\\Frame.xlsx");
	
	//Read the excel value
	FileInputStream fin=new FileInputStream(f);
	
	//workbook type
	Workbook w=new XSSFWorkbook(fin);
	
	//get sheet
	Sheet s = w.getSheet("Frametask");
	
	for(int i=0;i<s.getPhysicalNumberOfRows();i++)
	{
		Row r = s.getRow(i);
		
		for(int j=0;j<r.getPhysicalNumberOfCells();j++)
		{
			Cell c = r.getCell(j);
			int cellType = c.getCellType();
			
			if(cellType==1)
			{
				String svalue = c.getStringCellValue();
				System.out.println(svalue);
			}
			else if(DateUtil.isCellDateFormatted(c))
			{
				Date dte = c.getDateCellValue();
				
				SimpleDateFormat dform =new SimpleDateFormat("dd, MMMM, yyyy");
				String value = dform.format(dte);
				System.out.println(value);
			}		
				else
				{
					double d=c.getNumericCellValue();
				long l=(long)d;
				String value = String.valueOf(l);
				System.out.println(value);
			}
		
	}
	
}
}

}
