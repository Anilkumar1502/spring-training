<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bit Coin Rates</title>
<style>
        table {
            margin: 0 auto;
            font-size: large;
            border: 1px solid black;
        }
  
        h1 {
            text-align: center;
            color: #006600;
            font-size: xx-large;
            font-family: 'Gill Sans', 
                'Gill Sans MT', ' Calibri', 
                'Trebuchet MS', 'sans-serif';
        }
  
        td {
            background-color: #E4F5D4;
            border: 1px solid black;
        }
  
        th,
        td {
            font-weight: bold;
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
  
        td {
            font-weight: lighter;
        }
    </style>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script>
      $(document).ready(function(){
    	// fetch json data from api
          $.getJSON("https://bitpay.com/api/rates", function(bitresult){
        	  var bitdata='';
        	  //iteration tru objects
             $.each(bitresult, function(key,value) {
            	 // construction of rows having data from json
            	 bitdata +='<tr>';
            		bitdata +='<td>' + value.code + '</td>';
            	 	bitdata +='<td>' + value.name + '</td>';
            	 	bitdata +='<td>' + value.rate + '</td>';
            	 bitdata +='</tr>';
             });
        	  //inserting rows
            	 $('#table').append(bitdata);
             }); 
          });
       </script>
</head>
<body>
<div>
		<h1>Bit Coin Currency Rates  - BitPay.com</h1>
      
        <table id='table'>
         
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Rate</th>
            </tr>
	</table>
	<br>
	<br>
	<div align="center"><a href="https://bitpay.com/api/rates">Data Sourced from BitPay</a></div>
	</div>
</body>
</html>