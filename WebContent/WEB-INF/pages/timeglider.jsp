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
                    $(document)
                            .ready(
                                    function() {
                                        var tg1 = $("#placement")
                                                .timeline(
                                                        {
                                                            "data_source" : {
                                                                "presentation" : "Timeglider",
                                                                "title" : "My Presentation",
                                                                "description" : "Example of two timelines loaded, one with 'inverted' set to true, and both with a higher 'bottom' value to create a bookmatched view.",
                                                                "open_modal" : true,
                                                                "initial_zoom" : 49,
                                                                "image_lane_height" : 100,
                                                                "focus_date" : "1991-06-12 12:00:00",
                                                                "initial_timelines" : [
                                                                        "j_life",
                                                                        "m_life" ],
                                                                "timelines" : [

                                                                        {
                                                                            "focus_date" : "1991-06-12 12:00:00",
                                                                            "title" : "John",
                                                                            "id" : "j_life",
                                                                            "initial_zoom" : "46",
                                                                            "bottom" : "250",
                                                                            "events" : [

                                                                                    {
                                                                                        "startdate" : "1968-08-20 12:00:00",
                                                                                        "enddate" : "",
                                                                                        "title" : "John Born",
                                                                                        "description" : "Valley hospital in Springfield, Illinois.<iframe src='http://techmeme.com' width=400 height=200></iframe>",
                                                                                        "icon" : "circle_green.png",
                                                                                        "importance" : "50",
                                                                                        "video" : "http://techmeme.com/m/",
                                                                                        "link" : "http://www.ridgewoodnj.net/main.cfm",
                                                                                        "id" : "ev_0"
                                                                                    },
                                                                                    {
                                                                                        "startdate" : "1981-09-01 12:00:00",
                                                                                        "enddate" : "1986-06-01 12:00:00",
                                                                                        "title" : "HHS",
                                                                                        "description" : "Hanover (NH) High School.",
                                                                                        "icon" : "square_blue.png",
                                                                                        "importance" : "32",
                                                                                        "link" : "http://hanoverhigh.us/Hanover/",
                                                                                        "id" : "ev_3"
                                                                                    },

                                                                                    {
                                                                                        "startdate" : "1999-06-19 12:00:00",
                                                                                        "enddate" : "1999-06-19 12:00:00",
                                                                                        "title" : "Married!",
                                                                                        "description" : "in Amherst, MA",
                                                                                        "icon" : "circle_red.png",
                                                                                        "importance" : "42",
                                                                                        "id" : "ev_3mar"
                                                                                    },

                                                                                    {
                                                                                        "startdate" : "today",
                                                                                        "enddate" : "",
                                                                                        "title" : "today!",
                                                                                        "description" : "Here in Boise Idaho.",
                                                                                        "icon" : "star_orange.png",
                                                                                        "importance" : "40",
                                                                                        "link" : "",
                                                                                        "id" : "ev_4"
                                                                                    } ]
                                                                        },

                                                                        {
                                                                            "focus_date" : "1969-02-27 12:00:00",
                                                                            "title" : "Mary",
                                                                            "description" : "Mary's life",
                                                                            "id" : "m_life",
                                                                            "initial_zoom" : "42",
                                                                            "bottom" : "180",
                                                                            "inverted" : true,
                                                                            "events" : [

                                                                                    {
                                                                                        "startdate" : "1969-02-27 12:00:00",
                                                                                        "enddate" : "1969-02-27 12:00:00",
                                                                                        "title" : "Mary born",
                                                                                        "description" : "St Lukes Hospital, Boise ID, to Walter and Diane Jastremsky",
                                                                                        "icon" : "circle_green.png",
                                                                                        "importance" : "50",
                                                                                        "id" : "hj_ev_0"
                                                                                    },
                                                                                    {
                                                                                        "startdate" : "1982-09-01 12:00:00",
                                                                                        "enddate" : "1987-06-01 12:00:00",
                                                                                        "title" : "Boise High",
                                                                                        "description" : "Boise (NH) High School.",
                                                                                        "icon" : "square_blue.png",
                                                                                        "importance" : "32",
                                                                                        "id" : "hj_ev_3"
                                                                                    },

                                                                                    {
                                                                                        "startdate" : "1999-06-19 12:00:00",
                                                                                        "enddate" : "1999-06-19 12:00:00",
                                                                                        "title" : "Married!",
                                                                                        "description" : "in Amherst, MA",
                                                                                        "icon" : "circle_red.png",
                                                                                        "importance" : "42",
                                                                                        "id" : "ev_3mar"
                                                                                    },

                                                                                    {
                                                                                        "startdate" : "today",
                                                                                        "enddate" : "",
                                                                                        "title" : "today!",
                                                                                        "description" : "Here in Boise Idaho.",
                                                                                        "icon" : "star_orange.png",
                                                                                        "importance" : "40",
                                                                                        "link" : "",
                                                                                        "id" : "ev_4"
                                                                                    } ]

                                                                        }

                                                                ]
                                                            },
                                                            "min_zoom" : 15,
                                                            "max_zoom" : 60,
                                                            "icon_folder" : "resources/timeglider/icons/",
                                                        });
                                    });
                </script>

</body>
</html>