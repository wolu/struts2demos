<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Struts 2 AJAX - More Tree</title>
        <s:head theme="ajax" debug="true" />
        <script type="text/javascript">
        /* <![CDATA[ */
            function treeNodeSelected(arg) {
                alert(arg.source.title + ' selected');
            }
            
            function treeNodeExpanded(arg) {
                alert(arg.source.title + ' expanded');
            }
            
            function treeNodeCollapsed(arg) {
                alert(arg.source.title + ' collapsed');
            }
            
            dojo.addOnLoad(function() {                
                var t = dojo.widget.byId('appFiles');
                dojo.event.topic.subscribe(t.eventNames.expand, treeNodeExpanded);                
                dojo.event.topic.subscribe(t.eventNames.collapse, treeNodeCollapsed);
                
                var s = t.selector;                
                dojo.event.connect(s, 'select', 'treeNodeSelected');
            });
        /* ]]> */    
        </script>
    </head>
    <body>
        <h2>
            Dynamic Tree Example
        </h2>
        <div style="float:left; margin-right: 50px;">
            <s:tree id="appFiles" theme="ajax" rootNode="root"
                nodeTitleProperty="name" nodeIdProperty="id"
                childCollectionProperty="children" />
        </div>
    </body>
</html>