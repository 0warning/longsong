package net.zaf.dto.ship;

import java.util.ArrayList;
import java.util.List;

import net.zaf.model.DataShipAdvanced;
import net.zaf.post.data.BaseData;

public class AdvancedDto extends DataShipAdvanced {
	private static final long serialVersionUID = 646757345487569406L;
	
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(this.getStr("adv_name"));
		sbf.append("：");
		sbf.append(this.getStr("adv_content"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}
	
	public static List<AdvancedDto> parse(List<DataShipAdvanced> dataShipAdvanceds) {
		List<AdvancedDto> list = new ArrayList<AdvancedDto>();
		for (DataShipAdvanced dsa : dataShipAdvanceds) {
			list.add((AdvancedDto) dsa);
		}
		return list;
	}
}
