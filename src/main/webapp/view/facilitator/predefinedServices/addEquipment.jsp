<%-- 
    Document   : addEquipment
    Created on : Dec 22, 2016, 3:06:08 PM
    Author     : Tharindu Jayathilake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Assign Equipments</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style type="text/css">
            body{
                background:url(images/93742-d09dd7090171c70be749072814043b26.jpg);
            }
        </style>
    </head>
    <body>

        <div class="container">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                    <li data-target="#myCarousel" data-slide-to="3"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="images/1.jpg" width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="images/2.jpg"  width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="images/3.jpg"  width="1200" height="200">
                    </div>

                    <div class="item">
                        <img src="images/4.jpg"  width="1200" height="200">
                    </div>
                </div>

                <!-- Left and right controls -->
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
                        <a class="navbar-brand" href="#">WebSiteName</a>
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
                <div class="panel-heading"><h1>Add Equipments To The Service</h1></div>
                <div class="panel-body">
                    <form class="form-horizontal" method="post" action="equipmentController/addEquipment" name="addEquipment">
                        <div class="form-group">
                            <label class="control-label col-sm-2">Name:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="equipmentName" placeholder="Enter Equipment Name">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Manufacturer:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="manufacturer" placeholder="Enter Manufacturer">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Purchased Date:</label>
                            <div class="col-sm-6">
                                <input type="date" class="form-control"  name="purchasedDate">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Quantity:</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="qty" placeholder="Enter Quantity">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Description:</label>
                            <div class="col-sm-6">
                                <textarea class="form-control" rows="4" cols="50" name="description" placeholder="Enter Description"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Add Equipment</button>
                                <button type="reset" class="btn btn-primary">Clear</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
