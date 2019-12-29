package com.tb.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import com.tb.beans.User;
import com.tb.services.UserServices;
import com.tb.services.UserServicesImpl;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class UserSignup {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtContact;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	User user=new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSignup window = new UserSignup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	UserServices services;
	
	public UserSignup() 
	{
		initialize();
		try 
		{
			services = new UserServicesImpl();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(30, 144, 255));
		frame.setBounds(100, 100, 611, 453);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(10, 155, 575, 210);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(384, 22, 119, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(384, 53, 119, 20);
		panel.add(txtAge);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(384, 84, 119, 20);
		panel.add(txtContact);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(384, 115, 119, 20);
		panel.add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(384, 146, 119, 20);
		panel.add(txtPassword);
		
		JLabel lblNane = new JLabel("Name");
		lblNane.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNane.setBounds(262, 25, 46, 14);
		panel.add(lblNane);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(262, 56, 93, 14);
		panel.add(lblAge);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContact.setBounds(262, 87, 75, 14);
		panel.add(lblContact);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(262, 118, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(262, 149, 75, 14);
		panel.add(lblPassword);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Man2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(36, 32, 186, 143);
		panel.add(label);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				user.setName(txtName.getText());
				user.setAge(Integer.parseInt(txtAge.getText()));
				user.setContact(txtContact.getText());
				user.setEmail(txtEmail.getText());
				user.setPassword(txtPassword.getText());
				int res = 0;
				try 
				{
					res = services.saveUser(user);
				}
				catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(btnSubmit, e1.getMessage());
				}
				
				JOptionPane.showMessageDialog(btnSubmit, "The "+res+" data is successfully saved");
			}
		});
		Image imgs = new ImageIcon(this.getClass().getResource("/Ok.png")).getImage();
		btnSubmit.setIcon(new ImageIcon(imgs));
		btnSubmit.setForeground(new Color(0, 0, 128));
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.setBounds(225, 369, 148, 34);
		frame.getContentPane().add(btnSubmit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(0, 0, 595, 68);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNew = new JButton("New");
		btnNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNew.setBounds(108, 22, 89, 23);
		panel_1.add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEdit.setBounds(241, 22, 89, 23);
		panel_1.add(btnEdit);
		
		JButton btnShowAll = new JButton("Show All");
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShowAll.setBounds(371, 22, 89, 23);
		panel_1.add(btnShowAll);
		
		JLabel lblUserManagement = new JLabel("                        User Management");
		lblUserManagement.setBackground(new Color(0, 128, 128));
		lblUserManagement.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserManagement.setBounds(122, 96, 337, 27);
		frame.getContentPane().add(lblUserManagement);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 215, 0));
		panel_2.setBounds(169, 90, 222, 41);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
	}
}
