package net.zaf.dto.ship;

import java.util.ArrayList;
import java.util.List;

import net.zaf.model.DataShipSkill;
import net.zaf.post.data.BaseData;

public class SkillDto extends DataShipSkill {
	private static final long serialVersionUID = -5675207505492256525L;

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append(this.getStr("skill_name"));
		sbf.append("：");
		sbf.append(this.getStr("skill_content"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}
	
	public static List<SkillDto> parse(List<DataShipSkill> dataShipSkills) {
		List<SkillDto> list = new ArrayList<SkillDto>();
		for (DataShipSkill dss : dataShipSkills) {
			list.add((SkillDto) dss);
		}
		return list;
	}
}
