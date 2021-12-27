package com.solvd.university.enums;

public enum CREDIENTALS {

	MA_AFRICAN_STUDIES("Masters of Arts in	Africana Studies"),
	MS_AGRICULTURAL_SCIENCE("Masters of Science in Agricultural Sciences"),
	PHD_AMERICAN_STUDIES("Doctor of Philosophy American Studies"),
	DVM_AMINAL_SCIENCE("Doctor of Veterinary Medicine Animal Science"),
	MA_ANTHROPOLOHY("Master of Arts in Anthropology"),
	MBA_APPLIED_ECONOMICS_MANAGMENT("Masters Business in Arts in Applied Economics and Management"),
	MS_ARCHAEOLOGY("Masters of Science in Archaeology"), MS_ARCHITECTURE("Masters of Science in Architecture"),
	MA_ASIAN_STUDIES("Master of Arts in Asian Studies"), MS_ASTRONOMY("Master of Science in Astronomy"),
	MS_BIOLOGICAL_ENGINEERING("Master of Science in Biological Engineering"),
	MS_BIOLOGICAL_SCIENCE("Master of Science in Biological Sciences"), UNKNOWN("Unknown");

	private String name;

	CREDIENTALS(String name) {
		this.setName(name);
	}

	public static CREDIENTALS valueOfName(final String name) {
		final String enumName = name.toUpperCase().replaceAll(" ", "_");
		try {
			return valueOf(enumName);
		} catch (final IllegalArgumentException e) {
			return CREDIENTALS.UNKNOWN;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
