package main;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

public class PingXi extends JFrame{
	private JLabel lblNewLabel;
	private JButton lblNewButton;
	private JLabel lblNewLabel_1;
	private JButton lblNewButton_1;
	private JLabel lblNewLabel_2;
	private JButton lblNewButton_2;
	private JLabel lblNewLabel_3;
	private JButton lblNewButton_3;
	private JLabel lblNewLabel_4;
	private JButton lblNewButton_4;
	private JLabel lblNewLabel_5;
	private JButton lblNewButton_5;
	private JLabel lblNewLabel_6;
	private JButton lblNewButton_6;
	private JLabel lblNewLabel_7;
	private JButton lblNewButton_7;
	private JLabel imageNewLabel;
	private JLabel imageNewLabel_1;
	private JLabel imageNewLabel_2;
	private JLabel imageNewLabel_3;
	private JLabel imageNewLabel_4;
	private JLabel imageNewLabel_5;
	private JLabel imageNewLabel_6;
	private JLabel imageNewLabel_7;
	private ArrayList<JLabel>labels;
	private ArrayList<JButton>buttons;
	private ArrayList<JLabel>imageNewlabels;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PingXi window = new PingXi();
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
	public PingXi() throws SQLException, IOException {
		getContentPane().setBackground(Color.PINK);
		labels = new ArrayList<JLabel>();
		lblNewLabel = new JLabel();
		lblNewLabel_1 = new JLabel();
		lblNewLabel_2 = new JLabel();
		lblNewLabel_3 = new JLabel();
		lblNewLabel_4 = new JLabel();
		lblNewLabel_5 = new JLabel();
		lblNewLabel_6 = new JLabel();
		lblNewLabel_7 = new JLabel();
		labels.add(lblNewLabel);
		labels.add(lblNewLabel_1);
		labels.add(lblNewLabel_2);
		labels.add(lblNewLabel_3);
		labels.add(lblNewLabel_4);
		labels.add(lblNewLabel_5);
		labels.add(lblNewLabel_6);
		labels.add(lblNewLabel_7);
		buttons = new ArrayList<JButton>();
		lblNewButton = new JButton();
		lblNewButton_1 = new JButton();
		lblNewButton_2 = new JButton();
		lblNewButton_3 = new JButton();
		lblNewButton_4 = new JButton();
		lblNewButton_5 = new JButton();
		lblNewButton_6 = new JButton();
		lblNewButton_7 = new JButton();
		buttons.add(lblNewButton);
		buttons.add(lblNewButton_1);
		buttons.add(lblNewButton_2);
		buttons.add(lblNewButton_3);
		buttons.add(lblNewButton_4);
		buttons.add(lblNewButton_5);
		buttons.add(lblNewButton_6);
		buttons.add(lblNewButton_7);
		imageNewlabels = new ArrayList<JLabel>();
		imageNewLabel = new JLabel();
		imageNewLabel_1 = new JLabel();
		imageNewLabel_2 = new JLabel();
		imageNewLabel_3 = new JLabel();
		imageNewLabel_4 = new JLabel();
		imageNewLabel_5 = new JLabel();
		imageNewLabel_6 = new JLabel();
		imageNewLabel_7 = new JLabel();
		imageNewlabels.add(imageNewLabel);
		imageNewlabels.add(imageNewLabel_1);
		imageNewlabels.add(imageNewLabel_2);
		imageNewlabels.add(imageNewLabel_3);
		imageNewlabels.add(imageNewLabel_4);
		imageNewlabels.add(imageNewLabel_5);
		imageNewlabels.add(imageNewLabel_6);
		imageNewlabels.add(imageNewLabel_7);
		initialize();
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws IOException 
	 */
	private void initialize() throws SQLException, IOException {
		
		this.setTitle("平溪老街");
		this.setBounds(100, 100, 950, 590);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Connection conn = DataSource.getConnection();
		try {	
			PreparedStatement stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
			ResultSet result = null;
			int labelindex = 0;
			for(int foodnum = 601; foodnum<=608; foodnum++) {
				stat.setInt(1,foodnum);
				result = stat.executeQuery();
				if(result.next()) {
					Blob blob = result.getBlob(1);
					InputStream in = blob.getBinaryStream();
					BufferedImage image = ImageIO.read(in);
					ImageIcon icon = new ImageIcon(image);
					icon = resize(icon,150,150);
					labels.get(labelindex).setIcon(icon);
				}
				labelindex++;
			}
			result.close();
			
			stat = conn.prepareStatement("SELECT Food FROM Foods WHERE FoodNum =?");
			int buttonindex = 0;
			for(int foodnum = 601; foodnum<=608; foodnum++) {	
				stat.setInt(1,foodnum);
				result = stat.executeQuery();
				if(result.next()) {
					String foodname = result.getString(1);
					buttons.get(buttonindex).setText(foodname);	
				}
				buttonindex++;
			}
			result.close();
			
			stat = conn.prepareStatement("SELECT URL FROM Foods WHERE FoodNum=?");
			buttonindex = 0;
			for(int foodnum = 601; foodnum<=608; foodnum++) {
				stat.setInt(1,foodnum);
				result = stat.executeQuery();
				if(result.next()) {
					String url = result.getString(1);
					buttons.get(buttonindex).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							openWebpage(url);
						}
					});	
				}
				buttonindex++;
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			conn.close();
		}
		conn = DataSource.getConnection();
		PreparedStatement stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,601);
		ResultSet rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,750,500);
			imageNewLabel.setIcon(icon);
			rs.close();
		}
		
		lblNewLabel.setBounds(40, 15, 150, 150);
		this.getContentPane().add(lblNewLabel);
		lblNewButton.setBounds(0, 165, 239, 23);
		lblNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton);
		lblNewLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,602);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,750,500);
			imageNewLabel_1.setIcon(icon);
			rs.close();
		}
		lblNewLabel_1.setBounds(298, 15, 150, 150);
		this.getContentPane().add(lblNewLabel_1);
		lblNewButton_1.setBounds(271, 165, 200, 23);
		lblNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_1);
		
		lblNewLabel_1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_1);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,603);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,750,500);
			imageNewLabel_2.setIcon(icon);
			rs.close();
		}
		lblNewLabel_2.setBounds(503, 15, 150, 150);
		this.getContentPane().add(lblNewLabel_2);
		lblNewButton_2.setBounds(486, 165, 200, 23);
		lblNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_2);
		lblNewLabel_2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_2);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,604);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,700,600);
			imageNewLabel_3.setIcon(icon);
			rs.close();
		}
		lblNewLabel_3.setBounds(730, 15, 150, 150);
		this.getContentPane().add(lblNewLabel_3);
		lblNewButton_3.setBounds(709, 165, 200, 23);
		lblNewButton_3.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_3);
		lblNewLabel_3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_3);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,605);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,750,500);
			imageNewLabel_4.setIcon(icon);
			rs.close();
		}
		lblNewLabel_4.setBounds(40, 269, 150, 150);
		this.getContentPane().add(lblNewLabel_4);
		lblNewButton_4.setBounds(0, 420, 231, 23);
		lblNewButton_4.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_4);
		lblNewLabel_4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_4);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,606);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,750,500);
			imageNewLabel_5.setIcon(icon);
			rs.close();
		}
		lblNewLabel_5.setBounds(298, 269, 150, 150);
		this.getContentPane().add(lblNewLabel_5);
		lblNewButton_5.setBounds(271, 420, 200, 23);
		lblNewButton_5.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_5);
		lblNewLabel_5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_5);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,607);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,700,500);
			imageNewLabel_6.setIcon(icon);
			rs.close();
		}
		lblNewLabel_6.setBounds(503, 269, 150, 150);
		this.getContentPane().add(lblNewLabel_6);
		lblNewButton_6.setBounds(486, 420, 192, 23);
		lblNewButton_6.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_6);
		lblNewLabel_6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(750,600);
				imageframe.getContentPane().add(imageNewLabel_6);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		stat = conn.prepareStatement("SELECT Pic FROM Foods WHERE FoodNum =?");
		stat.setInt(1,608);
		rs = null;
		rs = stat.executeQuery();
		if(rs.next()) {
			Blob blob = rs.getBlob(1);
			InputStream in = blob.getBinaryStream();
			BufferedImage image = ImageIO.read(in);
			ImageIcon icon = new ImageIcon(image);
			icon = resize(icon,700,500);
			imageNewLabel_7.setIcon(icon);
			rs.close();
		}
		lblNewLabel_7.setBounds(730, 269, 150, 150);
		this.getContentPane().add(lblNewLabel_7);
		lblNewButton_7.setBounds(709, 420, 200, 23);
		lblNewButton_7.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		this.getContentPane().add(lblNewButton_7);
		lblNewLabel_7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				JFrame imageframe = new JFrame();
				imageframe.setSize(800,700);
				imageframe.getContentPane().add(imageNewLabel_7);
				imageframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				imageframe.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	}
	public ImageIcon resize(ImageIcon imageicon,int x ,int y) {
		ImageIcon icon;
		Image old = imageicon.getImage();
		Image newimage = old.getScaledInstance(x,y,Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimage);
		return icon;
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
		JOptionPane.showMessageDialog(this,"連線失敗，請檢查網路。","錯誤", JOptionPane.ERROR_MESSAGE);
	}
}
