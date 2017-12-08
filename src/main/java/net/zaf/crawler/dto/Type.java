package net.zaf.crawler.dto;

import us.codecraft.webmagic.Page;

public enum Type {
    SHIP("SHIP", "舰娘"),
    NONE("NONE", "未知"),
    GATE("GATE", "关卡");
    private String value;
    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    Type(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static Type getType(Page page) {
        try {
            String text = page.getHtml().$("div.bread").nodes().get(1).toString();
            if (text != null && text.contains("碧蓝航线舰娘图鉴")) {
                return Type.SHIP;
            }
        } catch (Exception e) {
        }
        try {
            String text = page.getHtml().$("table.wikitable").nodes().get(0).xpath("//tr[8]//th//text()").toString();
            if (text != null && text.contains("旗舰刷新")) {
                return Type.GATE;
            }
        } catch (Exception e) {
        }
        return Type.NONE;
    }
}
