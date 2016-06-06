<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="/js/dingshui.js"></script>
<link href="https://res.wx.qq.com/open/libs/weui/0.4.2/weui.min.css" rel="stylesheet" type="text/css"/>
<title>订水</title>  
</head>  
<body>  

<div class="weui_cells_title">选择水的种类和数量</div>
<div class="weui_cells">
    <div class="weui_cell weui_cell_select weui_select_before">
        <div class="weui_cell_hd">
            <select class="weui_select" name="select2">
                 <c:forEach items="${proList}" var="pro" varStatus="vs"> 
                    <option value="${pro.productId}" tip="容量：${pro.capacity}">${pro.name}</option> 
                 </c:forEach>
            </select>
        </div>
        <div class="weui_cell_bd weui_cell_primary">
            <input class="weui_input" type="tel" placeholder="请输入订水的数目">
        </div>
    </div>
</div>
<a href="confirm_order" class="weui_btn weui_btn_primary">确认</a>
<a href="dingshui" class="weui_btn weui_btn_default">取消</a>


</body>  
<script>
  wx.config({
      debug: true,
      appId: "${signature.appid}",
      timestamp: "${signature.timeStamp}",
      nonceStr: "${signature.nonceStr}",
      signature: "${signature.signature}",
      jsApiList: [
        'checkJsApi'
      ]
  });
</script>
</html>