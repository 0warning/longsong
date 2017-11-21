package net.zaf.post.data.ship;

import java.util.List;

import net.zaf.model.DataShip;
import net.zaf.post.data.BaseData;

/**
 * 将实体类转换为中文-舰娘
 * @author mengr
 *
 */
public class Ship implements BaseData<DataShip> {

	@Override
	public String entityToChinese(DataShip model) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘基础信息：");
		sbf.append(BaseData.newLine);
		sbf.append("编号：" + model.getStr("no"));
		sbf.append(BaseData.newLine);
		sbf.append("名称：" + model.getStr("name"));
		sbf.append(BaseData.newLine);
		sbf.append("初始星级：" + model.getStr("star"));
		sbf.append(BaseData.newLine);
		sbf.append("类型：" + model.getStr("type"));
		sbf.append(BaseData.newLine);
		sbf.append("稀有度：" + model.getStr("rarity"));
		sbf.append(BaseData.newLine);
		sbf.append("阵营：" + model.getStr("group"));
		sbf.append(BaseData.newLine);
		sbf.append("建造耗时：" + model.getStr("building_time"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}

	@Override
	public String entityToChinese(List<DataShip> model) {
		return null;
	}

	@Override
	public String entityToChinese(DataShip... model) {
		return null;
	}

}
