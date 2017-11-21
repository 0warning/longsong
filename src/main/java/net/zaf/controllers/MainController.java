package net.zaf.controllers;

import net.zaf.crawler.PageProcessorImpl;
import net.zaf.dto.ship.ShipDto;
import net.zaf.post.PostMsg;
import net.zaf.tools.GetMsgFromReader;
import us.codecraft.webmagic.Page;

import com.alibaba.fastjson.JSONObject;

public class MainController extends BaseController {

	public void index() throws Exception {
		try {
			JSONObject jsonObject = GetMsgFromReader.toMap(GetMsgFromReader.get(getRequest().getReader()));
			String message = jsonObject.getString("message");
			if (message == null || !message.contains("crawler")) {
				return;
			}
			Page page = new PageProcessorImpl(message.replace("crawler", "").trim()).getPage();
			ShipDto dataShip = new ShipDto(page);
			PostMsg.postMsg(jsonObject, dataShip.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			renderNull();
		}
	}
}