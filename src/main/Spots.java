package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.util.ArrayList;
import java.sql.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Spots {

	private JFrame frame;
	private static ArrayList<String> spotsList;
	private ArrayList<String> recordsList;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JButton button;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextArea textArea1;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JTextArea textArea4;
	private JTextArea textArea5;
	private String start;
	private String dest;


	/**
	 * Create the application.
	 */
	public Spots() throws SQLException {
		start = "起點";
		dest = "終點";
		recordsList = new ArrayList<String>();
		getSpotsList();
		initialize();
		fillinJudge();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("夢幻政大情侶旅遊行程推薦指南大全 - 景點");
		frame.setResizable(false);
		frame.setBounds(100, 100, 1150, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // DIDPOSE
		frame.getContentPane().setLayout(null);
		
		button = new JButton("開始約會");
		button.setForeground(new Color(204, 0, 51));
		button.setFont(new Font("華康魏碑體", Font.BOLD, 31));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					showInfo();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(609, 123, 182, 73);
		frame.getContentPane().add(button);
		
		btnNewButton = new JButton("終點美食");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					foodConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(204, 0, 51));
		btnNewButton.setFont(new Font("華康魏碑體", Font.BOLD, 31));
		btnNewButton.setBounds(848, 123, 175, 73);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setSize(1116, 228);
		panel_1.setLocation(14, 298);
		//panel_1.setLayout(new GridLayout(1,5));
		//JLabel label = new JLabel("起點");
		//panel_1.add(label);
		//panel_1.add(new JLabel("路徑"));   
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new EtchedBorder());
		panel1.setLayout(new BorderLayout());
		JLabel label1 = new JLabel("起點/地區");
		label1.setFont(new Font("華康魏碑體", Font.PLAIN, 21));
		label1.setPreferredSize(new Dimension(80, 40));
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setLineWrap(true);
		textArea1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		textArea1.setColumns(10);
		textArea1.setPreferredSize(new Dimension(80,130));
		panel1.add(label1, BorderLayout.NORTH);
		panel1.add(textArea1);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new EtchedBorder());
		panel2.setLayout(new BorderLayout());
		JLabel label2 = new JLabel("終點/景點");
		label2.setFont(new Font("華康魏碑體", Font.PLAIN, 21));
		label2.setPreferredSize(new Dimension(80, 40));
		textArea2 = new JTextArea(); 
		textArea2.setEditable(false);
		textArea2.setLineWrap(true);
		textArea2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		textArea2.setColumns(10);
		textArea2.setPreferredSize(new Dimension(80,130));
		panel2.add(label2, BorderLayout.NORTH);
		panel2.add(textArea2);
		
		JPanel panel3 = new JPanel();
		panel3.setBorder(new EtchedBorder());
		panel3.setLayout(new BorderLayout());
		JLabel label3 = new JLabel("推薦路線/旅遊資訊");
		label3.setFont(new Font("華康魏碑體", Font.PLAIN, 21));
		label3.setPreferredSize(new Dimension(600,40));
		textArea3 = new JTextArea(); 
		textArea3.setEditable(false);
		textArea3.setColumns(20);
		textArea3.setLineWrap(true);
		textArea3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		textArea3.setPreferredSize(new Dimension(600,130));
		JScrollPane scrollPane = new JScrollPane(textArea3);
		panel3.add(label3, BorderLayout.NORTH);
		panel3.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel4 = new JPanel();
		panel4.setBorder(new EtchedBorder());
		panel4.setLayout(new BorderLayout());
		JLabel label4 = new JLabel("金錢");
		label4.setFont(new Font("華康魏碑體", Font.PLAIN, 21));
		label4.setPreferredSize(new Dimension(80, 40));
		textArea4 = new JTextArea(); 
		textArea4.setEditable(false);
		textArea4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		textArea4.setColumns(5);
		textArea4.setPreferredSize(new Dimension(80,130));
		panel4.add(label4, BorderLayout.NORTH);
		panel4.add(textArea4);
	
		JPanel panel5 = new JPanel();
		panel5.setBorder(new EtchedBorder());
		panel5.setLayout(new BorderLayout());
		
		panel_1.add(panel1);
		panel_1.add(panel2);
		panel_1.add(panel3);
		panel_1.add(panel4);
		panel_1.add(panel5);
		JLabel label5 = new JLabel("時間");
		panel5.add(label5, BorderLayout.NORTH);
		label5.setFont(new Font("華康魏碑體", Font.PLAIN, 21));
		label5.setPreferredSize(new Dimension(80, 40));
		textArea5 = new JTextArea();
		textArea5.setEditable(false);
		panel5.add(textArea5, BorderLayout.SOUTH);
		textArea5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		textArea5.setColumns(5);
		textArea5.setPreferredSize(new Dimension(80,130));
		frame.getContentPane().add(panel_1);
		
		btnNewButton_1 = new JButton("起點資訊");
		btnNewButton_1.setForeground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("華康魏碑體", Font.PLAIN, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					giveInfo(start);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(88, 183, 150, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("終點資訊");
		btnNewButton_2.setForeground(new Color(0, 0, 128));
		btnNewButton_2.setFont(new Font("華康魏碑體", Font.PLAIN, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					giveInfo(dest);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(371, 183, 150, 52);
		frame.getContentPane().add(btnNewButton_2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系統");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("紀錄");
		  class RecordListener implements ActionListener {
	            public void actionPerformed(ActionEvent e) {
	                try {
						createFrame();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        }
		mntmNewMenuItem.addActionListener(new RecordListener());
		mnNewMenu.add(mntmNewMenuItem);
		 
		comboBox = new JComboBox<String>();
		comboBox.setForeground(new Color(0, 128, 128));
		comboBox.setFont(new Font("華康魏碑體", Font.PLAIN, 29));
		comboBox.setEditable(false);
		comboBox.setEnabled(true);
		String default1 = "起點";
		comboBox.addItem(default1);
		for(String spot: spotsList) {
			comboBox.addItem(spot);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start = (String)comboBox.getSelectedItem();
				fillinJudge();
			}
		});
		comboBox.setBounds(47, 78, 229, 52);
		frame.getContentPane().add(comboBox);
		
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setForeground(new Color(0, 128, 128));
		comboBox_1.setFont(new Font("華康魏碑體", Font.PLAIN, 29));
		comboBox_1.setEditable(false);
		comboBox_1.setEnabled(true);
		String default2 = "終點";
		comboBox_1.addItem(default2);
		for(String spot: spotsList) {
			comboBox_1.addItem(spot);
		}
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dest = (String)comboBox_1.getSelectedItem();
				fillinJudge();
			}
		});
		comboBox_1.setBounds(316, 78, 236, 52);
		frame.getContentPane().add(comboBox_1);		 
		  
		  
	}
	
	/*
	private String getSpotsNum(String str) throws SQLException {
		
		Connection conn = DataSource.getConnection();
		String result = "";
		try {
			
			String sql = "SELECT SpotsNum FROM Spotsdata WHERE Spots = ?";
			PreparedStatement prestat = conn.prepareStatement(sql);
			prestat.setString(1, str);
			ResultSet result_ = prestat.executeQuery();
			while(result_.next()) {
				result += result_.getString(1);
			}
		}finally {
			conn.close();
		}
		return result;
	}
	*/
	
	private void showInfo() throws SQLException {
		
		String[] info = new String[5];
		info[0] = start;
		info[1] = dest;
		Connection conn = DataSource.getConnection();
		try {
			PreparedStatement prestat = conn.prepareStatement("SELECT Info, Money, Time " + 
																"FROM Travel " + 
																"WHERE Travel.SpotsNum IN " + 
																	"(SELECT SpotsNum FROM Spotsdata WHERE Spots = ?) " + 
																"AND Travel.DestinationNum IN " + 
																	"(SELECT SpotsNum FROM Spotsdata WHERE Spots = ?)");
			//String travelNum = getSpotsNum(this.start) + getSpotsNum(this.dest);
			
			//prestat.setString(1, travelNum);
			prestat.setString(1, this.start);
			prestat.setString(2, this.dest);
			ResultSet result = prestat.executeQuery();
			while(result.next()) {
				info[2] = result.getString("Info");
				info[3] = result.getString("Money");
				info[4] = result.getString("Time");
			}
		}finally {
			conn.close();
		}
		
		textArea1.setText(info[0]);
		textArea2.setText(info[1]);
		textArea3.setText(info[2]);
		textArea4.setText(info[3]);
		textArea5.setText(info[4]);
		recordsList.add(0, start);
		recordsList.add(1, dest);
		
	}
	
private void showInfoRecord() throws SQLException {
		
		String[] info = new String[5];
		info[0] = start;
		info[1] = dest;
		Connection conn = DataSource.getConnection();
		try {
			PreparedStatement prestat = conn.prepareStatement("SELECT Info, Money, Time " + 
																"FROM Travel " + 
																"WHERE Travel.SpotsNum IN " + 
																	"(SELECT SpotsNum FROM Spotsdata WHERE Spots = ?) " + 
																"AND Travel.DestinationNum IN " + 
																	"(SELECT SpotsNum FROM Spotsdata WHERE Spots = ?)");
			//String travelNum = getSpotsNum(this.start) + getSpotsNum(this.dest);
			
			//prestat.setString(1, travelNum);
			prestat.setString(1, this.start);
			prestat.setString(2, this.dest);
			ResultSet result = prestat.executeQuery();
			while(result.next()) {
				info[2] = result.getString("Info");
				info[3] = result.getString("Money");
				info[4] = result.getString("Time");
			}
		}finally {
			conn.close();
		}
		
		textArea1.setText(info[0]);
		textArea2.setText(info[1]);
		textArea3.setText(info[2]);
		textArea4.setText(info[3]);
		textArea5.setText(info[4]);
		
	}
	private void giveInfo(String str) throws SQLException{
		
		textArea2.setText(str);
		textArea4.setText("");
		textArea5.setText("");

		Connection conn = DataSource.getConnection();
		try {
			PreparedStatement prestat = conn.prepareStatement("SELECT District, Introduction FROM Spotsdata WHERE Spots = ?");		
			prestat.setString(1, str);
			ResultSet result = prestat.executeQuery();
			while(result.next()) {
				textArea1.setText(result.getString("District"));
				textArea3.setText(result.getString("Introduction"));
			}
		}finally {
			conn.close();
		}
	}
	
	private void fillinJudge() {
		
		button.setEnabled(false);
		btnNewButton.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		
		if(start.equals("起點")&&!(dest.equals("終點"))) {
			
			button.setEnabled(false);
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(false);
			btnNewButton_2.setEnabled(true);
		}else if(dest.equals("終點")&&!(start.equals("起點"))) {
			
			button.setEnabled(false);
			btnNewButton.setEnabled(false);
			btnNewButton_1.setEnabled(true);
			btnNewButton_2.setEnabled(false);
		}else if(!(dest.equals("終點")&&start.equals("起點"))){
			
			button.setEnabled(true);
			btnNewButton.setEnabled(true);
			btnNewButton_1.setEnabled(true);
			btnNewButton_2.setEnabled(true);
		}
	}
	
	private static void getSpotsList() throws SQLException{
		
		spotsList = new ArrayList<String>();
		Connection conn = DataSource.getConnection();
		try {
			
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT Spots FROM Spotsdata");
			while(result.next()) {
				spotsList.add(result.getString(1));
			}
		}finally {
			conn.close();
		}
	
	}
	
	private void createFrame() throws SQLException {
		
		if(this.recordsList.size() > 0) {
			Records records = new Records(this, recordsList);
		}else{
			JOptionPane.showMessageDialog(frame,"目前無搜索紀錄。","魯蛇", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void queryRecords(int num) throws SQLException {
		
		comboBox.setSelectedItem(recordsList.get((num*2)-2));
		comboBox_1.setSelectedItem(recordsList.get((num*2)-1));
		showInfoRecord();
	}
private String getSpotsNum() throws SQLException {
		
		String resultnum = "";
		Connection conn = DataSource.getConnection();
		try {
			
			PreparedStatement prestat = conn.prepareStatement("SELECT SpotsNum FROM Spotsdata WHERE Spots = ?");
			prestat.setString(1, this.dest);
			ResultSet result = prestat.executeQuery();
			while(result.next()) {
				resultnum = result.getString(1);
			}
		}finally {
			conn.close();
		}
		return resultnum;
		
	}
	
	private void foodConnection() throws SQLException, IOException {
		
		String target = this.getSpotsNum();
		if(target.equals("01")) {
			Raohe food = new Raohe();
		}else if(target.equals("02")) {
			MtShiung food = new MtShiung();
		}else if(target.equals("03")) {
			TaipeiZoo food = new TaipeiZoo();
		}else if(target.equals("04")) {
			Observatory food = new Observatory();
		}else if(target.equals("05")) {
			DamShui food = new DamShui();
		}else if(target.equals("06")) {
			PingXi food = new PingXi();
		}else if(target.equals("07")) {
			Taipei101 food = new Taipei101();
		}else if(target.equals("08")) {
			Ximen food = new Ximen();
		}else if(target.equals("09")) {
			Qingtiangang food = new Qingtiangang();
		}else if(target.equals("10")) {
			DadauTown food = new DadauTown();
		}else if(target.equals("11")) {
			JiuFen food = new JiuFen();
		}else if(target.equals("12")) {
			Beitou food = new Beitou();
		}else if(target.equals("13")) {
			TongHua food = new TongHua();
		}else if(target.equals("14")) {
			Amusement food = new Amusement();
		}else if(target.equals("15")) {
			TaipeiArt food = new TaipeiArt();
		}else if(target.equals("16")) {
			FuLong food = new FuLong();
		}else if(target.equals("17")) {
			Sanxia food = new Sanxia();
		}else if(target.equals("18")) {
			BeautyMall food = new BeautyMall();
		}else {
			JOptionPane.showMessageDialog(frame,"系統壞掉了QQ。","魯蛇", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
