<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>JSON Plugin</title>
        <s:head theme="ajax" />
        <script type="text/javascript">                    
        dojo.addOnLoad(function() {
            dojo.event.topic.subscribe('retrieveBook', this, function(data, type, e){
                if(type == 'load') {
                    showBook(data);
                } else if(type == 'error') {
                    alert('Can not retrieve the book');
                }
            });
        });
        
        function showBook(strBook) {
            var oBook = eval('(' + strBook + ')');
            var bookHolder = document.getElementById('bookHolder');
            var sBook = '<p><b>ISBN: </b>' + oBook.ISBN + '</p>';
            sBook += ('<p><b>Title: </b>' + oBook.title + '</p>');
            sBook += ('<p><b>Price: </b>$' + oBook.price + '</p>');
            sBook += ('<b><i>Comments: </i></b><hr/>');
            for(i = 0; i < oBook.comments.length; i++) {
                sBook += ('<p><b>#' + (i + 1) + ' </b>' + oBook.comments[i] + '</p>');
            }
            bookHolder.innerHTML = sBook;
        }
        </script>
    </head>
    <body>
        <s:url id="bookUrl" value="/JsonPlugin.action" />
        <s:submit href="%{bookUrl}" theme="ajax" indicator="indicator"
            value="Retrieve Book" align="left" notifyTopics="retrieveBook" />
        <s:a theme="ajax" href="%{bookUrl}" indicator="indicator"
            notifyTopics="retrieveBook">Retrieve Book</s:a>
        <img id="indicator"
            src="${pageContext.request.contextPath}/images/indicator.gif"
            alt="Loading" style="display:none" />
        <div id="bookHolder"></div>
    </body>
</html>