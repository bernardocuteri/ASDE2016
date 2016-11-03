<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.css">
<script
	src="resources/script/jquery-ui-1.12.1.dark/external/jquery/jquery.js"></script>
<script src="resources/script/jquery-ui-1.12.1.dark/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/home.css">
<script>
	$(function() {
		$(document).tooltip();
	});
	$(document).ready(function() {
		$("#select").selectmenu();
		$("#showHide-menu").menu();
		$(function() {
			$(document).tooltip();
		});

		$("#hide-all").click(function() {
			$("img").hide();
		});
		$("#show-all").click(function() {
			$("img").show();
		});

		$("#show-selected").click(function() {
			$("#checkboxes input[type=checkbox]").each(function() {
				if (this.checked) {
					$("#" + this.id + "Img").show();
				} else {
					$("#" + this.id + "Img").hide();
				}
			});
		});

		$("#menu button").button();
		$("#checkboxes").buttonset();

		$("#small").click(function() {
			$("#content img").addClass("imagessmall")
		});
		$("#large").click(function() {
			$("#content img").removeClass("imagessmall");
		});
		$("#small-large").click(function() {
			$("#content img").toggleClass("imagessmall");
		});
		$("#fade-in").click(function() {
			$("#content img").fadeIn("slow");
		});
		$("#fade-out").click(function() {
			$("#content img").fadeOut("slow");
		});
		$("#slide-down").click(function() {
			$("#hidden").slideDown("slow");
		});
		$("#slide-up").click(function() {
			$("#hidden").slideUp("slow");
		});
		$("#textButton").click(function() {
			$("#content p").text($("#text").val());
		});
		$("#add").click(function() {
			$("#hidden").append("<p class='par'>A new paragraph</p>");
		});
		$("#remove").click(function() {
			$("#hidden p").remove();
		});

	});
</script>
<title>Good Jeweller</title>
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>

		<div id="menu">

			<div id="showHide-menu-wrapper">
				<ul id="showHide-menu">
					<li><div>Show/hide menu</div>
						<ul>
							<li id="show-all"><div>Show all</div></li>
							<li id="hide-all"><div>Hide all</div></li>
							<li id="show-selected" title="Shows selected items"><div>Show
									selected</div></li>
						</ul></li>
				</ul>
			</div>
			<table>
				<tr>
					<td><button id="small" class="button"
							title="Makes images small">Small</button></td>
				</tr>
				<tr>
					<td><button id="large" class="button">Large</button></td>
				</tr>
				<tr>
					<td><button id="small-large" class="button">Small/Large</button></td>
				</tr>
				<tr>
					<td><button id="fade-out" class="button">Fade out</button></td>
				</tr>
				<tr>
					<td><button id="fade-in" class="button">Fade in</button></td>
				</tr>
				<tr>
					<td><button id="slide-down" class="button">Slide down</button></td>
				</tr>
				<tr>
					<td><button id="slide-up" class="button">Slide up</button></td>
				</tr>
				<tr>
					<td><input id="text" title="Set sliding paragraphs text"
						class="text"></td>
				</tr>
				<tr>
					<td><button id="textButton" class="button">Set par
							text</button></td>
				</tr>
				<tr>
					<td><button id="add" class="button">Add par</button></td>
				</tr>
				<tr>
					<td><button id="remove" class="button">Remove all par</button></td>
				</tr>
			</table>
		</div>

		<div id="content">
			<div>
				<img src="resources/images/sea.png" alt="sea" id="seaImg"
					class="images"> <img src="resources/images/mountain.png"
					alt="mountain" id="mountainImg" class="images"> <img
					src="resources/images/city.png" alt="city" id="cityImg"
					class="images">
			</div>
			<div id="hidden">
				<p class="par">Par1</p>
				<p class="par">Par2</p>
				<p class="par">Par3</p>
			</div>

			<div id="checkboxes">
				<input type="checkbox" id="sea"><label for="sea">Sea</label>
				<input type="checkbox" id="mountain"><label for="mountain">Mountain</label>
				<input type="checkbox" id="city"><label for="city">City</label>
			</div>
		</div>

		<div id="footer">Agile Software Development for the Enterprise -
			Department of Mathematics and Computer Science - University of
			Calabria - Arcavacata di Rende (CS) - Italy</div>
	</div>
</body>
</html>