<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Eduvisor"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <asset:javascript src="application.js"/>
    <asset:javascript src="materialize.min.js"/>
    <asset:javascript src="common.js"/>

    <g:layoutHead/>
</head>

<body>
<nav class="indigo lighten-2 z-depth-1 animated fadeInRightBig">
    <div class="nav-wrapper">
        <a href="" class="brand-logo waves-effect waves-light">
            <img src="../../assets/images/forge-logo.png" alt="Eduvisor"/>
        </a>
        <ul class="right hide-on-med-and-down">
            <li>
                <form>
                    <div class="input-field">
                        <input id="search" type="search" required>
                        <label for="search"><i class="fa fa-search-plus"></i></label>
                    </div>
                </form>
            </li>
            <li><a class="waves-effect waves-light" href="../about.xhtml">About</a></li>
            <li><a class="waves-effect waves-light" href="../faq.xhtml">Faq</a></li>
            <li><a class="waves-effect waves-light" href="../faq.xhtml">Contact</a></li>
            <li><a class="waves-effect waves-light" href="login.html">Login</a></li>
        </ul>
    </div>
</nav>


<g:layoutBody/>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<footer class="indigo lighten-2 z-depth-1 page-footer animated fadeInLeftBig">
    <div class="footer-copyright">
        <div class="container">
            © 2016 Copyright Eduvisor
            <a class="pink-text text-lighten-4 right" href="http://cinsol.com.ng">Powered by Cinsol</a>
        </div>
    </div>
</footer>

</body>
</html>
