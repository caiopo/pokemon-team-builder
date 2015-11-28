package main;

import com.pokejava.Pokemon;

import io.Exporter;
import io.Importer;
import objects.Team;

public class Main3 {

	public static void main(String[] args) {

		Team t = Importer.importar();

		for (int i = 0; i < Team.MAX_SIZE; i++) {
			System.out.println(t.get(i));
		}

		t.add(new Pokemon("rayquaza"), 2);

		Exporter.export(t);

	}

}
