<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@page import="com._42Penguins.gosign.service.EntKeyLocalServiceUtil"%>
<%@page import="com._42Penguins.gosign.model.EntKey"%>
<%@page import="com._42Penguins.gosign.service.EntDocLocalServiceUtil"%>
<%@page import="com._42Penguins.gosign.model.EntDoc"%>
<%@page import="com.liferay.portal.kernel.model.User" %>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="com.liferay.portal.kernel.model.User" %>

<%
long userId = ParamUtil.getLong(request, "userId");
User userData = UserLocalServiceUtil.getUser(userId);
%>

<style>

@media (min-width: 1200px) {
    .container{
        max-width: 800px;
    }
}
	
</style>

<div class="container panel">

  <div class="panel-body">
  
  	<div align="center"><table><tr><td>
  	
  	<liferay-ui:user-display
        markupView="lexicon"
        showUserDetails="false"
        showUserName="false"
		userId="<%=userData.getUserId()%>"
        userName="<%=userData.getFullName()%>"/>
  	
  	</td>
	</tr></table>   </div>  
  <table class="table table-hover">
    <tbody>
<tr>
	<td width="150">User ID:</td>
	<td><%=userData.getUserId()%></td>
</tr>
<tr>
	<td>Full Name:</td>
	<td><%=userData.getFullName()%></td>
</tr>
<tr>
	<td>Email:</td>
	<td><%=userData.getEmailAddress()%></td>
</tr>
<tr>
	<td>Registered On:</td>
	<td><%=userData.getCreateDate()%></td>
</tr>
<tr>
	<td>Last Login:</td>
	<td><%=userData.getLastLoginDate()%></td>
</tr>
    </tbody>
  </table>
	
</div> </div>

