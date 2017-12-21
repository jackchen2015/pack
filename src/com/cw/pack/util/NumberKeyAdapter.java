/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */
package com.cw.pack.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author chenwei Created on 2017-12-21, 16:12:51
 */
public class NumberKeyAdapter extends KeyAdapter
{
	public void keyTyped(KeyEvent e)
	{
		char c = e.getKeyChar();
		if(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)
		{
			return;
		}
		e.consume();
	}

	public void keyPressed(KeyEvent e)
	{
		if(e.isControlDown())
		{
			e.consume();
		}
	}
}
