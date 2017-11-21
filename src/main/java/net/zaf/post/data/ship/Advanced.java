package net.zaf.post.data.ship;

import java.util.List;

import net.zaf.model.DataShipAdvanced;
import net.zaf.post.data.BaseData;

import com.jfinal.plugin.activerecord.Model;

/**
 * 将实体类转换为中文-舰娘进阶
 * @author mengr
 *
 */
@SuppressWarnings({"rawtypes"})
public class Advanced implements BaseData<DataShipAdvanced> {

	@Override
	public String entityToChinese(List<DataShipAdvanced> model) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘进阶：");
		sbf.append(BaseData.newLine);
		for (int i = 0; i < model.size(); i++) {
			Model m = (Model) model.get(i);
			sbf.append(m.getStr("adv_name"));
			sbf.append("：");
			sbf.append(m.getStr("adv_content"));
			sbf.append(BaseData.newLine);
		}
		return sbf.toString();
	}

	@Override
	public String entityToChinese(DataShipAdvanced model) {
		return null;
	}

	@Override
	public String entityToChinese(DataShipAdvanced... model) {
		return null;
	}

}
