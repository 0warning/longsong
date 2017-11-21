package net.zaf.post.data.ship;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import net.zaf.post.data.BaseData;

/**
 * 将实体类转换为中文-舰娘属性评价
 * @author mengr
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PerformanceEvaluate<E extends Model> implements BaseData<E> {

	@Override
	public String entityToChinese(E model) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘属性评价：");
		sbf.append(BaseData.newLine);
		sbf.append("炮击：" + model.getStr("attr_pj"));
		sbf.append(BaseData.newLine);
		sbf.append("耐久：" + model.getStr("attr_nj"));
		sbf.append(BaseData.newLine);
		sbf.append("防空：" + model.getStr("attr_fk"));
		sbf.append(BaseData.newLine);
		sbf.append("机动：" + model.getStr("attr_jd"));
		sbf.append(BaseData.newLine);
		sbf.append("航空：" + model.getStr("attr_hk"));
		sbf.append(BaseData.newLine);
		sbf.append("雷击：" + model.getStr("attr_lj"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}

	@Override
	public String entityToChinese(List<E> model) {
		return null;
	}

	@Override
	public String entityToChinese(E... model) {
		return null;
	}

}
