package net.zaf.post;

import net.zaf.tools.CQ;

import com.alibaba.fastjson.JSONObject;
import net.zaf.utils.StrUtils;

public class PostMsg {

    public static void postMsg(JSONObject map, String message, boolean needAt) {
        if (StrUtils.isBlank(message)) return;
        switch (map.getString("message_type")) {
            case "private":
                User.toUserMsg(map.getLong("user_id"), message);
                break;
            case "group":
                Group.toGroupMsg(map.getLong("group_id"), ((needAt) ? CQ.at(map.getLong("user_id")) : "") + message);
                break;
            case "discuss":
                Discuss.toDiscussMsg(map.getLong("discuss_id"), ((needAt) ? CQ.at(map.getLong("user_id")) : "") + message);
                break;
            default:
                break;
        }
    }

    public static void postMsg(JSONObject map, String message) {
        postMsg(map, message, false);
    }
}
