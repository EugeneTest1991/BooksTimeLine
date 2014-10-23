<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Books Timeline</title>
<style>
body, html {
 font-family: arial, sans-serif;
 font-size: 11pt;
}

.vis.timeline .item.background.negative {
 background-color: rgba(255, 0, 0, 0.2);
}

.vis.timeline .item.background.marker {
 border-left: 2px solid green;
}
</style>

<script
    src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"
    src="${pageContext.servletContext.contextPath}/resources/js/vis.js"></script>
<link rel="stylesheet" type="text/css"
    href="${pageContext.servletContext.contextPath}/resources/css/vis.css" />
</head>
<body>
    <h1>Books:</h1>
    <p>${books}</p>
    <p>This example demonstrates the item type "background", see
        "Period A" and "Period B". The background areas can be styled
        with css.</p>
    <div id="visualization"></div>
    <div id="loading">loading...</div>
    <script>
                    // load data via an ajax request. When the data is in, load the timeline
                    $
                            .ajax({
                                url : 'http://localhost:8080/BooksTimeLine/jsons',
                                success : function(data) {
                                    // hide the "loading..." message
                                    document.getElementById('loading').style.display = 'none';

                                    var items = new vis.DataSet({
                                        type : {
                                            start : 'Date',
                                            end : 'Date'
                                        }
                                    });
                                    
                                    // add items to the DataSet
                                    items.add([ {
                                        id : 'A',
                                        content : 'Great Depression',
                                        start : new Date(-1267833600000),
                                        end : new Date(-978307200000),
                                        type : 'background',
                                        className : 'negative'
                                    }, {
                                        id : 'B',
                                        content : 'slavery',
                                        start : new Date(-11076480000000),
                                        end : new Date(-3283113600000),
                                        type : 'background',
                                        className : 'negative'
                                    } ]);

                                    for (var i = 0; i < data.length; i++) {
                                        items.add({
                                            id : data[i].id,
                                            content : data[i].title,
                                            start : new Date(
                                                    data[i].actionStart),
                                            end : new Date(data[i].actionEnd)
                                        });
                                    }

                                    var container = document
                                            .getElementById('visualization');
                                    var options = {
                                        start : new Date(-3943814400000),
                                        end : new Date(-943315200000),
                                        editable : false
                                    };

                                    var timeline = new vis.Timeline(container,
                                            items, options);
                                },
                                error : function(err) {
                                    console.log('Error', err);
                                    if (err.status === 0) {
                                        alert('Failed to load data/basic.json.\nPlease run this example on a server.');
                                    } else {
                                        alert('Failed to load data/basic.json.');
                                    }
                                }
                            });

/*                     var books = [ {
                        "id" : 1,
                        "author" : "Harper Lee",
                        "title" : "To Kill a Mockingbird",
                        "actionStart" : -1104526800000,
                        "actionEnd" : -1072990800000
                    }, {
                        "id" : 22,
                        "author" : "Harriet Beecher Stowe",
                        "title" : "Uncle Tom's Cabin",
                        "actionStart" : -3786814800000,
                        "actionEnd" : -3723742800000
                    } ];

                    var items = new vis.DataSet({
                        type : {
                            start : 'Date',
                            end : 'Date'
                        }
                    });

                    // add items to the DataSet
                    items.add([ {
                        id : 'A',
                        content : 'Great Depression',
                        start : new Date(-1267833600000),
                        end : new Date(-978307200000),
                        type : 'background',
                        className : 'negative'
                    }, {
                        id : 'B',
                        content : 'slavery',
                        start : new Date(-11076480000000),
                        end : new Date(-3283113600000),
                        type : 'background',
                        className : 'negative'
                    } ]);

                    for (var i = 0; i < books.length; i++) {
                        items.add({
                            id : books[i].id,
                            content : books[i].title,
                            start : new Date(books[i].actionStart),
                            end : new Date(books[i].actionEnd)
                        });
                    }

                    var container = document.getElementById('visualization');
                    var options = {
                        start : new Date(-3943814400000),
                        end : new Date(-943315200000),
                        editable : false
                    };

                    var timeline = new vis.Timeline(container, items, options); */
                </script>
</body>
</html>