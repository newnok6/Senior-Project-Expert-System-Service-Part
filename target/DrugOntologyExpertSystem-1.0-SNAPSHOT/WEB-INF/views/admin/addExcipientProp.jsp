<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/22/2014
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/foundation.css" />"/>
    <script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
    <title>Add new excipient property page</title>

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
        <li><label>Excipient Property</label></li>
        <li><a class="solubility" href="#solubilityForm">Solubility</a></li>
        <li><a class="degradationMechanism" href="#degradationMechanismForm">DegradationMechanism</a></li>
        <li><a class="kineticReaction" href="#kineticReactionForm">KineticReaction</a></li>
        <li><a class="pka" href="#pkaForm">Pka</a></li>
        <li><a class="partitionCoefficient" href="#partitionCoefficientForm">PartitionCoefficient</a></li>
        <li><a class="solidstate" href="#solidstateForm">Solidstate</a></li>
        <li><a class="hygroscopicity" href="#hygroscopicityForm">Hygroscopicity</a></li>
        <li><a class="particleSize" href="#particleSizeForm">ParticleSize</a></li>
        <li><a class="flowAbility" href="#flowAbilityForm">FlowAbility</a></li>
        <li><a class="density" href="#densityForm">Density</a></li>

        <li><label>CompoundFunction</label></li>
        <li><a class="compoundFunction" href="#compoundFunctionForm">CompoundFunction</a></li>


    </ul>
</aside>

<section class="main-section">
<div class="section-inner">

<div id="showAllProperty" class="scroll-contrainer">
<h2>Excipient Property Data</h2>


<!-- Show the Solubility in the database on the table ---->
<p><a name="showSolubility"></a></p>

<h3 data-magellan-destination="showSolubility">Solubility Data</h3>

<table>
    <c:forEach var="solubility" items="${solubilityList}">
        <thead>

        <tr>
            <th width="200">Solubility Type</th>
            <th width="200">Solubility Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${solubility.type}</td>
            <td>${solubility.solubilityValueProperty}</td>
        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the Solubility in the database on the table ---->


<h3 data-magellan-destination="showKineticReaction">DegradationMechanism Data</h3>

<table>
    <c:forEach var="degradationMechanism" items="${degradationMechanismList}">
        <thead>

        <tr>
            <th width="200">DegradationMechanism Type</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${degradationMechanism.type}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the Solubility in the database on the table ---->
<p><a name="showKineticReaction"></a></p>

<h3 data-magellan-destination="showKineticReaction">KineticReaction Data</h3>

<table>

    <thead>

    <tr>
        <th width="200">KineticReaction Type</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="kineticReaction" items="${kineticReactionList}">
        <tr>
            <td>${kineticReaction.type}</td>

        </tr>
    </c:forEach>
    </tbody>

</table>
<!----------------------------------------------------------->

<!-- Show the Pka in the database on the table ---->
<p><a name="showPka"></a></p>

<h3 data-magellan-destination="showPka">Pka Data</h3>

<table>
    <c:forEach var="pka" items="${pkaList}">
        <thead>

        <tr>
            <th width="200">Pka Type</th>
            <th width="200">Pka Value</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${pka.type}</td>
            <td>${pka.pkaValue}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the PartitionCoefficient in the database on the table ---->
<p><a name="showPartitionCoefficient"></a></p>

<h3 data-magellan-destination="showPartitionCoefficient">PartitionCoefficien Data</h3>

<table>
    <c:forEach var="partitionCoefficient" items="${partitionCoefficientList}">
        <thead>

        <tr>
            <th width="200">PartitionCoefficient Type</th>
            <th width="200">PartitionCoefficient Value</th>

        </tr>
        </thead>
        <tbody>

        <tr>
            <td>${partitionCoefficient.type}</td>
            <td>${partitionCoefficient.type}</td>
        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the Solidstate data in the database on the table ---->
<p><a name="showSolidstate"></a></p>

<h3 data-magellan-destination="showSolidstate">Solidstate Data</h3>

<table>
    <c:forEach var="solidstate" items="${solidstateList}">
        <thead>

        <tr>
            <th width="200">Solidstate Type</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${solidstate.type}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the Hygroscopicity in the database on the table ---->
<p><a name="showHygroscopicity"></a></p>

<h3 data-magellan-destination="showHygroscopicity">Hygroscopicity Data</h3>

<table>
    <c:forEach var="hygroscopicity" items="${hygroscopicityList}">
        <thead>

        <tr>
            <th width="200">hygroscopicity Type</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${hygroscopicity.type}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the ParticleSize in the database on the table ---->
<p><a name="showParticleSize"></a></p>

<h3 data-magellan-destination="showParticleSize">ParticleSize Data</h3>

<table>
    <c:forEach var="particleSize" items="${particleSizeList}">
        <thead>

        <tr>
            <th width="200">particleSize Type</th>
            <th width="200">particleSize Value</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${particleSize.type}</td>
            <td>${particleSize.valueProperty}</td>
        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the FlowAbility in the database on the table ---->
