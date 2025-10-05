<form action="sendNotification" method="post">
  <select name="roleTarget">
    <option value="STUDENT">Students</option>
    <option value="FACULTY">Faculty</option>
    <option value="ALL">Everyone</option>
  </select>
  <input type="text" name="title" placeholder="Title" required />
  <textarea name="message" placeholder="Message" required></textarea>
  <select name="urgency">
    <option value="NORMAL">Normal</option>
    <option value="URGENT">Urgent</option>
  </select>
  <button type="submit">Send</button>
</form>
