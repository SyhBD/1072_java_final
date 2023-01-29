package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.*;

public class Developers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Developers window = new Developers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public Developers() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("開發人員資訊");
		frame.setResizable(false);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 543, 514);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("    國立政治大學 資訊管理學系學士班一年級  李鴻禧");
		label.setFont(new Font("Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		frame.getContentPane().add(label, gbc_label);
		
		JButton button = new JButton("連絡他");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebpage("https://www.facebook.com/profile.php?id=100003633712091");
			}
		});
		button.setBackground(Color.GRAY);
		button.setFont(new Font("Serif", Font.PLAIN, 15));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		frame.getContentPane().add(button, gbc_button);
		
		JLabel lblNewLabel = new JLabel("國立政治大學 資訊管理學系學士班一年級  陳廷威");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JButton button_1 = new JButton("連絡他");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebpage("https://www.facebook.com/profile.php?id=100002525667600");
			}
		});
		button_1.setFont(new Font("Serif", Font.PLAIN, 15));
		button_1.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 3;
		frame.getContentPane().add(button_1, gbc_button_1);
		
		JLabel label_1 = new JLabel("國立政治大學 資訊管理學系學士班一年級  許嘉誠");
		label_1.setFont(new Font("Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 5;
		frame.getContentPane().add(label_1, gbc_label_1);
		
		JButton button_2 = new JButton("連絡他");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openWebpage("https://www.facebook.com/profile.php?id=100002328889838");
			}
		});
		button_2.setFont(new Font("Serif", Font.PLAIN, 15));
		button_2.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 5;
		frame.getContentPane().add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("連絡他");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openWebpage("http://www.facebook.com/xmsknight");
			}
		});
		
		JLabel label_2 = new JLabel("    國立政治大學 統計學系學士班二年級  李奕宏");
		label_2.setFont(new Font("Serif", Font.PLAIN, 16));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 7;
		frame.getContentPane().add(label_2, gbc_label_2);
		button_3.setFont(new Font("Serif", Font.PLAIN, 15));
		button_3.setBackground(Color.GRAY);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 7;
		frame.getContentPane().add(button_3, gbc_button_3);
		
		JLabel label_3 = new JLabel("    特別感謝：");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 10;
		frame.getContentPane().add(label_3, gbc_label_3);
		
		JLabel lblNewLabel_1 = new JLabel("國立政治大學 商學院 資訊管理學系");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 11;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel label_4 = new JLabel("林怡伶  助理教授");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridwidth = 2;
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 11;
		frame.getContentPane().add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("國立政治大學 商學院 資訊管理學研究所");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 12;
		frame.getContentPane().add(label_5, gbc_label_5);
		
		JLabel lblsimon = new JLabel("余嘉翔(Simon) 助教");
		GridBagConstraints gbc_lblsimon = new GridBagConstraints();
		gbc_lblsimon.gridwidth = 2;
		gbc_lblsimon.anchor = GridBagConstraints.WEST;
		gbc_lblsimon.insets = new Insets(0, 0, 5, 0);
		gbc_lblsimon.gridx = 2;
		gbc_lblsimon.gridy = 12;
		frame.getContentPane().add(lblsimon, gbc_lblsimon);
		
		JButton btnNewButton = new JButton("離開");
		btnNewButton.setPreferredSize(new Dimension(110, 27));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.ipadx = 90;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 15;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	}
	
	private boolean openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	            return true;
	        } catch (Exception e) {
	        	connectionError();
	        }
	    }
	    return false;
	}

	private boolean openWebpage(String urlString) {
	    try {
	    	URL url = new URL(urlString);
	        return openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	    	connectionError();
	    } catch (Exception e) {
	    	connectionError();
	    }
	    return false;
	}
	
	private void connectionError() {
		JOptionPane.showMessageDialog(frame,"連線失敗，請檢查網路。","錯誤", JOptionPane.ERROR_MESSAGE);
	}

}
