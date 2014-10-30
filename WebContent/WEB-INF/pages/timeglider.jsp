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

.timeglider-ev-modal h4, .tg-timeline-modal h4 {
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
                    function getFormattedDate(date) {
                        var year = date.getFullYear();
                        var month = (1 + date.getMonth()).toString();
                        var day = date.getDate().toString();
                        var hours = date.getHours();
                        var minutes = date.getMinutes();
                        return year + '-' + month + '-' + day + " " + hours
                                + ":" + minutes;
                    }

                    function loadJSON(callback) {
                        var xobj = new XMLHttpRequest();
                        xobj.overrideMimeType("application/json");
                        xobj
                                .open(
                                        "GET",
                                        "http://localhost:8080/BooksTimeLine/resources/timeglider/json/flight.json",
                                        true);
                        xobj.onreadystatechange = function() {
                            if (xobj.readyState == 4 && xobj.status == "200") {
                                // Required use of an anonymous callback as .open will NOT return a value but simply returns undefined in asynchronous mode
                                callback(xobj.responseText);
                            }
                        };
                        xobj.send(null);
                    }

                    $(function() {
                        var data_JSON;
                        loadJSON(function(response) {
                            // Parse JSON string into object
                            data_JSON = JSON.parse(response);
                            var events = data_JSON[0].events;
                            events.push({
                                "id" : "1",
                                "title" : "Great Depression",
                                "startdate" : getFormattedDate(new Date(
                                        -1267833600000)),
                                "enddate" : "1940-9-20 1:00",
                                "date_display" : "da",
                                "icon" : "halfcircle_blue.png",
                                "low_threshold" : "1",
                                "high_threshold" : "45",
                                "importance" : "52",
                                "css_class" : ""
                            });
                            var tg1 = $("#placement").timeline({
                                "data_source" : data_JSON,
                                "min_zoom" : 15,
                                "max_zoom" : 60,
                                "icon_folder" : "resources/timeglider/icons/"
                            });
                        });

                    });
                </script>

</body>
</html>