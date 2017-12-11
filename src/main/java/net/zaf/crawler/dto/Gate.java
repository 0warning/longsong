package net.zaf.crawler.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.zaf.model.DataGate;
import net.zaf.post.Data;
import net.zaf.tools.UUID;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class Gate {
    private Page page;
    private String code;

    public Gate(Page page) {
        this.page = page;
    }

    public String getCode() {
        return code;
    }

    public void save() {
        saveGate();
    }

    public boolean saveGate() {
        Selectable selectable = page.getHtml().$("table.wikitable").nodes().get(0);
        code = page.getUrl().toString().substring(page.getUrl().toString().lastIndexOf("/") + 1, page.getUrl().toString().length());
        DataGate dataGate = new DataGate();
        dataGate.setId(UUID.uuid());
        dataGate.set("name", code);
        dataGate.set("need_level", StrUtils.cleanTRN(StrUtils.delHTMLTag(selectable.xpath("//tr[3]//td").toString())));
        dataGate.set("boss_add", StrUtils.cleanTRN(StrUtils.delHTMLTag(selectable.xpath("//tr[9]//td").toString())));
        dataGate.set("clear_award", StrUtils.cleanTRN(selectable.xpath("//tr[10]//td//text()").toString().trim()));
        dataGate.set("award_list", this.saveGateAwardList());
        return dataGate.save();
    }

    public String saveGateAwardList() {
        Selectable selectable = page.getHtml().$("table.table-DropList").nodes().get(0);
        List<Selectable> nodes = selectable.xpath("//tr").nodes();
        JSONArray array = new JSONArray();
        for (int i = 0; i < nodes.size(); i++) {
            JSONObject dss = new JSONObject();
            dss.put("ship_type", StrUtils.cleanTRN(StrUtils.delHTMLTag(nodes.get(i).xpath("//th").toString())));
            dss.put("ship_list", StrUtils.cleanTRN(StrUtils.delHTMLTag(nodes.get(i).xpath("//td").toString())));
            array.add(dss);
        }
        return array.toJSONString();
    }

    public static String toStringGate(DataGate dataGate) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("关卡信息：");
        sbf.append(Data.newLine);
        sbf.append("关卡名称：" + dataGate.getStr("name"));
        sbf.append(Data.newLine);
        sbf.append("需求等级：" + dataGate.getStr("need_level"));
        sbf.append(Data.newLine);
        sbf.append("旗舰刷新：" + dataGate.getStr("boss_add"));
        sbf.append(Data.newLine);
        sbf.append("地图掉落：" + dataGate.getStr("clear_award"));
        return sbf.toString();
    }

    public static String toStringGateAwardList(DataGate dataGate) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("掉落信息：");
        JSONArray list = JSON.parseArray(dataGate.getAwardList());
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append(list.getJSONObject(i).get("ship_type"));
            sbf.append("：");
            sbf.append(list.getJSONObject(i).get("ship_list"));
        }
        return sbf.toString();
    }
}
