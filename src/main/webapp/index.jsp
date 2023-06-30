<!DOCTYPE html>
<html>
<head>
    <title>Online Banking System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        h1 {
            color: #333;
        }

        p {
            color: #666;
        }

        .option-button {
            margin: 10px;
        }

        .option-button input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        .option-button input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<h1>Welcome to the Online Banking System</h1>
<p>Please select an option:</p>

<div class="option-button">
    <form action="http://localhost:8080/OnlineBankingSystem/login">
        <input type="submit" value="Login" />
    </form>
</div>

<div class="option-button">
    <form action="http://localhost:8080/OnlineBankingSystem/signup">
        <input type="submit" value="Sign Up" />
    </form>
</div>
</body>
</html>
