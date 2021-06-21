<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%
String loggedInUsername = (String)session.getAttribute("LOGGED_IN_USER");
String loggedInAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
%>

<header>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
  <a class="navbar-brand" href="#">PIZZA DELIVERY APP</a>
  <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
      aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavId">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ListProducts.jsp">List Of products <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdownId">
          <a class="dropdown-item" href="#">Action 1</a>
          <a class="dropdown-item" href="#">Action 2</a>
        </div>
      </li>
    </ul>
    <%if(loggedInUsername == null && loggedInAdmin == null ){ %>
     <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="Adminlogin.jsp"> Admin Login</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="UserLogin.jsp">User Login</a>
      </li>
      </ul>
      <%}else{ 
      if(loggedInUsername != null){
      %>
       <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#"> Welcome <%=loggedInUsername%></a>
      </li>
      <li class="nav-item"><a class="nav-link"
					href="MyOrderServlet">My Orders</a></li>
      <%}else{ %>
      <li class="nav-item active">
        <a class="nav-link" href="#"> Welcome <%=loggedInAdmin%></a>
      </li>
      <%} %>
      <li class="nav-item">
        <a class="nav-link" href="LogoutServlet">Logout</a>
      </li>
      </ul>
      <%} %>
   
  </div>
</nav>
</header>