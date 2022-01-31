<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Word</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="word">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="eng">English word</form:label>
							<form:input path="eng" type="text" class="form-control"
								required="required" />
							<form:errors path="eng" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="rus">Translation into Russian</form:label>
							<form:input path="rus" type="text" class="form-control"
										required="required" />
							<form:errors path="rus" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="description">Description</form:label>
							<form:input path="description" type="text" class="form-control"
										required="required" />
							<form:errors path="description" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>