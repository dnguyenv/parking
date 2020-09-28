package view.applayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.Util;
import view.listeners.Listerner;
import view.users.UserForm;

public class MainMenu extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu jmFile;
	private JMenuItem jmiExit;
	
	private JMenu jmEdit;
	private JMenuItem jmiAdd;
	private JMenuItem jmiEdit;
	private JMenuItem jmiRemove;

	private JMenu jmVisitor;
	private JMenuItem jmiVisitorGetPermit;
	private JMenuItem jmiVisitorPayCitation;
	private JMenuItem jmiVisitorExitLot;

	private JMenu jmUniversityUser;

	private JMenu jmAdministrator;
	private JMenuItem jmiAdminAddLot;
	private JMenuItem jmiAdminAssignZone;
	private JMenuItem jmiAdminAssignType2Space;
	private JMenuItem jmiAdminAssignPermit;
	private JMenuItem jmiAdminCheckValidVisitorParking;
	private JMenuItem jmiAdminCheckInvalidVisitorParking;


	
	private JMenu jmReport;
	private JMenuItem jmReportListOfZone;
	private JMenuItem jmReportGetPermitInformation;
	private JMenuItem jmReportGetVehicleInformation;


	private JMenu jmHelp;
	private JMenuItem jmiAbout;
	

	private Listerner eventListerner; 
	
	public MainMenu(Listerner eventListerner) {
		this.eventListerner = eventListerner;
		configure();
		registerListeners();
	}
	

	private void configure() {
		jmFile = createMenu("File", 'F');

		jmReport = createMenu("Report", 'R');

		jmReportListOfZone = createMenuItem(jmReport, "List of zones", 'V', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_MASK));

		jmReportGetPermitInformation = createMenuItem(jmReport, "Permit information", 'P', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.ALT_MASK));

		jmReportGetVehicleInformation = createMenuItem(jmReport, "Vehicle information", 'I', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.ALT_MASK));

		
		jmAdministrator = createMenu("Administrator", 'M');

		jmiAdminAddLot = createMenuItem(jmAdministrator, "Add lot", 'L', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.ALT_MASK));

		jmiAdminAssignZone = createMenuItem(jmAdministrator, "Assign zone", 'Z', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.ALT_MASK));

		jmiAdminAssignType2Space = createMenuItem(jmAdministrator, "Assign type to space", 'T', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));

		jmiAdminAssignPermit = createMenuItem(jmAdministrator, "Assign permit", 'Q', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_5, InputEvent.ALT_MASK));

		jmiAdminCheckValidVisitorParking = createMenuItem(jmAdministrator, "Check valid visitor parking", 'Z', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_6, InputEvent.ALT_MASK));

		jmiAdminCheckInvalidVisitorParking = createMenuItem(jmAdministrator, "Check invalid visitor parking", 'Z', "configs", 
		KeyStroke.getKeyStroke(KeyEvent.VK_7, InputEvent.ALT_MASK));

		
		jmVisitor = createMenu("Visitor", 'V');

		jmiVisitorGetPermit = createMenuItem(jmVisitor, "Get visitor permit", 'V', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_0, InputEvent.ALT_MASK));

		jmiVisitorPayCitation = createMenuItem(jmVisitor, "Pay citation", 'C', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.ALT_MASK));

		jmiVisitorExitLot = createMenuItem(jmVisitor, "Exit lot", 'E', "configs", 
				KeyStroke.getKeyStroke(KeyEvent.VK_9, InputEvent.ALT_MASK));
		

			

		jmUniversityUser = createMenu("University User", 'U');

	
		
		jmEdit = createMenu("Edit", 'E');
		
		jmHelp = createMenu("Help", 'H');
		
		jmiExit = createMenuItem(jmFile, "Exit", 'x', "close_view",
				KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		
		
		jmiAdd = createMenuItem(jmEdit, "Add", 'A', "add_obj",
				KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0));
		
		
		jmiEdit = createMenuItem(jmEdit, "Edit", 'E', "edit",
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.ALT_MASK));
		
		jmiRemove = createMenuItem(jmEdit, "Remove", 'R', "remove",
				KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		
		
		jmiAbout = createMenuItem(jmHelp, "About", 'U', "about",
				KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
	}
	
	
	private JMenu createMenu(String name, char mnemonic) {
		JMenu jMenu = new JMenu(name);
		jMenu.setMnemonic(mnemonic);
		this.add(jMenu);	
		return jMenu;
	}
	
	private JMenuItem createMenuItem(JMenu jMenu, String name,
			char mnmonic, String icone, KeyStroke keyStroke){
		
		JMenuItem jMenuItem = new JMenuItem(name);
		jMenuItem.setAccelerator(keyStroke);
		jMenuItem.setIcon(Util.getIcon(getClass(), icone));
		jMenuItem.setMnemonic(mnmonic);
		jMenu.add(jMenuItem);
		
		return jMenuItem;
	}


	private void registerListeners(){
		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdExit();
			}
		});	
		
		jmiAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdAdd();
			}
		});
		
		jmiEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdEdit();
			}
		});
		
		jmiRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventListerner.cmdRemove();
			}
		});
		
		jmiAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("About");
			}
		});
	}
	
	public void cmdExit(){
		System.exit(0);
	}
}
