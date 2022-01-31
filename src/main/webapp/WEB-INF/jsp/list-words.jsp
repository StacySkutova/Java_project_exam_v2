<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-word">Add Word</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of English words</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="20%">English word</th>
						<th width="20%">Translation into Russian</th>
						<th width="40%">Description</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${word}" var="word">
						<tr>
							<td>${word.eng}</td>
							<td>${word.rus}</td>
							<td>${word.description}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-word?id=${word.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-word?id=${word.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>