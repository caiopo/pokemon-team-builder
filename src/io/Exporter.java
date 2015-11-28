package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import objects.Team;

public class Exporter {

	public static void export(Team team) {

		JFileChooser jfc = new JFileChooser();

		if (!(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION))
			return;

		File input = jfc.getSelectedFile();

		if (!input.exists())
			System.out.println("it exists");

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

	}

}
