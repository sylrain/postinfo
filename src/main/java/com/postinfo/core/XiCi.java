package com.postinfo.core;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public class XiCi extends Forum {
    public XiCi(String userName, String password, String url) {
        super(userName, password, url);
    }

    @Override
    public WebClient createWebClient() {
        return null;
    }

    @Override
    public boolean login() {
        System.out.print("aaa");
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
