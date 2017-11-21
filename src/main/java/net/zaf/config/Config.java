package net.zaf.config;

import net.zaf.controllers.MainController;
import net.zaf.model._MappingKit;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		// me.setRenderFactory();
		me.setDevMode(false);
		me.setJsonFactory(new MixedJsonFactory());
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", MainController.class);
	}

	@Override
	public void configEngine(Engine me) {

	}

	@Override
	public void configPlugin(Plugins me) {
		try {
			loadPropertyFile("jdbc_config.txt");
			DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password"));
			dp.setValidationQuery("select 1");
			me.add(dp);
			ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
			_MappingKit.mapping(arp);
			me.add(arp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}

	@Override
	public void configHandler(Handlers me) {

	}

	@Override
	public void afterJFinalStart() {
		Props.init();
	}
}