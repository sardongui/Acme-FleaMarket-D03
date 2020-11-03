<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-url code="administrator.banner.form.label.target" path="target"/>
	<br/>
	<fieldset>
	<legend><acme:message code="administrator.banner.creditCard.form.legend.creditCard"/></legend>
	<acme:form-textbox code="administrator.banner.creditCard.form.label.holderName" path="creditCard.holderName"/>
	<acme:form-textbox code="administrator.banner.creditCard.form.label.number" path="creditCard.number" placeholder="1111 2222 3333 4444" />
	<acme:form-textbox code="administrator.banner.creditCard.form.label.brand" path="creditCard.brand"/>
	<acme:form-integer code="administrator.banner.creditCard.form.label.month" path="creditCard.month" placeholder="mm" />
	<acme:form-integer code="administrator.banner.creditCard.form.label.year" path="creditCard.year" placeholder="yyyy" />
	<acme:form-integer code="administrator.banner.creditCard.form.label.cvv" path="creditCard.cvv" placeholder="XXXX"/>
	</fieldset>
	
	<acme:form-submit test="${command == 'show' }"
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'show' }"
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
	<acme:form-submit test="${command == 'create' }"
		code="administrator.banner.form.button.create" 
		action="/administrator/banner/create"/>
	<acme:form-submit test="${command == 'update' }"
		code="administrator.banner.form.button.update" 
		action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'delete' }"
		code="administrator.banner.form.button.delete" 
		action="/administrator/banner/delete"/>
			
	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>
