/*
 * [number converter] 
 * Write a JFrame that converts between decimal, hex, and binary numbers. 
 * When you enter a decimal value in the decimal-value text field and press the Enter key, 
 * its corresponding hex and binary numbers are displayed in the other two text fields. 
 * Likewise, you can enter values in the other fields and convert them accordingly.
 * 
 * */

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberConverter extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtfDecimal = new JTextField(20);
	JTextField jtfHex = new JTextField(20);
	JTextField jtfBinary = new JTextField(20);

	public NumberConverter()
	{
		// Set GridLayout, 3 rows, 2 columns, and gaps 5 between
		// components horizontally and vertically
		setLayout(new GridLayout(3, 2, 0, 0));

		// Set JTextField Alignment
		jtfDecimal.setHorizontalAlignment(JTextField.RIGHT);
		jtfHex.setHorizontalAlignment(JTextField.RIGHT);
		jtfBinary.setHorizontalAlignment(JTextField.RIGHT);

		// Add labels and text fields to the frame
		add(new JLabel("Decimal"));
		add(jtfDecimal);
		add(new JLabel("Hex"));
		add(jtfHex);
		add(new JLabel("Binary"));
		add(jtfBinary);

		final String error = "Format Mismatch";
		
		// Add JTextField KeyListener
		jtfDecimal.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
				{
					if (isDecimal(jtfDecimal))
					{
						jtfBinary.setText(toBinary(jtfDecimal));
						jtfDecimal.setText(toDecimal(jtfDecimal));
						jtfHex.setText(toHex(jtfDecimal));
					} else
					{
						jtfBinary.setText(error);
						jtfDecimal.setText(error);
						jtfHex.setText(error);
					}
				}
			}
		});
		jtfHex.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
				{
					if (isHex(jtfHex))
					{
						jtfBinary.setText(toBinary(jtfHex));
						jtfDecimal.setText(toDecimal(jtfHex));
						jtfHex.setText(toHex(jtfHex));
					} else
					{
						jtfBinary.setText(error);
						jtfDecimal.setText(error);
						jtfHex.setText(error);
					}
				}
			}
		});
		jtfBinary.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)
				{
					if (isBinary(jtfBinary))
					{
						jtfBinary.setText(toBinary(jtfBinary));
						jtfDecimal.setText(toDecimal(jtfBinary));
						jtfHex.setText(toHex(jtfBinary));
					} else
					{
						jtfBinary.setText(error);
						jtfDecimal.setText(error);
						jtfHex.setText(error);
					}
				}
			}
		});

	}

	/** Main method */
	public static void main(String[] args)
	{
		NumberConverter frame = new NumberConverter();
		frame.setTitle("NumberConverter :[number converter]");
		frame.setSize(300, 120);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public Boolean isBinary(JTextField textField)
	{
		try
		{
			Integer.parseInt(textField.getText(), 2);
			return true;

		} catch (Exception E)
		{
			return false;
		}

	}

	public Boolean isDecimal(JTextField textField)
	{
		try
		{
			Integer.parseInt(textField.getText());
			return true;

		} catch (Exception E)
		{
			return false;
		}

	}

	public Boolean isHex(JTextField textField)
	{
		try
		{
			Integer.parseInt(textField.getText(), 16);
			return true;
		} catch (Exception E)
		{
			return false;
		}

	}

	public String toHex(JTextField textField)
	{
		try
		{
			if (textField == jtfBinary)
			{
				return Integer.toHexString(Integer.parseInt(
						textField.getText(), 2));

			} else if (textField == jtfDecimal)
			{
				return Integer
						.toHexString(Integer.parseInt(textField.getText()));

			} else if (textField == jtfHex)
			{
				return textField.getText();
			}
		} catch (Exception E)
		{

		}
		return "Format Mismatch";
	}

	public String toBinary(JTextField textField)
	{
		try
		{
			if (textField == jtfBinary)
			{
				return textField.getText();

			} else if (textField == jtfDecimal)
			{
				return Integer.toBinaryString(Integer.parseInt(textField
						.getText()));

			} else if (textField == jtfHex)
			{
				return Integer.toBinaryString(Integer.parseInt(
						textField.getText(), 16));
			}

		} catch (Exception E)
		{

		}
		return "Format Mismatch";
	}

	public String toDecimal(JTextField textField)
	{
		try
		{
			if (textField == jtfBinary)
			{
				return Integer
						.toString(Integer.parseInt(textField.getText(), 2));

			} else if (textField == jtfDecimal)
			{
				return textField.getText();

			} else if (textField == jtfHex)
			{
				return Integer.toString(Integer.parseInt(textField.getText(),
						16));
			}

		} catch (Exception E)
		{

		}
		return "Format Mismatch";
	}

}
