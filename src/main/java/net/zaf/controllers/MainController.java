package net.zaf.controllers;

import com.alibaba.fastjson.JSONObject;
import net.zaf.crawler.PageProcessorImpl;
import net.zaf.crawler.dto.Gate;
import net.zaf.crawler.dto.Type;
import net.zaf.crawler.dto.Ship;
import net.zaf.model.*;
import net.zaf.post.PostMsg;
import net.zaf.services.DataService;
import net.zaf.tools.GetMsgFromReader;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;

import java.util.List;

public class MainController extends BaseController {

    public void index() throws Exception {
        try {
            JSONObject jsonObject = GetMsgFromReader.toMap(GetMsgFromReader.get(getRequest().getReader()));
            if (jsonObject == null) return;
            String msg = jsonObject.getString("message");
            if (StrUtils.isBlank(msg)) {
                return;
            }
            msg = msg.trim();
            if (!msg.substring(0, 1).equals("-")) {
                return;
            }
            String code = StrUtils.cleanTRN(msg.substring(1, msg.length()).trim());
            if (StrUtils.isBlank(code)) {
                return;
            }
            DataService dataService = DataService.getInstance();
            if (!dataService.has(code)) {
//                PostMsg.postMsg(jsonObject, "数据库中未查找到该信息，尝试从wiki中获取，请稍等", true);
                PageProcessorImpl ppi = new PageProcessorImpl(code);
                Page page = ppi.getPage();
                if (page == null) {
//                    PostMsg.postMsg(jsonObject, "从wiki中读取信息失败，主机无法访问到wiki，或wiki中无该页面", true);
                    return;
                }
                Type type = Type.getType(page);
//                switch (type) {
//                    case NONE:
//                        PostMsg.postMsg(jsonObject, "从wiki中读取信息成功，但是并没有对应的解析方式，数据类型：" + type.getDesc(), true);
//                        return;
//                    case SHIP:
//                    case GATE:
//                        PostMsg.postMsg(jsonObject, "从wiki中读取信息成功，正在解析数据，请稍等，数据类型：" + type.getDesc(), true);
//                        break;
//                }
                switch (type) {
                    case SHIP:
                        Ship dtoShip = new Ship(page);
                        dtoShip.save();
                        dataService.saveIndex(dtoShip.getCode(), type);
                        break;
                    case GATE:
                        Gate dtoGate = new Gate(page);
                        dtoGate.save();
                        dataService.saveIndex(dtoGate.getCode(), type);
                        break;
                }
            }
            DataIndex dataIndex = dataService.findIndexByCode(code);
            Type type = Type.valueOf(dataIndex.getType());
            code = dataIndex.getCode();
            switch (type) {
                case NONE:
//                    PostMsg.postMsg(jsonObject, "从数据库中读取信息成功，但是并没有对应的类型，数据类型：" + type.getDesc(), true);
                    return;
                case SHIP:
                    DataShip dataShip = dataService.findShipByName(code);
                    PostMsg.postMsg(jsonObject, Ship.toStringShip(dataShip));
                    PostMsg.postMsg(jsonObject, Ship.toStringShipPerformance(dataShip));
                    PostMsg.postMsg(jsonObject, Ship.toStringShipSkill(dataShip));
                    PostMsg.postMsg(jsonObject, Ship.toStringShipAdvanced(dataShip));
                    PostMsg.postMsg(jsonObject, Ship.toStringRemark(dataShip));
                    break;
                case GATE:
                    PostMsg.postMsg(jsonObject, Gate.toStringGate(dataService.findGateByName(code)));
                    PostMsg.postMsg(jsonObject, Gate.toStringGateAwardList(dataService.findGateByName(code)));
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            renderNull();
        }
    }
}