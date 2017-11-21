package net.zaf.post.data.ship;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import net.zaf.model.DataShipSkill;
import net.zaf.post.data.BaseData;

/**
 * 将实体类转换为中文-舰娘技能
 * @author mengr
 *
 */
@SuppressWarnings({"rawtypes"})
public class Skill implements BaseData<DataShipSkill> {

	@Override
	public String entityToChinese(List<DataShipSkill> model) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘技能：");
		sbf.append(BaseData.newLine);
		for (int i = 0; i < model.size(); i++) {
			Model m = (Model) model.get(i);
			sbf.append(m.getStr("skill_name"));
			sbf.append("：");
			sbf.append(m.getStr("skill_content"));
			sbf.append(BaseData.newLine);
		}
		return sbf.toString();
	}

	@Override
	public String entityToChinese(DataShipSkill model) {
		return null;
	}

	@Override
	public String entityToChinese(DataShipSkill... model) {
		return null;
	}

}
