package objects;

public enum Type {
	NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, DARK, FAIRY;

	public static Type getEnum(String s) {

		for (Type type : values())
			if (type.toString().equalsIgnoreCase(s))
				return type;

		throw new IllegalArgumentException(String.format("Type %s does not exist", s));
	}

}