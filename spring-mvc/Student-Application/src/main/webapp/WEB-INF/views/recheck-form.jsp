<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apply for Recheck</title>
    <!-- Add the Bootstrap CSS link -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script>
        function validateForm() {
            var checkboxes = document.getElementsByName("subjects");
            var isChecked = false;

            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    isChecked = true;
                    break;
                }
            }

            if (!isChecked) {
                alert("Please select at least one subject.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
    <div class="container mt-4">
        <%
        String email = (String) request.getAttribute("email");
        %>

        <h2>Email: <%=email%></h2>
        <form action="recheck-form-data" method="post" onsubmit="return validateForm();">
            <input type="hidden" name="email" value="<%=email%>">

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="java" name="subjects" value="Java">
                <label class="form-check-label" for="java">Java</label>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="javascript" name="subjects" value="JavaScript">
                <label class="form-check-label" for="javascript">JavaScript</label>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="python" name="subjects" value="Python">
                <label class="form-check-label" for="python">Python</label>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="c" name="subjects" value="C">
                <label class="form-check-label" for="c">C</label>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="operatingsystem" name="subjects" value="Operating System">
                <label class="form-check-label" for="operatingsystem">Operating System</label>
            </div>

            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="dbms" name="subjects" value="DBMS">
                <label class="form-check-label" for="dbms">DBMS</label>
            </div>

            <!-- Add more subjects here -->

            <button type="submit" class="btn btn-primary mt-2">Submit</button>
        </form>
    </div>

    <!-- Add the Bootstrap JS and jQuery scripts (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
