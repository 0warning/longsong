package net.zaf.dto.ship;

import java.util.ArrayList;
import java.util.List;

import net.zaf.model.DataShip;
import net.zaf.post.data.BaseData;
import net.zaf.tools.UUID;
import net.zaf.utils.StrUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

public class ShipDto extends DataShip {
	private static final long serialVersionUID = -8792370316186480438L;
	
	private Page page;
	
	private PerformanceDto performanceDto;
	
	private PerformanceMaxDto performanceMaxDto;
	
	private PerformanceEvaluateDto performanceEvaluateDto;
	
	private List<AdvancedDto> advancedDtos;
	
	private List<SkillDto> skillDtos;
	
	public void setPerformanceDto(PerformanceDto performanceDto) {
		this.performanceDto = performanceDto;
	}

	public void setPerformanceMaxDto(PerformanceMaxDto performanceMaxDto) {
		this.performanceMaxDto = performanceMaxDto;
	}

	public void setPerformanceEvaluateDto(PerformanceEvaluateDto performanceEvaluateDto) {
		this.performanceEvaluateDto = performanceEvaluateDto;
	}

	public void setAdvancedDtos(List<AdvancedDto> advancedDtos) {
		this.advancedDtos = advancedDtos;
	}

	public void setSkillDtos(List<SkillDto> skillDtos) {
		this.skillDtos = skillDtos;
	}

	public ShipDto() {}
	
