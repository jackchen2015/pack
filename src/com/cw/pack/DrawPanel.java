/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */

/*
 * DrawPanel.java
 *
 * Created on 2017-12-11, 19:14:54
 */

package com.cw.pack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;

/**
 *
 * @author chenwei
 */
public class DrawPanel extends javax.swing.JPanel
{

	private int type;
	private Car car;
	private Color[] colors = new Color[]{Color.BLUE, Color.ORANGE, Color.GREEN, Color.BLACK, Color.LIGHT_GRAY, Color.RED};
    /** Creates new form DrawPanel */
    public DrawPanel(int type, Car car)
	{
        initComponents();
		this.car = car;
		this.type = type;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 285, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     @Override
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		drawCar(g2d);
	}
	private void drawCar(Graphics2D g2d)
	{
		int carLength = (int)car.getLength();
		int carWidth = (int)car.getWidth();
		int carHigh = (int)car.getHigh();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
		int drawCarLen = this.getWidth() - 10;
		
		float rate = (float)drawCarLen/carLength;
		Diff diff = drawBox(g2d, car, rate);
		
		List<Device> devs = car.getPutDevices();
		int carLeftLength = (int)car.getLength();
		int x = 0;
		int y = 0;
		int z = 0;
		int count = 0;
		for(Device dev:devs)
		{
			g2d.setColor(colors[count++]);
			int cols = carWidth/(int)dev.getLength();//每条个数
			int rows = carHigh/(int)dev.getHigh();//能放多少排
			int levels = carLeftLength/(int)dev.getWidth();//能放多少层
			x = 5;
			y = (int)(car.getHigh() - dev.getHigh() + diff.getTop());
			z = 0;
			for(int i = 0;i<dev.getNumber();i++)
			{
				//根据i求x,y,z 
				//x 为左侧面 物体左上角的坐标
				
				drawDevice(g2d, x, y, z, diff, car, dev, rate);
				if(z+dev.getLength()>car.getWidth())
				{
					if(y-dev.getHigh()<0)//超出一排
					{
						x += dev.getWidth();
						y = (int)(car.getHigh() - dev.getHigh());
						z = 0;
					}
					else
					{
						z += dev.getLength();
					}
				}
				else
				{
					z += dev.getLength();
				}
			}
		}	

	}
	
	private Diff drawBox(Graphics2D g2d, Car car, float rate)
	{
		int di = 5;
		Diff diff = new Diff(type, di, 0, 0);
		int carLength = (int)car.getLength();
		int carWidth = (int)car.getWidth();
		int carHigh = (int)car.getHigh();

		int drawCarLen = this.getWidth() - 10;
		switch(type)
		{
			case 1://车左侧面
				g2d.drawString("左侧面", 10, 15);
				float drawCarWid = carHigh*rate;
				float start = (this.getHeight() - drawCarWid)/2;
				diff.setTop((int)start);
				g2d.drawRect(di, (int)start, drawCarLen, (int)drawCarWid);				
				break;
			case 2://车右侧面
				g2d.drawString("右侧面", 10, 15);
				float drawCarWid1 = carHigh*rate;
				float start1 = (this.getHeight() - drawCarWid1)/2;
				diff.setTop((int)start1);
				g2d.drawRect(di, (int)start1, drawCarLen, (int)drawCarWid1);
				break;
			case 3://车顶侧面
				g2d.drawString("顶侧面", 10, 15);
				float drawCarWid2 = carWidth*rate;
				float start2 = (this.getHeight() - drawCarWid2)/2;
				diff.setDistance((int)start2);
				g2d.drawRect(di, (int)start2, drawCarLen, (int)drawCarWid2);
				break;
			default:
				break;
		}
		return diff;
	}
	
	private void drawDevice(Graphics2D g2d, int x, int y, int z, Diff diff, Car car, Device dev, float rate)
	{
		switch(type)
		{
			case 1://左侧面
				g2d.fillRect(diff.getLeft()+(int)((x-diff.getLeft())*rate), (int)((y-diff.getTop())*rate), (int)(dev.getWidth()*rate), (int)(dev.getHigh()*rate));
				break;
			case 2://右侧面
				g2d.fillRect((int)(diff.getLeft()+((car.getLength()-dev.getWidth())-x+diff.getLeft())*rate), (int)((y-diff.getTop())*rate), (int)(dev.getWidth()*rate), (int)(dev.getHigh()*rate));
				break;
			case 3://顶侧面
				g2d.fillRect(diff.getLeft()+(int)((x-diff.getLeft())*rate), (int)(diff.getDistance()+(car.getWidth()-z-dev.getLength()+diff.getDistance())*rate), (int)(dev.getWidth()*rate), (int)(dev.getLength()*rate));
				break;
			default:
				break;
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
