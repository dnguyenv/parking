package view.users;

import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.User;
import view.listeners.Listerner;
import controllers.users.UserController;
import controllers.users.listeners.UsersTriggerEvent;
import controllers.users.listeners.UserListener;

public class JTableList extends JTable implements UserListener, Listerner {
	
	private static final long serialVersionUID = 1L;
	
	private TableModel model = new TableModel();

	public JTableList() {
		this.setModel(model);
		this.getTableHeader().setReorderingAllowed(false);
		UserController.getInstance().addUserListener(this);
		loadAllUsers();
	}
	
	public void loadAllUsers(){
		try {
			for (User user : UserController.getInstance().allUsers()) {
				System.out.println(user.toString());
				model.insertRow(0, user.toArray());

			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error", e.getMessage(), JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	
	private class TableModel extends DefaultTableModel{
		
		private static final long serialVersionUID = 1L;
		
		public TableModel() {
			super(new Object[][][]{}, new String[] {"Login", "Name", "Role"});	 
		}
		
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		
	}

	@Override
	public void useradd(UsersTriggerEvent<User> event) {
		model.insertRow(0, event.getSource().toArray());
	}

	@Override
	public void cmdEdit() {
		System.out.println(this.getSelectedRow());
	}

	@Override
	public void cmdRemove() {
		if (this.getSelectedRow() != -1) {
			int row = this.getSelectedRow();
			String login = (String) this.getValueAt(row, 0);
			try {
				UserController.getInstance().remove(login);
				model.removeRow(row);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void cmdDetails() {
		System.out.println(this.getSelectedRow());
	}
	
	@Override
	public void cmdAdd() {
		UserForm.toggle();
	}

}
