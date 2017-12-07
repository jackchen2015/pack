/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class Device
{
	private int id;//编号
	private String model;//型号
	private String name;//名称
	private long length;//长
	private long width;//宽
	private long high;//高
	private boolean horizontal;//横放
	private boolean vertical;//竖放
	private boolean bottom;//底部朝下
	private boolean slanting;//斜着放置
	private List<Integer> compatibility;//不能放在一起列表
	private int number;//物品数量
	private int weight;

	
	public Device()
	{		
	}
	
	public Device(int id, long length, long width, long high, int weight, int number)
	{
		this.id = id;
		this.length = length;
		this.width = width;
		this.high = high;
		this.weight = weight;
		this.number = number;
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
	 * @return the length
	 */
	public long getLength()
	{
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(long length)
	{
		this.length = length;
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
	 * @return the horizontal
	 */
	public boolean isHorizontal()
	{
		return horizontal;
	}

	/**
	 * @param horizontal the horizontal to set
	 */
	public void setHorizontal(boolean horizontal)
	{
		this.horizontal = horizontal;
	}

	/**
	 * @return the vertical
	 */
	public boolean isVertical()
	{
		return vertical;
	}

	/**
	 * @param vertical the vertical to set
	 */
	public void setVertical(boolean vertical)
	{
		this.vertical = vertical;
	}

	/**
	 * @return the compatibility
	 */
	public List<Integer> getCompatibility()
	{
		return compatibility;
	}

	/**
	 * @param compatibility the compatibility to set
	 */
	public void setCompatibility(List<Integer> compatibility)
	{
		this.compatibility = compatibility;
	}

	/**
	 * @return the number
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number)
	{
		this.number = number;
	}

	/**
	 * @return the bottom
	 */
	public boolean isBottom()
	{
		return bottom;
	}

	/**
	 * @param bottom the bottom to set
	 */
	public void setBottom(boolean bottom)
	{
		this.bottom = bottom;
	}

	/**
	 * @return the slanting
	 */
	public boolean isSlanting()
	{
		return slanting;
	}

	/**
	 * @param slanting the slanting to set
	 */
	public void setSlanting(boolean slanting)
	{
		this.slanting = slanting;
	}

	/**
	 * @return the weight
	 */
	public int getWeight()
	{
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
	
	@Override
	public Device clone()
	{
		Device dev = new Device(id, length, width, high, weight, number);
		return dev;
	}
	
	@Override
	public String toString()
	{
		return "id:"+id+", length:"+length+", width:"+width+", high:"+high+", weight:"+weight+", number:"+number;
	}

}
