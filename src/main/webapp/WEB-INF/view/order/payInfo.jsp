<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>PayInfo</title>
    <%@include file="../../common/common.jsp"%><!--静态包含,含jquery引用-->
</head>
<body>
<div>
    <form>
    <table>
        <thead>
            <tr>
                <th>ID</th><th>商品名</th> <th>商品类别</th> <th>单价</th><th>数量</th><th>总价</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.prodId}</td><td>${product.prodName}</td> <td>${product.prodTypeId}</td>
                    <td><input type="text" id="${product.prodId}_standPrice" value="${product.standPrice}" disabled="true"/></td>
                    <td><input type="text" id="${product.prodId}_num" value="1" onclick="calculate(this,${product.standPrice});"/></td>
                    <td>
                        <input type="text" id="${product.prodId}_itemPrice" value="${product.standPrice}" disabled="true"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </form>
</div>
<div>
    合计总价：<input type="text" id="totalMoney" disabled="disabled" value="300">元 <br>
    自定义价：<input type="text" id="realPay" value="300">元<br>
    <input type="button" value="支付" onclick="submitOrder(4);"> <input type="button" value="欠款" onclick="submitOrder(2);">
</div>
</body>

<script>
    function calculate(obj,price) {
        var num = obj.value;
        var id = obj.id.replace("_num","_itemPrice");
        var item = $("#"+id);
        alert(typeof item);
        console.log(item);
//        alert(item[0].attributes.getNamedItem("value").value);
//        $("#"+id+"_itemPrice").val(price*num);
    }

    function submitOrder(submitType) {
        var jsonData={
            masterOrder:{
                status:submitType,
                userId:123,
                totalPrice:300,
                realyPay:300
            },
            orderItems:[
                {prodId:1,prodNum:2},
                {prodId:1,prodNum:2}
            ]
        };

        $.ajax({
            url:"<%=request.getContextPath()%>/order/payOrder",
            type:"POST",
            data:jsonData,
            dataType:"json",
            success:function(data){
                console.log(data);
                alert(data);
                if(data.resultCode=="0000"){
                    alert("提交成功！");
                }else{
                    alert("提交失败！"+data.resultMsg);
                }
            },
            error: function (xhr, status, err) {
                alert("出错了" + xhr.status + "，错误信息：" + xhr.responseText);
            }
        });
    }
</script>

</html>
