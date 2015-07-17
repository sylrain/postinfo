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
    private boolean logining;
    private int forumCode;

    public static Map<String,Forum> forumMap;
    public Forum(String userName,String password,String url,int forumCode){
        super();
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.forumCode = forumCode;
    }


    public int getForumCode() {
        return forumCode;
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
        return logining;
    }

    public void setLogining(boolean logining) {
        this.logining = logining;
    }

    public static Map<String, Forum> getForumMap() {
        if (forumMap == null||forumMap.size() == 0){
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

        Forum tianYa = ForumFactory.createForum("a","","",1);
        forumMap.put(tianYa.getUserName()+","+ForumType.TianYa.getCode(),tianYa);
        Forum xiCi = ForumFactory.createForum("b","","",2);
        forumMap.put(xiCi.getUserName()+","+ForumType.XiCi.getCode(),xiCi);
    }

    //key是name+","+论坛标识
    public void addCache(String key,Forum forum){
        forumMap.put(key,forum);
    }
    public static void main(String[] args) {
        init();
        Map<String,Forum> map = getForumMap();
        Forum forum = map.get("a,1");
        Forum forum2 = map.get("b,2");
        System.out.println(forum.vaildLogining());
        System.out.println(forum2.vaildLogining());
    }
}
