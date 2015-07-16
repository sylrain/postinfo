package com.postinfo.core;

import com.gargoylesoftware.htmlunit.WebClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public abstract  class Forum {
    private String userName;
    private String password;
    private String url;
    private boolean isLogining;

    public static Map<String,Forum> forumMap;
    public Forum(String userName,String password,String url){
        super();
        this.userName = userName;
        this.password = password;
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public boolean isLogining() {
        return isLogining;
    }

    public static Map<String, Forum> getForumMap() {
        if (forumMap == null){
            init();
        }
        return forumMap;
    }

    public abstract WebClient createWebClient();

    public abstract boolean login();

    public abstract boolean postInfo(String title,String content,Map<String,String> attrs);

    public abstract boolean vaildLogining();

    public static void init(){
        if (forumMap == null){
            forumMap = new HashMap<String,Forum>();
        }
        //toDo 读取execl

        TianYa tianYa = new TianYa("","","");
        tianYa.createWebClient();
        tianYa.login();
        forumMap.put(tianYa.getUserName()+ForumType.TianYa.getForumName(),tianYa);
        XiCi xiCi = new XiCi("","","");
        forumMap.put(xiCi.getUserName()+ForumType.XiCi.getForumName(),xiCi);
    }

    //key是name+论坛标识
    public void addCache(String key,Forum forum){
        forumMap.put(key,forum);
    }
    public static void main(String[] args) {
        init();
        Map<String,Forum> map = getForumMap();
//        Forum forum = map.get(ForumType.TianYa);
//        Forum forum2 = map.get(ForumType.XiCi);
//        System.out.println(forum.vaildLogining());
//        System.out.println(forum2.vaildLogining());
    }
}
