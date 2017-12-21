/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

package com.cw.pack.util;

import com.cw.pack.Car;
import com.cw.pack.Model;
import com.cw.pack.Weapon;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chenwei
 * Created on 2017-12-21, 13:59:25
 */
public class Constants
{
	
	private List<Car> allCars;
	private List<Weapon> allWeapons;
	private List<Model> allModels;
	private Map<String, Model> allMapModels = new HashMap<String, Model>();
	private Map<String, Weapon> allNameMapping = new HashMap<String, Weapon>();
	private Map<Model, List<Weapon>> weapMapping = new HashMap<Model, List<Weapon>>();
	
	private static Constants instance = new Constants();
	
	private Constants()
	{
		
	}
	
	public static Constants getInstance()
	{
		return instance;
	}

	/**
	 * @return the allCars
	 */
	public List<Car> getAllCars()
	{
		return allCars;
	}

	/**
	 * @param allCars the allCars to set
	 */
	public void setAllCars(List<Car> allCars)
	{
		this.allCars = allCars;
	}

	/**
	 * @return the allWeapons
	 */
	public List<Weapon> getAllWeapons()
	{
		return allWeapons;
	}

	/**
	 * @param allWeapons the allWeapons to set
	 */
	public void setAllWeapons(List<Weapon> allWeapons)
	{
		this.allWeapons = allWeapons;
	}

	/**
	 * @return the allModels
	 */
	public List<Model> getAllModels()
	{
		return allModels;
	}

	/**
	 * @param allModels the allModels to set
	 */
	public void setAllModels(List<Model> allModels)
	{
		this.allModels = allModels;
	}

	/**
	 * @return the allMapModels
	 */
	public Map<String, Model> getAllMapModels()
	{
		return allMapModels;
	}

	/**
	 * @param allMapModels the allMapModels to set
	 */
	public void setAllMapModels(
			Map<String, Model> allMapModels)
	{
		this.allMapModels = allMapModels;
	}

	/**
	 * @return the allNameMapping
	 */
	public Map<String, Weapon> getAllNameMapping()
	{
		return allNameMapping;
	}

	/**
	 * @param allNameMapping the allNameMapping to set
	 */
	public void setAllNameMapping(
			Map<String, Weapon> allNameMapping)
	{
		this.allNameMapping = allNameMapping;
	}

	/**
	 * @return the weapMapping
	 */
	public Map<Model, List<Weapon>> getWeapMapping()
	{
		return weapMapping;
	}

	/**
	 * @param weapMapping the weapMapping to set
	 */
	public void setWeapMapping(
			Map<Model, List<Weapon>> weapMapping)
	{
		this.weapMapping = weapMapping;
	}
	
	

}
