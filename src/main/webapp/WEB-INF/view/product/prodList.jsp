<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <%@include file="../../common/common.jsp"%><!--静态包含,含jquery引用-->
    <!--jQuery dependencies-->
    <script src="<%=request.getContextPath()%>/js/jquery-1.8.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>

    <!--PQ Grid files-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/grid/pqgrid.min.css" />
    <script src="<%=request.getContextPath()%>/js/grid/pqgrid.min.js"></script>
    <!--PQ Grid Office theme-->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/grid/pqgrid.css" />

<script>
    $(function () {
        doQuery();
    });
    
    function loadData(dataJson) {
        $.each(dataJson,function (n,prod) {
            console.log(n,prod);
            prod.operation="<a href=\"<%=request.getContextPath()%>/prod/getProd?prodId="+prod.prodId+"\">查看</a><br>"
                    +"<a href=\"<%=request.getContextPath()%>/prod/delProd?prodId="+prod.prodId+"\">删除</a>";
        });

        var obj = { width: 1000, height: 800, title: "产品列表",resizable:true,draggable:true };
        obj.colModel = [
            { title: "产品ID", width: 100, dataType: "string", dataIndx: "prodId" },
            { title: "产品名称", width: 100,dataType: "string", dataIndx: "prodName" },
            { title: "产品类型", width: 100,dataType: "string", dataIndx: "prodTypeId" },
            { title: "标准价格",width: 100,dataType: "string", dataIndx: "standPrice" },
            { title: "单位",width: 100,dataType: "string", dataIndx: "unitId" },
            { title: "库存",width: 100,dataType: "string", dataIndx: "stock" },
            { title: "备注",width: 100,dataType: "string", dataIndx: "note" },
            { title: "操作",width: 100,dataType: "string", dataIndx: "operation" }
            ];
        obj.dataModel = { data: dataJson };
        $("#grid_array").pqGrid(obj);
    }

    function doQuery() {
        $.ajax({
            url:"<%=request.getContextPath()%>/prod/prodList",
            type: "POST",
            async:true,    //或false,是否异步
            data:"",
            dataType:"json",
            success:function(data,textStatus,jqXHR){
//                console.log(data);
                loadData(data);
            },
            error:function(xhr,textStatus){
                console.log('错误')
                console.log(xhr)
                console.log(textStatus)
            },
        });
    }
        
</script>    
</head>
<body>
<div>
    <input type="button" id="doQuery" value="查询" onclick="doQuery()"/>
    <input type="button" id="addProd" value="新增"
           onclick="window.self.location='<%=request.getContextPath()%>/prod/addProd';"/>
</div>

<div id="grid_array" style="margin:100px;"></div>

</body>
</html>
