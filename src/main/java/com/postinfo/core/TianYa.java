package com.postinfo.core;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public class TianYa extends Forum {
    public TianYa(String userName, String password, String url) {
        super(userName, password, url);
    }

    @Override
    public WebClient createWebClient() {
        WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
//        try {
//            HtmlPage htmlPage = webClient.getPage(this.getUrl());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return webClient;
    }

    @Override
    public boolean login() {
        System.out.println("111");
        return true;
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
