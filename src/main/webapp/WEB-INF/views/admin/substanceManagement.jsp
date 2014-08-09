<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/23/2014
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/foundation.css" />"/>
    <script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
    <title>Manage the substance</title>
</head>
<body>
<div class="off-canvas-wrap">

<div class="inner-wrap">

<nav class="tab-bar">

    <section class="left-small">
        <a class="left-off-canvas-toggle menu-icon"><span></span></a>
    </section>

    <section class="middle tab-bar-section">
        <h1 class="title"><a class="showData" href="#"> Exipient Property></a></h1>
    </section>

</nav>
<aside class="left-off-canvas-menu">
    <ul class="off-canvas-list">
        <li><label>Substance Management</label></li>

        <li><a class="addSubstance" href="#addSubstanceForm">Add new substance</a></li>
        <li><a class="editSubstance" href="#editSubstanceForm">Edit a substance</a></li>
        <li><a class="deleteSubstance" href="#deleteSubstanceForm">Delete the substance</a></li>


    </ul>
</aside>

<section class="main-section">
<div class="section-inner">
<div class="scroll-contrainer">
<!--------------------------- This is Add new Substance form--------------------------------------->
<form data-abide id="addSubstanceForm" action="addSubstance" method="get">
<fieldset>
<legend>Add Substamce</legend>
<div class="row">
    <div class="large-6 columns">
        <label>Substance Name:
            <small>required</small>
            <input type="text" name="name" pattern="alpha" placeholder="SubstanceA"
                   required>
        </label>
        <small class="error">Name is required and must be a string.</small>
    </div>
</div>

<div class="row">
    <div class="large-6 columns">

        <label>Water Solubility
            <select name="waterSolubilityId">
                <option value=0>None</option>
                <c:forEach var="solubility" items="${solubilityList}">
                    <option value="${solubility.id}"> ${solubility.type}</option>
                </c:forEach>


            </select>
        </label>

    </div>
</div>
<label>Stability</label>

<div class="row">

    <div class="large-6 columns">
        <label>Kinetic Creation
            <select name="kineticCrId">
                <option value=0>None</option>
                <c:forEach var="kineticReaction" items="${kineticReactionList}">
                    <option value="${kineticReaction.id}">${kineticReaction.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">
    <div class="large-6 columns">
        <label>Degradation Mechanism
            <label>Check these out</label>
            <c:forEach var="degradationMechanism" items="${degradationMechanismList}">
                <input id="checkbox1" type="checkbox" name="degraId" value="${degradationMechanism.id}"><label
                    for="checkbox1">${degradationMechanism.type}</label>
            </c:forEach>

        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Dissolution Property
            <select name="disProId">
                <option value=0>None</option>
                <c:forEach var="pka" items="${PkaList}">
                    <option value="${pka.id}">${pka.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Partition Coefficient
            <select name="partCoId">
                <option value=0>None</option>
                <c:forEach var="partitionCoefficient" items="${partitionCoefficientList}">
                    <option value="${partitionCoefficient.id}">${partitionCoefficient.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Physical Form
            <select name="phyId">
                <option value=0>None</option>
                <c:forEach var="solidstate" items="${solidstateList}">
                    <option value="${solidstate.id}">${solidstate.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Hygroscopitity
            <select name="hygroId">
                <option value=0>None</option>
                <c:forEach var="hygroscopicity" items="${hygroscopicityList}">
                    <option value="${hygroscopicity.id}">${hygroscopicity.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Particle Size
            <select name="particleId">
                <option value=0>None</option>
                <c:forEach var="particleSize" items="${particleSizeList}">
                    <option value="${particleSize.id}">${particleSize.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Alcohol Solubility Property
            <select name="alcoholId">
                <option value=0>None</option>
                <c:forEach var="solubility" items="${solubilityList}">
                    <option value="${solubility.id}">${solubility.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Flowability
            <select name="flowablityId">
                <option value=0>None</option>
                <c:forEach var="flowability" items="${flowabilityList}">
                    <option value="${flowability.id}">${flowability.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="row">

    <div class="large-6 columns">
        <label>Desity
            <select name="desityId">
                <option value=0>None</option>
                <c:forEach var="desity" items="${desityList}">
                    <option value="${desity.id}">${desity.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>
<div class="row">

    <div class="large-6 columns">
        <label>MolecularWeightProperty
            <small>required</small>
            <input type="text" name="molecularWeight" pattern="float"
                   placeholder="2.35" required>
        </label>
        <small class="error">The Value Property is float Number.</small>
    </div>
    <div class="large-6 columns">
        <label>PKa Property
            <select name="pkaPro">
                <option value=0>None</option>
                <c:forEach var="pka" items="${PkaList}">
                    <option value="${pka.id}">${pka.type}</option>
                </c:forEach>
            </select>
        </label>

    </div>
</div>

<div class="large-6 columns">
    <label>WeightProperty
        <small>required</small>
        <input type="text" name="weightproperty" pattern="float"
               placeholder="2.35" required>
    </label>
    <small class="error">The Value Property is float Number.</small>
</div>

<div class="row">
    <div class="large-6 columns">
        <label>Ionicity
            <small>required</small>
            <input type="text" name="lonicity" pattern="alpha" placeholder="LogicalFP"
                   required>
        </label>
        <small class="error">Name is required and must be a string.</small>
    </div>
</div>

<button type="submit">Submit</button>
</fieldset>
</form>
<!------------------------------------------------------------------------------------------------>
</div>
</div>
</section>
</div>

</div>


<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/foundation/foundation.topbar.js" />"></script>
<script src="<c:url value="/resources/js/foundation/foundation.abide.js" />"></script>
<script>
    $(document).foundation();
</script>

</body>
</html>
