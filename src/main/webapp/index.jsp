<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <jsp:foward page="/emps"></jsp:foward> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<body>
	
	<!-- <button class="btn btn-danger">按钮</button> -->
	<a href="${APP_PATH}/emps">跳转</a>
	
  <form class="form-horizontal">
    <fieldset>
      <div id="legend" class="">
        <legend class="">表单名</legend>
      </div>
    

    <div class="control-group">
          <label class="control-label">File</label>

          <!-- File Upload -->
          <div class="controls">
            <input class="input-file" id="fileInput" type="file">
          </div>
        </div>

    </fieldset>
  </form>
</body>
</html>
