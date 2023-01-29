package main;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.*;

public class Main {

	private JFrame frame;
	private final JButton btnNewButton_1 = new JButton("找美食?");
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_1;
	private JRadioButtonMenuItem rdbtnmntmNewRadioItem_2;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JCheckBoxMenuItem checkBoxMenuItem;
	private JCheckBoxMenuItem chckbxmntmNewCheckItem;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JButton btnNewButton;
	private JTextArea textArea;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem menuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		try {
			this.setWeather();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frame,"連線失敗，請檢查網路。","錯誤", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int i = JOptionPane.showConfirmDialog(frame,"確定要離開系統嗎?","詢問",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(i == 0) {
					System.exit(0);
				}
			}
		});
		frame.setTitle("夢幻政大情侶旅遊行程推薦指南大全 - 主頁面");
		frame.setResizable(false);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 1100, 700);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("設定");
		mnNewMenu.setFont(new Font("PMingLiU", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		mnNewMenu_2 = new JMenu("字體");
		mnNewMenu_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_2);
		rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("大");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontsChange();
				}
		});
		rdbtnmntmNewRadioItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_2.add(rdbtnmntmNewRadioItem);
		
		rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("中");
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontsChange();
				}
		});
		rdbtnmntmNewRadioItem_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_2.add(rdbtnmntmNewRadioItem_1);
		
		rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("小");
		rdbtnmntmNewRadioItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontsChange();
				}
		});
		rdbtnmntmNewRadioItem_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_2.add(rdbtnmntmNewRadioItem_2);
		
		ButtonGroup btngrp = new ButtonGroup();
		btngrp.add(rdbtnmntmNewRadioItem);
		btngrp.add(rdbtnmntmNewRadioItem_1);
		btngrp.add(rdbtnmntmNewRadioItem_2);
		rdbtnmntmNewRadioItem_1.setSelected(true);
		
		
		mnNewMenu_3 = new JMenu("天氣顯示");
		mnNewMenu_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu.add(mnNewMenu_3);
		
		checkBoxMenuItem = new JCheckBoxMenuItem("隱藏當日天氣");
		checkBoxMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				judgeWeather();
			}
		});
		checkBoxMenuItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_3.add(checkBoxMenuItem);
		
		chckbxmntmNewCheckItem = new JCheckBoxMenuItem("隱藏當周天氣");
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				judgeWeather();
			}
		});
		chckbxmntmNewCheckItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_3.add(chckbxmntmNewCheckItem);
		
		mnNewMenu_1 = new JMenu("關於");
		mnNewMenu_1.setFont(new Font("PMingLiU", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_1);
		
		menuItem = new JMenuItem("系統簡介");
		menuItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemIntro sysInt = new SystemIntro();
			}
		});
		mnNewMenu_1.add(menuItem);
		
		mntmNewMenuItem = new JMenuItem("開發人員");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Developers dvlp = new Developers();
			}
		});
		mntmNewMenuItem.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel jpanel = new JPanel();
		frame.getContentPane().add(jpanel, BorderLayout.CENTER);
		GridBagLayout gbl_jpanel = new GridBagLayout();
		gbl_jpanel.columnWidths = new int[]{530, 0};
		gbl_jpanel.rowHeights = new int[]{154, 74, 134, 0, 0, 0};
		gbl_jpanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_jpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		jpanel.setLayout(gbl_jpanel);
		
		btnNewButton = new JButton("找景點?");
		btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Spots spotsWin = new Spots();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.ipady = 60;
		gbc_btnNewButton.ipadx = 90;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		jpanel.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.ipady = 60;
		gbc_btnNewButton_1.ipadx = 90;
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 3;
		btnNewButton_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 30));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					foodGUI food = new foodGUI();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jpanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		textArea = new JTextArea();
		textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		textArea.setAlignmentX(Component.RIGHT_ALIGNMENT);
		textArea.setText("天氣資訊載入中......");
		textArea.setRows(30);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setColumns(35);
		
		frame.getContentPane().add(textArea, BorderLayout.EAST);
	}
	
	private void fontsChange() {
		if(rdbtnmntmNewRadioItem.isSelected()) {
			textArea.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
			btnNewButton_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 34));
			btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 34));
		}else if(rdbtnmntmNewRadioItem_1.isSelected()) {
			textArea.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
			btnNewButton_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 30));
			btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 30));
		}else if(rdbtnmntmNewRadioItem_2.isSelected()) {
			textArea.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
			btnNewButton_1.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 26));
			btnNewButton.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 26));
		}
	}
	
	private void judgeWeather() {
		try {
			if(checkBoxMenuItem.isSelected() && chckbxmntmNewCheckItem.isSelected()) {
				this.setNoWeather();
			}else{
				this.setWeather();
				if(checkBoxMenuItem.isSelected()) {
					this.setOnlyWeeksWeather();
				}
				if(chckbxmntmNewCheckItem.isSelected()) {
					this.setOnlyTodaysWeather();
				}
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frame,"連線失敗，請檢查網路。","錯誤", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void setWeather() throws Exception{
		Weatherforecast weather = new Weatherforecast();
		String info = "天氣預報:\n" + weather.todaysWeather() + "\n\n本周天氣:\n" + weather.weeksWeather();
		textArea.setText(info);
	}
	
	private void setOnlyWeeksWeather() throws Exception{
		Weatherforecast weather = new Weatherforecast();
		String info = "本周天氣:\n" + weather.weeksWeather();
		textArea.setText(info);
	}
	
	private void setOnlyTodaysWeather() throws Exception{
		Weatherforecast weather = new Weatherforecast();
		String info = "天氣預報:\n" + weather.todaysWeather();
		textArea.setText(info);
	}
	
	private void setNoWeather() {
		textArea.setText("沒有天氣資訊。");
	}

}
