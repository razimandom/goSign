<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="DocRegistration.model.Document"%>
<%@page import="DocRegistration.service.DocumentLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!-- Start - This script and script for toggler button 

<script src="https://cdn.alloyui.com/3.0.1/aui/aui-min.js"></script>
<link href="https://cdn.alloyui.com/3.0.1/aui-css/css/bootstrap.min.css"></link>

<script type="text/javascript">

YUI().use(
  'aui-toggler',
  function(Y) {
    new Y.Toggler(
      {
        container: '#myToggler',
        animated: true,
        content: '.content',
        expanded: false,
        header: '.header'
      }
    );
  }
);


</script>-->

<!-- End - This script and script for toggler button -->

<!-- Start - Button styles  -->

<style>
td{
	padding:5px}
	
.btn {
    border: none; /* Remove borders */
    color: white; /* Add a text color */
    padding: 14px 28px; /* Add some padding */
    cursor: pointer; /* Add a pointer cursor on mouse-over */
}

.btngreen {background-color: #4CAF50;} /* Green */
.btngreen:hover {background-color: #46a049;}

.btnblue {background-color: #2196F3;} /* Blue */
.btnblue:hover {background: #0b7dda;}

.btnorange {background-color: #ff9800;} /* Orange */
.btnorange:hover {background: #e68a00;}

.btnred {background-color: #f44336;} /* Red */ 
.btnred:hover {background: #da190b;}

.btngray {background-color: #e7e7e7; color: black;} /* Gray */ 
.btngray:hover {background: #ddd;}

</style>

<!-- End - Button styles -->

<%
long docId = ParamUtil.getLong(request, "docId");
Document document = DocumentLocalServiceUtil.getDocument(docId);
request.setAttribute("document", document);
String redirect = ParamUtil.getString(request, "backURL");
%>

		<portlet:resourceURL var="viewURL">
            <portlet:param name="dataId"
                value="<%=String.valueOf(document.getDocId())%>" />
        </portlet:resourceURL>

<h3>Request Details: </h3>

<table>
<tr>
	<td>Request ID:</td>
	<td>${document.docId}</td>
</tr>
<tr>
	<td>Requestor Name:</td>
	<td>${document.req_name}</td>
</tr>
<tr>
	<td>Requestor Email:</td>
	<td>${document.req_email}</td>
</tr>
<tr>
	<td>Signer Email:</td>
	<td>${document.sign_email}</td>
</tr>
<tr>
	<td>Type:</td>
	<td>${document.doc_type}</td>
</tr>
<tr>
	<td>Status:</td>
	<td>${document.doc_status}</td>
</tr>
<tr>
	<td>Date Created:</td>
	<td>${document.req_dateCreated}</td>
</tr>
<tr>
	<td>Deadline:</td>
	<td>${document.doc_deadline}</td>
</tr>
<tr>
	<td>File Name:</td>
	<td>${document.file_name}</td>
</tr>
<tr>
	
 
	<td>Download:</td>
	<td><aui:form action="<%=viewURL.toString() %>" method="post" name="name">
	<button name="delDocument" type="submit">Download File</button>
	</aui:form></td>

	
</tr>
<tr>
	<td>Description/Justification:</td>
	<td>${document.doc_description}</td>
</tr>
</table>
<br>

<portlet:actionURL name="delDocument" var="delDocument" />
<portlet:actionURL name="doBack" var="doBack" />

<table>
<tr>
<td>
	<aui:form action="<%=doBack%>" method="post" name="name">
	<aui:button cssClass="btngrey" name="back" type="submit" value="Back" last="true" />
	</aui:form>
</td>
<td>
	<aui:form action="<%=delDocument%>" method="post" name="name">
	<aui:input label="Doc Id: " name="docId" type="hidden" value="${document.docId}" readOnly="true"/>
	<aui:button cssClass="btnred" name="delDocument" type="submit" value="Delete" last="true" />
	</aui:form>
</td>
<td>
	<button class="header btn btn-primary toggler-header-collapsed" >Change Deadline</button>
</td>

 <!--  
<td>
	<aui:form action="<%=viewURL.toString() %>" method="post" name="name">
	<aui:button cssClass="btngreen" name="delDocument" type="submit" value="Download File" last="true" />
	</aui:form>
</td>
-->

</tr>
</table>

<div class="content toggler-content-collapsed" id="myToggler">

<h3>Update Request:</h3>

<portlet:actionURL name="updateDoc" var="updateDoc" />

<aui:form action="<%=updateDoc%>" method="post" name="name">
	<aui:input label="Doc Id: " name="docId" type="hidden" value="${document.docId}" readOnly="true"/>
	<aui:input label="Deadline: " name="doc_deadline" type="type" value="${document.doc_deadline}" />
	<aui:button name="update" type="submit" value="Update" last="true" />

</aui:form>

</div>