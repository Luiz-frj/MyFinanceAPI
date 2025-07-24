<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Documentação MyFinanceAPI</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; line-height: 1.6; }
        h1 { color: #2c3e50; }
        h2 { color: #34495e; margin-top: 40px; }
        code { background-color: #f4f4f4; padding: 2px 6px; border-radius: 4px; }
        pre { background: #f9f9f9; padding: 10px; border-left: 3px solid #ccc; }
    </style>
</head>
<body>
    <h1>Documentação MyFinanceAPI</h1>
    <p><strong>Autor:</strong> Luiz Francisco Rodrigues Junior</p>
    <hr>
    <pre>Documentação MyFinanceAPI
Luiz Francisco Rodrigues Junior

1. GET /transactions/paginated – Listar transações paginadas
Descrição: Retorna uma lista de transações com paginação.
Método HTTP: GET
Endpoint: /transactions/paginated?page=0
Parâmetros de query:
● page (número) – número da página (começa em 0).
Códigos de resposta:
● 200 OK – Lista de transações retornada com sucesso.
● 500 Internal Server Error – Erro ao buscar as transações.

2. GET /transactions/categoria/{categoria} – Filtrar por categoria
Descrição: Retorna transações com base na categoria especificada.
Método HTTP: GET
Endpoint: /transactions/categoria/Alimentação
Códigos de resposta:
● 200 OK – Transações filtradas retornadas.
● 404 Not Found – Nenhuma transação encontrada.
● 500 Internal Server Error – Erro ao buscar os dados.

3. GET /transactions/tipo/{tipo} – Filtrar por tipo
Descrição: Retorna transações do tipo receita ou despesa.
Método HTTP: GET
Endpoint: /transactions/tipo/receita

4. GET /transactions/categoriaetipo/{categoria}+{tipo} – Filtro combinado
Descrição: Filtra transações por categoria e tipo ao mesmo tempo.
Método HTTP: GET
Exemplo de endpoint: /transactions/categoriaetipo/Alimentação+despesa

5. POST /transactions – Criar nova transação
Descrição: Cadastra uma nova transação no banco de dados.
Método HTTP: POST
Endpoint: /transactions
Corpo da requisição (JSON):
{
  "descricao": "Compra no mercado",
  "valor": 150.75,
  "tipo": "despesa",
  "categoria": "Alimentação",
  "data_criacao": "2025-07-04"
}
Códigos de resposta:
● 201 Created – Transação criada com sucesso.
● 400 Bad Request – Dados ausentes ou inválidos.
● 500 Internal Server Error – Erro ao persistir os dados.

6. PUT /transactions/{id} – Atualizar transação
Descrição: Atualiza uma transação existente.
Método HTTP: PUT
Endpoint: /transactions/3
Corpo da requisição (JSON):
{
  "descricao": "Aluguel atualizado",
  "valor": 2500.00,
  "tipo": "despesa",
  "categoria": "Moradia"
}
Códigos de resposta:
● 200 OK – Transação atualizada.
● 404 Not Found – ID não encontrado.
● 400 Bad Request – Dados inválidos.
● 500 Internal Server Error – Erro ao salvar.

7. DELETE /transactions/{id} – Deletar transação
Descrição: Remove uma transação pelo ID.
Método HTTP: DELETE
Endpoint: /transactions/5
Códigos de resposta:
● 204 No Content – Transação deletada com sucesso.
● 404 Not Found – Transação não encontrada.
● 500 Internal Server Error – Erro ao excluir.

8. GET /transactions/resumo – Resumo financeiro
Descrição: Retorna um resumo com total de receitas, despesas e saldo.
Método HTTP: GET
Endpoint: /transactions/resumo
Exemplo de resposta:
{
  "totalReceitas": 2000.00,
  "totalDespesas": 1500.00,
  "saldoAtual": 500.00,
  "receitasPorCategoria": {
    "Salário": 2000.00
  },
  "despesasPorCategoria": {
    "Alimentação": 500.00,
    "Moradia": 1000.00
  }
}
Códigos de resposta:
● 200 OK – Resumo retornado com sucesso.
● 500 Internal Server Error – Erro ao calcular o resumo.</pre>
</body>
</html>
