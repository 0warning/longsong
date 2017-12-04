package net.zaf.controllers;

import com.alibaba.fastjson.JSONObject;
import net.zaf.crawler.PageProcessorImpl;
import net.zaf.crawler.dto.CheckType;
import net.zaf.crawler.dto.Ship;
import net.zaf.model.*;
import net.zaf.post.PostMsg;
import net.zaf.tools.GetMsgFromReader;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;

import java.util.List;

public class MainController extends BaseController {

    public void index() throws Exception {
        try {
            JSONObject jsonObject = GetMsgFromReader.toMap(GetMsgFromReader.get(getRequest().getReader()));
            String msg = jsonObject.getString("message");
            if (StrUtils.isBlank(msg)) {
                return;
            }
            if (!msg.substring(0, 1).equals("-")) {
                return;
            }
            String searchMsg = StrUtils.cleanTRN(msg.substring(1, msg.length()).trim());
            if (StrUtils.isBlank(searchMsg)) {
                return;
            }
            DataShip ds = DataShip.dao.findFirst("select * from data_ship where name like ? ", "%" + searchMsg + "%");
            if (ds == null) {
                PostMsg.postMsg(jsonObject, "数据库中未查找到该信息，尝试从wiki中获取，请稍等", true);
                PageProcessorImpl ppi = new PageProcessorImpl(searchMsg);
                Page page = ppi.getPage();
                if (page == null) {
                    PostMsg.postMsg(jsonObject, "从wiki中读取信息失败，主机无法访问到wiki", true);
                    return;
                }
                CheckType.DataType dataType = CheckType.getType(page);
                if (dataType.equals(CheckType.DataType.NONE)) {
                    PostMsg.postMsg(jsonObject, "从wiki中读取信息成功，但是并没有对应的解析方式", true);
                    return;
                }
                if (dataType.equals(CheckType.DataType.SHIP)) {
                    PostMsg.postMsg(jsonObject, "从wiki中读取信息成功，正在解析数据，请稍等，数据类型：舰娘", true);
                    Ship dtoShip = new Ship(page);
                    dtoShip.saveAll();
                }
                ds = DataShip.dao.findFirst("select * from data_ship where name = ? ", searchMsg);
            }
            DataShipPerformance dsp = DataShipPerformance.dao.findFirst("select * from data_ship_performance where ship_id = ?", ds.getId());
            DataShipPerformanceMax dspm = DataShipPerformanceMax.dao.findFirst("select * from data_ship_performance_max where ship_id = ?", ds.getId());
            List<DataShipSkill> dss = DataShipSkill.dao.find("select * from data_ship_skill where ship_id = ?", ds.getId());
            List<DataShipAdvanced> dsa = DataShipAdvanced.dao.find("select * from data_ship_advanced where ship_id = ?", ds.getId());
            PostMsg.postMsg(jsonObject, Ship.dataShipToString(ds));
            PostMsg.postMsg(jsonObject, Ship.dataShipPerformanceToString(dsp, dspm));
            PostMsg.postMsg(jsonObject, Ship.dataShipSkillToString(dss));
            PostMsg.postMsg(jsonObject, Ship.dataShipAdvancedToString(dsa));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            renderNull();
        }
    }
}