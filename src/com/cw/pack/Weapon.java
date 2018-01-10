/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cw.pack;
/**
 *
 * @author Administrator
 */
public class Weapon
{
	private int id;//编号
	private String name;//名称
	private Model model;//型号种类
	private long length;//长
	private long width;//宽
	private long high;//高
	private boolean horizontal;//横放
	private boolean vertical;//竖放
	private boolean bottom;//底部朝下
	private boolean slanting;//斜着放置
	private int number;//物品数量
	private int weight;

	
	public Weapon()
	{		
	}
	
	public Weapon(int id, String name, long length, long width, long high, int weight, int number, Model model)
	{
		this.id = id;
		this.name = name;
		this.length = length;
		this.width = width;
		this.high = high;
		this.weight = weight;
		this.number = number;
		this.model = model;
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
	public Model getModel()
	{
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model)
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
	public Weapon clone()
	{
		Weapon dev = new Weapon(id, name, length, width, high, weight, number, model);
		dev.setSlanting(slanting);
		return dev;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
	
	@Override
	public boolean equals(Object w)
	{
		if(w==null)
		{
			return false;
		}
		return id == ((Weapon)w).id
				&&name.equals(((Weapon)w).name);
	}
	
	public String getWeaponDesc()
	{
		return "物品 id:"+id+ ", 物品名称:"+name+", 长:"+length+"mm, 宽:"+width+"mm, 高:"+high+"mm, 重量:"+weight+"KG, 数量:"+number+", 类别:"+model.getName()+"\n";
	}
	
	@Override
	public String toString()
	{
		return name;
	}

}
