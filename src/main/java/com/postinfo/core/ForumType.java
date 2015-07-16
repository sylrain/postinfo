package com.postinfo.core;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-16.
 */
public enum ForumType {
    TianYa(1,"tianya"),XiCi(2,"xici");
    private int code;
    private String forumName;

    private ForumType(int code,String forumName){
        this.code = code;
        this.forumName = forumName;
    }


    public Integer getCode() {
        return code;
    }

    public String getForumName() {
        return forumName;
    }

    public static String getForumName(int code){
        for (ForumType f:ForumType.values()){
            if (code == f.getCode()){
                return f.getForumName();
            }
        }
        return null;
    }
}
