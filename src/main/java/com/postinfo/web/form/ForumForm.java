package com.postinfo.web.form;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-17.
 */
public class ForumForm {
    private String userName;
    private String password;
    private String url;
    private boolean isLogining;
    private int forumCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isLogining() {
        return isLogining;
    }

    public void setLogining(boolean isLogining) {
        this.isLogining = isLogining;
    }

    public int getForumCode() {
        return forumCode;
    }

    public void setForumCode(int forumCode) {
        this.forumCode = forumCode;
    }
}
