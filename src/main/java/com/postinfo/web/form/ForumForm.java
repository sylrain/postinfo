package com.postinfo.web.form;

import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-17.
 */
public class ForumForm {
    private String userName;
    private boolean logining;
    private int forumCode;
    private String title;
    private String content;
    private String forumName;
    private Map<String,String> attrs;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLogining() {
        return logining;
    }

    public void setLogining(boolean isLogining) {
        this.logining = isLogining;
    }

    public int getForumCode() {
        return forumCode;
    }

    public void setForumCode(int forumCode) {
        this.forumCode = forumCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, String> attrs) {
        this.attrs = attrs;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }
}
