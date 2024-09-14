<%@ page import="java.util.List" %>
<%@ page import="com.hluther.entity.Advertisement" %>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Propietario</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Fecha Creacion</th>
            <th>Duracion</th>
            <th>Tipo</th>
            <th>Activo</th>
        </tr>
    </thead>
    <tbody>
        <%
            List<Advertisement> advertisementList= (List<Advertisement>) request.getAttribute("advertisementList");

            if (advertisementList != null && !advertisementList.isEmpty()) {
                for (Advertisement currentAdvertisement : advertisementList) {
                    out.write("<tr>");
                    out.write("<td>" + currentAdvertisement.getId() + "</td>");
                    out.write("<td>" + currentAdvertisement.getOwner() + "</td>");
                    out.write("<td>" + currentAdvertisement.getTitle() + "</td>");
                    out.write("<td>" + currentAdvertisement.getPrice() + "</td>");
                    out.write("<td>" + currentAdvertisement.getStartDate() + "</td>");
                    out.write("<td>" + currentAdvertisement.getDuration() + "</td>");
                     out.write("<td>" + currentAdvertisement.getType() + "</td>");
                    out.write("<td>" + (currentAdvertisement.getActive() ? "Si" : "No") + "</td>");
                    out.write("</tr>");
                }
            } else {
                out.write("<tr><td colspan='7'>No advertisements found</td></tr>");
            }
        %>
    </tbody>
</table>
