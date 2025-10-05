<form action="postAnnouncement" method="post" enctype="multipart/form-data">
  <select name="category" class="form-select">
    <option value="EVENT">Event</option>
    <option value="EXAM">Exam Seating Plan & Schedule</option>
    <option value="TRANSPORT">Holiday & Bus Updates</option>
  </select>

  <textarea name="text" class="form-control" placeholder="Write announcement..."></textarea>

  <label>Upload Image (optional)</label>
  <input type="file" name="image" class="form-control" accept="image/*" />

  <label>Upload PDF (optional)</label>
  <input type="file" name="pdf" class="form-control" accept="application/pdf" />

  <button type="submit" class="btn btn-primary mt-2">Post Announcement</button>
</form>
