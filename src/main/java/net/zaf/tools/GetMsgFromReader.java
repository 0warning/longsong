package net.zaf.tools;

import java.io.BufferedReader;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetMsgFromReader {

	public static String get(BufferedReader reader) {
		StringBuilder json;
		try {
			json = new StringBuilder(); 
			String line = null;
			while((line = reader.readLine()) != null){
				json.append(line);
			}
			reader.close();
			return json.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static JSONObject toMap(String json) {
		
		return (JSONObject) JSON.parse(json);
	}
}