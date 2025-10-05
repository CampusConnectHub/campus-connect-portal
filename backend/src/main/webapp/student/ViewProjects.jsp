<h3>Your Projects</h3>
<c:forEach var="p" items="${projects}">
  <div>
    <strong>${p.title}</strong> - Status: ${p.status}
    <c:if test="${p.status == 'PENDING'}">
      <form action="submitProject" method="post" enctype="multipart/form-data">
        <input type="hidden" name="projectId" value="${p.projectId}" />
        <input type="file" name="file" required />
        <button type="submit">Submit</button>
      </form>
    </c:if>
    <c:if test="${p.feedback != null}">
      <p>Feedback: ${p.feedback}</p>
    </c:if>
  </div>
</c:forEach>
