package net.zaf.post;

import java.util.HashMap;
import java.util.Map;

public class Group {
	
	public static final void toGroupMsg(Long group_id, String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("group_id", group_id);
		map.put("is_raw", false);
		map.put("message", message);
		BasePost.post("send_group_msg", map);
	}
}
