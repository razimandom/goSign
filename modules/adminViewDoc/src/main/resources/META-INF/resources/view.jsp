<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com._42Penguins.gosign.service.EntDocLocalServiceUtil"%>
<%@page import="com._42Penguins.gosign.model.EntDoc"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<div class="portlet-header">List of Submitted Request</div>
<br>

<div class="alert alert-info">
	<span class="glyphicon glyphicon-bullhorn"></span>&nbsp; <strong>Info!</strong>
	Sign ID with '0' value means signer has not open the request yet
</div>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-ui:search-container
	emptyResultsMessage="No uploaded document found."
	iteratorURL="<%=iteratorURL%>" delta="10" deltaConfigurable="true">
	<liferay-ui:search-container-results>

		<%
			List<EntDoc> keyList = EntDocLocalServiceUtil.getEntDocs(-1, -1);
					results = ListUtil.subList(keyList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setTotal(keyList.size());
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com._42Penguins.gosign.model.EntDoc" modelVar="docData"
		keyProperty="docId">

		<portlet:renderURL var="viewDocURL">
			<portlet:param name="fileId" value="${docData.fileId}" />
			<portlet:param name="docId" value="${docData.docId}" />
			<portlet:param name="mvcPath" value="/viewDetails.jsp" />
		</portlet:renderURL>

		<portlet:actionURL var="doDelDoc" name="doDelDoc">
			<portlet:param name="docId" value="${docData.docId}" />
		</portlet:actionURL>

		<liferay-ui:search-container-column-text
			value="<%=String.valueOf(row.getPos() + 1)%>" name="No" />

		<liferay-ui:search-container-column-text name="Req ID"
			property="docId">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="User ID"
			property="userId">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Sign ID"
			property="signId">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Created On"
			property="req_dateCreated">
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Deadline"
			property="doc_deadline">
		</liferay-ui:search-container-column-text>
		<c:choose>
			<c:when test="<%=docData.getDoc_status().equals("Pending")%>">
				<liferay-ui:search-container-column-text cssClass="text-primary"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="<%=docData.getDoc_status().equals("Signed")%>">
				<liferay-ui:search-container-column-text cssClass="text-success"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="<%=docData.getDoc_status().equals("Rejected")%>">
				<liferay-ui:search-container-column-text cssClass="text-danger"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="<%=docData.getDoc_status().equals("Expired")%>">
				<liferay-ui:search-container-column-text cssClass="text-muted"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="<%=docData.getDoc_status().equals("Justify")%>">
				<liferay-ui:search-container-column-text cssClass="text-orange"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
			<c:when test="<%=docData.getDoc_status().equals("Verified")%>">
				<liferay-ui:search-container-column-text cssClass="text-info"
					name="Status" property="doc_status">
				</liferay-ui:search-container-column-text>
			</c:when>
		</c:choose>

		<liferay-ui:search-container-column-text name="Action">

			<a href="${viewDocURL}" data-toggle="tooltip" title="View request"><span
				class="glyphicon glyphicon-folder-open text-green"></span></a>
			    &nbsp;
			<a href="${doDelDoc}" data-toggle="tooltip" title="Delete"
				onclick="return confirm('Are you sure you want to delete this request?')"><span
				class="glyphicon glyphicon-remove text-red"></span></a>
		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />

</liferay-ui:search-container>