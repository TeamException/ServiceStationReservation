<%-- 
    Document   : searchService
    Created on : Jan 31, 2017, 9:42:04 PM
    Author     : Tharindu Jayathilake
--%>

<%@page import="com.teamexception.reseravationmaven.model.VehicleServiceType"%>
<%@page import="com.teamexception.reseravationmaven.model.PredefinedServices"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
            <%
                PredefinedServices service = (PredefinedServices) request.getAttribute("service");
                ArrayList<VehicleServiceType> typeList = (ArrayList<VehicleServiceType>) request.getAttribute("serviceTypes");
            %>
            <div class="panel panel-primary">
                <div class="panel-heading"><h1>Update Predefined Service</h1></div>
                <div class="panel-body">
                    <form id="service" class="form-horizontal" method="GET" action="view/facilitator/predefinedServices/updateVehicleType">

                        <div class="form-group">
                            <label class="control-label col-sm-2">Service Name:</label>
                            <div class="col-sm-6">
                                <input id="serviceName" type="text" class="form-control" name="serviceName" value="<% out.print(service.getServiceName()); %>" readonly>
                                <input id="serviceId" type="text" class="form-control" name="serviceId" value="<% out.print(service.getServiceId()); %>" hidden>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Description:</label>
                            <div class="col-sm-6">
                                <textarea id="description" rows="4" cols="50" class="form-control" name="description" readonly>
                                    <% out.print(service.getDescription()); %>
                                </textarea>
                            </div>
                        </div>
                        <hr>


                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <table id="detail" class="table table-bordered">
                                    <thead>
                                    <th>Vehicle Type</th>
                                    <th>Duration(mins)</th>
                                    <th>Cost(Rs)</th>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (VehicleServiceType serviceType : typeList) {%>
                                    <td> <% out.print(serviceType.getTypeId()); %> </td>
                                    <td> <% out.print(serviceType.getDuration()); %> </td>
                                    <td> <% out.print(serviceType.getCost()); %> </td>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button id="submit" class="btn btn-success">Add Service Type</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
