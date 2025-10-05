<h3>Your Assignments</h3>
<c:forEach var="a" items="${assignments}">
  <div>
    <strong>${a.title}</strong> - Due: ${a.dueDate}
    <form action="submitAssignment" method="post" enctype="multipart/form-data">
      <input type="hidden" name="assignmentId" value="${a.id}" />
      <input type="file" name="file" required />
      <button type="submit">Submit</button>
    </form>
  </div>
</c:forEach>
