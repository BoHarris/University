package com.solvd.university.enums;

public enum DEPARTMENT {

	ACCOUNTING("Accounting"), BUSINESS_ADMINISTRATION("Business Administration"), ECONOMICS("Economics"),
	FINANCE("Finance"), HOSPITALITY_AND_TOURISM_MANAGEMENT("Hospilatility and Tourism Managment"),
	INTERNATIONAL_BUSINESS("International Business"), MARKETING("Marketing"),
	SOCIAL_ENTREPRENEURSHIP("Social Entrepreneurship"), SPORT_MANAGEMENT("Sport Managment"),
	COMPUTER_INFORMATION_SYSTEMS("Computer Information Systems"), MATHEMATICS("Mathmatics"), ADVERTISING("Advertising"),
	ART_HISTORY("Art History"), FILM_STUDIES("Film Studies"), ILLUSTRATION("Illistration"),
	COMMUNICATION_AND_MEDIA("Communication and Media"),
	DIGITAL_MEDIA_PRODUCTION_AND_JOURNALISM("Digital Media Production and Journalism"), MEDIA_STUDIES("Media Studies"),
	CREATIVE_WRITING("Creative Writing"), ENGLISH("English"), UNKNOWN("Unknown");

	private String name;

	DEPARTMENT(String name) {
		this.setName(name);
	}

	public static DEPARTMENT valueOfName(final String name) {
		final String enumName = name.toUpperCase().replaceAll(" ", "_");
		try {
			return valueOf(enumName);
		} catch (final IllegalArgumentException e) {
			return DEPARTMENT.UNKNOWN;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