<p><a name="showFlowAbility"></a></p>

<h3 data-magellan-destination="showFlowAbility">FlowAbility Data</h3>

<table>
    <c:forEach var="flowability" items="${flowabilityList}">
        <thead>

        <tr>
            <th width="200">Flowability Type</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${flowability.type}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

<!-- Show the Density in the database on the table ---->
<p><a name="showDensity"></a></p>

<h3 data-magellan-destination="showDensity">Density Data</h3>

<table>

    <thead>

    <tr>
        <th width="200">Desity Type</th>
        <th width="200">Desity Value</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="desity" items="${desityList}">
        <tr>
            <td>${desity.type}</td>
            <td>${desity.densityValue}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<!----------------------------------------------------------->

<!-- Show the Compuond Function in the database on the table ---->


<h3 data-magellan-destination="showPartitionCoefficient">CompoundFunctionForm Data</h3>

<table>
    <c:forEach var="compoundFunction" items="${compoundFunctionList}">
        <thead>

        <tr>
            <th width="200">Compound Function Type</th>
            <th width="200">Compound Function MinConcarntation Value</th>
            <th width="200">Compound Function MaxConcarntation Value</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${compoundFunction.type}</td>
            <td>${compoundFunction.minconcentrationproperty}</td>
            <td>${compoundFunction.maxconcentrationproperty}</td>

        </tr>

        </tbody>
    </c:forEach>
</table>
<!----------------------------------------------------------->

</div>

<!--------------------------- This is solubility input form--------------------------------------->
<form data-abide id="solubilityForm" style="display: none;" action="addNewSolubility" method="get">
    <fieldset>
        <legend>Add new solubility</legend>
        <div class="large-6 columns">
            <label>Solubility Type
                <small>required</small>
                <input type="text" name="type" pattern="alpha" placeholder="input solubility type here"
                       required>
            </label>
            <small class="error">Name is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>Solubility Value
                <small>required</small>
                <input type="text" name="solubilityValueProperty" pattern="float"
                       placeholder="input solubility value here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>

        <button type="submit">Submit</button>
    </fieldset>
</form>
<!------------------------------------------------------------------------------------------------>


<!-- This is a solidstate input form -->
<form data-abide id="solidstateForm" style="display: none;" action="addNewSolidstate" method="get">
    <fieldset>
        <legend>Add new solidstate</legend>
        <div class="large-6 columns">
            <label>Solidstate Type
                <small>required</small>
                <input type="text" name="ssTypeProperty" pattern="alpha" placeholder="input solidstate type here"
                       required>
            </label>
            <small class="error">Name is required and must be a string.</small>
        </div>


        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a pka input form -->
<form data-abide id="pkaForm" style="display: none;" action="addNewPka" method="get">
    <fieldset>
        <legend>Add new Pka</legend>
        <div class="large-6 columns">
            <label>Pka Type
                <small>required</small>
                <input type="text" name="type" pattern="alpha" placeholder="Input the Pka type here" required>
            </label>
            <small class="error">Name is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>Pka Value
                <small>required</small>
                <input type="text" name="pKaValueProperty" pattern="float"
                       placeholder="input the pka value property here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>
        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a partitionCoefficient input form -->
<form data-abide id="partitionCoefficientForm" style="display: none;" action="addNewPartitionCoefficient" method="get">
    <fieldset>
        <legend>Add new PartitionCoefficient</legend>
        <div class="large-6 columns">
            <label>partitionCoefficient Type
                <small>required</small>
                <input type="text" name="pcTypeProperty" pattern="alpha"
                       placeholder="input the partitionCoefficient type here " required>
            </label>
            <small class="error">Name is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>partitionCoefficient Value
                <small>required</small>
                <input type="text" name="pcValueProperty" pattern="float"
                       placeholder="input the partitionCoefficient value here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>
        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a particleSize input form -->
<form data-abide id="particleSizeForm" style="display: none;" action="addNewParticleSize" method="get">
    <fieldset>
        <legend>Add new ParticleSize</legend>
        <div class="large-6 columns">
            <label>particleSize Type
                <small>required</small>
                <input type="text" name="type" pattern="alpha" placeholder="input the particleSize type here" required>
            </label>
            <small class="error">Name is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>particleSize Value
                <small>required</small>
                <input type="text" name="valueProperty" pattern="float" placeholder="input the particleSize value here"
                       required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>
        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a kineticReaction input form -->
<form data-abide id="kineticReactionForm" style="display: none;" action="addNewKineticReaction" method="get">
    <fieldset>
        <legend>Add new KineticReaction</legend>
        <div class="large-6 columns">
            <label>kineticReaction Type
                <small>required</small>
                <input type="text" pattern="alpha" name="krTypeProperty"
                       placeholder="input the kineticReaction type here" required>
            </label>
            <small class="error">property type is required and must be a string.</small>
        </div>


        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a flowAbility input form -->
