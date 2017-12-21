/*
 * Copyright 2015 Hongxin Telecommunication Technologies Co, Ltd.,
 * Wuhan, Hubei, China. All rights reserved.
 */
package com.cw.pack.util;

/**
 *
 * @author chenwei Created on 2017-12-21, 16:06:12
 */
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
//只能输入整数

public class Txtonlynumber
{
	public Txtonlynumber()
	{
		JFrame f = new JFrame("Txtonlynumber");
		Container contentPane = f.getContentPane();
		JTextField salary = new JTextField(10);
		salary.setDocument(new NumOnlyDocument());
		contentPane.add(salary);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	public static void main(String[] args)
	{
		new Txtonlynumber();
	}

	class NumOnlyDocument extends PlainDocument
	{
		public void insertString(int offset, String s, AttributeSet attrSet) throws BadLocationException
		{
			try
			{
				Integer.parseInt(s);
			}
			catch(NumberFormatException ex)
			{
				return;
			}
			super.insertString(offset, s, attrSet);
		}
	}
}
