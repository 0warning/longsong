package net.zaf.crawler.dto;

import net.zaf.model.*;
import net.zaf.post.Data;
import net.zaf.tools.UUID;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class Ship {
    private Page page;
    private String shipId;

    public Ship(Page page) {
        this.page = page;
    }

    public void saveAll() throws Exception {
        saveShip();
        saveShipPerformance();
        saveShipPerformanceMax();
        saveShipAdvanced();
        saveShipSkill();
    }

    public boolean saveShip() {
        Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
        Selectable selectable = selectables.nodes().get(0);
        DataShip ds = new DataShip();
        ds.setId(UUID.uuid());
        ds.set("name", page.getUrl().toString().substring(page.getUrl().toString().lastIndexOf("/") + 1, page.getUrl().toString().length()));
        ds.set("no", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[3]//text()").toString().trim()));
        ds.set("star", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[5]//text()").toString().trim()));
        ds.set("type", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[2]//text()").toString().trim()));
        ds.set("rarity", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[4]//text()").toString().trim()));
        ds.set("group", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[2]//text()").toString().trim()));
        ds.set("building_time", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[4]//text()").toString().trim()));
        this.shipId = ds.getId();
        return ds.save();
    }

    public boolean saveShipPerformance() throws Exception {
        if (StrUtils.isBlank(shipId)) {
            throw new Exception("shipId is empty, please use dtoShip first");
        }
        Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
        Selectable selectable = selectables.nodes().get(2);
        DataShipPerformance dsp = new DataShipPerformance();
        dsp.setId(UUID.uuid());
        dsp.setShipId(shipId);
        dsp.set("attr_nj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
        dsp.set("attr_zj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
        dsp.set("attr_zt", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
        dsp.set("attr_pj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
        dsp.set("attr_lj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
        dsp.set("attr_jd", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
        dsp.set("attr_fk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
        dsp.set("attr_hk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
        dsp.set("attr_xh", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
        dsp.set("attr_hs", getMin(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
        return dsp.save();
    }

    public boolean saveShipPerformanceMax() throws Exception {
        if (StrUtils.isBlank(shipId)) {
            throw new Exception("shipId is empty, please use dtoShip first");
        }
        Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
        Selectable selectable = selectables.nodes().get(2);
        DataShipPerformanceMax dspm = new DataShipPerformanceMax();
        dspm.setId(UUID.uuid());
        dspm.setShipId(shipId);
        dspm.set("attr_nj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
        dspm.set("attr_zj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
        dspm.set("attr_zt", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
        dspm.set("attr_pj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
        dspm.set("attr_lj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
        dspm.set("attr_jd", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
        dspm.set("attr_fk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
        dspm.set("attr_hk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
        dspm.set("attr_xh", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
        dspm.set("attr_hs", getMax(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
        return dspm.save();
    }

    public boolean saveShipSkill() throws Exception {
        if (StrUtils.isBlank(shipId)) {
            throw new Exception("shipId is empty, please use dtoShip first");
        }
        Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
        Selectable selectable = selectables.nodes().get(6);
        List<Selectable> nodes = selectable.xpath("//tr").nodes();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) continue;
            if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()).equals("")) continue;
            DataShipSkill dss = new DataShipSkill();
            dss.setId(UUID.uuid());
            dss.setShipId(shipId);
            dss.set("skill_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()));
            dss.set("skill_content", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
            dss.save();
        }
        return true;
    }

    public boolean saveShipAdvanced() throws Exception {
        if (StrUtils.isBlank(shipId)) {
            throw new Exception("shipId is empty, please use dtoShip first");
        }
        Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
        Selectable selectable = selectables.nodes().get(4);
        List<Selectable> nodes = selectable.xpath("//tr").nodes();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) continue;
            if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()).equals("")) continue;
            DataShipAdvanced dsa = new DataShipAdvanced();
            dsa.setId(UUID.uuid());
            dsa.setShipId(shipId);
            dsa.set("adv_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()));
            dsa.set("adv_content", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
            dsa.save();
        }
        return true;
    }

    public static String dataShipToString(DataShip dataShip) {
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
        return sbf.toString();
    }

    public static String dataShipAdvancedToString(List<DataShipAdvanced> list) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘进阶：");
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append(list.get(i).getStr("adv_name"));
            sbf.append("：");
            sbf.append(list.get(i).getStr("adv_content"));
        }
        return sbf.toString();
    }

    public static String dataShipSkillToString(List<DataShipSkill> list) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘技能：");
        for (int i = 0; i < list.size(); i++) {
            sbf.append(Data.newLine);
            sbf.append(list.get(i).getStr("skill_name"));
            sbf.append("：");
            sbf.append(list.get(i).getStr("skill_content"));
        }
        return sbf.toString();
    }
    
    public static String dataShipPerformanceToString(DataShipPerformance dataShipPerformance, DataShipPerformanceMax dataShipPerformanceMax) {
        StringBuffer sbf = new StringBuffer();
        sbf.append("舰娘属性：");
        sbf.append(Data.newLine);
        sbf.append("耐久：" + dataShipPerformance.getStr("attr_nj") + "->" + dataShipPerformanceMax.getStr("attr_nj"));
        sbf.append(Data.newLine);
        sbf.append("装甲：" + dataShipPerformance.getStr("attr_zj") + "->" + dataShipPerformanceMax.getStr("attr_zj"));
        sbf.append(Data.newLine);
        sbf.append("装填：" + dataShipPerformance.getStr("attr_zt") + "->" + dataShipPerformanceMax.getStr("attr_zt"));
        sbf.append(Data.newLine);
        sbf.append("炮击：" + dataShipPerformance.getStr("attr_pj") + "->" + dataShipPerformanceMax.getStr("attr_pj"));
        sbf.append(Data.newLine);
        sbf.append("雷击：" + dataShipPerformance.getStr("attr_lj") + "->" + dataShipPerformanceMax.getStr("attr_lj"));
        sbf.append(Data.newLine);
        sbf.append("机动：" + dataShipPerformance.getStr("attr_jd") + "->" + dataShipPerformanceMax.getStr("attr_jd"));
        sbf.append(Data.newLine);
        sbf.append("防空：" + dataShipPerformance.getStr("attr_fk") + "->" + dataShipPerformanceMax.getStr("attr_fk"));
        sbf.append(Data.newLine);
        sbf.append("航空：" + dataShipPerformance.getStr("attr_hk") + "->" + dataShipPerformanceMax.getStr("attr_hk"));
        sbf.append(Data.newLine);
        sbf.append("消耗：" + dataShipPerformance.getStr("attr_xh") + "->" + dataShipPerformanceMax.getStr("attr_xh"));
        sbf.append(Data.newLine);
        sbf.append("航速：" + dataShipPerformance.getStr("attr_hs") + "->" + dataShipPerformanceMax.getStr("attr_hs"));
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
