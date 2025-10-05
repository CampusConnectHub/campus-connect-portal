<h3>Notifications</h3>
<c:forEach var="n" items="${notifications}">
  <div style="border:1px solid #ccc; padding:10px; margin:10px;">
    <strong>${n.title}</strong> (${n.urgency})<br/>
    ${n.message}<br/>
    <small>Posted on: ${n.timestamp}</small>
  </div>
</c:forEach>
