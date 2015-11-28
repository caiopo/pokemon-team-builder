package window;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JButton;

import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JLabel;

import util.PokedexWrapper;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuWindow window = new MainMenuWindow();
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
	public MainMenuWindow() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblPokemonTeamBuilderpokde = new JLabel("Pokemon Team Builder/Pok\u00E9dex");
		lblPokemonTeamBuilderpokde.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPokemonTeamBuilderpokde.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblPokemonTeamBuilderpokde, "10, 2, 3, 5");
		
		JButton btnCreateNewTeam = new JButton("Create New Team");
		btnCreateNewTeam.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCreateNewTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeamBuilderWindowManager(null, new PokedexWrapper());
				frame.setVisible(false);
			}
		});
		btnCreateNewTeam.setVerticalAlignment(SwingConstants.BOTTOM);
		frame.getContentPane().add(btnCreateNewTeam, "10, 12");
		
		JButton btnImportExistingTeam = new JButton("Import Existing Team");
		btnImportExistingTeam.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(btnImportExistingTeam, "12, 12");
		
		JButton btnLookPokdex = new JButton("Look Pok\u00E9dex");
		btnLookPokdex.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		frame.getContentPane().add(btnLookPokdex, "10, 14, 3, 1");
	}

}
