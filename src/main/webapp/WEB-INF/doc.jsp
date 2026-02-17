<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentation Page</title>
    <link rel="stylesheet" href="css/docStyle.css">
</head>
<body>

	<div class="logo"></div>

	<%
  	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
	if(session.getAttribute("unm") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
 	%>

    <nav class="hdr">
	    <a href="courses"><button class="b1"></button></a>
	    <a href="HomeIndex"><button class="bb"></button></a>
	    <a href="profile"><button class="bc"></button></a>
	    <a href="ChatIndex"><button class="cr"></button></a>
  	</nav>
    
    <%
    	HttpSession docSession = request.getSession();
    	Integer score = (Integer) docSession.getAttribute("score");
    %>

    <nav class="score">
        <h3>XP : </h3> <h3 id="score"><%= score %></h3>
    </nav>

    <nav class="hd">
        
            <button class="btn" href="#java" onclick="jv()">Java</button>
            <button class="btn" href="#cs" onclick="cs()">C#</button>
            <button class="btn" href="" onclick="shw()">JavaScript</button>
            <button class="btn" href="" onclick="shw()">OS</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">DSA</button></li>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
            <button class="btn" href="" onclick="shw()">Structure Machine</button>
        
    </nav>

    <nav class="java container" id="java">
        <h2>Java</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. 
            Optio ea a sint nisi consequuntur nostrum exercitationem consectetur obcaecati ducimus quae atque,
            cupiditate commodi saepe eius ipsa. Dolorem sit dicta iste.
        </p>
        <pre class="cd">
            <code>
                public static void main(String[] args){
                    System.out.println("Hello Friend !");
                }
            </code>
        </pre>
        <h2>Java</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. 
            Optio ea a sint nisi consequuntur nostrum exercitationem consectetur obcaecati ducimus quae atque,
            cupiditate commodi saepe eius ipsa. Dolorem sit dicta iste.
        </p>
        <pre class="cd">
            <code>
                public static void main(String[] args){
                    System.out.println("Hello Friend !");
                }
            </code>
        </pre>
        <h2>Java</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. 
            Optio ea a sint nisi consequuntur nostrum exercitationem consectetur obcaecati ducimus quae atque,
            cupiditate commodi saepe eius ipsa. Dolorem sit dicta iste.
        </p>
        <pre class="cd">
            <code>
                public static void main(String[] args){
                    System.out.println("Hello Friend !");
                }
            </code>
        </pre>
    </nav>

    <nav class="cs container" id="cs">
        <h2>C#</h2>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. 
            Optio ea a sint nisi consequuntur nostrum exercitationem consectetur obcaecati ducimus quae atque,
            cupiditate commodi saepe eius ipsa. Dolorem sit dicta iste.
            <pre class="cd">
            <code>
                public static void main(String[] args){
                    Console.println("Hello Friend !");
                }
            </code>
        	</pre>
        </p>
    </nav>

    <nav class="end container" id="end">
        This Course Ends Here !
    </nav>

    <nav class="back">
        <nav class="front">
        	<form action="ScoreUpdateServlet" method="post">
	            <p>Congratulations<br>
	            You've Finished the Course ! <br></p>
	            <input type="submit" id="msgbx" onclick="closeBx()" value="OK">
            </form>
        </nav>
    </nav>

    <script src="css/docScript.js"></script>
</body>
</html>