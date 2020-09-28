package view.applayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import view.users.JTableList;


public class MainJFrame extends JFrame {

	public static final Dimension PREFERREDSIZE = new Dimension(1000,600);
	
	private static final long serialVersionUID = 1L;
	
	public MainJFrame() {
		super("Parking management system - Team 3");
		
		JPanel jpBody = new JPanel();
		jpBody.setLayout(new BorderLayout());
		
		JScrollPane jspList = new JScrollPane();
		JTableList jTableList = new JTableList();
		jspList.setViewportView(jTableList);
		
		jpBody.add(new Options(jTableList), BorderLayout.SOUTH);
		jpBody.add(jspList, BorderLayout.CENTER);
		
		setJMenuBar(new MainMenu(jTableList));
		
		this.setContentPane(jpBody);
	}
	
	public static void createAndShowGUI() {
        JFrame frame = new MainJFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(PREFERREDSIZE);
        frame.setPreferredSize(PREFERREDSIZE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
