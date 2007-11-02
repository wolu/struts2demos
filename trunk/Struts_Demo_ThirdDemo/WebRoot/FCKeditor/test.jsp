<%@ taglib uri="/FCKeditor" prefix="FCK" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>FCKeditor Sample</title>
    </head>
    <body>
        <h2>
            FCKeditor Sample
        </h2>
        <div>
			<form action="show.jsp" method="post" target="_blank">
				<FCK:editor id="content" basePath="/Struts_Demo_ThirdDemo/FCKeditor/"
					width="700"
					height="500"
					skinPath="/Struts_Demo_ThirdDemo/FCKeditor/editor/skins/silver/"
					toolbarSet = "Default">
					input
				</FCK:editor>
				<input type="submit" value="Submit">
			</form>
		</div>
    </body>
</html>