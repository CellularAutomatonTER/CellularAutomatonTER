package com.ter.CellularAutomaton.vue;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import com.ter.CellularAutomaton.controller.CloseElementaryRulesWindowEvent;
import com.ter.CellularAutomaton.controller.QuitEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;


public class ElementaryRulesWindow extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/******ATTRIBUTES******/
	private JMenuBar m_menuBar = new JMenuBar();

	/** The menu file. */
	//Tab in MenuBar
	private JMenu m_menuFile = new JMenu("File");
	
	/** The menu bar file item 1. */
	// In file menu

	/** The menu bar file item 1. */
	private JMenuItem m_menuBarFileItem1 = new JMenuItem("Close");

	/** The menu bar file item 2. */
	private JMenuItem m_menuBarFileItem2 = new JMenuItem("Quit");
	
	/** Component of window */
	private final JPanel m_panelControl = new JPanel();
	private final JButton m_buttonReset = new JButton("Reset");
	private final JCheckBox m_checkBoxRememberSetting = new JCheckBox("Remember this setting");
	private final JCheckBox m_checkBoxSetActualSettingAsDefault = new JCheckBox("Set actual setting as default");
	private final JPanel m_panelRulesSetting = new JPanel();
	private final JLabel m_labelAlphabet = new JLabel("Alphabet (0 to ?):  1");
	private final JLabel m_labelRadius = new JLabel("Radius (must be equal or greater than 1):");
	private final JFormattedTextField m_formattedTextFieldRadius = new JFormattedTextField();
	private final JLabel m_labelRules = new JLabel("Rules (0 to 2^(2*Radius+1)):");
	private final JFormattedTextField m_formattedTextFieldRules = new JFormattedTextField();
	private final JButton m_buttonOk = new JButton("OK");
	private final JButton m_buttonPersonalize = new JButton("Personalize");
	private JSeparator m_separatorBetweenAlphabetAndRadius;
	private JSeparator m_separatorBetweenRadiusAndRules;
	private JSeparator m_separatorBetweenRulesAndPanelControl;
	private final JButton button = new JButton("Bookmarks");
	
	


	/**
	 * Create the application.
	 */
	public ElementaryRulesWindow() {
		
		buildComponentWindow();//Build component of window
		
		this.initMenuMnemonic();//Set mnemonic of the MenuBar
		
		this.initMenuBar();//We initialize our menuBar
		
		this.addListenerMenuBar();//We initialize Listener of menuBar
		
		this.setVisible(true);//Set the window visible
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void buildComponentWindow() {
		this.setTitle("Elementary Rules Window");//Set the title of window
		this.setSize(550,400);//Set size of window
		this.setLocationRelativeTo(null);//Center the location of window
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Set Default Close Operation to DISPOSE_ON_CLOSE
		getContentPane().add(m_panelControl, BorderLayout.SOUTH);//Set panel Control in SOUTH
		
		buildGroupLayoutPanelControl();//Set Layout for Panel Control
		m_labelAlphabet.setBounds(10, 27, 140, 19);
		
		m_labelAlphabet.setFont(new Font(m_labelAlphabet.getFont().getName(), m_labelAlphabet.getFont().getStyle(), 15));// new font size is 15
		m_labelRules.setBounds(8, 217, 200, 19);
		m_labelRules.setFont(new Font(m_labelRules.getFont().getName(), m_labelRules.getFont().getStyle(), 15));// new font size is 15
		m_labelRadius.setBounds(10, 108, 288, 19);
		m_labelRadius.setFont(new Font(m_labelRadius.getFont().getName(), m_labelRadius.getFont().getStyle(), 15));// new font size is 15
		
		getContentPane().add(m_panelRulesSetting, BorderLayout.CENTER);//Set panel RulesSetting in SOUTH
		
		m_separatorBetweenAlphabetAndRadius = new JSeparator();//Set separator between alphabet and Radius
		m_separatorBetweenAlphabetAndRadius.setBounds(0, 171, 10000, 2);
		m_separatorBetweenRadiusAndRules = new JSeparator();//Set separator between Radius and Rules
		m_separatorBetweenRadiusAndRules.setBounds(0, 69, 10000, 2);
		m_separatorBetweenRulesAndPanelControl = new JSeparator();//Set separator between Rules and panel control
		m_separatorBetweenRulesAndPanelControl.setBounds(0, 277, 10000, 2);
		
		buildGroupLayoutPanelRulesSetting();//Set Layout for Panel RulesSetting
	}
	
	
	/******GroupLayout******/
	/**
	 * GroupLayout of Panel RulesSetting.
	 */
	private void buildGroupLayoutPanelRulesSetting(){
		m_panelRulesSetting.setLayout(null);
		m_panelRulesSetting.add(m_separatorBetweenRadiusAndRules);
		m_panelRulesSetting.add(m_separatorBetweenRulesAndPanelControl);
		m_panelRulesSetting.add(m_labelAlphabet);
		m_buttonPersonalize.setBounds(160, 11, 358, 49);
		m_panelRulesSetting.add(m_buttonPersonalize);
		m_panelRulesSetting.add(m_labelRules);
		m_formattedTextFieldRules.setBounds(207, 212, 181, 32);
		m_panelRulesSetting.add(m_formattedTextFieldRules);
		m_panelRulesSetting.add(m_separatorBetweenAlphabetAndRadius);
		m_panelRulesSetting.add(m_labelRadius);
		m_formattedTextFieldRadius.setBounds(296, 103, 222, 33);
		m_panelRulesSetting.add(m_formattedTextFieldRadius);
		button.setBounds(398, 212, 120, 32);
		
		m_panelRulesSetting.add(button);
	}
	

	/**
	 * GroupLayout of Panel Control.
	 */
	private void buildGroupLayoutPanelControl(){
		
		GroupLayout gl_panelControl = new GroupLayout(m_panelControl);
		gl_panelControl.setHorizontalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_checkBoxSetActualSettingAsDefault)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_checkBoxRememberSetting)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_buttonOk, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panelControl.setVerticalGroup(
			gl_panelControl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelControl.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelControl.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_buttonReset, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(m_checkBoxSetActualSettingAsDefault)
						.addComponent(m_checkBoxRememberSetting)
						.addComponent(m_buttonOk, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		m_panelControl.setLayout(gl_panelControl);
	}
	
	
	/******Menu bar******/
	/**
	 * Inits the menu bar.
	 */
	private void initMenuBar(){
		//We initialize our menuBar 
		this.constructTabFileMenuBar();//Construction of the tab "File" of menuBar
		
		this.setJMenuBar(m_menuBar);//Add menuBar to window
		
		this.initAcceleratorMenuBar();//Adding all Accelerator of the MenuBar
	}
	
	
	/**
	 * Construct tab file menu bar.
	 */
	private void constructTabFileMenuBar(){
		//Construction of the tab "File" of menuBar
		this.m_menuFile.add(m_menuBarFileItem1);//Adding a tab "Close" in tab File in MenuBar
		this.m_menuFile.add(m_menuBarFileItem2);//Adding a tab "Quit" in tab File in MenuBar
		this.m_menuBar.add(m_menuFile);//the File tab is added to MenuBar
	}
	
	
	/******Mnemonic******/
	/**
	 * Inits the menu mnemonic.
	 */
	private void initMenuMnemonic(){
		//add all the mnémonic for the MenuBar
		m_menuFile.setMnemonic('F');
	}
	
	/******Accelerator******/
	/**
	 * *Init the accelerators**.
	 */
	private void initAcceleratorMenuBar(){
		//add all the accelerators for the items
		this.initAcceleratorFile(); //accelerator of tab File
	}
	
	private void initAcceleratorFile(){
		//add all the accelerators for the items of tab File
		m_menuBarFileItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK)); //add accelerators of Close in tab File
		m_menuBarFileItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK)); //add accelerators of Quit in tab File
	}
	
	/******Listeners MenuBar******/
	//add listeners MenuBar
	private void addListenerMenuBar (){
		this.addListenerFile(); //add listener of tab File
	}

	//add listeners for tab File in MenuBar
	private void addListenerFile (){
		m_menuBarFileItem1.addActionListener(new CloseElementaryRulesWindowEvent(this));
		m_menuBarFileItem2.addActionListener(new QuitEvent());
	}
}
