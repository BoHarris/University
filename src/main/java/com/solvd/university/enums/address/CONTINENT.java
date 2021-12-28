package com.solvd.university.enums.address;

public enum CONTINENT {
	AUSTRALIA("Australia"), ASIA("Asia"), EUROPE("Europe"), AFRICA("Africa"), NORTH_AMERICA("North America"),
	SOUTH_AMERICA("South America"), ANTARCTICA("Antartica"), UNKNOWN("Unknown");

	private String name;

	CONTINENT(String name) {
		this.setName(name);

	}

	public static CONTINENT valueOfName(final String name) {
		final String enumName = name.toUpperCase().replaceAll(" ", "_");
		try {
			return valueOf(enumName);
		} catch (final IllegalArgumentException e) {
			return CONTINENT.UNKNOWN;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
