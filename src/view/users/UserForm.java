package view.users;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controllers.users.UserController;
import model.User;

public class UserForm extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private static UserForm form = new UserForm();


	private JTextField jtfLogin;
	private JTextField jtfName;
	private JTextField jtfRole;	

	private JButton jbSave;
	private JButton jbCancel;

	public UserForm() {
		createForms();
		createButtons();
		registerListeners();
		configure();
	}	

	private void configure(){
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(this.getRootPane());
	}
	
	private void createForms(){
		JPanel jpForm = new JPanel(new GridLayout(2, 1, 0, 5));

		jpForm.setBorder(BorderFactory.createTitledBorder("Personal Details"));

		jpForm.add(fieldset(new JLabel("Login: "),
							jtfLogin = new JTextField(30)));

		jpForm.add(fieldset(new JLabel("Name: "),
				            jtfName = new JTextField(30)));

		jpForm.add(fieldset(new JLabel("Role: "),
				            jtfRole = new JTextField(30)));


		this.add(jpForm, BorderLayout.CENTER);
	}

	private JPanel fieldset(JComponent...components){
		JPanel fieldset = new JPanel();
		for (JComponent component : components) {
			fieldset.add(component);
		}
		return fieldset;
	}
	
	private void createButtons(){
		JPanel jpButtons = new JPanel();    

		jpButtons.add(jbSave = new JButton("Save"));
		jpButtons.add(jbCancel = new JButton("Cancel"));	

		this.add(jpButtons, BorderLayout.SOUTH);		
	}
	
	private void registerListeners() {
		jbSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdSave();
			}
		});
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdCancel();
			}
		});
	}
	
	private void cmdSave(){
		try {
			User user = new User( jtfLogin.getText(),jtfName.getText(),jtfRole.getText());
			JOptionPane.showMessageDialog(this, jtfLogin.getText() + " " + jtfName.getText() + " " + jtfRole.getText(), "", JOptionPane.INFORMATION_MESSAGE);
			UserController.getInstance().save(user);
			JOptionPane.showMessageDialog(this, "User saved successfully", "", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void cmdCancel(){
		dispose();
	}
	
	private void clearForm(JTextComponent... jtcomponets){
		for (JTextComponent component : jtcomponets) {
			component.setText("");
		}
	}
	
	@Override
	public void dispose(){
		super.dispose();
		clearForm(jtfLogin, jtfName, jtfRole);
	}
	
	public static void toggle(){
		form.setVisible(!form.isVisible());
	}
}