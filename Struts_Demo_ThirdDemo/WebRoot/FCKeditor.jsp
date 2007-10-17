<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://fckeditor.net/tags-fckeditor" prefix="FCK" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>FCKeditor Sample</title>
    </head>
    <body>
        <h2>
            Tree
        </h2>
        <div>
			<FCK:editor id="EditorAccessibility" width="80%" height="120"
				toolbarSet="Accessibility">This is another test. <BR>
				<B>The "Second" row.</B>
			</FCK:editor>
		</div>
    </body>
</html>