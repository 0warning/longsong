package net.zaf.post;

import java.util.HashMap;
import java.util.Map;

public class User {
	
	public static void toUserMsg(Long user_id, String message) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", user_id);
		map.put("message", message);
		BasePost.post("send_private_msg", map);
		
	}
}
