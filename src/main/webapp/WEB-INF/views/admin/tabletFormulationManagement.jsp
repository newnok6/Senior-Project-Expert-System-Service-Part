<%--
  Created by IntelliJ IDEA.
  User: Panupak
  Date: 5/24/2014
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/foundation.css" />"/>
    <script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
    <title>This is formulation management page</title>
</head>
<body>
<div class="off-canvas-wrap">

    <div class="inner-wrap">


        <nav class="tab-bar">

            <section class="left-small">
                <a class="left-off-canvas-toggle menu-icon"><span></span></a>
            </section>

            <section class="middle tab-bar-section">
                <h1 class="title"><a class="showData" href="#"> Tablet Formulation </a></h1>
            </section>

        </nav>
        <aside class="left-off-canvas-menu">
            <ul class="off-canvas-list">
                <li><label>Tablet Formulation</label></li>

                <li><a class="addTabletFormulation" href="#addTabletFormulationForm">Add Tablet Formulation</a></li>
                <li><a class="editTabletFormulation" href="#editTabletFormuationForm">Edit Tablet Formulation</a></li>
                <li><a class="deleteTabletFormulation" href="#deleteTabletFormulationForm">Delete Tablet Formulation</a>
                </li>


            </ul>
        </aside>

        <section class="main-section">
            <div class="section-inner">
                <div class="scroll-contrainer">
                    <form data-abide id="addTabletFormulationForm" action="addFormulation" method="get">
                        <fieldset>
                            <legend>Add Formulation</legend>
                            <table id="formulationTable">
                                <thead>
                                <tr>
                                    <th width="200">Choose the substance</th>
                                    <th width="200">Choose the substance role</th>
                                    <th width="150">Substance Quantity</th>
                                    <th width="150">Substance Intensity</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="tr_clone">
                                    <td>
                                        <select name="substanceId">
                                            <option value=0>None</option>
                                            <c:forEach var="substance" items="${substanceList}">
                                                <option value="${substance.id}"> ${substance.name}</option>
                                            </c:forEach>
                                        </select>
                                    </td>

                                    <td>
                                        <select name="compoundFunctionId">
                                            <option value=0>None</option>
                                            <c:forEach var="compoundFunction" items="${compoundFunctionList}">
                                                <option value="${compoundFunction.id}"> ${compoundFunction.type}</option>
                                            </c:forEach>
                                        </select>
                                    </td>

                                    <td>
                                        <input type="text" name="substancequantity" pattern="float"
                                               placeholder="2">
                                        <small class="error">The Value Property is float Number.</small>
                                    </td>

                                    <td>

                                        <input type="text" name="substanceintensity" pattern="float"
                                               placeholder="14.65">
                                        <small class="error">The Value Property is float Number.</small>
                                    </td>


                                    <td>
                                        <a href="#" class="medium alert button">Delete</a>

                                    </td>

                                    <td>
                                        <a class="button">Add more</a>
                                    </td>

                                </tr>

                                </tbody>
                            </table>
                            <div align="center">
                                <button type="submit">Submit</button>
                            </div>
                        </fieldset>

                    </form>


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

    $("a.button").click(function () {


        $(this).closest('.tr_clone').clone().insertAfter(".tr_clone:last");

    });

</script>
</body>
</html>
