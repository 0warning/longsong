package net.zaf.crawler.dto;

import net.zaf.model.DataGate;
import net.zaf.post.Data;
import net.zaf.tools.UUID;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

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
        Selectable selectables = page.getHtml().$("table.wikitable");
        Selectable selectable = selectables.nodes().get(0);
        code = page.getUrl().toString().substring(page.getUrl().toString().lastIndexOf("/") + 1, page.getUrl().toString().length());
        DataGate dataGate = new DataGate();
        dataGate.setId(UUID.uuid());
        dataGate.set("name", code);
        dataGate.set("need_level", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td//text()").toString().trim()));
        dataGate.set("boss_add", StrUtils.cleanTRN(selectable.xpath("//tr[8]//td//text()").toString().trim()));
        dataGate.set("clear_award", StrUtils.cleanTRN(selectable.xpath("//tr[9]//td//text()").toString().trim()));
        dataGate.set("award_list", "");
        return dataGate.save();
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
        sbf.append(Data.newLine);
        sbf.append("掉落信息：" + dataGate.getStr("award_list"));
        return sbf.toString();
    }
}
