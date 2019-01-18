package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.ViewManager;
import model.BankAccount;
import model.User;

public class InfoView extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewManager manager;
	
	private JButton backButton;
	private JLabel errorLabel = new JLabel("", SwingConstants.CENTER);
	private BankAccount account;
	private JLabel accountNumLabel;
	private JLabel accountNum;
	private JLabel nameLabel;
	private JLabel name;
	private JLabel addressLabel;
	private JLabel address;
	private JLabel cityLabel;
	private JLabel city;
	private JLabel stateLabel;
	private JLabel state;
	private JLabel zipLabel;
	private JLabel zip;
	private JLabel birthLabel;
	private JLabel birth;
	private JLabel phoneNumLabel;
	private JLabel phoneNum;
	private JTextField addressField;
	private JTextField cityField;
	private JComboBox stateField;
	private JFormattedTextField zipField;
	private JFormattedTextField phoneNumField1;
	private JFormattedTextField phoneNumField2;
	private JFormattedTextField phoneNumField3;
	private JPasswordField pinField;
	private JButton editButton;
	private JLabel editLabel;

	public InfoView(ViewManager manager) throws ParseException {
		super();
		
		this.manager = manager;
		initialize();
	}

	private void initialize() throws ParseException {
		initBackButton();
		initLabels();
		initInfo();
		initEditButton();
	}

	private void initEditButton() {
		editButton = new JButton();
		editButton.setBounds(350, 200, 50, 50);
		editButton.addActionListener(this);
		
		editLabel = new JLabel("Edit", SwingConstants.CENTER);
		editLabel.setBounds(350, 200, 50, 50);
		editLabel.setLabelFor(editButton);
		
		this.add(editLabel);
		this.add(editButton);
	}

	private void initInfo() {
		if (this.account == null) {
			return;
		}
		
		accountNum = new JLabel(String.valueOf(account.getAccountNumber()), SwingConstants.LEFT);
		accountNum.setBounds(200, 50, 100, 35);
	
		name = new JLabel(account.getUser().getFirstName() + " " + account.getUser().getLastName(), SwingConstants.LEFT);
		name.setBounds(200, 100, 100, 35);
		
		address = new JLabel(account.getUser().getStreetAddress(), SwingConstants.LEFT);
		address.setBounds(200, 150, 200, 35);
		
		city = new JLabel(account.getUser().getCity(), SwingConstants.LEFT);
		city.setBounds(200, 200, 100, 35);
		
		state = new JLabel(account.getUser().getState(), SwingConstants.LEFT);
		state.setBounds(200, 250, 100, 35);
		
		zip = new JLabel(account.getUser().getZip(), SwingConstants.LEFT);
		zip.setBounds(200, 300, 100, 35);
		
		birth = new JLabel(account.getUser().getFormattedDob(), SwingConstants.LEFT);
		birth.setBounds(200, 350, 100, 35);
		
		phoneNum = new JLabel(String.valueOf(account.getUser().getFormattedPhone()), SwingConstants.LEFT);
		phoneNum.setBounds(200, 400, 100, 35);
		
		this.add(accountNum);
		this.add(name);
		this.add(address);
		this.add(city);
		this.add(state);
		this.add(zip);
		this.add(birth);
		this.add(phoneNum);
	}

	private void initLabels() {
		accountNumLabel = new JLabel("Account Number: ", SwingConstants.RIGHT);
		accountNumLabel.setBounds(0, 50, 200, 35);
		accountNumLabel.setLabelFor(accountNum);
		accountNumLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		nameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
		nameLabel.setBounds(100, 100, 100, 35);
		nameLabel.setLabelFor(name);
		nameLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		addressLabel = new JLabel("Street Address: ", SwingConstants.RIGHT);
		addressLabel.setBounds(0, 150, 200, 35);
		addressLabel.setLabelFor(address);
		addressLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		cityLabel = new JLabel("City: ", SwingConstants.RIGHT);
		cityLabel.setBounds(100, 200, 100, 35);
		cityLabel.setLabelFor(city);
		cityLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		stateLabel = new JLabel("State: ", SwingConstants.RIGHT);
		stateLabel.setBounds(100, 250, 100, 35);
		stateLabel.setLabelFor(state);
		stateLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		zipLabel = new JLabel("Postal Code: ", SwingConstants.RIGHT);
		zipLabel.setBounds(0, 300, 200, 35);
		zipLabel.setLabelFor(zip);
		zipLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		birthLabel = new JLabel("Date of Birth: ", SwingConstants.RIGHT);
		birthLabel.setBounds(0, 350, 200, 35);
		birthLabel.setLabelFor(birth);
		birthLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		phoneNumLabel = new JLabel("Phone Number: ", SwingConstants.RIGHT);
		phoneNumLabel.setBounds(0, 400, 200, 35);
		phoneNumLabel.setLabelFor(phoneNum);
		phoneNumLabel.setFont(new Font("DialogInput", Font.BOLD, 14));
		
		this.add(accountNumLabel);
		this.add(nameLabel);
		this.add(addressLabel);
		this.add(cityLabel);
		this.add(stateLabel);
		this.add(zipLabel);
		this.add(birthLabel);
		this.add(phoneNumLabel);
	}

	private void initBackButton() {
		backButton = new JButton();
		backButton.setBounds(5, 5, 50, 50);
		backButton.addActionListener(this);
		this.setLayout(null);
		
		JLabel label = new JLabel("Back", SwingConstants.CENTER);
		label.setBounds(5, 5, 50, 50);
		label.setLabelFor(backButton);
		
		this.add(label);
		this.add(backButton);
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
		
		initInfo();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		errorLabel.setText("");
		errorLabel.setBounds(150, 250, 200, 35);
		this.add(errorLabel);
		
		if (object.equals(backButton)) {
			manager.switchTo(ATM.HOME_VIEW);
			if (this.account != null) {
				accountNum.setText("");
				name.setText("");
				address.setText("");
				city.setText("");
				state.setText("");
				zip.setText("");
				birth.setText("");
				phoneNum.setText("");
			}
		} else if (object.equals(editButton)) {
			addressField = new JTextField();
			addressField.setText(account.getUser().getStreetAddress());
			addressField.setBounds(200, 150, 200, 35);
			this.add(addressField);
			address.remove(this);
		}
	}
}