package com.qa.opencart.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomDataProvider {
	public String randomName() {
		String name=RandomStringUtils.randomAlphabetic(6,10);
		String s1=name.substring(0, 1).toUpperCase();
		String s2=name.substring(1).toLowerCase();
		return s1+s2;
	}
	public String randomPassword() {
		return RandomStringUtils.randomAlphanumeric(6, 12);
	}
	public String randomEmail() {
		return RandomStringUtils.randomAlphabetic(6, 15).toLowerCase()+"@gmail.com";
	}

}
