package 进制;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Desktop.Action;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;



import javax.swing.JRadioButton;

public class now implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JLabel show;
	private JButton btnNewButton;
	private JRadioButton binary_1;
	private JRadioButton decimalism_1;
	private JRadioButton octal_1;
	private JRadioButton hexadecimal_1;
	private JRadioButton binary;
	private JRadioButton decimalism;
	private JRadioButton octal;
	private JRadioButton hexadecimal;
	private ButtonGroup btg;
	private ButtonGroup btg1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					now window = new now();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public now() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 200);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		show = new JLabel();
		show.setText("结果在这里");
		panel.add(show);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setSize(300, 400);
		
		textField = new JTextField();
		textField.setText("");
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("转换");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(this);
		binary_1 = new JRadioButton("二进制");
		panel_1.add(binary_1);
		
		decimalism_1 = new JRadioButton("十进制");
		panel_1.add(decimalism_1);
		
		octal_1 = new JRadioButton("八进制");
		panel_1.add(octal_1);
		
		hexadecimal_1 = new JRadioButton("十六进制");
		panel_1.add(hexadecimal_1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		binary = new JRadioButton("二进制");
		panel_2.add(binary);
		
		decimalism = new JRadioButton("十进制");
		panel_2.add(decimalism);
		
		octal = new JRadioButton("八进制");
		panel_2.add(octal);
		
		hexadecimal = new JRadioButton("十六进制");
		panel_2.add(hexadecimal);
		
		btg = new ButtonGroup();
		btg.add(binary);
		btg.add(hexadecimal);
		btg.add(octal);
		btg.add(decimalism);
		btg1 = new ButtonGroup();
		btg1.add(binary_1);
		btg1.add(hexadecimal_1);
		btg1.add(octal_1);
		btg1.add(decimalism_1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String num = textField.getText();
		try {
			if(e.getActionCommand().equals("转换")) {
				if (binary_1.isSelected()&&decimalism.isSelected()) {
					//二转十
					show.setText(Integer.valueOf(num,2).toString());
				}else if (binary_1.isSelected()&&octal.isSelected()) {
					//二转八
					show.setText(Integer.toOctalString(Integer.valueOf(num,2)));
				}else if (binary_1.isSelected()&&hexadecimal.isSelected()) {
					//二转十六
					show.setText(Integer.toHexString(Integer.valueOf(num,2)));
				}else if (decimalism_1.isSelected()&&binary.isSelected()) {
					//十转二
					show.setText(Integer.toBinaryString(Integer.parseInt(num)));
				}else if (decimalism_1.isSelected()&&octal.isSelected()) {
					//十转八
					show.setText(Integer.toOctalString(Integer.parseInt(num)));
				}else if (decimalism_1.isSelected()&&hexadecimal.isSelected()) {
					//十转十六
					show.setText(Integer.toHexString(Integer.parseInt(num)));
				}else if (octal_1.isSelected()&&binary.isSelected()) {
					//八转二
					show.setText(Integer.toBinaryString(Integer.valueOf(num,8)));
				}else if (octal_1.isSelected()&&decimalism.isSelected()) {
					//八转十
					show.setText(Integer.valueOf(num,8).toString());
				}else if (octal_1.isSelected()&&hexadecimal.isSelected()) {
					//八转十六
					show.setText(Integer.toHexString(Integer.valueOf(num,8)));
				}else if (hexadecimal_1.isSelected()&&binary.isSelected()) {
					//十六转二
					show.setText(Integer.toBinaryString(Integer.valueOf(num,16)));
				}else if (hexadecimal_1.isSelected()&&octal.isSelected()) {
					//十六转八
					show.setText(Integer.toOctalString(Integer.valueOf(num,16)));
				}else if (hexadecimal_1.isSelected()&&decimalism.isSelected()) {
					//十六转十
					show.setText(Integer.valueOf(num,16).toString());
				}else {
					show.setText(textField.getText());
				}
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
			 JOptionPane.showMessageDialog(null, "输入有误！请重新输入！", "出错啦！", JOptionPane.PLAIN_MESSAGE);
			 textField.setText("");
		}
	}
		
}
