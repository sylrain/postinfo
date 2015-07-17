package com.postinfo.core;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public class XiCi extends Forum {

    public XiCi(String userName, String password, String url, int forumCode) {
        super(userName, password, url, forumCode);
    }
    private WebClient webClient;

    @Override
    public WebClient createWebClient() {
        return null;
    }

    @Override
    public boolean login() {
	    HtmlPage htmlPage = null;
	    try {
		    htmlPage = webClient.getPage(getUrl());

		    HtmlElement htmlElement = htmlPage.getBody();
            HtmlTextInput loginName = (HtmlTextInput)htmlElement.getElementsByTagName("input").get(0);
            HtmlPasswordInput loginPass = (HtmlPasswordInput)htmlElement.getElementsByTagName("input").get(1);
		    loginName.setValueAttribute(getUserName());
		    loginPass.setValueAttribute(getPassword());

		    HtmlButton button = (HtmlButton)htmlElement.getElementsByTagName("button").get(0);
		    htmlPage = button.click();
		    String text = htmlPage.asText();
		    if(text.contains("我的首页")){
			    return true;
		    }
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
        System.out.print("bbb");
        return false;
    }

    @Override
    public boolean vaildLogining() {
        System.out.print("ccc");
        return false;
    }
}
