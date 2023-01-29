package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.Font;

public class foodGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					foodGUI window = new foodGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public foodGUI() throws SQLException, IOException {
		initialize();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void initialize() throws SQLException, IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 570);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("夢幻政大情侶旅遊行程推薦指南大全 - 找美食");
		
		JLabel label = new JLabel("請選擇想找的美食");
		label.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
		label.setBackground(Color.PINK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label, BorderLayout.NORTH);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setLayout(new GridLayout(6,3));
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		
		JButton button = new JButton("台北美術館");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TaipeiArt subFrame = new TaipeiArt();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		button.setBackground(Color.WHITE);
		/*
		TaipeiArt subFrame = new TaipeiArt();
		if(subFrame.isShowing()) {
			button.setEnabled(false);
		}
		else {
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					subFrame.setVisible(true);
				}
			});
		}
		*/
		mainpanel.add(button);
		
		JButton btnNewButton = new JButton("新北市政府大樓觀景瞭望台");
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Observatory subFrame0 = new Observatory();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("淡水老街");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DamShui subFrame1 = new DamShui();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("台北101");
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Taipei101 subFrame2 = new Taipei101();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("西門町");
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_3.setBackground(Color.WHITE);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Ximen subFrame3 = new Ximen();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("大稻埕");
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_4.setBackground(Color.WHITE);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DadauTown subFrame4 = new DadauTown();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("九份");
		btnNewButton_5.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_5.setBackground(Color.WHITE);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JiuFen subFrame5 = new JiuFen();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("平溪老街");
		btnNewButton_6.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_6.setBackground(Color.WHITE);
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PingXi subFrame6 = new PingXi();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("擎天崗");
		btnNewButton_7.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Qingtiangang subFrame7 = new Qingtiangang();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("北投");
		btnNewButton_8.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Beitou subFrame8 = new Beitou();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("通化夜市");
		btnNewButton_9.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_9.setBackground(Color.WHITE);
		btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						TongHua subFrame9 = new TongHua();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("兒童新樂園");
		btnNewButton_10.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Amusement subFrame10 = new Amusement();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mainpanel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("饒河夜市");
		btnNewButton_11.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try {
						Raohe subFrame11 = new Raohe();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("象山親山步道");
		btnNewButton_12.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						MtShiung subFrame12 = new MtShiung();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("臺北市立動物園");
		btnNewButton_13.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_13.setBackground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						TaipeiZoo subFrame13 = new TaipeiZoo();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("福隆海水浴場");
		btnNewButton_14.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_14.setBackground(Color.WHITE);
		btnNewButton_14.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						FuLong subFrame14 = new FuLong();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("三峽老街");
		btnNewButton_15.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_15.setBackground(Color.WHITE);
		btnNewButton_15.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Sanxia subFrame15 = new Sanxia();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("美麗華");
		btnNewButton_16.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton_16.setBackground(Color.WHITE);
		btnNewButton_16.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						BeautyMall subFrame16 = new BeautyMall();
					} catch (SQLException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		mainpanel.add(btnNewButton_16);
	}

}
