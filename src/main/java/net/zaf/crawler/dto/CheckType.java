package net.zaf.crawler.dto;

import us.codecraft.webmagic.Page;

public class CheckType {
    public enum DataType {
        SHIP, NONE
    }

    public static DataType getType(Page page) {
        try {
            String text = page.getHtml().$("div.bread").nodes().get(1).toString();
            if (text != null && text.contains("碧蓝航线舰娘图鉴")) {
                return DataType.SHIP;
            }
        } catch (Exception e) {
        }
        return DataType.NONE;
    }
}
