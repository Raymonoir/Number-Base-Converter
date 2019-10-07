package raymond.com.baseConverter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window 
{

	private JFrame frmBaseConverter;
	private JComboBox givenBase;
	private JComboBox wantedBase;
	private JTextField givenNumberText;
	private JLabel answerText;
	private BaseConverter b;
	private String [] baseOptions = {"2","3","4","5","6","7","8", "9","10"};
	
	


	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() 
	{
		frmBaseConverter = new JFrame();
		frmBaseConverter.setTitle("Base Converter");
		frmBaseConverter.setResizable(false);
		frmBaseConverter.setBounds(100, 100, 341, 300);
		frmBaseConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBaseConverter.getContentPane().setLayout(null);
		
		b = new BaseConverter();
		
		JLabel lblGivenBase = new JLabel("Given base");
		lblGivenBase.setBounds(38, 40, 73, 16);
		frmBaseConverter.getContentPane().add(lblGivenBase);
		
		JLabel lblNewLabel = new JLabel("Wanted base");
		lblNewLabel.setBounds(191, 40, 90, 16);
		frmBaseConverter.getContentPane().add(lblNewLabel);
		
		givenBase = new JComboBox(baseOptions);
		givenBase.setBounds(28, 68, 130, 26);
		frmBaseConverter.getContentPane().add(givenBase);

		
		wantedBase =  new JComboBox(baseOptions);
		wantedBase.setBounds(183, 68, 130, 26);
		frmBaseConverter.getContentPane().add(wantedBase);

		
		JLabel lblNewLabel_1 = new JLabel("Given number");
		lblNewLabel_1.setBounds(38, 106, 90, 16);
		frmBaseConverter.getContentPane().add(lblNewLabel_1);
		
		givenNumberText = new JTextField();
		givenNumberText.setBounds(28, 134, 130, 26);
		frmBaseConverter.getContentPane().add(givenNumberText);
		givenNumberText.setColumns(10);
		
		JButton convertButton = new JButton("Convert");
		convertButton.setBounds(196, 134, 117, 29);
		convertButton.addActionListener(source -> 
		{
			
			boolean acceptable = true;
			
			String [] digits = givenNumberText.getText().split("");
			
			for (String c : digits)
			{
				if (Integer.valueOf(c) >= Integer.valueOf(givenBase.getSelectedItem().toString()))
				{
					acceptable = false;
				}
			}
			
			
			if(acceptable)
			{
				int answer = b.baseConverter(Integer.valueOf(wantedBase.getSelectedItem().toString()),
				Integer.valueOf(givenNumberText.getText()),
				Integer.valueOf(givenBase.getSelectedItem().toString()));
								
				answerText.setText(Integer.toString(answer));
				
			}
			else
			{
				answerText.setText("An error has occured within your inputs");
			}
			
			
			
			
			
		
		});
		frmBaseConverter.getContentPane().add(convertButton);
		
		answerText = new JLabel();
		answerText.setBounds(38, 202, 275, 26);
		frmBaseConverter.getContentPane().add(answerText);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(38, 183, 61, 16);
		frmBaseConverter.getContentPane().add(lblAnswer);

		
		
		frmBaseConverter.setVisible(true);
	}

		
	public static void main (String [] args)
	{
		Window w = new Window();
		w.initialize();
	}
	

}
