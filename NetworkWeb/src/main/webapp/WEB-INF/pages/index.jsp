<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="resources/core/my-style.css">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:useBean id="posts" scope="request" type="java.util.List<dao.model.PostDto>"/>

    <jsp:useBean id="hobby" scope="request" type="java.util.List<dao.model.HobbyDto>"/>
    <jsp:useBean id="hobbys" scope="request" type="java.util.List<dao.model.HobbyDto>"/>
    <jsp:useBean id="places" scope="request" type="java.util.List<dao.model.PlaceDto>"/>
    <jsp:useBean id="friends" scope="request" type="java.util.List<dao.model.PersonDto>"/>
    <jsp:useBean id="messageForMe" scope="request" type="java.util.List<dao.model.MessageDto>"/>
    <jsp:useBean id="myMessage" scope="request" type="java.util.List<dao.model.MessageDto>"/>
    <jsp:useBean id="person" scope="request" type="dao.model.PersonDto"/>


</head>
<body>

<nav  class="navbar navbar-inverse">
    <div   class="container-fluid" id="header" >
        <div  class="navbar-header"  >
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand myButton" href="#" >Logo</a>

        </div>
        <div class="collapse navbar-collapse " id="myNavbar">
            <ul class="nav navbar-nav navbar-right myButton ">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
            </ul>
            <div class="text-center" id="myH1" >
                <h1 >HAND MADE</h1>
            </div>
            <ul class="nav navbar-nav">
                <li class="active myButton" ><a href="home" id="logo">Home</a></li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group input-group">
                    <input type="text" class="form-control myButton" placeholder="Search..">
          <span class="input-group-btn">
            <button id="myButt" class="btn btn-default myButt" type="button">
                <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>
                </div>
            </form>
        </div>
    </div>
</nav>

<div class="container text-center">
    <div class="row">
        <div class="col-sm-3 well">
            <div class="well">
                <p><a href="#">My Profile</a></p>
                <p><b>nik name: </b>${person.nicName}</p>
                <p><b>first name: </b>${person.firstNname}</p>
                <p><b>last name: </b>${person.lastName}</p>
                <c:forEach items="${hobby}" var="myhobby">
                  <p><b>hobby: </b>${myhobby.title}</p>
                </c:forEach>

                <img src="resources/image/pict.jpg" class="img-circle" height="65" width="65" alt="Avatar">
            </div>
            <div class="well">
                <!-- Trigger the modal with a button -->
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Messages</button>

                <!-- Modal -->
                <div class="modal fade" id="myModal" role="dialog">
                    <div class="modal-dialog">

                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="dropdown">
                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">messages for me
                                        <span class="caret"></span></button>
                                           <ul class="dropdown-menu">
                                             <c:forEach items="${messageForMe}" var="mess">
                                                <div class="well NikName" id="${mess.personFrom.nicName}">
                                                    <p><b>nik name: </b>${mess.personFrom.nicName}</p>
                                                    <p>${mess.content}</p>
                                                    <p>${mess.timeSent}</p>
                                                </div>
                                             </c:forEach>
                                           </ul>
                                </div>
                                <div class="dropdown">
                                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> My messages
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${myMessage}" var="mymess">
                                            <div class="well NikName" id="${mymess.personTo.nicName}">
                                                <p><b>nik name: </b>${mymess.personTo.nicName}</p>
                                                <p>${mymess.content}</p>
                                                <p>${mymess.timeSent}</p>
                                            </div>
                                        </c:forEach>
                                    </ul>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
            <div class="well">
                <p ><a href="#">Interests</a></p>
                <p>
                    <c:forEach items="${hobbys}" var="hobby1">
                        <div class="dropdown">
                              <button class=" dropdown-toggle" id="#myButt1" type="button" data-toggle="dropdown">${hobby1.title}
                                  <span class="caret"></span></button>
                                  <ul class="dropdown-menu">
                                     <c:forEach items="${hobby1.personDtos}" var="personesHobby">
                                        <li><a href="#" class="NikName" id="${personesHobby.nicName}">${personesHobby.nicName}</a></li>
                                      </c:forEach>
                                    </ul>
                        </div>
                    </c:forEach>
                </p>
            </div>
            <div class="alert alert-success fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <p><strong>Ey!</strong></p>
                Places where do you like to visit
            </div>
            <c:forEach items="${places}" var="place">
                <p><a href="#">${place.title}</a></p>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">also love to be in this place
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <c:forEach items="${place.personDtos}" var="personesPlace">
                            <li><a href="#" class="NikName" id="${personesPlace.nicName}">${personesPlace.nicName}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>


        </div>
        <div class="col-sm-7">

            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default text-left">
                        <div class="panel-body">
                            <p contenteditable="true">Status: Felting</p>
                            <button type="button" class="btn btn-default btn-sm" id="bootpink">
                                <span class="glyphicon glyphicon-thumbs-up"></span> Like
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form">
                    <div class="form-group">
                         <label for="postTitle" >Title</label>
                        <input type="text" class="form-control" id="postTitle" placeholder="Title">
                    </div>
                    <div class="form-group">
                        <label for="postcontent">content</label>
                        <input type="text" class="form-control" id="postcontent" placeholder="Content">
                    </div>
                    <button class="btn btn-default" id="submit-post">post</button>
                </div>

            </div>
          <div id="postconteiner"  >
            <c:forEach items="${posts}" var="post">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="well" id="">
                            <p>${post.person.nicName}</p>
                            <img src="resources/image/pict.jpg" class="img-circle" height="55" width="55" alt="Avatar">

                        </div>
                    </div>
                    <div class="col-sm-9">
                        <div class="well">
                            <p><b>${post.title}: </b>${post.content}</p>
                            <button id="heart" class="glyphicon glyphicon-heart button button3"></button>
                            <div class="dropdown">
                                <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">likes
                                    <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                   <c:forEach items="${post.postLikesPerson}" var="postLike">
                                     <li><a href="#" class="NikName" id="${postLike.nicName}">${postLike.nicName}</a></li>
                                   </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
          </div>


            <div class="row">
                <div class="col-sm-3">
                    <div class="well">
                        <p>Anja</p>
                        <img src="bird.jpg" class="img-circle" height="55" width="55" alt="Avatar">
                    </div>
                </div>
                <div class="col-sm-9">
                    <div class="well">
                        <p>Just Forgot that I had to mention something about someone to someone about how I forgot something, but now I forgot it. Ahh, forget it! Or wait. I remember.... no I don't.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-2 well">
            <div class="thumbnail">
                <p ><H3 id="myH11">Friends</H3></p>
                <div class="row">
                   <c:forEach items="${friends}" var="friend">
                    <div class="col-sm-12 friend-info" id="${friend.nicName}">
                        <div class="well">
                            <span class="label label-info">Nic Name</span>
                            <p >${friend.nicName}</p>
                            <span class="label label-info">First Name</span>
                            <p>${friend.firstNname}</p>
                            <span class="label label-info">Last Name</span>
                            <p>${friend.lastName}</p>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <button class="btn btn-primary">Info</button>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
    </div>
</div>

<footer id="myDIV" class="container-fluid text-center">
    <p>CREATIVE ACHIEVEMENTS!</p>
</footer>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/core/my-script.js"></script>
</body>
</html>