	public ShipDto(Page page) {
		this.page = page;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(0);
		setId(UUID.uuid());
		set("name", page.getUrl().toString().substring(page.getUrl().toString().lastIndexOf("/") + 1, page.getUrl().toString().length()));
		set("no", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[3]//text()").toString().trim()));
		set("star", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[5]//text()").toString().trim()));
		set("type", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[2]//text()").toString().trim()));
		set("rarity", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[4]//text()").toString().trim()));
		set("group", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[2]//text()").toString().trim()));
		set("building_time", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[4]//text()").toString().trim()));
		getAdvancedDtos();
		getPerformanceDto();
		getPerformanceEvaluateDto();
		getPerformanceMaxDto();
		getSkillDtos();
	}
	
	public String toString() {
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘基础信息：");
		sbf.append(BaseData.newLine);
		sbf.append("编号：" + this.getStr("no"));
		sbf.append(BaseData.newLine);
		sbf.append("名称：" + this.getStr("name"));
		sbf.append(BaseData.newLine);
		sbf.append("初始星级：" + this.getStr("star"));
		sbf.append(BaseData.newLine);
		sbf.append("类型：" + this.getStr("type"));
		sbf.append(BaseData.newLine);
		sbf.append("稀有度：" + this.getStr("rarity"));
		sbf.append(BaseData.newLine);
		sbf.append("阵营：" + this.getStr("group"));
		sbf.append(BaseData.newLine);
		sbf.append("建造耗时：" + this.getStr("building_time"));
		sbf.append(BaseData.newLine);
		sbf.append(BaseData.newLine);
		sbf.append(performanceDtoToString());
		sbf.append(BaseData.newLine);
		sbf.append(performanceEvaluateDto.toString());
		sbf.append(BaseData.newLine);
		sbf.append(advancedDtoToString());
		sbf.append(BaseData.newLine);
		sbf.append(skillDtosToString());
		return sbf.toString();
	}
	
	public String performanceDtoToString() {
		if (performanceDto == null || performanceMaxDto == null) {
			return "未查找到舰娘属性 (Model is empty)";
		}
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘属性：");
		sbf.append(BaseData.newLine);
		sbf.append("耐久：" + performanceDto.getStr("attr_nj") + "->" + performanceMaxDto.getStr("attr_nj"));
		sbf.append(BaseData.newLine);
		sbf.append("装甲：" + performanceDto.getStr("attr_zj") + "->" + performanceMaxDto.getStr("attr_zj"));
		sbf.append(BaseData.newLine);
		sbf.append("装填：" + performanceDto.getStr("attr_zt") + "->" + performanceMaxDto.getStr("attr_zt"));
		sbf.append(BaseData.newLine);
		sbf.append("炮击：" + performanceDto.getStr("attr_pj") + "->" + performanceMaxDto.getStr("attr_pj"));
		sbf.append(BaseData.newLine);
		sbf.append("雷击：" + performanceDto.getStr("attr_lj") + "->" + performanceMaxDto.getStr("attr_lj"));
		sbf.append(BaseData.newLine);
		sbf.append("机动：" + performanceDto.getStr("attr_jd") + "->" + performanceMaxDto.getStr("attr_jd"));
		sbf.append(BaseData.newLine);
		sbf.append("防空：" + performanceDto.getStr("attr_fk") + "->" + performanceMaxDto.getStr("attr_fk"));
		sbf.append(BaseData.newLine);
		sbf.append("航空：" + performanceDto.getStr("attr_hk") + "->" + performanceMaxDto.getStr("attr_hk"));
		sbf.append(BaseData.newLine);
		sbf.append("消耗：" + performanceDto.getStr("attr_xh") + "->" + performanceMaxDto.getStr("attr_xh"));
		sbf.append(BaseData.newLine);
		sbf.append("航速：" + performanceDto.getStr("attr_hs") + "->" + performanceMaxDto.getStr("attr_hs"));
		sbf.append(BaseData.newLine);
		return sbf.toString();
	}
	
	public String skillDtosToString() {
		if (skillDtos == null) {
			return "未查找到舰娘技能 (Model is empty)";
		}
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘技能：");
		sbf.append(BaseData.newLine);
		for (int i = 0; i < skillDtos.size(); i++) {
			sbf.append(skillDtos.get(i).toString());
		}
		return sbf.toString();
	}
	
	public String advancedDtoToString() {
		if (advancedDtos == null) {
			return "未查找到舰娘进阶 (Model is empty)";
		}
		StringBuffer sbf = new StringBuffer();
		sbf.append("舰娘进阶：");
		sbf.append(BaseData.newLine);
		for (int i = 0; i < advancedDtos.size(); i++) {
			sbf.append(advancedDtos.get(i).toString());
		}
		return sbf.toString();
	}
	
	public List<AdvancedDto> getAdvancedDtos() {
		if (advancedDtos != null) return advancedDtos;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(4);
		advancedDtos = new ArrayList<>();
		List<Selectable> nodes = selectable.xpath("//tr").nodes();
		for (int i = 0; i < nodes.size(); i++) {
			if (i == 0) continue;
			if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()).equals("")) continue;
			AdvancedDto advancedDto = new AdvancedDto();
			advancedDto.setId(UUID.uuid());
			advancedDto.setShipId(this.getId());
			advancedDto.set("adv_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/b/text()").toString().trim()));
			advancedDto.set("adv_content",  StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
			advancedDtos.add(advancedDto);
		}
		return advancedDtos;
	}

	public PerformanceDto getPerformanceDto() {
		if (performanceDto != null) return performanceDto;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(2);
		performanceDto = new PerformanceDto();
		performanceDto.setId(UUID.uuid());
		performanceDto.setShipId(this.getId());
		performanceDto.set("attr_nj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
		performanceDto.set("attr_zj", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
		performanceDto.set("attr_zt", getMin(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
		performanceDto.set("attr_pj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
		performanceDto.set("attr_lj", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
		performanceDto.set("attr_jd", getMin(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
		performanceDto.set("attr_fk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
		performanceDto.set("attr_hk", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
		performanceDto.set("attr_xh", getMin(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
		performanceDto.set("attr_hs", getMin(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
		return performanceDto;
	}
	
	public PerformanceMaxDto getPerformanceMaxDto() {
		if (performanceMaxDto != null) return performanceMaxDto;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(2);
		performanceMaxDto = new PerformanceMaxDto();
		performanceMaxDto.setId(UUID.uuid());
		performanceMaxDto.setShipId(this.getId());
		performanceMaxDto.set("attr_nj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[2]/text()").toString()));
		performanceMaxDto.set("attr_zj", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[4]/text()").toString()));
		performanceMaxDto.set("attr_zt", getMax(selectable.xpath("//tr").nodes().get(10).xpath("//td[6]/text()").toString()));
		performanceMaxDto.set("attr_pj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[2]/text()").toString()));
		performanceMaxDto.set("attr_lj", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[4]/text()").toString()));
		performanceMaxDto.set("attr_jd", getMax(selectable.xpath("//tr").nodes().get(11).xpath("//td[6]/text()").toString()));
		performanceMaxDto.set("attr_fk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[2]/text()").toString()));
		performanceMaxDto.set("attr_hk", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[4]/text()").toString()));
		performanceMaxDto.set("attr_xh", getMax(selectable.xpath("//tr").nodes().get(12).xpath("//td[6]/text()").toString()));
		performanceMaxDto.set("attr_hs", getMax(selectable.xpath("//tr").nodes().get(13).xpath("//td[2]/text()").toString()));
		return performanceMaxDto;
	}

	public List<SkillDto> getSkillDtos() {
		if (skillDtos != null) return skillDtos;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(6);
		skillDtos = new ArrayList<>();
		List<Selectable> nodes = selectable.xpath("//tr").nodes();
		for (int i = 0; i < nodes.size(); i++) {
			if (i == 0) continue;
			if (StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()).equals("")) continue;
			SkillDto skillDto = new SkillDto();
			skillDto.setId(UUID.uuid());
			skillDto.setShipId(this.getId());
			skillDto.set("skill_name", StrUtils.cleanTRN(nodes.get(i).xpath("//td[1]/text()").toString().trim()));
			skillDto.set("skill_content", StrUtils.cleanTRN(nodes.get(i).xpath("//td[2]/text()").toString().trim()));
			skillDtos.add(skillDto);
		}
		return skillDtos;
	}

	public PerformanceEvaluateDto getPerformanceEvaluateDto() {
		if (performanceEvaluateDto != null) return performanceEvaluateDto;
		Selectable selectables = page.getHtml().$("div.jntj").$("table.wikitable");
		Selectable selectable = selectables.nodes().get(3);
		performanceEvaluateDto = new PerformanceEvaluateDto();
		performanceEvaluateDto.setId(UUID.uuid());
		performanceEvaluateDto.setShipId(this.getId());
		performanceEvaluateDto.set("attr_pj", StrUtils.cleanTRN(selectable.xpath("//tr[1]//td[2]/text()").toString().trim()));
		performanceEvaluateDto.set("attr_nj", StrUtils.cleanTRN(selectable.xpath("//tr[2]//td[2]/text()").toString().trim()));
		performanceEvaluateDto.set("attr_fk", StrUtils.cleanTRN(selectable.xpath("//tr[3]//td[2]/text()").toString().trim()));
		performanceEvaluateDto.set("attr_jd", StrUtils.cleanTRN(selectable.xpath("//tr[4]//td[2]/text()").toString().trim()));
		performanceEvaluateDto.set("attr_hk", StrUtils.cleanTRN(selectable.xpath("//tr[5]//td[2]/text()").toString().trim()));
		performanceEvaluateDto.set("attr_lj", StrUtils.cleanTRN(selectable.xpath("//tr[6]//td[2]/text()").toString().trim()));
		return performanceEvaluateDto;
	}

	private String getMin(String str) {
		String result = "";
		if (str == null) return result;
		if (str.contains("→")) {
			result = str.substring(0, str.indexOf("→"));
		} else {
			result = str;
		}
		return StrUtils.cleanTRN(result.trim());
	}
	
	private String getMax(String str) {
		String result = "";
		if (str == null) return result;
		if (str.contains("→")) {
			result = str.substring(str.indexOf("→") + 1, str.length());
		} else {
			result = str;
		}
		return StrUtils.cleanTRN(result.trim());
	}
}
