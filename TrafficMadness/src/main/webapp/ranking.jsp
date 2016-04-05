<%@ include file="includes/header.jsp" %>
</head>
<body ng-controller="rankingController">
	<%@ include file="includes/nav.jsp" %>
	<div class="container">
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
				  <tbody>
				  	<tr ng-repeat="player in players | orderBy:'-score'">
						<th>{{ $index + 1 }}</th>
						<td>{{ player.name  }}</td>
						<td>{{ player.email }}</td>
						<td>{{ player.score }}</td>
				  	</tr>
				  </tbody>
				</table>
		    </div>
		</div>
	</div>
	<%@ include file="includes/footer.jsp" %>
	<script src="scripts/controllers/rankingController.js"></script>
</body>
</html>