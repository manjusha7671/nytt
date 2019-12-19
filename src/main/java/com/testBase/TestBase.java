package com.testBase;

import org.apache.log4j.Logger;

public class TestBase {
	
	public static Logger log = Logger.getLogger(TestBase.class);
	public static void main(String[] args) {
		log.info("test log");
	}

}
