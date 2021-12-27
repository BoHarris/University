package com.solvd.university.enums;

public enum POSITION {
	INSTRUCTOR("Instructor"), ASSISTANT_PROFESSOR("Assistant Professor"), ASSOCIATE_PROFESSOR("Associate Professor"),
	PROFESSOR("Professor"), UNKNOWN("Unknown");

	private String name;

	POSITION(String name) {
		this.setName(name);
	}

	public static POSITION valueOfName(final String name) {
		final String enumName = name.toUpperCase().replaceAll(" ", "_");
		try {
			return valueOf(enumName);
		} catch (final IllegalArgumentException e) {
			return POSITION.UNKNOWN;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
