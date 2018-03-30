<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Stark Go</title>
        <link href="bootstrap/css/shop-homepae.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
        <link
            href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.2.1/css/bootstrap-combined.min.css"
            rel="stylesheet">
        <link
            href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
            rel="stylesheet">
        <script src="bootstrap/scripts/jquery-1.7.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <style>
            .paymentinfo ul {
                margin: 0;
                padding: 0;
                list-style-type: none;
            }

            .paymentinfo ul li {
                display: inline;
            }
        </style>

    </head>
    <body>
        <!--Header-->
        <header> <nav class="navbar navbar-inverse" role="navigation">
                <div class="navbar-inner">
                    <a class="brand" href="home.jsp">Stark Go</a> <a
                        class="btn btn-navbar" data-toggle="collapse"
                        data-target=".nav-collapse"> <span class="icon-bar"></span> <span
                            class="icon-bar"></span> <span class="icon-bar"></span>
                    </a>
                </div>
            </nav> </header>
<%
                                String flag =  ""+session.getAttribute("loginFlag");
                                if (flag.equals("false")) {
                            %>
                            <script >
                                alert("plz Enter right user name or password while login");
                            </script>
                            <%}
                            %>
        <!-- Section -->
        <section>
            <div class="container">
                <div class="breadcrumbs">
                    <ul class="breadcrumb">
                        <li class="active"><a href="home.jsp">Home</a> <span
                                class="divider">/</span></li>
                        <li class="active">Login</li>
                    </ul>
                </div>
                <div class="loginsection">
                    <hr class="soft" />

                    <div class="row">
                        <div class="span5">
                            <div class="well">

                                <h5>CREATE YOUR ACCOUNT</h5>
                                <form action="signup.jsp" method="post">
                                    <div class="control-group">
                                        <label class="control-label" for="inputEmail">E-mail
                                            Address</label>
                                        <div class="controls">
                                            <input class="span3" type="text" name="inputEmail"
                                                   id="inputEmail" placeholder="Enter you email" />
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="inputEmail">Password</label>
                                        <div class="controls">
                                            <input class="span3" type="password" name="password"
                                                   id="password" placeholder="Password" />
                                        </div>
                                    </div>
                                    <div class="controls">
                                        <button type="submit" class="btn btn-primary">Create
                                            Your Account</button>
                                    </div>
                                </form>
                            </div>
                        </div>			
                        <div class="span1">&nbsp;</div>
                        <div class="span5">
                            
                            <div class="well">
                                <form action="login.jsp" method="post">
                                    <div class="control-group">
                                        <label class="control-label" for="inputEmail">Email</label>
                                        <div class="controls">
                                            <input class="span3" type="text" name="inputEmail"
                                                   id="inputEmail" placeholder="E-mail Address">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="inputPassword">Password</label>
                                        <div class="controls">
                                            <input type="password" class="span3" name="password"
                                                   id="inputPassword" placeholder="Password">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <button type="submit" class="btn btn-primary">Sign in</button>
                                            <a href="forgetpass.html">Forget password?</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="soft" />
            </div>
        </section>
    </body>
</html>