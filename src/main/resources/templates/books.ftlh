<html lang="en">
<head>
    <link rel="stylesheet" href="/books.css", type="text/css">
</head>
<body>
<div class="container">
    <h2>Books</h2>
    <ul class="responsive-table">
        <li class="table-header">
            <div class="col col-1">id</div>
            <div class="col col-2">name</div>
            <div class="col col-3">genre</div>
        </li>
        <#list books as book>
            <li class="table-row">
                <div class="col col-1">${book.id}</div>
                <div class="col col-2">${book.name}</div>
                <div class="col col-3">${book.genre}</div>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>