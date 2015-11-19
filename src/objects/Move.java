package objects;

public class Move {

	private String name, description;
	private Type type;

	public Move(String name, Type type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}


}
