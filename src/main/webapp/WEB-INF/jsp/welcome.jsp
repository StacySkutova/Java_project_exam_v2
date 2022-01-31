<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Home Page</div>
		<div class="panel-body">
			Welcome ${user}! <a href="/list-words">Click here</a> to manage your
			English words list.
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>