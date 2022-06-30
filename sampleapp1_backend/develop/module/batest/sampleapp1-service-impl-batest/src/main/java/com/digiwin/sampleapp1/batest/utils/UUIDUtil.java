package com.digiwin.sampleapp1.batest.utils;

import java.util.UUID;

public class UUIDUtil {
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-","");
	}
	
}
