/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack.util;

import com.cw.pack.Car;
import com.cw.pack.Device;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Administrator
 */
public class Utils
{
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
	
	public static int getMaxNums(Device dev, long length, long width, long high)
	{
		return (int)((width/dev.getLength())*(length/dev.getWidth())*(high/dev.getHigh()));
	}
	
	public static void load(List<Car> cars, List<Map.Entry<Integer, Device>> sortResult, Car car)
	{
		boolean isMore = false;
		for(Map.Entry<Integer, Device> entry:sortResult)
		{
			Device dev = entry.getValue();
			int maxNum = getMaxNums(dev, car.getLeftLength(), car.getWidth(), car.getHigh());
			if(dev.getNumber()>maxNum)
			{
				Device devClone = dev.clone();
				dev.setNumber(dev.getNumber()-maxNum);
				devClone.setNumber(maxNum);
				car.getPutDevices().add(devClone);
				isMore = true;
				cars.add(car);
				break;
			}
			else
			{
				car.getPutDevices().add(dev);
				sortResult.remove(entry);
				int rowNum = (int)(car.getWidth()/dev.getLength()*(car.getHigh()/dev.getHigh()));
				int rows = dev.getNumber()/rowNum+(dev.getNumber()%rowNum==0?0:1);				
				car.setLeftLength(car.getLeftLength()-dev.getWidth()*rows);
				break;
			}
		}
		if(sortResult.size()>0)
		{
			Car c = new Car(car.getLength(), car.getWidth(), car.getHigh());
			c.setId(cars.size());
			load(cars, sortResult, isMore?c:car);
		}
		else
		{
			cars.add(car);
		}
	}
	
	public static void main(String[] args)
	{
		Map<Integer, Device> map = new HashMap<Integer, Device>();
		map.put(1, new Device(1, 120,213,122));
		map.put(2, new Device(2, 1220,213,122));
		map.put(3, new Device(3, 20,23,122));
		map.put(4, new Device(4, 3320,233,122));
		map.put(5, new Device(5, 10,2145,122));
		map.put(6, new Device(6, 13340,2313,122));
		List<Map.Entry<Integer, Device>> list = sort(map, true);
		for(Map.Entry<Integer, Device> e:list)
		{
			System.out.println(e);
		}
	}
}
