<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newOrder</title>
    <%@include file="../../common/common.jsp"%><!--静态包含,含jquery引用-->
</head>
<body>
   选择商品：<br>
   <form>
       <input name="prod" value="1" type=checkbox>玉米种子
       <input name="prod" value="2" type=checkbox>复合肥
       <input name="prod" value="3" type=checkbox>杀虫剂
       <input name="prod" value="4" type=checkbox>喷壶器


       <br><input value="购买" onclick=check("prod") type=button>
   </form>


</body>

    <script>
        function check(objName){
            var prods=document.getElementsByName(objName);
            var prodIds = new Array();
            var n = 0 ;
            for(var i=0;i<prods.length;i++){
                if(prods[i].checked){
                    prodIds[n] = prods[i].value;
                    n++;
                }
            }

            if(n==0){
                alert("至少要选择一个，谢谢");
            }else{
                console.log(prodIds);
                window.self.location="<%=request.getContextPath()%>/order/payInfo?prodIds="+prodIds;
            }
        }

    </script>

</html>
