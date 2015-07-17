package com.postinfo.core;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-17.
 */
public class ForumFactory {
    public static Forum createForum(String userName,String password,String url,int forumCode){
        if (forumCode == ForumType.TianYa.getCode()){
            return new TianYa(userName,password,url,forumCode);
        }
        if (forumCode == ForumType.XiCi.getCode()){
            return new XiCi(userName,password,url,forumCode);
        }
        return null;
    }
}
