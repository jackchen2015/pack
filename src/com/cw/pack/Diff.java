/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

package com.cw.pack;

/**
 *
 * @author chenwei
 * Created on 2017-12-13, 16:40:16
 */
public class Diff
{
	private int type;
	private int left;//x
	private int top;//y
	private int distance;//z
	
	public Diff(int type, int left, int top, int distance)
	{
		this.type = type;
		this.left = left;
		this.top = top;
		this.distance = distance;
	}

	/**
	 * @return the type
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * @return the left
	 */
	public int getLeft()
	{
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(int left)
	{
		this.left = left;
	}

	/**
	 * @return the top
	 */
	public int getTop()
	{
		return top;
	}

	/**
	 * @param top the top to set
	 */
	public void setTop(int top)
	{
		this.top = top;
	}

	/**
	 * @return the distance
	 */
	public int getDistance()
	{
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance)
	{
		this.distance = distance;
	}

}
