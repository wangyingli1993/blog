<%--
  Created by IntelliJ IDEA.
  User: Alent
  Date: 2017/3/27
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>博客编辑</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/editor-md/css/editormd.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/style.css">
</head>
<body>
<header class="header">
    <div class="logout">
        <span class="icon glyphicon glyphicon-share"></span>
        <span class="text">退出</span>
    </div>
    <div class="welcome">
        <span class="text">欢迎登陆：小辣椒</span>
    </div>
</header>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2 col-sm-3 col-xs-4 main-menu">
            <ul class="navbar inner">
                <li>
                    <a href="index.html"><i
                            class="glyphicon glyphicon-folder-open"></i>博客管理</a>
                </li>
                <li class="active">
                    <a href="#"><i class="glyphicon glyphicon-edit"></i>写博客</a>
                </li>
                <li>
                    <a href="comment.html"><i
                            class="glyphicon glyphicon-comment"></i>评论管理</a>
                </li>
                <li>
                    <a href="#"><i
                            class="glyphicon glyphicon-cog"></i>个人信息管理</a>
                </li>
            </ul>
        </div>
        <div class="col-md-10 col-sm-9 col-xs-8 right">
            <div class="right-inner" style="padding: 0;">
                <form action="" class="form-inline">
                    <div class="title form-group input-lg">
                        <label for="title">标题</label>
                        <input type="text" id="title" class="form-control"
                               placeholder="请输入文章标题">
                    </div>
                </form>

                <div id="my-editormd">
                    <textarea class="editormd-markdown-textarea" name="my-editormd-markdown"></textarea>
                    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
                    <textarea class="editormd-html-textarea" name="content-html"></textarea>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/res/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/editor-md/editormd.min.js"></script>
<script type="text/javascript">
    var testEditor;
    $(function () {
        testEditor = editormd("my-editormd", {
            width: "100%",
            height: 540,
            markdown : "",
            syncScrolling: "single",
            path: "<%=request.getContextPath()%>/res/editor-md/lib/",
            previewTheme: "dark",
            saveHTMLToTextarea : true,
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "<%=request.getContextPath()%>/upload-img",
            toolbarIcons: function () {
                // Or return editormd.toolbarModes[name]; // full, simple, mini
                // Using "||" set icons align right.
                return ["undo", "redo", "|", "image", "code-block", "||", "watch", "fullscreen",
                    "preview"];
            }
            //上传图片后返回json
            /*
             {
             success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
             message : "提示的信息，上传成功或上传失败及错误信息等。",
             url     : "图片地址"        // 上传成功时才返回
             }
             */
        });
    });
</script>

</body>
</html>