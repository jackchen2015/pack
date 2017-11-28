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
	private int length;//长
	private int width;//宽
	private int high;//高
	private boolean horizontal;//横放
	private boolean vertical;//竖放
	private boolean bottom;//底部朝下
	private boolean slanting;//斜着放置
	private List<Integer> compatibility;//不能放在一起列表
	private int number;//物品数量

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
	public int getLength()
	{
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}

	/**
	 * @return the high
	 */
	public int getHigh()
	{
		return high;
	}

	/**
	 * @param high the high to set
	 */
	public void setHigh(int high)
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
}
