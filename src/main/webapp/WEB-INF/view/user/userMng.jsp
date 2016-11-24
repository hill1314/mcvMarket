<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>用户列表</title>
    <%@include file="../../common/common.jsp"%><!--静态包含,含jquery引用-->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/base.css">
    <style>
    html, body{
        overflow-x:hidden;
    }
    h2{
        font-size:22px;
        padding:10px 30px;
        color:#333;
    }
    p{
        font-size:14px;
        padding:10px 30px;
        color:#333;
        text-indent:2em;
    }
    hr{
        margin-top: 18px;
        margin-bottom: 18px;
        border: 0;
        border-top: 1px solid #eee;
    }
    </style>
</head>

<body>
    <h2>用户管理</h2>

<hr/>
<div style="width:95%;margin:0px auto;">
    <table grid-manager="userTable"></table>
</div>
<%--<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>--%>
<script src="<%=request.getContextPath()%>/js/GridManager2.js"></script>
<script type="text/javascript" >
$(function(){
	//单列表简易渲染
	var table = $('table[grid-manager]');
	table.GM({
		supportRemind: true
		,isDevelopMode: true
		,autoLoadCss:true  //自动加载CSS文件，无需在页面中引用
		,i18n:'zh-cn'
		,textConfig:{
			'page-go': {
				'zh-cn':'跳转',
				'en-us':'Go '
			}
		}
		,gridManagerName:'aaa'
		,disableCache:false
		,disableOrder:false
		,supportSorting: true
		,supportDrag:true
		,supportAjaxPage:true
		,emptyTemplate: '<div class="gm-emptyTemplate">什么也没有</div>'
		,ajax_data : {
			"data":[{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
                {
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
                {
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				},
				{
					"name": "baukh",
					"age": "28",
					"createDate": "2015-03-12",
					"info": "野生前端程序",
					"operation": "修改"
				}
			],
			"totals": 15
		}
		,isCombSorting: false
		,pageSize:30
		,query: {ex: '用户自定义的查询参数,格式:{key:value}'}
		,columnData: [
            {key: 'name',remind: 'the username',sorting: 'up',width: '200px',text: 'username'},
            {key: 'age',remind: 'the age',sorting: '',width: '200px',text: 'age'},
            {key: 'createDate',remind: 'the createDate',sorting: 'down',width: '200px',text: 'createDate'},
            {key: 'info',remind: 'the info',sorting: '',text: 'info'},
            {key: 'operation',remind: 'the operation',sorting: '',width: '100px',text: 'operation',
				template: function(operation, rowObject)
                {  //operation:当前key所对应的单条数据；rowObject：单个一行完整数据
					return '<a href=javascript:alert("这是一个按纽");>'+operation+'</a>';
				}
			}
		]
		,pagingBefore:function(query){
      		console.log('Event: 分页前', query);
		}
		,pagingAfter: function(query){
		  	console.log('Event: 分页后', query);	
		}
		,sortingBefore:function(query){
      		console.log('Event: 排序前', query);
		}
		,sortingAfter: function(query){
		  	console.log('Event: 排序后', query);
		}
		,ajax_success: function(data){
		  	console.log('Event: ajax_success', data);
		}
	},function(query){
		console.log('init方法回调query参数', query);
	});
});
</script>

</body>
</html>
