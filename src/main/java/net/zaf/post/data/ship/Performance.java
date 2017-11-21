package net.zaf.post.data.ship;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

import net.zaf.post.data.BaseData;

/**
 * 将实体类转换为中文-舰娘属性
 * @author mengr
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class Performance<E extends Model> implements BaseData<E> {

	@Override
	public String entityToChinese(List<E> model) {
		return null;
	}

	@Override
	public String entityToChinese(E model) {
		return null;
	}

	@Override
	public String entityToChinese(E... model) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘属性：");
		sbf.append(BaseData.newLine);
		sbf.append("耐久：" + model[0].getStr("attr_nj") + "->" + model[1].getStr("attr_nj"));
		sbf.append(BaseData.newLine);
		sbf.append("装甲：" + model[0].getStr("attr_zj") + "->" + model[1].getStr("attr_zj"));
		sbf.append(BaseData.newLine);
		sbf.append("装填：" + model[0].getStr("attr_zt") + "->" + model[1].getStr("attr_zt"));
		sbf.append(BaseData.newLine);
		sbf.append("炮击：" + model[0].getStr("attr_pj") + "->" + model[1].getStr("attr_pj"));
		sbf.append(BaseData.newLine);
		sbf.append("雷击：" + model[0].getStr("attr_lj") + "->" + model[1].getStr("attr_lj"));
		sbf.append(BaseData.newLine);
		sbf.append("机动：" + model[0].getStr("attr_jd") + "->" + model[1].getStr("attr_jd"));
		sbf.append(BaseData.newLine);
		sbf.append("防空：" + model[0].getStr("attr_fk") + "->" + model[1].getStr("attr_fk"));
		sbf.append(BaseData.newLine);
		sbf.append("航空：" + model[0].getStr("attr_hk") + "->" + model[1].getStr("attr_hk"));
		sbf.append(BaseData.newLine);
		sbf.append("消耗：" + model[0].getStr("attr_xh") + "->" + model[1].getStr("attr_xh"));
		sbf.append(BaseData.newLine);
		sbf.append("航速：" + model[0].getStr("attr_hs") + "->" + model[1].getStr("attr_hs"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}

}
