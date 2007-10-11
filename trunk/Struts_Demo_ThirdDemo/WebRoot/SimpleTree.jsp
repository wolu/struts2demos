<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Struts 2 AJAX - Tree</title>
        <s:head theme="ajax" debug="true" />
        <script type="text/javascript">
            function treeNodeSelected(arg) {
                alert(arg.source.title + ' selected');
            }
            dojo.addOnLoad(function() {                
                var s = dojo.widget.byId('parentId').selector;                
                dojo.event.connect(s, 'select', 'treeNodeSelected');
            }); 
        </script>
    </head>
    <body>
        <h2>
            Tree
        </h2>
        <div style="float:left; margin-right: 50px;">
            <s:tree label="parent" id="parentId" theme="ajax"
                templateCssPath="/struts/tree.css" showRootGrid="true"
                showGrid="true">
                <s:treenode theme="ajax" label="child1" id="child1Id">
                    <s:treenode theme="ajax" label="grandchild1" id="grandchild1Id" />
                    <s:treenode theme="ajax" label="grandchild2" id="grandchild2Id" />
                    <s:treenode theme="ajax" label="grandchild3" id="grandchild3Id" />
                </s:treenode>
                <s:treenode theme="ajax" label="child2" id="child2Id" />
                <s:treenode theme="ajax" label="child3" id="child3Id" />
                <s:treenode theme="ajax" label="child4" id="child4Id" />
                <s:treenode theme="ajax" label="child5" id="child5Id">
                    <s:treenode theme="ajax" label="gChild1" id="gChild1Id" />
                    <s:treenode theme="ajax" label="gChild2" id="gChild2Id" />
                </s:treenode>
            </s:tree>
        </div>
    </body>
</html>