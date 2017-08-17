<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>写博客页面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="common/head.jsp"%>

<script type="text/javascript" charset="utf-8" src="${blog}/static/ueditor1_4_3_3/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${blog}/static/ueditor1_4_3_3/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${blog}/static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	function submitData() {
		
		$("#fm").form("submit",{
			url: "${blog}/admin/blogger/save.do",
			onSubmit: function() {
				var profile = UE.getEditor("profile").getContent();
				$("#pf").val(profile); //将UEditor编辑器中的内容放到隐藏域中提交到后台
				return $(this).form("validate");
			}, //进行验证，通过才让提交
			success: function(result) {
				var result = eval("(" + result + ")"); //将json格式的result转换成js对象
				if(result.success) {
					$.messager.alert("系统提示", "博主信息更新成功");
				} else {
					$.messager.alert("系统提示", "博主信息更新失败");
					return;
				} 
			}
		});
	}
</script>
</head>

<body style="margin: 10px; font-family: microsoft yahei">

	<div id="p" class="easyui-panel" title="修改个人信息" style="padding: 10px;">
		<form id="fm" method="post" enctype="multipart/form-data">
			<table cellspacing="20px">
				<tr>
					<td width="80px">用户名：</td>				
					<td>
						<input type="hidden" id="id" name="id" value="${blogger.id }"/>
						<input type="text" id="username" name="userName" style="width:200px" readonly="readonly" value="${blogger.userName }"/>
					</td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td>
						<input type="text" id="nickname" name="nickName" style="width:200px"
							class="easyui-validatebox" required="true"/>
					</td>
				</tr>
				<tr>
					<td>个性签名：</td>
					<td>
						<input type="text" id="sign" name="sign" style="width:400px" 
							class="easyui-validatebox" required="true""/>
					</td>
				</tr>
				<tr>
					<td>个人头像：</td>
					<td>
						<input type="file" id="imageFile" name="imageFile"/>
					</td>
				</tr>
				<tr>
					<td>个人简介：</td>
					<td>
						<script id="profile" type="text/plain" style="width:80%; height:500px;"></script>
						<input type="hidden" id="pf" name="profile"> <%-- UEditor不能作为表单的一部分提交，所以用这种隐藏域的方式 --%>
					</td>
				</tr>
				<tr>
				<td></td>
				<td><a href="javascript:submitData()" class="easyui-linkbutton"
					data-options="iconCls:'icon-submit'">提交</a></td>
			</tr>
			</table>
		</form>
	</div>

<%-- 实例化编辑器 --%>
<script type="text/javascript">
	var ue = UE.getEditor('profile',{
		serverUrl: "${request.requestURL}${blog}/static/ueditor1_4_3_3/jsp/controller.jsp",
		//这里可以选择自己需要的工具按钮名称,此处仅选择如下五个
		toolbars:[['fullScreen', 'simpleupload','Source', 'Undo', 'Redo','Bold','test']],
		//focus时自动清空初始化时的内容
		autoClearinitialContent:true,
		//关闭字数统计
		wordCount:false,
		//关闭elementPath
		elementPathEnabled:false,
		//默认的编辑区域高度
		initialFrameHeight:400,
		initialFrameWidth:1000
		//更多其他参数，请参考ueditor.config.js中的配置项
	});
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	UE.Editor.prototype.getActionUrl = function(action) {
		if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadvideo') {
			return '${blog}/admin/upload/uploadImg.do';
		} else {
			return this._bkGetActionUrl.call(this, action);
		}
	}
	ue.addListener("ready", function(){
		//通过UE自己封装的ajax请求数据
		UE.ajax.request("${blog}/admin/blogger/findBlogger.do",
				{
					method: "post",
					async: false,
					data: {},
					onsuccess: function(result) { //
						result = eval("(" + result.responseText + ")");
						$("#nickname").val(result.nickname);
						$("#sign").val(result.sign);
						UE.getEditor('profile').setContent(result.profile);
					}
				});
	});
</script>

</body>
</html>
