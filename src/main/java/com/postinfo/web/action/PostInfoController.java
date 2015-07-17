package com.postinfo.web.action;

import com.postinfo.core.Forum;
import com.postinfo.core.ForumFactory;
import com.postinfo.web.form.ForumForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author sunyu
 *         Created by Administrator on 15-7-17.
 */
@Controller
public class PostInfoController extends BaseController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam MultipartFile multipartFile){
        return getSuccessResult();
    }

    @RequestMapping("/queryList")
    public Map<String,Object> queryList(){
        Map<String,Forum> forumMap = Forum.getForumMap();
        List<Forum> forums = new ArrayList<Forum>();
        Iterator it = forumMap.entrySet().iterator();
        while (it.hasNext()){
            String key = it.next().toString();
            forums.add(forumMap.get(key));
        }
        return dataTableJson(forums);
    }

    @RequestMapping("/login")
    public Map<String,Object> login(ForumForm forumForm){
        Forum forum = ForumFactory.createForum(forumForm.getUserName(),forumForm.getPassword(),forumForm.getUrl(),forumForm.getForumCode());
        if (forum==null){
            return getFailResult("此论坛账号不存在");
        }
        forum.login();
        return getSuccessResult();
    }
}
