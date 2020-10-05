<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Filme</title>
</head>
<body>

    <form action="/cinema/entrada?acao=CadastraFilme" method="post">
        Nome: <input type="text" name="nome"/>
        Nota: <input type="text" name="nota"/>
        Ano: <input type="text" name="ano"/>
        <input type="submit">
   
    </form>
</body>
</html>