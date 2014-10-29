<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" charset="utf-8"
    href="${pageContext.servletContext.contextPath}/resources/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css" charset="utf-8"
    href="${pageContext.servletContext.contextPath}/resources/timeglider/Timeglider.css">
<link rel="stylesheet" type="text/css" charset="utf-8"
    href="${pageContext.servletContext.contextPath}/resources/timeglider/timeglider.datepicker.css">

<style type='text/css'>
body {
    margin: 0;
    font-family: "franklin-gothic-urw-cond", Helvetica, Arial, sans-serif;
}

#placement {
    margin: 0;
    border: none;
}

.timeglider-container {
    border: none;
}

.tg-timeline-env-buttons {
    display: none;
}

.tg-close-button-remove {
    position: absolute;
    top: 4px;
    right: 4px;
    z-index: 400;
    width: 20px;
    height: 20px;
    padding: 0;
    border: none;
    color: transparent;
}

.timeglider-ev-modal {
    background-color: #201e1b;
    background-color: rgba(54, 52, 48, 1);
    border: 4px solid #aaa69c;
    -moz-box-shadow: 3px 4px 6px #0A0A0A;
    -webkit-box-shadow: 3px 4px 6px #0A0A0A;
    box-shadow: 3px 4px 6px #0A0A0A;
    -webkit-border-radius: 8px;
    -moz-border-radius: 8px;
    border-radius: 8px;
    width: 350px;
}

.timeglider-ev-modal p {
    font-size: 14px;
    color: #fefbf4;
    margin: 8px;
}

.timeglider-ev-modal h4,.tg-timeline-modal h4 {
    margin: 4px 8px 2px 8px;
    padding: 0;
    color: #b8b1a3;
    font-size: 16px;
}
</style>

<script type="text/javascript"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery-ui.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/underscore-min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/backbone-min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/json2.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.tmpl.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/ba-tinyPubSub.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.ui.ipad.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/globalize.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/ba-debug.min.js"></script>


<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/timeglider/timeglider-1.0.1.min.js"></script>


<title>Books timeglider</title>
</head>
<body>

    <div id='placement'></div>

    <script>
                    var myList;
                    $
                            .getJSON(
                                    "http://localhost:8080/BooksTimeLine/resources/timeglider/json/flight.json",
                                    function(json) {
                                        alert("JSON Data: " + json);
                                        myList = json;
                                    });

                    /*                     $.getJSON("http://localhost:8080/BooksTimeLine/resources/timeglider/json/flight.json").done(
                     function(data) {
                     myList = data;
                     }); */

                    $(function() {
                        alert("readed: " + myList);
                        var tg1 = $("#placement")
                                .timeline(
                                        {
                                            "data_source" : "resources/timeglider/json/flight.json",
                                            "min_zoom" : 15,
                                            "max_zoom" : 60,
                                            "icon_folder" : "resources/timeglider/icons/"
                                        });
                    });
                </script>

</body>
</html>