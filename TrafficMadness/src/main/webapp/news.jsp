<%@ include file="includes/header.jsp" %>
</head>
<body ng-controller="newsController">
	<%@ include file="includes/nav.jsp" %>
	<div class="container">
		<div class="row">
		    <div class="col-lg-12">
		        <h1 class="page-header">News
		            <small>Latest</small>
		       		<button type="button" ng-click="showPanel(createNewsPanel)" class="pull-right btn btn-primary btn-sm">
		       			Create News
		       		</button>
		        </h1>
		    </div>
		</div>

		<div ng-show="ifActive(showAllNewsPanel)">
			<div ng-repeat="news in allNews">
				<div class="row">
					<div class="col-md-7">
						<img class="img-responsive" src="{{ news.image }}" alt="">
					</div>
					<div class="col-md-5">
						<h3>{{ news.title }}</h3>
						<h4>{{ news.administrator.email }}</h4>
						<p> {{ news.content | limitTo:maxContentLength }}</p>
						<button class="btn btn-primary" ng-click="showNewsWithId(news.id)">More Info 
							<span class="glyphicon glyphicon-chevron-right"></span>
						</button>
					</div>
				</div>
				<hr />
			</div>
			<div class="row text-center">
			    <div class="col-lg-12">
			        <ul class="pagination">
			            <li>
			                <a href="#">&laquo;</a>
			            </li>
			            <li class="active">
			                <a href="#">1</a>
			            </li>
			            <li>
			                <a href="#">2</a>
			            </li>
			            <li>
			                <a href="#">&raquo;</a>
			            </li>
			        </ul>
			    </div>
			</div>
		</div>

		<div ng-show="ifActive(showNewsPanel)">
			<div class="row">
				<div class="col-md">
					<button class="btn btn-primary" ng-click="showPanel(showAllNewsPanel)">
						<span class="glyphicon glyphicon-chevron-left"></span> Back
					</button>
					<button class="btn btn-danger pull-right" ng-click="showPanel(editNewsPanel)">
						Edit
					</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md">
					<h3>{{ currentNews.title }}</h3>
					<h4 id="showNewsAuthor">{{ currentNews.administrator.email }}</h4>
					<img class="pull-right"
						src="{{ currentNews.image }}"
						alt=""
						style="padding: 10px;">
					<p>{{ currentNews.content }}</p>
				</div>
			</div>
		</div>

		<div ng-show="ifActive(createNewsPanel)">
			<div class="row">
				<div class="col-md-8" id="createNewsPanelAlertElement"></div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<form role="form" action="">
						<div class="form-group">
							<label for="createNewsPanelTitle">Title:</label>
					    	<input id="createNewsPanelTitle" type="text" class="form-control">
					  	</div>
					  	<div class="form-group">
					  		<label for="createNewsPanelImage">Image:</label>
					    	<input id="createNewsPanelImage" type="text" class="form-control">
					  	</div>
					  	<div class="form-group">
					  		<label for="createNewsPanelContent">Content:</label>
					  		<textarea id="createNewsPanelContent" class="form-control" rows="10"></textarea>
					  	</div>
					  	<button type="button" class="btn btn-primary" ng-click="showPanel(showAllNewsPanel); disableAlert()">
							<span class="glyphicon glyphicon-chevron-left"></span> Back
						</button>
						<button type="button" id="sendCreateNewsButton" class="btn btn-default">Create</button>
					</form>
				</div>
			</div>
		</div>

		<div ng-show="ifActive(editNewsPanel)">
			<div class="row" style="padding-bottom: 10px;">
				<div class="col-md">
				  	<button type="button" class="btn btn-primary" ng-click="showPanel(showAllNewsPanel); disableAlert()">
						<span class="glyphicon glyphicon-chevron-left"></span> Back 
					</button>	
				</div>
			</div>
			<div class="row" ng-show="alertBoxShow">
				<div class="col-md-8">
					<div class='alert alert-{{ alertBoxType }}' role='alert'>
						{{ alertBoxMessage }}
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-8">
					<form role="form" action="">
						<div class="form-group">
							<label for="editNewsPanelTitle">Title:</label>
					    	<input id="editNewsPanelTitle" ng-model="currentNews.title" type="text" class="form-control">
					  	</div>
					  	<div class="form-group">
					  		<label for="editNewsPanelImage">Image:</label>
					    	<input id="editNewsPanelImage" ng-model="currentNews.image" type="text" class="form-control">
					  	</div>
					  	<div class="form-group">
					  		<label for="editNewsPanelContent">Content:</label>
					  		<textarea id="editNewsPanelContent" ng-model="currentNews.content" class="form-control" rows="10"></textarea>
					  	</div>
						<button type="button" class="btn btn-default" ng-click="updateNews(currentNews)">Update</button>
						<button type="button" class="btn btn-danger">Delete</button>
					</form>
				</div>
			</div>
		</div>

	</div>
	<%@ include file="includes/footer.jsp" %>
	<!-- <script src="scripts/pages/news.js"></script> -->
	<script src="scripts/controllers/newsController.js"></script>
</body>
</html>