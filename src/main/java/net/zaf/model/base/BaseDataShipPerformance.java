package net.zaf.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDataShipPerformance<M extends BaseDataShipPerformance<M>> extends Model<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}

	public java.lang.String getId() {
		return get("id");
	}

	public void setShipId(java.lang.String shipId) {
		set("ship_id", shipId);
	}

	public java.lang.String getShipId() {
		return get("ship_id");
	}

	public void setAttrNj(java.lang.String attrNj) {
		set("attr_nj", attrNj);
	}

	public java.lang.String getAttrNj() {
		return get("attr_nj");
	}

	public void setAttrZj(java.lang.String attrZj) {
		set("attr_zj", attrZj);
	}

	public java.lang.String getAttrZj() {
		return get("attr_zj");
	}

	public void setAttrZt(java.lang.String attrZt) {
		set("attr_zt", attrZt);
	}

	public java.lang.String getAttrZt() {
		return get("attr_zt");
	}

	public void setAttrPj(java.lang.String attrPj) {
		set("attr_pj", attrPj);
	}

	public java.lang.String getAttrPj() {
		return get("attr_pj");
	}

	public void setAttrLj(java.lang.String attrLj) {
		set("attr_lj", attrLj);
	}

	public java.lang.String getAttrLj() {
		return get("attr_lj");
	}

	public void setAttrJd(java.lang.String attrJd) {
		set("attr_jd", attrJd);
	}

	public java.lang.String getAttrJd() {
		return get("attr_jd");
	}

	public void setAttrFk(java.lang.String attrFk) {
		set("attr_fk", attrFk);
	}

	public java.lang.String getAttrFk() {
		return get("attr_fk");
	}

	public void setAttrHk(java.lang.String attrHk) {
		set("attr_hk", attrHk);
	}

	public java.lang.String getAttrHk() {
		return get("attr_hk");
	}

	public void setAttrXh(java.lang.String attrXh) {
		set("attr_xh", attrXh);
	}

	public java.lang.String getAttrXh() {
		return get("attr_xh");
	}

	public void setAttrHs(java.lang.String attrHs) {
		set("attr_hs", attrHs);
	}

	public java.lang.String getAttrHs() {
		return get("attr_hs");
	}

}
