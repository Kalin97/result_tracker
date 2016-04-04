<%@ include file="includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Players
            <small>Top 10</small>
        </h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
		<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>#</th>
		      <th>Name</th>
		      <th>Email</th>
		      <th>Score</th>
		    </tr>
		  </thead>
		  <tbody id="topPlayersTableBody">
		  </tbody>
		</table>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
<script src="scripts/pages/ranking.js"></script>
    