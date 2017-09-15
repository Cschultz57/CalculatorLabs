<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <div id="wrapper">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Web Calculators</title>
            <link rel="stylesheet" type="text/css" href="calcStyle.css">
        </head>

        <body>
            <h1><u>Web Calculators</u></h1><br>

            <h2>Labs 1-2</h2>
            <h2>Rectangle Area Calculator</h2>
            <img src="rectangleArea.png" alt="rectangle"><br>
            <p>Please enter a length and width.</p>
            <form id="rectangleArea" name="rectangleArea" method="POST" action="calc?calcType=rectArea">
                <label for="length">Length: </label>
                <input type="text" id="length" name="length" value=""><br><br>
                <label for="width">Width: </label>
                <input type ="text" id="width" name="width" value=""><br><br>
                <input type ="submit" name="submit" value="SUBMIT"> 
                <br><br>
                <p> Answer: ${msgAreaRect}</p>
                <label for="resultsCheck">(Lab 1) To output to Results page Check Here:</label>
                <input id="checkBox" type="checkbox" id="resultsCheck" name="resultsCheck">.

            </form><br><br>
            <h2>Lab 3</h2>
            <h2>Circle Area Calculator</h2>
            <img src="circleArea.png" alt="circleArea"><br>
            <p>Please enter the radius of the circle</p>
            <form id="circleArea" name="circleArea" method="POST" action="calc?calcType=circleArea">
                <label for="length">Radius: </label>
                <input type="text" id="radius" name="radius" value=""><br><br>
                <input type="submit" name="submit" value="Submit"><br><br>
                <p>Answer: ${msgAreaCircle}</p>
            </form><br><br>
            <h2> Right Triangle Hypotenuse Calculator</h2>
            <img src="rightTriangle.png" alt="rightTriangle"><br>
            <p> Please enter the lengths of side a and side b</p>
            <form id="rightTriangleHypotenuse" name="rightTriangleHypotenuse" method="POST" action="calc?calcType=rightTriangleHypotenuse">
                <label for="length">Side a: </label>
                <input type="text" id="sideA" name="sideA" value=""><br><br>
                <label for="width">Side b: </label>
                <input type="text" id="sideB" name="sideB" value=""><br><br>
                <input type="submit" name="submit" value="Submit"><br><br>
                <p>Answer: ${msgRightTriangleHypotenuse}</p>
            </form>
        </body>

        <footer>
            <br>2017 Web Calculator<br>
            Carson Schultz Distributed Java<br>
        </footer>
    </div>
</html>