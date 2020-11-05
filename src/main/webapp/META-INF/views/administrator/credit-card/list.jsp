<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.creditCard.form.label.holderName" path=".holderName" />
	<acme:list-column code="administrator.creditCard.form.label.number" path="number" />
	<acme:list-column code="administrator.creditCard.form.label.brand" path="brand" />
	<acme:list-column code="administrator.creditCard.form.label.month" path="month" />
	<acme:list-column code="administrator.creditCard.form.label.year" path="year" />
	<acme:list-column code="administrator.creditCard.form.label.cvv" path="cvv" />
</acme:list>


