package net.zaf.post;

import java.util.HashMap;
import java.util.Map;

public class Discuss {
	
	public static void toDiscussMsg(Long discuss_id, String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("discuss_id", discuss_id);
		map.put("is_raw", false);
		map.put("message", message);
		BasePost.post("send_discuss_msg", map);
	}
}
