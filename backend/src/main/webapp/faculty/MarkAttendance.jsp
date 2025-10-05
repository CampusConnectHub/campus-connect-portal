<form action="markAttendance" method="post">
  <input type="date" name="date" required />
  <c:forEach var="student" items="${studentList}">
    <div>
      <input type="hidden" name="studentId" value="${student.id}" />
      ${student.name}
      <select name="status">
        <option value="PRESENT">Present</option>
        <option value="ABSENT">Absent</option>
        <option value="LEAVE">Leave</option>
      </select>
    </div>
  </c:forEach>
  <button type="submit">Submit Attendance</button>
</form>
