<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	

<div class="container">
	
	<h1>Enter Todo Details</h1>
	
	<form:form method="post" modelAttribute="todo">

		<fieldset class="mb-3">				
			<form:label path="title">Title</form:label>
			<br>
			<form:input type="text" path="title" required="required"/>
		</fieldset>
		
		<fieldset class="mb-3">				
			<form:label path="notes">Notes</form:label>
			<br>
			<form:textarea style="width:189px; height:100px;" type="text" path="notes" required="required"/>
			<form:errors path="notes" cssClass="text-warning"/>
		</fieldset>

		<fieldset class="mb-3">				
			<form:label path="targetDate">Target Date</form:label>
			<br>
			<form:input type="text" path="targetDate" required="required"/>
			<form:errors path="targetDate" cssClass="text-warning"/>
		</fieldset>

		
		<form:input type="hidden" path="id"/>

		<form:input type="hidden" path="status"/>

		<input type="submit" class="btn btn-success"/>
	
	</form:form>
	
</div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>