package net.zaf.post;

import java.util.HashMap;
import java.util.Map;

import net.zaf.config.Props;

import com.alibaba.fastjson.JSON;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;

public class BasePost {

	public static final void post(String url, Object obj) {
		if (StrKit.isBlank(url)) {
			return;
		}
		String path = "http://" + Props.httpApiProp.get("post.path.host") + ":" + Props.httpApiProp.get("post.path.port") + "/" + url;
		String data = JSON.toJSONString(obj);
		Map<String, String> header = new HashMap<>();
		header.put("accept", "application/json");
		header.put("accept-encoding", "gzip, deflate");
		header.put("accept-language", "en-US,en;q=0.8");
		header.put("content-type", "application/json");
		header.put("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");
		try {
			String result = HttpKit.post(path, data, header);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}