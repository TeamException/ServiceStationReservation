<%-- 
    Document   : updateVehicleType
    Created on : Feb 1, 2017, 10:57:13 PM
    Author     : Tharindu Jayathilake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
html lang="en">
    <head>
        <title>Predefined Services</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style type="text/css">
            body{
                background:url(${pageContext.request.contextPath}/resources/images/93742-d09dd7090171c70be749072814043b26.jpg);
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function () {
                document.getElementById("add").disabled = true;
                var table = $("#detail");

                $("#serviceName").keyup(function () {
                    if (this.value.length != 0 && $("#description").val().length != 0 && $("#duration").val().length != 0 && $("#cost").val().length != 0 && $("#type").val() !== "--Select Type--")
                        document.getElementById("add").disabled = false;
                    else
                        document.getElementById("add").disabled = true;

                });

                $("#description").keyup(function () {
                    if (this.value.length != 0 && $("#serviceName").val().length != 0 && $("#duration").val().length != 0 && $("#cost").val().length != 0 && $("#type").val() !== "--Select Type--")
                        document.getElementById("add").disabled = false;
                    else
                        document.getElementById("add").disabled = true;
                });

                $("#type").change(function () {
                    if (this.value != "--Select Type--" && $("#description").val().length != 0 && $("#duration").val().length != 0 && $("#cost").val().length != 0 && $("#serviceName").val().length != 0)
                        document.getElementById("add").disabled = false;
                    else
                        document.getElementById("add").disabled = true;
                });

                $("#duration").keyup(function () {
                    if (this.value.length != 0 && $("#description").val().length != 0 && $("#serviceName").val().length != 0 && $("#cost").val().length != 0 && $("#type").val() !== "--Select Type--")
                        document.getElementById("add").disabled = false;
                    else
                        document.getElementById("add").disabled = true;
                });

                $("#cost").keyup(function () {
                    if (this.value.length != 0 && $("#description").val().length != 0 && $("#duration").val().length != 0 && $("#serviceName").val().length != 0 && $("#type").val() != "--Select Type--")
                        document.getElementById("add").disabled = false;
                    else
                        document.getElementById("add").disabled = true;
                });


                $("#add").click(function () {
                    var type = document.getElementById("type").value;
                    var duration = document.getElementById("duration").value;
                    var cost = document.getElementById("cost").value;
                    var markup = "<tr><tr><td><input type='checkbox' name='record'></td><td>" + type + "</td><td>" + duration + "</td><td>" + cost + "</td></tr>";
                    $("table tbody").append(markup);
                    document.getElementById("type").value = "--Select Type--";
                    document.getElementById("duration").value = "";
                    document.getElementById("cost").value = "";
                    document.getElementById("add").disabled = true;
                });

                $("#submit").click(function () {
                    var data = [];
                    data.push(document.getElementById("serviceName").value);
                    data.push(document.getElementById("description").value);


                    $("table").find("tr").each(function () {
                        $(this).find("td").each(function () {
                            if ($(this).text() != "") {
                                data.push($(this).text());
                            }
                        });
                    });
                    var formAction = $('#service').attr('action');
                    $('#service').attr('action', formAction + data);
                });

                $("#deleteSelected").click(function () {
                    $("table tbody").find('input[name="record"]').each(function () {
                        if ($(this).is(":checked")) {
                            $(this).parents("tr").remove();
                        }
                    });
                });

            });
            
            function createXMLHttpRequest() {
                var xmlhttp;
                if (window.XMLHttpRequest) {
                    // code for IE7+, Firefox, Chrome, Opera, Safari 
                    xmlhttp = new XMLHttpRequest();
                } else {
                    // code for IE6, IE5 
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                return xmlhttp;

            }
            function sendRequest() {
                var url = "vehicleTypeController/allVehicleTypes";

                var request = createXMLHttpRequest();
                request.open("GET", url, true);
                request.send(null);
                request.onreadystatechange = function () {
                    if (request.readyState == 4) {
                        if (request.status == 200) {
                            var output = request.responseText;
                            document.getElementById('combo').innerHTML = output;
                        }
                    }
                }
            }

        </script>
    </head>
    <body onload="sendRequest();">

        <div class="container">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">

                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                    <li data-target="#myCarousel" data-slide-to="3"></li>
                </ol>

                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/resources/images/1.jpg" width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/images/2.jpg"  width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/images/3.jpg"  width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="${pageContext.request.contextPath}/resources/images/4.jpg"  width="1200" height="200">
                    </div>
                </div>

                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">ChannelEasy</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li class="dropdown">
                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Page 1-1</a></li>
                                    <li><a href="#">Page 1-2</a></li>
                                    <li><a href="#">Page 1-3</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Page 2</a></li>
                            <li><a href="#">Page 3</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Add Predefined Service</h1></div>
                <div class="panel-body">
                    <form id="service" class="form-horizontal" method="GET" action="serviceController/add/">

                        <div class="form-group">
                            <label class="control-label col-sm-2">Service Name:</label>
                            <div class="col-sm-6">
                                <input id="serviceName" type="text" class="form-control" name="serviceName" placeholder="Enter Service Name">
                                <input id="serviceId" type="text" class="form-control" name="serviceId" value="<% request.getParameter("serviceId");%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Description:</label>
                            <div class="col-sm-6">
                                <textarea id="description" rows="4" cols="50" class="form-control" name="description" placeholder="Enter Description"></textarea>
                            </div>
                        </div>
                        <hr>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Vehicle Type:</label>
                            <div id ="combo" name="typeName" class="col-sm-6">
      
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Duration:</label>
                            <div class="col-sm-6">
                                <input id="duration" type="text" class="form-control" name="duration" placeholder="Enter Duration(min)">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="control-label col-sm-2">Cost:</label>
                            <div class="col-sm-6">
                                <input id="cost" type="text" class="form-control" name="cost" placeholder="Enter Cost(Rs)">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button id="add" type="submit" class="btn btn-primary">Add Vehicle Type</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
