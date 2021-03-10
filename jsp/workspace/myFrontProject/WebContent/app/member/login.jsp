<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Faction by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
<head>
<title>STforU_Login</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

		<link rel="stylesheet" href="assets/css/main.css" />
<style>
	.section {width:500px; height: 500px; margin: 20px auto;}
	.section input[id*="slide"] {display:none;}
	.section .slidewrap {max-width:1200px;margin:0 auto;}
	.section .slidelist {white-space:nowrap;font-size:0;overflow:hidden;position:relative;}
	.section .slidelist > li {display:inline-block;vertical-align:middle;width:100%;transition:all .5s;}
	.section .slidelist > li > a {display:block;position:relative;}
	.section .slidelist > li > a img {width:100%;}
	.section .slidelist label {position:absolute;z-index:10;top:50%;transform:translateY(-50%);padding:50px;cursor:pointer;}
	.section .slidelist .textbox {position:absolute;z-index:1;top:50%;left:50%;transform:translate(-50%,-50%);line-height:1.6;text-align:center;}
	.section .slidelist .textbox h3 {font-size:36px;color:#fff;;transform:translateY(30px);transition:all .5s;}
	.section .slidelist .textbox p {font-size:16px;color:#fff;opacity:0;transform:translateY(30px);transition:all .5s;}
	
	/* input에 체크되면 슬라이드 효과 */
	.section input[id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
	.section input[id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
	.section input[id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}

	/* input에 체크되면 텍스트 효과 */
	.section input[id="slide01"]:checked ~ .slidewrap li:nth-child(1) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
	.section input[id="slide01"]:checked ~ .slidewrap li:nth-child(1) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}
	.section input[id="slide02"]:checked ~ .slidewrap li:nth-child(2) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
	.section input[id="slide02"]:checked ~ .slidewrap li:nth-child(2) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}
	.section input[id="slide03"]:checked ~ .slidewrap li:nth-child(3) .textbox h3 {opacity:1;transform:translateY(0);transition-delay:.2s;}
	.section input[id="slide03"]:checked ~ .slidewrap li:nth-child(3) .textbox p {opacity:1;transform:translateY(0);transition-delay:.4s;}

	/* 좌,우 슬라이드 버튼 */
	.slide-control > div {display:none;}
	.section .left {left:5px;background:url('./img/left.png') center center / 100% no-repeat; margin-right:50px; }
	.section .right {right:5px;background:url('./img/right.png') center center / 100% no-repeat;}
	.section input[id="slide01"]:checked ~ .slidewrap .slide-control > div:nth-child(1) {display:block;}
	.section input[id="slide02"]:checked ~ .slidewrap .slide-control > div:nth-child(2) {display:block;}
	.section input[id="slide03"]:checked ~ .slidewrap .slide-control > div:nth-child(3) {display:block;}

	/* 페이징 */
	.slide-pagelist {text-align:center;padding:5px;}
	.slide-pagelist > li {display:inline-block;vertical-align:middle;}
	.slide-pagelist > li > label {display:block;padding:8px 30px; border: 1px solid #888888;border-radius:30px;background:white;margin:20px 10px;cursor:pointer;}
	.section input[id="slide01"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(1) > label {background:#509ed8;}
	.section input[id="slide02"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(2) > label {background:#509ed8;}
	.section input[id="slide03"]:checked ~ .slidewrap .slide-pagelist > li:nth-child(3) > label {background:#509ed8;}
	</style>

</head>
<body class="is-preload">

	<!-- Header -->
	<header id="header">

		<!-- Logo -->
					<span class="logo">
						<a href="${pageContext.request.contextPath}/member/MemberHome.me">STforU</a>
						<span >Sharing Talent For U</span>
					</span>


		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="#" class="icon solid fa-angle-down">Dropdown</a>
					<ul>
						<li><a href="#">Option One</a></li>
						<li><a href="#">Option Two</a></li>
						<li><a href="#">Option Three</a></li>
						<li><a href="#">Submenu</a>
							<ul>
								<li><a href="#">Option One</a></li>
								<li><a href="#">Option Two</a></li>
								<li><a href="#">Option Three</a></li>
								<li><a href="#">Option Four</a></li>
							</ul></li>
					</ul></li>
				<li><a href="generic.html">Generic</a></li>
				<li><a href="elements.html">Elements</a></li>
				<li><a href="${pageContext.request.contextPath}/member/MemberLogin.me" class="button">Log In</a></li>
			</ul>
		</nav>

	</header>
	<!-- 
		가운데정렬
1. margin 사용
   margin:0 auto;
   좌우 여백(left, rigth)을 사용해서 직접 가운데 정렬

2. text-align 사용(form태그는 안됨)
   외부요소 : text-align:center
   내부요소 : inline-block
3. flexbox
   외부요소 : display:flex, justify-content:center
			 -->
	<!-- Wrapper -->
	<div class="wrapper" >
		<!-- Main -->
		<div style="margin: 20px; margin-left:100px;">
			<h3>로그인</h3>
		</div>
		<form name = "loginForm" method="post" action="${pageContext.request.contextPath}/member/MemberLoginOk.me">
			<div class="gtr-uniform" >
				<div class="col-6 col-12-xsmall"
					style="margin: 20px auto;">
					<input type="email" name="email" id="email" value=""
						placeholder="Email" style="width: 300px" /><br> <input
						type="password" name="pw" id="pw" value="" placeholder="password"
						style="width: 300px" />
				</div>
				<div style="margin: 20px auto; text-align: center;">
					<a href="findId.html" style="border-bottom : none; font-size: 0.7rem; ">아이디 찾기</a> <a
						href="findPw.html" style="border-bottom : none; font-size: 0.7rem;">비밀번호 찾기</a>
				</div>
				<div class="col-12" class="actions"
					style="margin: 20px auto; display: inline-block;">
					<!-- login()을 위해 js를 만들어서 -> 공백 체크하고 넘기기 -->
					<a href="javascript:loginForm.submit()" class="button primary"style="width: 150px">login</a>
					<a href="${pageContext.request.contextPath}/member/MemberSignup.me" class="button"style="width: 150px">Sign up</a>
				</div>
			</div>
		</form>
		<!--  -->
		<div class="section">
	<input type="radio" name="slide" id="slide01" checked>
	<input type="radio" name="slide" id="slide02">
	<input type="radio" name="slide" id="slide03">
	<div class="slidewrap" style = "position: fixed; width : 500px; height: 500px; ">
		
		<ul class="slidelist">
			<!-- 슬라이드 영역 -->
			<li class="slideitem">
				<a>
					<div class="textbox">
						<h3>첫번째 슬라이드</h3>
						<p>첫번째 슬라이드 입니다.</p>
					</div>
					<img src="./img/slide.jpg">
				</a>
			</li>
			<li class="slideitem">
				<a>
					<div class="textbox">
						<h3>두번째 슬라이드</h3>
						<p>두번째 슬라이드 입니다.</p>
					</div>
					<img src="./img/slide.jpg">
				</a>
			</li>
			<li class="slideitem">
				<a>
					
					<div class="textbox">
						<h3>두번째 슬라이드</h3>
						<p>두번째 슬라이드 입니다.</p>
					</div>
					<img src="./img/slide.jpg">
				</a>
			</li class="slideitem">

			<!-- 좌,우 슬라이드 버튼 -->
			<div class="slide-control">
				<div>
					<label for="slide03" class="left"></label>
					<label for="slide02" class="right"></label>
				</div>
				<div>
					<label for="slide01" class="left"></label>
					<label for="slide03" class="right"></label>
				</div>
				<div>
					<label for="slide02" class="left"></label>
					<label for="slide01" class="right"></label>
				</div>
			</div>

		</ul>
		<!-- 페이징 -->
		<ul class="slide-pagelist">
			<li><label for="slide01"></label></li>
			<li><label for="slide02"></label></li>
			<li><label for="slide03"></label></li>
		</ul>
	</div>

	
</div>
		
		
		<!--  -->

	</div>

	<!-- Footer -->
	<footer id="footer">
		<div class="inner">
			<section class="info">
				<h3>About Us</h3>
				<div class="about">
					<p>Morbi mattis mi consectetur tortor elementum, varius
						pellentesque velit convallis. Aenean tincidunt lectus auctor
						mauris maximus, ac scelerisque ipsum tempor. Duis vulputate ex et
						ex tincidunt, quis lacinia velit aliquet. Duis non efficitur
						malesuada.</p>
					<p>Sagittis felis ac sagittis semper. Curabitur purus leo donec
						vel dolor at arcu tincidunt bibendum. Interdum et malesuada fames
						ac ante ipsum primis.</p>
					<ul class="actions">
						<li><a href="#" class="button">Learn More</a></li>
					</ul>
				</div>
				<div class="team">
					<article>
						<span class="image"><img src="images/pic06.jpg" alt=""></span>
						<p>
							<strong class="name">John Doe</strong> <span class="title">Lorem
								semper magna etiam</span>
						</p>
					</article>
					<article>
						<span class="image"><img src="images/pic07.jpg" alt=""></span>
						<p>
							<strong class="name">Jane Anderson</strong> <span class="title">Etiam
								feugiat adipiscing veroeros</span>
						</p>
					</article>
					<article>
						<span class="image"><img src="images/pic08.jpg" alt=""></span>
						<p>
							<strong class="name">Mike Smith</strong> <span class="title">Consequat
								nulla dolor blandit</span>
						</p>
					</article>
				</div>
			</section>
			<section class="contact">
				<h3>Contact Us</h3>
				<ul class="contact-icons">
					<li class="icon solid fa-home"><a href="#">1234 Somewhere
							Road #80486<br>Nashville, TN 00000
					</a></li>
					<li class="icon solid fa-phone"><a href="#">(800) 555-0000
							x12345</a></li>
					<li class="icon solid fa-envelope"><a href="#">hello@untitled.tld</a></li>
					<li class="icon brands fa-facebook"><a href="#">facebook.com/untitled-tld</a></li>
					<li class="icon brands fa-twitter"><a href="#">twitter.com/untitled-tld</a></li>
				</ul>
			</section>
		</div>
		<div class="copyright">&copy; Untitled. All rights reserved.</div>
	</footer>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</body>
</html>