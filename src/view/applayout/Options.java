package view.applayout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import util.Util;
import view.listeners.Listerner;

public class Options extends JPanel{

	private static final long serialVersionUID = 1L;

	private JButton jbAdd;
	private JButton jbEdit;
	private JButton jbDetails;
	private JButton jbRemove;
	
	private JToolBar jtbOptions;
	
	private Listerner eventListerner; 
	
	public Options(Listerner eventListerner) {
		this.eventListerner = eventListerner;
		
		//Flowlayout is the default layout of panel
		setLayout(new BorderLayout());
		configure();
		registerListeners();
	}
	
	private void configure(){
		jtbOptions = new JToolBar("Options Bar"); 
		
		jbAdd = createButton("Add", "add_obj");
		jbEdit = createButton("Edit", "edit");
		jbDetails = createButton("Details", "details");
		jbRemove = createButton("Remove", "remove");
		
		this.add(jtbOptions, BorderLayout.CENTER);
	}
	
	private JButton createButton(String hint, String icon){
		JButton jButton = new JButton();
		
		jButton.setIcon(Util.getIcon(getClass(), icon));
		jButton.setToolTipText(hint);
		jtbOptions.add(jButton);
		
		return jButton;
	}
	
	private void registerListeners(){
		jbEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdEdit();
			}
		});
		
		jbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdAdd();
			}
		});
		
		jbDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdDetails();
			}
		});
		
		jbRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdRemove();
			}
		});
	}
	
	public void cmdExit(){
		System.exit(0);
	}
}
