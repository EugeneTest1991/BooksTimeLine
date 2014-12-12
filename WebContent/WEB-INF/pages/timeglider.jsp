<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width">

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/modernizr.custom.js"></script>

<script type="text/javascript" src="https://use.typekit.com/hjz1sud.js"></script>
<script type="text/javascript">
    try {
        Typekit.load();
    } catch (e) {
    }
</script>

<link rel="stylesheet" type="text/css" charset="utf-8" media="screen"
    title="no title"
    href="${pageContext.servletContext.contextPath}/resources/css/jquery-ui-1.10.3.custom.css">
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen"
    title="no title"
    href="${pageContext.servletContext.contextPath}/resources/timeglider/Timeglider.css">
<link rel="stylesheet" type="text/css"
    href="${pageContext.servletContext.contextPath}/resources/css/jquery.jscrollpane.css">
<link rel="stylesheet" type="text/css" charset="utf-8" media="screen"
    title="no title"
    href="${pageContext.servletContext.contextPath}/resources/css/select2.css">
<link rel="stylesheet" type="text/css" charset="utf-8"
    href="${pageContext.servletContext.contextPath}/resources/timeglider/Timeglider.event_color_themes.css">
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
    src="${pageContext.servletContext.contextPath}/resources/js/json2.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/underscore-min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/backbone-min.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.tmpl.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/ba-debug.min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/ba-tinyPubSub.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.ui.ipad.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/globalize.js"></script>

<script type="text/javascript"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.ba-throttle-debounce.min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/jquery.jscrollpane.min.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/js/select2.min.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/timeglider/timeglider-1.0.1.min.js"></script>
<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/timeglider/timeglider.datepicker.js"></script>

<script type="text/javascript" charset="utf-8"
    src="${pageContext.servletContext.contextPath}/resources/timeglider/usa_history.js"></script>

<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push([ '_setAccount', 'UA-8964270-1' ]);
    _gaq.push([ '_trackPageview' ]);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl'
                : 'http://www')
                + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
</script>


<title>Books timeglider</title>
</head>
<body>

    <div id='placement'></div>

    <script type='text/javascript'>
                    var tg1 = {};

                    jQuery.support.cors = true;

                    // memoize the url query string
                    window.getSearch = function(variable) {
                        var parsedSearch;
                        parsedSearch = window.parsedSearch || (function() {
                            var match, re, ret;
                            re = /\??(.*?)=([^\&]*)&?/gi;
                            ret = {};
                            while (match = re.exec(document.location.search)) {
                                ret[match[1]] = match[2];
                            }
                            return window.parsedSearch = ret;
                        })();
                        return parsedSearch[variable];
                    };

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
                        xobj.open("GET",
                                "http://localhost:8080/BooksTimeLine/books",
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
                        var books_json;
                        var min_zoom = parseInt(getSearch("min_zoom"), 10) || 1;

                        var max_zoom = parseInt(getSearch("max_zoom"), 10) || 100;

                        var boost = parseInt(getSearch("boost"), 10) || 0;

                        var doc_ht = $(document).height();

                        $("#placement").css({
                            "height" : doc_ht
                        });

                        loadJSON(function(response) {

                            // Parse JSON string into object
                            books_json = JSON.parse(response);
                            var events = USAhistory[0].events;

                            for (var i = 0; i < books_json.length; i++) {
                                events.push({
                                    "id" : books_json[i].id,
                                    "title" : books_json[i].title,
                                    "description" : books_json[i].title
                                            + " by " + books_json[i].author,
                                    "startdate" : getFormattedDate(new Date(
                                            books_json[i].actionStart)),
                                    "enddate" : getFormattedDate(new Date(
                                            books_json[i].actionEnd)),
                                    "date_display" : "da",
                                    "icon" : "halfcircle_blue.png",
                                    "low_threshold" : "1",
                                    "high_threshold" : "55",
                                    "importance" : "52",
                                    "css_class" : ""
                                });
                            }

                            tg1 = $("#placement").timeline({
                                "min_zoom" : min_zoom,
                                "max_zoom" : max_zoom,
                                "boost" : boost,
                                "show_centerline" : true,
                                "image_lane_height" : 120,
                                "data_source" : USAhistory,
                                "icon_folder" : "resources/timeglider/icons/",
                                "show_footer" : true,
                                "display_zoom_level" : false,
                                "constrain_to_data" : true
                            });

                            var tg1_actor = tg1.data("timeline");

                            window.setTimeout(function() {
                                tg1_actor.refresh();
                            }, 1000);

                            $(window).resize(
                                    $.debounce(250, false, function(e) {
                                        debug.log("t resizing");
                                        var doc_ht = $(window).height()
                                        $("#placement").css({
                                            "height" : doc_ht
                                        });
                                        tg1_actor.resize();
                                    }));

                            var cot = Modernizr.touch ? "touchstart" : "click";

                            $(".tg-modal a").on(cot, function() {
                                $(this).attr('target', '_blank');
                            });
                        });

                    });
                </script>

</body>
</html>