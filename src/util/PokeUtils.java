package util;

import java.util.ArrayList;
import java.util.List;

public class PokeUtils {

	public static List<Integer> indexContains(List<String> list, String element) {
		List<Integer> listInt = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).toLowerCase().contains(element.toLowerCase())) {
				listInt.add(i);
			}
		}

		return listInt;
	}

}