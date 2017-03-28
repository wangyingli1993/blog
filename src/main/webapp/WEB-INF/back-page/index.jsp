<%--
  Created by IntelliJ IDEA.
  User: Alent
  Date: 2017/3/27
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>博客管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/css/bootstrap-datetimepicker.min.css">
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
                <li class="active">
                    <a href="#"><i
                            class="glyphicon glyphicon-folder-open"></i>博客管理</a>
                </li>
                <li>
                    <a href="/<%=request.getContextPath()%>/blog/edit"><i class="glyphicon glyphicon-edit"></i>写博客
                    </a>
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
            <div class="right-inner">
                <div class="title">
                    <h2>博客管理</h2>
                </div>
                <div class="search-wrapper">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="title">标题</label>
                            <input type="text" class="form-control input-sm"
                                   id="title" placeholder="请输入要查询的标题">
                        </div>
                        <div class="form-group">
                            <label for="startDate">开始日期</label>
                            <input type="text" class="form-control input-sm"
                                   id="startDate"
                                   placeholder="请选择开始日期">
                        </div>
                        <div class="form-group">
                            <label for="endDate">结束日期</label>
                            <input type="text" class="form-control input-sm"
                                   id="endDate"
                                   placeholder="请选择结束日期">
                        </div>
                        <div class="form-group">
                            <select name="state" class="state">
                                <option value="0">提交</option>
                                <option value="1">未提交</option>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-info btn-sm"><i
                                class="glyphicon glyphicon-search"></i> 搜索
                        </button>
                    </form>
                </div>
                <div class="table-wrapper">
                    <table class="table table-hover custom-table">
                        <thead>
                        <tr>
                            <th><input type="checkbox"></th>
                            <th>标题</th>
                            <th>创建日期</th>
                            <th>发布日期</th>
                            <th>阅读</th>
                            <th>评论</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>线程技术之死锁问题</td>
                            <td>2017-6-10</td>
                            <td>2017-6-11</td>
                            <td>100</td>
                            <td>15</td>
                            <td>未发布</td>
                            <td>
                                <button type="button"
                                        class="btn btn-xs btn-danger"
                                        data-toggle="modal"
                                        data-target=".dialog-delete"
                                        onclick="deleteInfo(1, '线程技术之死锁问题')"
                                >删除
                                </button>
                                <button type="button" class="btn btn-xs btn-info">编辑
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>线程技术之死锁问题</td>
                            <td>2017-6-10</td>
                            <td>2017-6-11</td>
                            <td>100</td>
                            <td>15</td>
                            <td>未发布</td>
                            <td>
                                <button type="button"
                                        class="btn btn-xs btn-danger">删除
                                </button>
                                <button type="button" class="btn btn-xs btn-info">编辑
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="checkbox"></td>
                            <td>线程技术之死锁问题</td>
                            <td>2017-6-10</td>
                            <td>2017-6-11</td>
                            <td>100</td>
                            <td>15</td>
                            <td>未发布</td>
                            <td>
                                <button type="button"
                                        class="btn btn-xs btn-danger">删除
                                </button>
                                <button type="button" class="btn btn-xs btn-info">编辑
                                </button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="modal fade dialog-delete" tabindex="-1"
                     role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close"
                                        data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">你确定要删除下列博客吗</h4>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="delete-id">
                                <p id="delete-title"></p>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-info"
                                        data-dismiss="modal">取消
                                </button>
                                <button type="button" class="btn btn-danger"
                                        data-dismiss="modal"
                                        onclick="update()">确认
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="pagination-wrapper">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="<%=request.getContextPath()%>/res/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/res/js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="UTF-8"
></script>
<script>
    //触发模态框的同时调用此方法
    function deleteInfo(id, title) {
        //向模态框中传值
        $('#delete-id').val(id);
        console.log(id);
        $('#delete-title').text(title);
    }
    //提交更改
    function update() {
        var id = $('#delete-id').val();
        $.ajax({
            type: "get",
            url: "delete.do", data: {id: id},
            success: function (result) {
                //location.reload();
            }
        });
    }
    $(function () {
        $('#startDate').datetimepicker({
            format: 'yyyy-mm-dd',
            weekStart: 1,
            autoclose: true,
            todayHighlight: true,
            language: 'zh-CN',
            todayBtn: true,
            minView: 2
        });
        $('#endDate').datetimepicker({
            format: 'yyyy-mm-dd',
            weekStart: 1,
            autoclose: true,
            todayHighlight: true,
            language: 'zh-CN',
            todayBtn: true,
            minView: 2
        });
    });
</script>
</body>
</html>


