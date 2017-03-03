<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/17
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>

<html>
<head>
    <title>添加产品</title>
</head>
<body>
<div>
    <form id="userForm" action="<%=request.getContextPath()%>/prod/saveProd" method="post">
        <table>
            <tbody>
            <tr>  <td>产品名称:</td> <td><input type="text" name="prodName" /></td> </tr>
            <tr>  <td>产品类别:</td>
                <td>
                    <select name="prodTypeId">
                        <option value='1'>种子</option>
                        <option value='2'>化肥</option>
                        <option value='3'>农药</option>
                        <option value='4'>农具</option>
                        <option value='5'>其他</option>
                    </select>
                </td>
            </tr>
            <tr>  <td>进价:</td> <td><input type="text" name="inPrice" /> </td></tr>
            <tr>  <td>售价:</td> <td><input type="text" name="standPrice" /> </td></tr>
            <tr>  <td>库存: </td><td><input type="text" name="stock" /></td> </tr>
            <tr>  <td>单位: </td><td><input type="text" name="unitId" /></td> </tr>
            <tr>  <td>描述: </td><td><input type="text" name="notes" /></td> </tr>
            </tbody>
        </table>
        <input type="submit" value="保存" />
    </form>
</div>

</body>

</html>
