package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import objects.Team;

public class Exporter {

	public static void export(Team team) {

		JFileChooser jfc = new JFileChooser();

		if (!(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION))
			return;

		File input = jfc.getSelectedFile();

		if (input.exists()) {
			int choose = JOptionPane.showConfirmDialog(null, "This file already exists, do you want to overwrite it?",
					"Warning!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);

			if (choose != JOptionPane.YES_OPTION) {
				return;
			}
		}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			if (team.get(i) == null)
				pw.println("null");
			else
				pw.println(team.get(i).getID());

		}

		pw.flush();
		pw.close();

		JOptionPane.showMessageDialog(null, "Team saved!", "Saved", JOptionPane.INFORMATION_MESSAGE);

	}

}
