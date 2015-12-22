<#macro page title>
<!DOCTYPE html>
<html>
  <head>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.6/css/bootstrap.min.css'>
    <link rel='stylesheet' href='resources/css/page-style.css'>
    <title>${title} | YourBusiness</title>
  </head>
  <body>
    <#include "header.ftl">
    <div class="container">
      <#nested>
      <#include "footer.ftl">
    </div>
  </body>
</html>
</#macro>