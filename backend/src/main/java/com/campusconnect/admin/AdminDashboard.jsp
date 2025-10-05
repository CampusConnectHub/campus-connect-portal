<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Admin Dashboard</h2>

<!-- System Stats -->
<div>
  <p>Total Users: ${stats.totalUsers}</p>
  <p>Total Projects: ${stats.totalProjects}</p>
  <p>Total Assignments: ${stats.totalAssignments}</p>
</div>

<!-- User Approval -->
<table>
  <tr><th>ID</th><th>Name</th><th>Role</th><th>Approved</th><th>Action</th></tr>
  <c:forEach var="u" items="${users}">
    <tr>
      <td>${u.userId}</td>
      <td>${u.name}</td>
      <td>${u.role}</td>
      <td>${u.approved}</td>
      <td>
        <form method="post" action="admin">
          <input type="hidden" name="action" value="approve" />
          <input type="hidden" name="userId" value="${u.userId}" />
          <button type="submit">Approve</button>
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