<form data-abide id="flowAbilityForm" style="display: none;" action="addNewFlowability" method="get">
    <fieldset>
        <legend>Add new FlowAbility</legend>
        <div class="large-6 columns">
            <label>FlowAbility Type
                <small>required</small>
                <input type="text" name="type" pattern="alpha" placeholder="input the flowAbility type here" required>
            </label>
            <small class="error">Property type is required and must be a string.</small>
        </div>


        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a hygroscopicity input form -->
<form data-abide id="hygroscopicityForm" style="display: none;" action="addNewHygroscopicity" method="get">
    <fieldset>
        <legend>Add new Hygroscopicity</legend>
        <div class="large-6 columns">
            <label>Hygroscopicity Type
                <small>required</small>
                <input type="text" name="type" pattern="alpha" placeholder="input the hygroscopicity type here "
                       required>
            </label>
            <small class="error">Property type is required and must be a string.</small>
        </div>


        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a degradationMechanism input form -->
<form data-abide id="degradationMechanismForm" style="display: none;" action="addNewDegradationMechanism" method="get">
    <fieldset>
        <legend>Add new DegradationMechanismy</legend>
        <div class="large-6 columns">
            <label>DegradationMechanism Type
                <small>required</small>
                <input type="text" pattern="alpha" name="type" placeholder="input the degradationMechanism type here"
                       required>
            </label>
            <small class="error">Property type is required and must be a string.</small>
        </div>


        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->


<!-- This is a density input form -->
<form data-abide id="densityForm" style="display: none;" action="addNewDensity" method="get">
    <fieldset>
        <legend>Add new DegradationMechanism</legend>
        <div class="large-6 columns">
            <label>Density Type
                <small>required</small>
                <input type="text" name="densitytypeproperty" pattern="alpha" placeholder="input the density type here"
                       required>
            </label>
            <small class="error">Property type is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>Density Value
                <small>required</small>
                <input type="text" name="densityvalueproperty" pattern="float"
                       placeholder="input the density value here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>
        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

<!-- This is a Compound Function input form -->
<form data-abide id="compoundFunctionForm" style="display: none;" action="addNewCompoundFunction" method="get">
    <fieldset>
        <legend>Add new DegradationMechanism</legend>
        <div class="large-6 columns">
            <label>CompoundFunction Type
                <small>required</small>
                <input type="text" name="typeproperty" pattern="alpha"
                       placeholder="input the Compound Function type here" required>
            </label>
            <small class="error">Property type is required and must be a string.</small>
        </div>

        <div class="large-6 columns">
            <label>Max Concentration
                <small>required</small>
                <input type="text" name="maxconcentrationproperty" pattern="float"
                       placeholder="input the max concentration value here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>

        <div class="large-6 columns">
            <label>Min Concentration
                <small>required</small>
                <input type="text" name="minconcentrationproperty" pattern="float"
                       placeholder="input the min concentration value here" required>
            </label>
            <small class="error">The Value Property is float Number.</small>
        </div>
        <button type="submit">Submit</button>
    </fieldset>
</form>
<!-------------------------------------->

</div>
</section>

<a class="exit-off-canvas"></a>

</div>

</div>
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/foundation/foundation.topbar.js" />"></script>
<script src="<c:url value="/resources/js/foundation/foundation.abide.js" />"></script>
<script src="<c:url value="/resources/js/foundation/foundation.magellan.js" />"></script>
<script>
    $(document).foundation();
    $(function () { //when the DOM is ready

        $('a.solubility').click(function () { //when clicking the link
            $('#solubilityForm ').show();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#showAllProperty').hide();
        });

        $('a.solidstate').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').show();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#showAllProperty').hide();
        });

        $('a.pka').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').show();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#showAllProperty').hide();
        });

        $('a.partitionCoefficient').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').show();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#showAllProperty').hide();
        });

        $('a.particleSize').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').show();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.kineticReaction').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').show();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.flowAbility').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').show();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.degradationMechanism').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').show();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.hygroscopicity').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').show();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.density').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').show();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').hide();
        });

        $('a.showData').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').hide();
            $('#showAllProperty').show();
        });
        $('a.compoundFunction').click(function () { //when clicking the link
            $('#solubilityForm ').hide();
            $('#solidstateForm ').hide();
            $('#pkaForm').hide();
            $('#partitionCoefficientForm ').hide();
            $('#particleSizeForm ').hide();
            $('#kineticReactionForm').hide();
            $('#flowAbilityForm ').hide();
            $('#hygroscopicityForm ').hide();//toggles visibility
            $('#degradationMechanismForm').hide();//toggles visibility
            $('#densityForm ').hide();//toggles visibility
            $('#compoundFunctionForm').show();
            $('#showAllProperty').hide();
        });

    });
</script>


</body>
</html>
