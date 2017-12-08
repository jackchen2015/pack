/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

package com.cw.pack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chenwei
 * Created on 2017-11-28, 18:48:11
 */
public class Car
{
	private int id;
	private String model;
	private String name;
	private long length;
	private long width;
	private long high;
	private int currWeight;
	private int loadWeight;
	
	private List<Device> putDevices = new ArrayList<Device>();
	private long leftLength;
	
	public Car()
	{
	}
	
	public Car(long length, long width, long high, int weight)
	{
		this.length = length;
		this.leftLength = length;
		this.width = width;
		this.high = high;
		this.loadWeight = weight;
	}

	/**
	 * @return the putDevices
	 */
	public List<Device> getPutDevices()
	{
		return putDevices;
	}

	/**
	 * @param putDevices the putDevices to set
	 */
	public void setPutDevices(List<Device> putDevices)
	{
		this.putDevices = putDevices;
	}

	/**
	 * @return the leftLength
	 */
	public long getLeftLength()
	{
		return leftLength;
	}

	/**
	 * @param leftLength the leftLength to set
	 */
	public void setLeftLength(long leftLength)
	{
		this.leftLength = leftLength;
	}
	
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}

	/**
	 * @return the model
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model)
	{
		this.model = model;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the lengh
	 */
	public long getLength()
	{
		return length;
	}

	/**
	 * @param length the lengh to set
	 */
	public void setLength(long length)
	{
		this.length = length;
		this.leftLength = length;
	}

	/**
	 * @return the width
	 */
	public long getWidth()
	{
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(long width)
	{
		this.width = width;
	}

	/**
	 * @return the high
	 */
	public long getHigh()
	{
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(long high)
	{
		this.high = high;
	}

	/**
	 * @return the currWeight
	 */
	public int getCurrWeight()
	{
		return currWeight;
	}

	/**
	 * @param currWeight the currWeight to set
	 */
	public void setCurrWeight(int currWeight)
	{
		this.currWeight = currWeight;
	}

	/**
	 * @return the loadWeight
	 */
	public int getLoadWeight()
	{
		return loadWeight;
	}

	/**
	 * @param loadWeight the loadWeight to set
	 */
	public void setLoadWeight(int loadWeight)
	{
		this.loadWeight = loadWeight;
	}
	
	@Override
	public String toString()
	{		
		return "车辆 id:"+id+", 长:"+length+"mm, 宽:"+width+"mm, 高:"+high+"mm, 载重:"+loadWeight+"KG, 当前载重:"+ currWeight+"KG";
	}

}
