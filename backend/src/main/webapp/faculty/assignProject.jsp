<form action="assignProject" method="post">
  <input type="text" name="title" placeholder="Project Title" required />
  <textarea name="description" placeholder="Description" required></textarea>
  <select name="teamId">
    <c:forEach var="team" items="${teamList}">
      <option value="${team.teamId}">${team.teamName}</option>
    </c:forEach>
  </select>
  <input type="date" name="dueDate" required />
  <button type="submit">Assign</button>
</form>
