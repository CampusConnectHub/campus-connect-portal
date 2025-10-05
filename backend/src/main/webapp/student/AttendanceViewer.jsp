<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Your Attendance</h2>
<p>Attendance Percentage: ${percentage}%</p>

<table>
  <tr><th>Date</th><th>Status</th><thMarked By</th></tr>
  <c:forEach var="a" items="${records}">
    <tr>
      <td>${a.date}</td>
      <td>${a.status}</td>
      <td>${a.markedBy}</td>
    </tr>
  </c:forEach>
</table>
