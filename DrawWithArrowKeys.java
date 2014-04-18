/*
 * [Draw lines using the arrow keys] 
 * Write a program that draws line segments using the arrow keys. 
 * The line starts from the center of the frame and draw towards east, north, west or south 
 * when the right-arrow () key, up-arrow (↑) key, left-arrow key () or down-arrow(↓) key is pressed.
 * 
 * */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawWithArrowKeys extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawWithArrowKeys()
	{
		add(new drawLine());
	}

	/** Main method */
	public static void main(String[] args)
	{
		DrawWithArrowKeys frame = new DrawWithArrowKeys();
		frame.setTitle("DrawWithArrowKeys : [Draw lines using the arrow keys] ");
		frame.setSize( width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	static int width = 400;
	static int height = 200;

	static class drawLine extends JPanel
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int x1 = width/2;
		private int y1 = height/2;
		private int x2 = width/2;
		private int y2 = height/2;

		public drawLine()
		{
			setFocusable(true);

			addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_UP:
							x1 = x2;
							if (y2 - 10 > 0)
								y2 -= 10;
							break;
						case KeyEvent.VK_DOWN:
							x1 = x2;
							if (y2 + 10 < height)
								y2 += 10;
							break;
						case KeyEvent.VK_LEFT:
							y1 = y2;
							if (x2 - 10 > 0)
								x2 -= 10;
							break;
						case KeyEvent.VK_RIGHT:
							y1 = y2;
							if (x2 + 10 < width)
								x2 += 10;
							break;
					}

					repaint();
				}
			});
		}

		public void paintComponent(Graphics g)
		{
			g.drawLine(x1, y1, x2, y2);
		}
	}
}
