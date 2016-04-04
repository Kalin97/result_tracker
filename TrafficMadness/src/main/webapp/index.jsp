<%@ include file="includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">News
            <small>Latest</small>
        </h1>
    </div>
</div>

<div id="showAllNewsPanel">

</div>

<div id="showNewsPanel" style="display: none">
	<div class="row">
		<div class="col-md-5">
			<button class="btn btn-primary backButton" data-news-id="1">
				<span class="glyphicon glyphicon-chevron-left"></span> Back
			</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md">
			<h3 id="showNewsTitle"></h3>
			<h4 id="showNewsAuthor"></h4>
			<img class="pull-right"
				id="showNewsImage"
				src=""
				alt=""
				style="padding: 10px;">
			<p id="showNewsContent"></p>
		</div>
	</div>
	
	<hr>
</div>

<!-- 
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
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">&raquo;</a>
            </li>
        </ul>
    </div>
</div>
 -->
<%@ include file="includes/footer.jsp" %>
<script src="scripts/pages/news.js"></script>
    