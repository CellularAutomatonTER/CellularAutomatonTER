package vue;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.GlobalCardWindowSettingEvent;
import controller.LocalCardWindowSettingEvent;

import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class CellularAutomatonSettingWindow extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JPanel m_mainPanel;
	private JPanel m_panelChooseTypeFunction;
	private JPanel m_panelResetValidateSetting;
	private JPanel m_panelEnterSetting;
	private GroupLayout m_groupLayoutMainPanel;
	private JButton m_buttonReset;
	private JButton m_buttonOK;
	private GroupLayout m_groupLayoutPanelResetValidateSetting;
	private JLabel m_labelDefinitionByFunction;
	private ButtonGroup m_radioButtonGroup;
	private JRadioButton m_radioButtonLocal;
	private JRadioButton m_radioButtonGlobal;
	private GroupLayout m_groupLayoutPanelChooseTypeFunction;
	private JCheckBox m_checkBoxSetActualSetting;
	private CardLayout m_cardLayoutOnPanelEnterSetting;
	private JPanel m_localcard;
	private JPanel m_globalcard;
	private boolean m_showPanelLocalSetting;
	
	/******GETTERS******/
	public boolean getm_showPanelLocalSetting(){
		return m_showPanelLocalSetting;
	}
	
	public CardLayout getm_cardLayoutOnPanelEnterSetting(){
		return m_cardLayoutOnPanelEnterSetting;
	}
	
	public JPanel getm_panelEnterSetting(){
		return m_panelEnterSetting;
	}
	
	/******SETTERS******/
	public void setm_showPanelLocalSetting(boolean showPanelLocalSetting){
		m_showPanelLocalSetting=showPanelLocalSetting;
	}
	

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CellularAutomatonSettingWindow window = new CellularAutomatonSettingWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the application.
	*/
	public CellularAutomatonSettingWindow() {
		this.setTitle("Cellular Automaton Setting");
		this.setSize(480,310);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m_showPanelLocalSetting=true;//Set the radioButton m_radioButtonLocal to true by default
		buildMainPanel();
	}

	
	/******Build MainWindowSetting******/
	
	/**
	* Initialize the contents of the frame.
	*/
	private void buildMainPanel() {
		
		m_mainPanel = new JPanel();
		getContentPane().add(m_mainPanel, BorderLayout.CENTER);
		
		buildComponentPanelChooseTypeFunction();		
		
		buildComponentPanelResetValidateSetting();
		
		buildComponentPanelEnterSetting();
		
		buildGroupLayoutMainPanel();

		this.setVisible(true);
	}
	
	
	
	private void buildGroupLayoutMainPanel(){
		m_groupLayoutMainPanel = new GroupLayout(m_mainPanel);
		m_groupLayoutMainPanel.setHorizontalGroup(
			m_groupLayoutMainPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(m_panelChooseTypeFunction, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(m_panelEnterSetting, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(m_panelResetValidateSetting, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		m_groupLayoutMainPanel.setVerticalGroup(
			m_groupLayoutMainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutMainPanel.createSequentialGroup()
					.addComponent(m_panelChooseTypeFunction, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelEnterSetting, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(m_panelResetValidateSetting, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
		);
		m_mainPanel.setLayout(m_groupLayoutMainPanel);
	}
	
	
	
	/******Build Component of Panel ResetValidateSetting******/
	
	private void buildComponentPanelResetValidateSetting(){
		m_panelResetValidateSetting = new JPanel();
		m_buttonReset = new JButton("Reset");
		m_checkBoxSetActualSetting = new JCheckBox("Set Actual Setting By Default");
		m_buttonOK = new JButton("OK");
		
		buildGroupLayoutPanelResetValidateSetting();
	}
	
	private void buildGroupLayoutPanelResetValidateSetting(){
		m_groupLayoutPanelResetValidateSetting = new GroupLayout(m_panelResetValidateSetting);
		m_groupLayoutPanelResetValidateSetting.setHorizontalGroup(
			m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelResetValidateSetting.createSequentialGroup()
					.addContainerGap()
					.addComponent(m_buttonReset, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(m_checkBoxSetActualSetting)
					.addGap(36)
					.addComponent(m_buttonOK, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		m_groupLayoutPanelResetValidateSetting.setVerticalGroup(
			m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelResetValidateSetting.createSequentialGroup()
					.addGap(5)
					.addGroup(m_groupLayoutPanelResetValidateSetting.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_checkBoxSetActualSetting)
						.addComponent(m_buttonOK)
						.addComponent(m_buttonReset)))
		);
		m_panelResetValidateSetting.setLayout(m_groupLayoutPanelResetValidateSetting);
	}
	
	
	/******Build Component of Panel ChooseTypeFunction******/
	
	private void buildComponentPanelChooseTypeFunction(){
		m_panelChooseTypeFunction = new JPanel();
		m_labelDefinitionByFunction = new JLabel("Definition by function: ");
		
		m_radioButtonLocal = new JRadioButton("local");
		m_radioButtonGlobal = new JRadioButton("global");
		
		m_radioButtonLocal.addActionListener(new LocalCardWindowSettingEvent(this));//Add actionListener to radioButton m_radioButtonLocal
		m_radioButtonGlobal.addActionListener(new GlobalCardWindowSettingEvent(this));//Add actionListener to radioButton m_radioButtonGlobal
		
		//Creation of ButtonGroup
		m_radioButtonGroup = new ButtonGroup();//Create ButtonGroup
		m_radioButtonGroup.add(m_radioButtonLocal);//Adding the radioButton rdbtnLocal to ButtonGroup m_radioButtonGroup
		m_radioButtonGroup.add(m_radioButtonGlobal);//Adding the radioButton rdbtnGlobal to ButtonGroup m_radioButtonGroup
		m_radioButtonLocal.setSelected(m_showPanelLocalSetting);//Set the radioButton m_radioButtonLocal to value of m_showPanelLocalSetting by default
		m_radioButtonGlobal.setSelected(!m_showPanelLocalSetting);//Set the radioButton m_radioButtonLocal to !value of m_showPanelLocalSetting by default
		
		m_groupLayoutPanelChooseTypeFunction = new GroupLayout(m_panelChooseTypeFunction);
		m_groupLayoutPanelChooseTypeFunction.setHorizontalGroup(
			m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelChooseTypeFunction.createSequentialGroup()
					.addGap(83)
					.addComponent(m_labelDefinitionByFunction)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(m_radioButtonLocal)
					.addGap(12)
					.addComponent(m_radioButtonGlobal)
					.addGap(124))
		);
		m_groupLayoutPanelChooseTypeFunction.setVerticalGroup(
			m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.LEADING)
				.addGroup(m_groupLayoutPanelChooseTypeFunction.createSequentialGroup()
					.addGap(5)
					.addGroup(m_groupLayoutPanelChooseTypeFunction.createParallelGroup(Alignment.BASELINE)
						.addComponent(m_labelDefinitionByFunction)
						.addComponent(m_radioButtonGlobal)
						.addComponent(m_radioButtonLocal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
		);
		m_panelChooseTypeFunction.setLayout(m_groupLayoutPanelChooseTypeFunction);
	}
	
	/******Build Component of Panel EnterSetting******/
	
	private void buildComponentPanelEnterSetting(){
		m_panelEnterSetting = new JPanel();
		m_cardLayoutOnPanelEnterSetting=new CardLayout(0, 0);
		m_panelEnterSetting.setLayout(m_cardLayoutOnPanelEnterSetting);
		
		//Creation of two card. The first contain the localFunction interface and the second contain the globalFunction interface
	    m_localcard = new JPanel();
	    m_localcard.setBackground(Color.blue);		
	    m_globalcard = new JPanel();
	    m_globalcard.setBackground(Color.yellow);
	    
	    //Add the cards m_localcard and m_globalcard to panel m_panelEnterSetting witch has a cardLayout
	    m_panelEnterSetting.add(m_localcard);
	    m_panelEnterSetting.add(m_globalcard);
	}
	
	
}