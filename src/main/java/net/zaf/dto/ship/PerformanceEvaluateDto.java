package net.zaf.dto.ship;

import net.zaf.model.DataShipPerformanceEvaluate;
import net.zaf.post.data.BaseData;

public class PerformanceEvaluateDto extends DataShipPerformanceEvaluate {
	private static final long serialVersionUID = -2502187344141412929L;

	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘属性评价：");
		sbf.append(BaseData.newLine);
		sbf.append("炮击：" + this.getStr("attr_pj"));
		sbf.append(BaseData.newLine);
		sbf.append("耐久：" + this.getStr("attr_nj"));
		sbf.append(BaseData.newLine);
		sbf.append("防空：" + this.getStr("attr_fk"));
		sbf.append(BaseData.newLine);
		sbf.append("机动：" + this.getStr("attr_jd"));
		sbf.append(BaseData.newLine);
		sbf.append("航空：" + this.getStr("attr_hk"));
		sbf.append(BaseData.newLine);
		sbf.append("雷击：" + this.getStr("attr_lj"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}
}
