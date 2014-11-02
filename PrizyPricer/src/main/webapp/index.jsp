<!DOCTYPE html>
<html>
<body>

<form action="http://localhost:8080/PrizyPricer/addproductcost" method="post" >
 Store <input type="text" name="pstore"><br>
 Product bar code : <input type="text" name="pbarcode"><br>
 Price <input type="text" name="pprice"><br> 
 Notes <input type="text" name="pnotes"><br>
  <input type="submit" value="update">
</form>

<p>Click on the submit button, and the input will be sent to a page on the server called.</p>




<form action="http://localhost:8080/PrizyPricer/addproduct" method="post" >
 
 Product bar code : <input type="text" name="pbarcode"><br>
 
 Description <input type="text" name="pnotes"><br>
  <input type="submit" value="update">
</form>

</body>
</html>