package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class SystemIntro {
	
	private static final String INTRO ="\n    本系統全名為「每個男人的夢想、讓情侶感情升溫、臉紅心跳撲通撲通、"
			+ "世界第一宇宙無敵、還在擔心出去玩都跑電影院、這個app讓你男友力UPUP — 夢幻政大情侶旅遊行程推薦指"
			+ "南大全」(以下簡稱「本系統」)，為一款於2019年由國立政治大學商學院學生所設計之約會景點旅遊推薦系統"
			+ "\n本系統提供以下功能:\n一、將近二十個雙北知名景點評論等觀光資訊供使用者參考。\n\n" 
			+ "二、大型(?)資料庫提供所有點對點的旅遊交通資訊，並包含金額及時間的估算。\n\n" 
			+ "三、各景點精選近十樣周邊美食，並提供連結至google maps領導頁面。\n\n"
			+ "四、最後，本系統提供最新的當日天氣資訊概況，包含最高低溫、資外線強度或降雨機率等\n\n" 
			+ "本團隊希冀透過這款應用程式，政大情侶們的感情能快速升溫、百年好合!!\n\n\n" 
			+ "最後，有任何問題歡迎透過「關於->開發人員」來聯絡我們，祝您使用愉快。";

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemIntro window = new SystemIntro();
					
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
	public SystemIntro() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("系統簡介");
		frame.setBounds(100, 100, 700, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JTextArea txtrappupup = new JTextArea();
		panel.add(txtrappupup);
		txtrappupup.setEditable(false);
		txtrappupup.setText(INTRO);
		txtrappupup.setLineWrap(true);
		txtrappupup.setRows(24);
		txtrappupup.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 18));
		txtrappupup.setColumns(40);
		
		JButton btnNewButton = new JButton("關閉");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("PMingLiU", Font.PLAIN, 18));
		frame.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	}

}
