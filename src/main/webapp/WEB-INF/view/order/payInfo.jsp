<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/27
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PayInfo</title>
    <%@include file="../../common/common.jsp"%><!--静态包含,含jquery引用-->
</head>
<body>
<div>
    <table>
        <thead>
            <tr>
                <th>商品名</th> <th>商品类别</th> <th>单价</th><th>数量</th><th>总价</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>玉米种子</td> <td>种子</td> <td>50</td><td>2</td><td>100</td>
            </tr>
            <tr>
                <td>复合肥</td> <td>化肥</td> <td>100</td><td>2</td><td>200</td>
            </tr>
        </tbody>
    </table>
</div>
<div>
    合计总价：<input type="text" id="totalMoney" disabled="disabled" value="300">元 <br>
    自定义价：<input type="text" id="realPay" value="300">元<br>
    <input type="button" value="支付" onclick="submitOrder(4);"> <input type="button" value="欠款" onclick="submitOrder(2);">
</div>
</body>

<script>
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
