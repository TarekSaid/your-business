<#macro page title>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <title>${title} | YourBusiness</title>
  </head>
  <body>
    <header class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
      <a href="#">YourBusiness</a>
      <nav>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Home</a></li>
          <li><a href="#">Help</a></li>
          <li><a href="#">Log in</a></li>
        </ul>
      </nav>
    </div>
    </header>
    <div class="container">
      <h1>${title}</h1>
      <#nested>
    </div>
  </body>
</html>
</#macro>