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
      <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
      <script type="text/javascript" src="../js/jquery.dataTables.init.js"></script>
      <script type="text/javascript" src="../js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="../js/handlebars1.3.0.js"></script>
  </head>
  <body>
      <div>
          <h3>选择上传文件</h3><input type="file" name="file-upload" id="file-upload"/><input id="upload" type="button" value="上传"/>
      </div>
      <hr/>
      <hr/>
      <div>
           <form id="search">
               <div>
                   <table id="forumList" style="font-size: 12px;">
                       <thead>
                           <tr style="font-size:1.2em;">
                               <th><input type="checkbox" id="chk"></th>
                               <th>论坛名称</th>
                               <th>用户名</th>
                               <th>登录状态</th>
                               <th>操作</th>
                           </tr>
                       </thead>
                       <tbody>
                       </tbody>
                </table>
               </div>
               <hr/>
               <div>
                   <input type="text" id="title" name="title" placeholder = "帖子名称"/>
                   <br/>
                   <h5>帖子内容:</h5><textarea id="content" name="content" placeholder="帖子内容"></textarea>
                   <br/>
                   <input type="button" id="postAll" value="一键发帖"/>
               </div>
           </form>
      </div>

    <script type="text/javascript">
        var selector = {
            data: [],
            add: function (id) {
                if (this.data.indexOf(id) === -1) {
                    this.data.push(id);
                }
            },
            remove: function (id) {
                var index = this.data.indexOf(id);
                if (index != -1) {
                    this.data.splice(index, 1);
                }
            }
        };
        $(function(){
            $("#forumList").dataTables({
                    sAjaxSource:"/queryList",
                    bSort:false,
                    fnServerData:function(sSource,aoData,fnCallback){
                        $("#forumList_paginate").hide();
                        $.post(sSource,function(json){
                            if(json.result == 'success'){

                            }else{

                            }
                        })
                    },
                    fnDrawCallback:function(){
                        $("#forumList_paginate").show();
                        $(":checkbox", $("#forumList tbody")).click(function () {
                            var status = $(this).prop("checked");
                            var value = $(this).val();
                            if (status) {
                                selector.add(value);
                            } else {
                                selector.remove(value);
                            }
                        });

                        //每页显示的数量pageSize
                        var pageSize = this.fnGetData().length;
                        //页面选中的checkbox的数量
                        var checkedNum = 0;
                        $.each(selector.data, function (index, item) {
                            $(":checkbox", $("#forumList tbody")).each(function () {
                                if ($(this).prop("value") === item) {
                                    $(this).prop('checked', true);
                                    checkedNum++;
                                }
                            });
                        });
                        //如果当前checkbox选中的数量和页面显示的数量相同，说明是全选，将全选的框勾上
                        if (checkedNum === pageSize) {
                            $("#chk").prop("checked", true);
                        } else {
                            $("#chk").prop("checked", false);
                        }
                    },
                    aoColumns:[
                     {
                         "bSortable": false,
                         mDataProp: function (aData, type, val) {
                             return html("#checkbox-template", {forumCode: aData.forumCode,userName:aData.userName});
                         }
                     },
                     {
                            "sName":"forumCode",
                            mDataProp:function(aData,type,val){
                                var forumCode = aData.forumCode;
                                val = "";
                                if(forumCode == 1){
                                    val="天涯";
                                }else if(forumCode == 2){
                                    val = "西祠"
                                }
                                return val;
                            }
                     },
                     {
                         "sName":"userName",
                         mDataProp:"userName",
                         bSortable:false
                     },
                    {
                        "sName":"isLogining",
                        mDataProp:function(aData,type,val){
                            val = "未登录";
                            if(aData.isLogining){
                                val =  "已登录"
                            }
                            return val;
                        }
                    },
                     {
                            mDataProp:function(aData,type,val){
                                return html("#html-template", {forumCode: aData.forumCode,userName:aData.userName,isLogining:aData.isLogining});
                            }
                     }
                    ]
                }

            );

                $("#chk").click(function () {
                    var checked = $(this).prop("checked");
                    $.each($("#deptList input[name='id']"), function () {
                        var val = $(this).val();
                        if (checked) {
                            selector.add(val);
                        } else {
                            selector.remove(val);
                        }
                        $(this).prop("checked", checked);
                    });
                });

                //搜索&刷新
                $("#search").click(function () {
                    $("#forumList").refreshData();
                });

                function html(templateId, data) {
                    var template = Handlebars.compile($(templateId).html());
                    return template(data);
                }
          }
        );
        function login(forumCode,userName){
            $.post("/login",{forumCode:forumCode,userName:userName})
                    .done(function(res){
                        if(res.result = "success"){
                            $("#forumList").refreshData();///删除成功后更新表单中的数据
                        } else {
                            alert(res.msg);
                        }
                    })
                    .fail(function() {
                        alert('网络错误');
                    });
        }
        function vaildLogin(forumCode,userName){
            $.post("/vaildLogin",{forumCode:forumCode,userName:userName})
                    .done(function(res){
                        if(res.result = "success"){
                            $("#forumList").refreshData();///删除成功后更新表单中的数据
                        } else {
                            alert(res.msg);
                        }
                    })
                    .fail(function() {
                        alert('网络错误');
                    });
        }
    </script>

      <script id="checkbox-template" type="text/x-handlebars-template">
          <input type="checkbox" name="id" value="'{{userName}}'+','+'{{forumCode}}'"/>
      </script>
      <script id="html-template" type="text/x-handlebars-template">
          <div>
                  <a href="javascript:login('{{forumCode}}','{{userName}}');" class="btn btn-default toggle-detail" hidden="{{!isLogining}}">
                      <i class="icon icon-edit"></i>登录
                  </a>
                  <a href="javascript:vaildLogin('{{forumCode}}','{{userName}}');" class="btn btn-default toggle-detail">
                      <i class="icon icon-trash-o"></i>
                      检查登录
                  </a>
          </div>
      </script>
  </body>
</html>
