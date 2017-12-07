/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack.util;

import com.cw.pack.Car;
import com.cw.pack.Device;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 *
 * @author Administrator
 */
public class Utils
{

	//默认单元格内容为数字时格式  
	private static DecimalFormat df = new DecimalFormat("0");
	// 默认单元格格式化日期字符串   
	private static SimpleDateFormat sdf
			= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// 格式化数字  
	private static DecimalFormat nf = new DecimalFormat("0.00");
	
	public static List<Map.Entry<Integer, Device>> sort(Map<Integer, Device> maps, final boolean desc)
	{
		//将map.entrySet()转换成list  
        List<Map.Entry<Integer, Device>> list = new ArrayList<Map.Entry<Integer, Device>>(maps.entrySet());  
        Collections.sort(list, new Comparator<Map.Entry<Integer, Device>>() {  
            //降序排序  
            @Override  
            public int compare(Entry<Integer, Device> o1, Entry<Integer, Device> o2) {  
                //return o1.getValue().compareTo(o2.getValue());  
				long o1Val = o1.getValue().getLength()*o1.getValue().getWidth()*o1.getValue().getHigh();
				long o2Val = o2.getValue().getLength()*o2.getValue().getWidth()*o2.getValue().getHigh();
				boolean tmp = desc?o1Val<o2Val:o2Val<o1Val;
                return tmp?1:-1;  
            }  
        });
		return list;
	}
	
	public static int getMaxNums(Device dev, Car car)
	{
		long length = car.getLeftLength();
		int currWeight = car.getCurrWeight();
		int loadWeight = car.getLoadWeight();
		int leftWeight = loadWeight-currWeight;
		int maxCanLoad1 = leftWeight/dev.getWeight();
		int maxCanLoad2 = (int)((car.getWidth()/dev.getLength())*(length/dev.getWidth())*(car.getHigh()/dev.getHigh()));		
		return maxCanLoad1>maxCanLoad2?maxCanLoad2:maxCanLoad1;
	}
	
	public static void load(List<Car> cars, List<Map.Entry<Integer, Device>> sortResult, Car car)
	{
		boolean isMore = false;
		for(Map.Entry<Integer, Device> entry:sortResult)
		{
			Device dev = entry.getValue();
			int maxNum = getMaxNums(dev, car);
			if(dev.getNumber()>maxNum)//设备数量大于可以装载的数量
			{
				Device devClone = dev.clone();
				dev.setNumber(dev.getNumber()-maxNum);
				devClone.setNumber(maxNum);
				car.getPutDevices().add(devClone);
				car.setCurrWeight(car.getCurrWeight()+dev.getWeight()*maxNum);//修改车当前装载重量
				isMore = true;
				cars.add(car);
				break;
			}
			else
			{
				car.getPutDevices().add(dev);
				car.setCurrWeight(car.getCurrWeight()+dev.getWeight()*dev.getNumber());//修改车当前装载重量
				sortResult.remove(entry);
				int rowNum = (int)(car.getWidth()/dev.getLength()*(car.getHigh()/dev.getHigh()));
				int rows = dev.getNumber()/rowNum+(dev.getNumber()%rowNum==0?0:1);
				car.setLeftLength(car.getLeftLength()-dev.getWidth()*rows);
				break;
			}
		}
		if(sortResult.size()>0)
		{
			Car c = new Car(car.getLength(), car.getWidth(), car.getHigh(), car.getLoadWeight());
			c.setId(cars.size());
			load(cars, sortResult, isMore?c:car);
		}
		else
		{
			cars.add(car);
		}
	}

	public static ArrayList<ArrayList<Object>> readExcel2003(File file)
	{
		try
		{
			ArrayList<ArrayList<Object>> rowList
					= new ArrayList<ArrayList<Object>>();
			ArrayList<Object> colList;
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			Object value;
			for(int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet.
					getPhysicalNumberOfRows(); i++)
			{
				row = sheet.getRow(i);
				colList = new ArrayList<Object>();
				if(row == null)
				{
					//当读取行为空时  
					if(i != sheet.getPhysicalNumberOfRows())
					{//判断是否是最后一行  
						rowList.add(colList);
					}
					continue;
				}
				else
				{
					rowCount++;
				}
				for(int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++)
				{
					cell = row.getCell(j);
					if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK)
					{
						//当该单元格为空  
						if(j != row.getLastCellNum())
						{//判断是否是该行中最后一个单元格  
							colList.add("");
						}
						continue;
					}
					switch(cell.getCellType())
					{
						case XSSFCell.CELL_TYPE_STRING:
//							System.out.
//									println(i + "行" + j + " 列 is String type");
							value = cell.getStringCellValue();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							if("@".equals(cell.getCellStyle().
									getDataFormatString()))
							{
								value = df.format(cell.getNumericCellValue());
							}
							else if("General".equals(cell.getCellStyle()
									.getDataFormatString()))
							{
								value = (int)(cell.getNumericCellValue());
							}
							else
							{
								value = sdf.format(HSSFDateUtil.getJavaDate(cell
										.getNumericCellValue()));
							}
//							System.out.println(i + "行" + j
//									+ " 列 is Number type ; DateFormt:"
//									+ value.toString());
							break;
						case XSSFCell.CELL_TYPE_BOOLEAN:
//							System.out.
//									println(i + "行" + j + " 列 is Boolean type");
							value = Boolean.valueOf(cell.getBooleanCellValue());
							break;
						case XSSFCell.CELL_TYPE_BLANK:
//							System.out.println(i + "行" + j + " 列 is Blank type");
							value = "";
							break;
						default:
//							System.out.
//									println(i + "行" + j + " 列 is default type");
							value = cell.toString();
					}// end switch  
					colList.add(value);
				}//end for j  
				rowList.add(colList);
			}//end for i  

			return rowList;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	public static void main(String[] args)
	{
		Map<Integer, Device> map = new HashMap<Integer, Device>();
		map.put(1, new Device(1, 120,213,122,50,100));
		map.put(2, new Device(2, 1220,213,122,50,100));
		map.put(3, new Device(3, 20,23,122,54,300));
		map.put(4, new Device(4, 3320,233,122,40,300));
		map.put(5, new Device(5, 10,2145,122,56,160));
		map.put(6, new Device(6, 13340,2313,122,30,180));
		List<Map.Entry<Integer, Device>> list = sort(map, true);
		for(Map.Entry<Integer, Device> e:list)
		{
			System.out.println(e);
		}
	}
}
