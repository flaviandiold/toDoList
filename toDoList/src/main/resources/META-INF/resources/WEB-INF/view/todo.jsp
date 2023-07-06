<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>	
<div class="container">
	<h1>Todos</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Title</th>
				<th>Target Date</th>
				<th>Status</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td><a href="notes-todo?id=${todo.id}" class="btn">${todo.title}</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn">${todo.targetDate}</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn">${todo.status}</a></td>
					<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>   </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@ include file="common/footer.jspf" %>