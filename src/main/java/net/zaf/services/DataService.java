package net.zaf.services;

import net.zaf.crawler.dto.Type;
import net.zaf.entity.Memory;
import net.zaf.model.DataGate;
import net.zaf.model.DataIndex;
import net.zaf.model.DataShip;
import net.zaf.tools.UUID;

public class DataService extends BaseService {

    private DataService() {
    }

    public static DataService getInstance() {
        String key = DataService.class.getPackage() + DataService.class.getSimpleName();
        if (Memory.has(key)) {
            return (DataService) Memory.get(key);
        }
        DataService dataService = new DataService();
        Memory.put(key, dataService);
        return dataService;
    }

    private class SqlStr {
        private static final String FIND_INDEX_BY_CODE = "select * from data_index where code = ?";
        private static final String FIND_SHIP_BY_NAME = "select * from data_ship where name = ? ";
        private static final String FIND_GATE_BY_NAME = "select * from data_gate where name = ?";
    }

    public boolean has(String code) {
        return findIndexByCode(code) != null ? true : false;
    }

    public void saveIndex(String code, Type type) {
        DataIndex dataIndex = new DataIndex();
        dataIndex.set("id", UUID.uuid());
        dataIndex.set("code", code);
        dataIndex.set("type", type.getValue());
        dataIndex.save();
    }

    public DataIndex findIndexByCode(String code) {
        return DataIndex.dao.findFirst(SqlStr.FIND_INDEX_BY_CODE, code);
    }

    public DataShip findShipByName(String name) {
        return DataShip.dao.findFirst(SqlStr.FIND_SHIP_BY_NAME, name);
    }

    public DataGate findGateByName(String name) {
        return DataGate.dao.findFirst(SqlStr.FIND_GATE_BY_NAME, name);
    }
}
