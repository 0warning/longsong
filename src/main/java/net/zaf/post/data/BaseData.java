package net.zaf.post.data;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;

/**
 * 将实体类转换为中文
 * @author mengr
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public interface BaseData<E extends Model> {
	public static String newLine = "\r\n";
	public String entityToChinese(E model);
	public String entityToChinese(List<E> model);
	public String entityToChinese(E... model);
}
