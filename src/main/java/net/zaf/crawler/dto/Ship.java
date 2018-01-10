package net.zaf.crawler.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.zaf.model.DataShip;
import net.zaf.post.Data;
import net.zaf.tools.UUID;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class Ship {
    private Page page;
    private String code;

    public Ship(Page page) {
        this.page = page;
    }

    public String getCode() {
        return code;
    }

    public void save() throws Exception {
        saveShip();
    }

    public boolean saveShip() {
        Selectable selectable = page.getHtml().$("div.jntj").$("table.wikitable").nodes().get(0);
        code = page.getUrl().toString().substring(page.getUrl().toString().lastIndexOf("/") + 1, page.getUrl().toString().length());
        DataShip ds = new DataShip();
        ds.setId(UUID.uuid());
        ds.set("name", code);
        ds.set("no", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[3]//text()").toString().trim()));
        ds.set("star", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[5]//text()").toString().trim()));
        ds.set("type", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[2]//text()").toString().trim()));
        ds.set("rarity", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[4]//text()").toString().trim()));
        ds.set("group", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[2]//text()").toString().trim()));
        ds.set("building_time", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[4]//a/text()").toString().trim()));
        ds.set("catch_place", StrUtils.cleanTRN(StrUtils.delHTMLTag(selectable.xpath("//tr[5]//td[2]").toString())));
        ds.set("nutritive_value", StrUtils.cleanTRN(selectable.xpath("//tr[6]//td[2]//text()").toString().trim()));
        ds.set("sell_value", StrUtils.cleanTRN(selectable.xpath("//tr[7]//td[2]//text()").toString().trim()));
        ds.set("performance", this.getPerformanceJson());
        ds.set("performance_max", this.getPerformanceMaxJson());
        ds.set("skill", this.getSkillJson());
        ds.set("advanced", this.getAdvancedJson());
        ds.set("remake", this.getRemakeJson());
        return ds.save();
    }

    public String getPerformanceJson() {
        Selectable selectable = page.getHtml().$("div.jntj").$("table.wikitable").nodes().get(2);
        JSONObject dsp = new JSONObject();
        dsp.put("attr_nj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
        dsp.put("attr_zj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
        dsp.put("attr_zt", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
        dsp.put("attr_pj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
        dsp.put("attr_lj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
        dsp.put("attr_jd", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
        dsp.put("attr_fk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
        dsp.put("attr_hk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
        dsp.put("attr_xh", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
        dsp.put("attr_hs", getMin(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
        return dsp.toJSONString();
    }

    public String getPerformanceMaxJson() {
        Selectable selectable = page.getHtml().$("div.jntj").$("table.wikitable").nodes().get(2);
        JSONObject dspm = new JSONObject();
        dspm.put("attr_nj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
        dspm.put("attr_zj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
        dspm.put("attr_zt", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
        dspm.put("attr_pj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
        dspm.put("attr_lj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
        dspm.put("attr_jd", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
        dspm.put("attr_fk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
        dspm.put("attr_hk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
        dspm.put("attr_xh", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
        dspm.put("attr_hs", getMax(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
        return dspm.toJSONString();
    }

    public String getSkillJson() {
        Selectable selectable = page.getHtml().$("div.jntj").$("table.wikitable").nodes().get(6);
        List<Selectable> nodes = selectable.xpath("//tr[@style!=\"display:none;\"]").nodes();
        JSONArray array = new JSONArray();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) continue;
            if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()).equals("")) continue;
            if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()).contains("{{{")) continue;
            JSONObject dss = new JSONObject();
            dss.put("skill_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()));
            dss.put("skill_content", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
            array.add(dss);
        }
        return array.toJSONString();
    }

    public String getAdvancedJson() {
        Selectable selectable = page.getHtml().$("div.jntj").$("table.wikitable").nodes().get(4);
        List<Selectable> nodes = selectable.xpath("//tr").nodes();
        JSONArray array = new JSONArray();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) continue;
            if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()).equals("")) continue;
            JSONObject dsa = new JSONObject();
            dsa.put("adv_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()));
            dsa.put("adv_content", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
            array.add(dsa);
        }
        return array.toJSONString();
    }

    public String getRemakeJson() {
        List<Selectable> ns = page.getHtml().$("div.wikibox-biginside").nodes();
        if (ns.size() == 1) return null;
        Selectable selectable = ns.get(1).$("table.wikitable");
        List<Selectable> nodes = selectable.xpath("//tr").nodes();
        JSONObject remake = new JSONObject();
        JSONArray array = new JSONArray();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0 || i == 1) continue;
            if (i == nodes.size() - 1) {
                remake.put("total", StrUtils.cleanTRN(nodes.get(i).xpath("//td/text()").toString().trim()));
                break;
            }
            JSONObject jo = new JSONObject();
            jo.put("project", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()));
            jo.put("project_performance", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
            jo.put("need_page", StrUtils.cleanTRN(nodes.get(i).xpath("//td[3]/text()").toString().trim()));
            jo.put("need_resource", StrUtils.cleanTRN(nodes.get(i).xpath("//td[4]/text()").toString().trim()));
            jo.put("need_level", StrUtils.cleanTRN(nodes.get(i).xpath("//td[5]/text()").toString().trim()));
            jo.put("need_star", StrUtils.cleanTRN(nodes.get(i).xpath("//td[6]/text()").toString().trim()));
            array.add(jo);
        }
        remake.put("detail", array);
        return remake.toJSONString();
    }

    public static String toStringAll(DataShip dataShip) {
        StringBuffer sbf = new StringBuffer();
        sbf.append(toStringShip(dataShip));
        sbf.append(Data.newLine);
        sbf.append(toStringShipPerformance(dataShip));
        sbf.append(Data.newLine);
        sbf.append(toStringShipAdvanced(dataShip));
        sbf.append(Data.newLine);
        sbf.append(toStringShipSkill(dataShip));
        sbf.append(Data.newLine);
        sbf.append(toStringRemark(dataShip));
        return sbf.toString();
    }

    public static String toStringShip(DataShip dataShip) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘基础信息：");
        sbf.append(Data.newLine);
        sbf.append("编号：" + dataShip.getStr("no"));
        sbf.append(Data.newLine);
        sbf.append("名称：" + dataShip.getStr("name"));
        sbf.append(Data.newLine);
        sbf.append("初始星级：" + dataShip.getStr("star"));
        sbf.append(Data.newLine);
        sbf.append("类型：" + dataShip.getStr("type"));
        sbf.append(Data.newLine);
        sbf.append("稀有度：" + dataShip.getStr("rarity"));
        sbf.append(Data.newLine);
        sbf.append("阵营：" + dataShip.getStr("group"));
        sbf.append(Data.newLine);
        sbf.append("建造耗时：" + dataShip.getStr("building_time"));
        sbf.append(Data.newLine);
        sbf.append("获取关卡：" + dataShip.getStr("catch_place"));
        sbf.append(Data.newLine);
        sbf.append("强化价值：" + dataShip.getStr("nutritive_value"));
        sbf.append(Data.newLine);
        sbf.append("卖出价值：" + dataShip.getStr("sell_value"));
        return sbf.toString();
    }

    public static String toStringShipAdvanced(DataShip dataShip) {
        JSONArray list = JSON.parseArray(dataShip.getAdvanced());
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘进阶：");
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append(list.getJSONObject(i).get("adv_name"));
            sbf.append("：");
            sbf.append(list.getJSONObject(i).get("adv_content"));
        }
        return sbf.toString();
    }

    public static String toStringShipSkill(DataShip dataShip) {
        JSONArray list = JSON.parseArray(dataShip.getSkill());
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘技能：");
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append(list.getJSONObject(i).get("skill_name"));
            sbf.append("：");
            sbf.append(list.getJSONObject(i).get("skill_content"));
        }
        return sbf.toString();
    }

    public static String toStringShipPerformance(DataShip dataShip) {
        JSONObject dsp = JSON.parseObject(dataShip.getPerformance());
        JSONObject dspm = JSON.parseObject(dataShip.getPerformanceMax());
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘属性：");
        sbf.append(Data.newLine);
        sbf.append("耐久：" + dsp.get("attr_nj") + "->" + dspm.get("attr_nj"));
        sbf.append(Data.newLine);
        sbf.append("装甲：" + dsp.get("attr_zj") + "->" + dspm.get("attr_zj"));
        sbf.append(Data.newLine);
        sbf.append("装填：" + dsp.get("attr_zt") + "->" + dspm.get("attr_zt"));
        sbf.append(Data.newLine);
        sbf.append("炮击：" + dsp.get("attr_pj") + "->" + dspm.get("attr_pj"));
        sbf.append(Data.newLine);
        sbf.append("雷击：" + dsp.get("attr_lj") + "->" + dspm.get("attr_lj"));
        sbf.append(Data.newLine);
        sbf.append("机动：" + dsp.get("attr_jd") + "->" + dspm.get("attr_jd"));
        sbf.append(Data.newLine);
        sbf.append("防空：" + dsp.get("attr_fk") + "->" + dspm.get("attr_fk"));
        sbf.append(Data.newLine);
        sbf.append("航空：" + dsp.get("attr_hk") + "->" + dspm.get("attr_hk"));
        sbf.append(Data.newLine);
        sbf.append("消耗：" + dsp.get("attr_xh") + "->" + dspm.get("attr_xh"));
        sbf.append(Data.newLine);
        sbf.append("航速：" + dsp.get("attr_hs") + "->" + dspm.get("attr_hs"));
        return sbf.toString();
    }

    public static String toStringRemark(DataShip dataShip) {
        if (StrUtils.isBlank(dataShip.getRemake())) return null;
        JSONObject remark = JSON.parseObject(dataShip.getRemake());
        JSONArray list = remark.getJSONArray("detail");
        StringBuffer sbf = new StringBuffer();
        sbf.append("改造详情：");
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append("改造项目：" + list.getJSONObject(i).getString("project"));
            sbf.append(Data.newLine);
            sbf.append("项目属性：" + list.getJSONObject(i).getString("project_performance"));
            sbf.append(Data.newLine);
            sbf.append("需求图纸：" + list.getJSONObject(i).getString("need_page"));
            sbf.append(Data.newLine);
            sbf.append("需求物资：" + list.getJSONObject(i).getString("need_resource"));
            sbf.append(Data.newLine);
            sbf.append("需求等级：" + list.getJSONObject(i).getString("need_level"));
            sbf.append(Data.newLine);
            sbf.append("需求星级：" + list.getJSONObject(i).getString("need_star"));
            sbf.append(Data.newLine);
        }
        sbf.append(Data.newLine);
        sbf.append("合计：" + remark.getString("total"));
        return sbf.toString();
    }

    private String getMin(String str) {
        String result = "";
        if (str == null) return result;
        if (str.contains("→")) {
            result = str.substring(0, str.indexOf("→"));
        } else {
            result = str;
        }
        return StrUtils.cleanTRN(result.trim());
    }

    private String getMax(String str) {
        String result = "";
        if (str == null) return result;
        if (str.contains("→")) {
            result = str.substring(str.indexOf("→") + 1, str.length());
        } else {
            result = str;
        }
        return StrUtils.cleanTRN(result.trim());
    }
}
