package net.zaf.config;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class Props {

	public static Prop crawlerProp;
	
	public static Prop httpApiProp;
	
	public static void init() {
		crawlerProp = PropKit.use("crawler.txt");
		httpApiProp = PropKit.use("kuQhttpApi.txt");
	}
	
}
