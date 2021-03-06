package net.zaf.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDataShip<M extends BaseDataShip<M>> extends Model<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}

	public java.lang.String getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setNo(java.lang.String no) {
		set("no", no);
	}

	public java.lang.String getNo() {
		return get("no");
	}

	public void setStar(java.lang.String star) {
		set("star", star);
	}

	public java.lang.String getStar() {
		return get("star");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setRarity(java.lang.String rarity) {
		set("rarity", rarity);
	}

	public java.lang.String getRarity() {
		return get("rarity");
	}

	public void setGroup(java.lang.String group) {
		set("group", group);
	}

	public java.lang.String getGroup() {
		return get("group");
	}

	public void setBuildingTime(java.lang.String buildingTime) {
		set("building_time", buildingTime);
	}

	public java.lang.String getBuildingTime() {
		return get("building_time");
	}

	public void setCatchPlace(java.lang.String catchPlace) {
		set("catch_place", catchPlace);
	}

	public java.lang.String getCatchPlace() {
		return get("catch_place");
	}

	public void setNutritiveValue(java.lang.String nutritiveValue) {
		set("nutritive_value", nutritiveValue);
	}

	public java.lang.String getNutritiveValue() {
		return get("nutritive_value");
	}

	public void setSellValue(java.lang.String sellValue) {
		set("sell_value", sellValue);
	}

	public java.lang.String getSellValue() {
		return get("sell_value");
	}

	public void setAdvanced(java.lang.String advanced) {
		set("advanced", advanced);
	}

	public java.lang.String getAdvanced() {
		return get("advanced");
	}

	public void setPerformance(java.lang.String performance) {
		set("performance", performance);
	}

	public java.lang.String getPerformance() {
		return get("performance");
	}

	public void setPerformanceMax(java.lang.String performanceMax) {
		set("performance_max", performanceMax);
	}

	public java.lang.String getPerformanceMax() {
		return get("performance_max");
	}

	public void setSkill(java.lang.String skill) {
		set("skill", skill);
	}

	public java.lang.String getSkill() {
		return get("skill");
	}

	public void setRemake(java.lang.String remake) {
		set("remake", remake);
	}

	public java.lang.String getRemake() {
		return get("remake");
	}

}
