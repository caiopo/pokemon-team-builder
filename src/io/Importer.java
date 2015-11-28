package io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;

import com.pokejava.Pokemon;

import objects.Team;

public class Importer {

	public static Team importar() {

		JFileChooser jfc = new JFileChooser();

		if (!(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION))
			return null;

		File input = jfc.getSelectedFile();

		if (!input.exists())
			return null;

		List<String> lines = null;

		try {

			lines = Files.readAllLines(Paths.get(input.getAbsolutePath()), StandardCharsets.UTF_8);

		} catch (IOException e) {
			e.printStackTrace();
		}

		Team team = new Team();

		for (int i = 0; i < Team.MAX_SIZE; i++) {

			if (lines.get(i).equalsIgnoreCase("null"))
				team.add(null, i);
			else
				team.add(new Pokemon(Integer.parseInt(lines.get(i))), i);

		}

		return team;
	}

}
