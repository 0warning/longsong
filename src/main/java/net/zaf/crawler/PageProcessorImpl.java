package net.zaf.crawler;

import net.zaf.config.Props;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class PageProcessorImpl implements PageProcessor {
	
	private Page page;
	
	public Page getPage() {
		return page;
	}

	@Override
	public void process(Page page) {
		this.page = page;
	}

	@Override
	public Site getSite() {
		return Site.me().setRetryTimes(1).setSleepTime(1);
	}
	
	public PageProcessorImpl(String url) {
		url = Props.crawlerProp.get("crawler.url") + url;
		Spider.create(this).addUrl(url).run();
	}
}
