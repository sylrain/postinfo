package com.postinfo.core;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public class TianYa extends Forum {

    public TianYa(String userName, String password, String url, int forumCode) {
        super(userName, password, url, forumCode);
    }
    private WebClient webClient;

    @Override
    public WebClient createWebClient() {
	    WebClient webClient = new WebClient(
			    BrowserVersion.INTERNET_EXPLORER_11);
	    webClient.getOptions().setThrowExceptionOnScriptError(false);
	    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    webClient.getOptions().setCssEnabled(false);
	    webClient.getOptions().setActiveXNative(false);


	    webClient.getOptions().setJavaScriptEnabled(true);

	    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
	    webClient.getOptions().setTimeout(60000); // 60秒过期
	    try {
		    webClient.getOptions().setUseInsecureSSL(true);

	    } catch (Exception e) {
		    e.printStackTrace();
	    }
	    return webClient;
    }

    @Override
    public boolean login() {
	    HtmlPage htmlPage = null;
	    try {
		    htmlPage = webClient.getPage(getUrl());

            HtmlForm form = htmlPage.getHtmlElementById("loginForm");
            HtmlTextInput nickName = form.getInputByName("vwriter");
            HtmlPasswordInput logPwd = form.getInputByName("vpassword");
		    nickName.setValueAttribute(getUserName());
		    logPwd.setValueAttribute(getPassword());

            HtmlButton button = htmlPage.getHtmlElementById("loginBtn");
		    htmlPage = button.click();
			String text = htmlPage.asText();
		    if(text.contains("最近登录")){
			    return true;
		    }
//		    System.out.println("登陆显示：");
//		    System.out.println(htmlPage.asText());
//		    System.out.println(this.getUserName() + "登陆了！！！！！！！");

	    } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
	    } finally {
		    if (htmlPage != null) {
			    htmlPage.cleanUp();
			    htmlPage = null;
		    }
	    }

	    return false;
    }

    @Override
    public boolean postInfo(String title, String content, Map<String, String> attrs) {
        return true;
    }

    @Override
    public boolean vaildLogining() {
        System.out.println("111111");
        return true;
    }
}
