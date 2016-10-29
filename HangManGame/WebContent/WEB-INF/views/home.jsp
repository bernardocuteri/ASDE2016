<%@page import="it.unical.hangman.businessLogic.HangmanGame"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/homePage.css">
<title>Insert title here</title>
</head>
<body>
<div class="externalContainer">
<h1>Hangman Game</h1>
<div class="centeredDiv">
<h2>Secret word:
<% 
HangmanGame game = (HangmanGame)session.getAttribute("hangmanGame");
String currentWord = game.getCurrentWord();
if(game.getLeftTrials()==0) {
	currentWord = game.getPlayWord();
}
for(int i=0;i<currentWord.length();i++) {
	out.print(currentWord.charAt(i)+" ");
}
%>
</h2>
<form class="reset"><button class="resetButton" type="submit">reset</button></form>
</div>
<c:if test="${(!hangmanGame.won) && (hangmanGame.leftTrials!='0')}">
<h2>You have ${hangmanGame.leftTrials} more trials</h2>
<h2>Buy a letter:</h2>
<div class="alphabetButtons">

<ul>
<%
for(char letter = 'A'; letter <= 'Z'; letter++) {
%>
    <li><form><button class="letter" type="submit" name="buy" value="<%=letter%>"><%=letter%></button></form></li>
<%
}
%>
</ul>
</div>
</c:if>

<c:if test="${hangmanGame.won}">
<h2>Well done, you won!</h2>
</c:if>
<c:if test="${hangmanGame.leftTrials=='0'}">
<h2>You lost.</h2>
</c:if>
</div>
</body>
</html>