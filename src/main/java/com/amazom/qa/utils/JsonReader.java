package com.amazom.qa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public static Object[][] getdatafromJson(String filename) throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\main\\resources\\Testdata\\"+filename+".json";

		//Read json to string
		String JsonContent=FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
		ObjectMapper mapper =new ObjectMapper();		

		if (JsonContent.trim().startsWith("[")) {
		    List<HashMap<String, String>> data = mapper.readValue(JsonContent,
		        new TypeReference<List<HashMap<String, String>>>() {});
		    Object[][] result = new Object[data.size()][1];
		    for (int i = 0; i < data.size(); i++) {
		        result[i][0] = data.get(i);
		    }
		    return result;
		} 
		else {
		    HashMap<String, String> data = mapper.readValue(JsonContent,
		        new TypeReference<HashMap<String, String>>() {});
		    return new Object[][] {{data}};
		}
	}
}
