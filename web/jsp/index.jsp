<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15-7-16
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>
        论坛控制页
    </title>
      <script type="text/javascript" src="../js/jquery.dataTables.init.js"></script>
      <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
  </head>
  <body>
      <div>
          <h3>选择上传文件</h3><input type="file" name="file-upload" id="file-upload"/><input id="upload" type="button" value="上传"/>
      </div>
      <div>
           <form id="forumList">
               <div>
                   <table style="font-size: 12px;">
                       <thead>
                           <tr style="font-size:1.2em;">
                               <th><input type="checkbox" id="chk"></th>
                               <th>论坛名称</th>
                               <th>用户名</th>
                               <th>操作</th>
                           </tr>
                       </thead>
                       <tbody>
                       </tbody>
                </table>
               </div>
               <div>
                   <input type="text" id="title" name="title" placeholder = "帖子名称"/>
                   <br/>
                   <input type="textArea" id="content" name="content" placeholder="帖子内容" />
                   <br/>
                   <input type="button" id="postAll" value="一键发帖"/>
               </div>
           </form>
      </div>

    <script type="text/javascript">
        $(
          function(){
            $("#forumList").dataTables({
                    sAjaxSource:"/queryList",
                    bSort:false,
                    fnServerData:function(sSource,aoData,fnCallback){
                        $("#forumList_paginate").hide();
                        $.post(sSource,function(json){
                            if(json.result == 'success'){

                            }
                        })
                    }
                }
            )
          }
        );
    </script>
  </body>
</html>
