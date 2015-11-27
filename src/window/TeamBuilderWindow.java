package window;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import com.pokejava.Pokemon;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeamBuilderWindow {

	private JFrame frame;
	private JButton Pokemon3;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamBuilderWindow window = new TeamBuilderWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamBuilderWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setSize(new Dimension(1000, 800));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(0);
		splitPane.setResizeWeight(0.5);
		splitPane.setBorder(null);
		frame.getContentPane().add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setResizeWeight(0.333);
		splitPane_1.setDividerSize(0);
		splitPane.setLeftComponent(splitPane_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setDividerSize(0);
		splitPane_2.setResizeWeight(0.5);
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_2);
		
		Pokemon3 = new JButton("New button");
		splitPane_2.setLeftComponent(Pokemon3);
		
		JButton Pokemon5 = new JButton("New button");
		splitPane_2.setRightComponent(Pokemon5);
		
		JButton Pokemon1 = new JButton("New button");
		splitPane_1.setLeftComponent(Pokemon1);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setDividerSize(0);
		splitPane_3.setResizeWeight(0.333);
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_3);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setResizeWeight(0.5);
		splitPane_4.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_4.setDividerSize(0);
		splitPane_3.setRightComponent(splitPane_4);
		
		JButton Pokemon4 = new JButton("New button");
		splitPane_4.setLeftComponent(Pokemon4);
		
		JButton Pokemon6 = new JButton("New button");
		splitPane_4.setRightComponent(Pokemon6);
		
		JButton Pokemon2 = new JButton("New button");
		splitPane_3.setLeftComponent(Pokemon2);
	}

	public void setPokemon1(Pokemon pokemon) {
		
	}
	
	public void setPokemon2(Pokemon pokemon) {
		
	}
	
	public void setPokemon3(Pokemon pokemon) {
		
	}
	
	public void setPokemon4(Pokemon pokemon) {
		
	}
	
	public void setPokemon5(Pokemon pokemon) {
		
	}
	
	public void setPokemon6(Pokemon pokemon) {
		
	}
}
