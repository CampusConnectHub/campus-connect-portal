<h3>Your Attendance</h3>
<p>Attendance Percentage: ${percentage}%</p>
<table>
  <tr><th>Date</th><th>Status</th></tr>
  <c:forEach var="a" items="${records}">
    <tr>
      <td>${a.date}</td>
      <td>${a.status}</td>
    </tr>
  </c:forEach>
</table>
