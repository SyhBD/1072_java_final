package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Records extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> recordslist;
	private JLabel lblNewLabel_1;
	private JLabel lblNa;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNa_1;
	private Spots master;
	
	/**
	 * Create the frame.
	 */
	public Records(Spots master,ArrayList<String> records) {
		
		this.recordslist = records;
		this.master = master;
		
		setResizable(false);
		setTitle("搜尋紀錄");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("1.");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NAAAAAAAAAAAA");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel label_3 = new JLabel("到");
		label_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 6;
		gbc_label_3.gridy = 1;
		contentPane.add(label_3, gbc_label_3);
		
		lblNewLabel_6 = new JLabel("NAAAAAAAAAAA");
		lblNewLabel_6.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 9;
		gbc_lblNewLabel_6.gridy = 1;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		btnNewButton = new JButton("前往搜尋");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					master.queryRecords(1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JLabel label = new JLabel("2.");
		label.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		contentPane.add(label, gbc_label);
		
		lblNa = new JLabel("NA");
		lblNa.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNa = new GridBagConstraints();
		gbc_lblNa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNa.gridx = 3;
		gbc_lblNa.gridy = 4;
		contentPane.add(lblNa, gbc_lblNa);
		
		JLabel lblNewLabel_3 = new JLabel("到");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblNewLabel_7 = new JLabel("NA");
		lblNewLabel_7.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 9;
		gbc_lblNewLabel_7.gridy = 4;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		btnNewButton_1 = new JButton("前往搜尋");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					master.queryRecords(2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 11;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel label_1 = new JLabel("3.");
		label_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 7;
		contentPane.add(label_1, gbc_label_1);
		
		lblNewLabel_2 = new JLabel("NA");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 7;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("到");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 7;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		lblNewLabel_8 = new JLabel("NA");
		lblNewLabel_8.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 9;
		gbc_lblNewLabel_8.gridy = 7;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		btnNewButton_2 = new JButton("前往搜尋");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					master.queryRecords(3);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 11;
		gbc_btnNewButton_2.gridy = 7;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JLabel label_2 = new JLabel("4.");
		label_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 10;
		contentPane.add(label_2, gbc_label_2);
		
		lblNa_1 = new JLabel("NA");
		lblNa_1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNa_1 = new GridBagConstraints();
		gbc_lblNa_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNa_1.gridx = 3;
		gbc_lblNa_1.gridy = 10;
		contentPane.add(lblNa_1, gbc_lblNa_1);
		
		JLabel lblNewLabel_5 = new JLabel("到");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 6;
		gbc_lblNewLabel_5.gridy = 10;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		lblNewLabel_9 = new JLabel("NA");
		lblNewLabel_9.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblNewLabel_9.gridx = 9;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		btnNewButton_3 = new JButton("前往搜尋");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					master.queryRecords(4);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 11;
		gbc_btnNewButton_3.gridy = 10;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		buttonlock();
		setLabelText();
		this.setVisible(true);
		
		
	}
	
	private void buttonlock() {
		
		int len = this.recordslist.size();
		
		if(len == 2) {
			btnNewButton_1.setEnabled(false);
			btnNewButton_2.setEnabled(false);
			btnNewButton_3.setEnabled(false);
		}else if(len == 4) {
			btnNewButton_2.setEnabled(false);
			btnNewButton_3.setEnabled(false);
		}else if(len == 6){
			btnNewButton_3.setEnabled(false);
		}
	}
	
	private void setLabelText() {
		
		int len = this.recordslist.size();
		
		if(len == 2) {
			lblNewLabel_1.setText(this.recordslist.get(0));
			lblNewLabel_6.setText(this.recordslist.get(1));
		}else if(len == 4) {
			lblNewLabel_1.setText(this.recordslist.get(0));
			lblNewLabel_6.setText(this.recordslist.get(1));
			lblNa.setText(this.recordslist.get(2));
			lblNewLabel_7.setText(this.recordslist.get(3));
		}else if(len == 6){
			lblNewLabel_1.setText(this.recordslist.get(0));
			lblNewLabel_6.setText(this.recordslist.get(1));
			lblNa.setText(this.recordslist.get(2));
			lblNewLabel_7.setText(this.recordslist.get(3));
			lblNewLabel_2.setText(this.recordslist.get(4));
			lblNewLabel_8.setText(this.recordslist.get(5));
		}else {
			lblNewLabel_1.setText(this.recordslist.get(0));
			lblNewLabel_6.setText(this.recordslist.get(1));
			lblNa.setText(this.recordslist.get(2));
			lblNewLabel_7.setText(this.recordslist.get(3));
			lblNewLabel_2.setText(this.recordslist.get(4));
			lblNewLabel_8.setText(this.recordslist.get(5));
			lblNa_1.setText(this.recordslist.get(6));
			lblNewLabel_9.setText(this.recordslist.get(7));
		}
	}
	
	

}
