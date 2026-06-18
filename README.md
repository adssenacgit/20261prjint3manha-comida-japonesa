# Backend Java 21 + Spring Boot + MySQL

Projeto REST criado com Java 21, Spring Boot, Spring Data JPA, MySQL e Swagger/OpenAPI.

## Versões usadas

- Java 21
- Spring Boot 3.5.15
- Maven
- MySQL Connector/J 8.0.32
- springdoc-openapi-starter-webmvc-ui 2.8.17

## Observação importante sobre exclusão lógica

A exclusão lógica foi implementada nas tabelas que possuem campo de status numérico na estrutura SQL enviada:

- `admin.admin_status`
- `cliente.cliente_status`
- `produto.produto_status`

Nessas tabelas:

- `1` = ativo
- `0` = inativo
- `-1` = apagado logicamente

O endpoint `DELETE` dessas entidades não remove o registro fisicamente: ele altera o status para `-1`.

As tabelas que não possuem campo numérico de status no SQL original continuam com exclusão física no endpoint `DELETE`, para não quebrar a compatibilidade com a estrutura enviada. Em `pedido` e `pagamento`, o campo `status` é de regra de negócio, com valores `pendente`, `pago`, `aprovado` etc., por isso ele não foi usado para `-1`, `0` e `1`.

## Como rodar

### 1. Subir MySQL local com Docker

```bash
docker compose up -d
```

O Docker já executa o script `database/schema.sql` na primeira criação do volume.

### 2. Configurar banco

O arquivo está em:

```text
src/main/resources/application.properties
```

Por padrão:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/20261_prjint3_manha_michaeloliveira?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=latin1
spring.datasource.username=root
spring.datasource.password=root
```

Para usar o banco remoto do Senac, altere `localhost`, usuário e senha no `application.properties`.

### 3. Rodar aplicação

```bash
mvn spring-boot:run
```

## Swagger

Depois de subir a aplicação, acesse:

```text
http://localhost:8080/swagger-ui.html
```

Documentação OpenAPI em JSON:

```text
http://localhost:8080/v3/api-docs
```

## Endpoints CRUD

| Entidade | Endpoint |
|---|---|
| Admin | `/api/admins` |
| Categoria | `/api/categorias` |
| Cliente | `/api/clientes` |
| Endereço do cliente | `/api/enderecos-clientes` |
| Estoque | `/api/estoques` |
| Item do pedido | `/api/itens-pedidos` |
| Movimentação de estoque | `/api/movimentacoes-estoque` |
| Pagamento | `/api/pagamentos` |
| Pedido | `/api/pedidos` |
| Produto | `/api/produtos` |
| Tipo de cliente | `/api/tipos-clientes` |

Cada endpoint possui:

```text
GET     /api/recurso
GET     /api/recurso/{id}
POST    /api/recurso
PUT     /api/recurso/{id}
DELETE  /api/recurso/{id}
PATCH   /api/recurso/{id}/ativar
PATCH   /api/recurso/{id}/inativar
```

Os endpoints `ativar` e `inativar` só funcionam nas entidades com status numérico: Admin, Cliente e Produto.

## Exemplos de JSON

### Criar categoria

```json
{
  "nome": "Eletrônicos",
  "descricao": "Produtos eletrônicos em geral"
}
```

### Criar tipo de cliente

```json
{
  "nome": "Pessoa Física",
  "descricao": "Cliente com CPF"
}
```

### Criar cliente

```json
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "senha": "123456",
  "telefone": "21999999999",
  "cpf": "12345678900",
  "tipoCliente": {
    "id": 1
  },
  "status": 1
}
```

### Criar produto

```json
{
  "nome": "Notebook",
  "descricao": "Notebook para estudos",
  "preco": 3500.00,
  "imagem": "notebook.png",
  "categoria": {
    "id": 1
  },
  "status": 1
}
```

### Criar estoque

```json
{
  "produto": {
    "id": 1
  },
  "quantidade": 10,
  "minimo": 5
}
```

### Criar pedido

```json
{
  "cliente": {
    "id": 1
  },
  "total": 3500.00,
  "status": "pendente"
}
```

### Criar item do pedido

```json
{
  "pedido": {
    "id": 1
  },
  "produto": {
    "id": 1
  },
  "quantidade": 1,
  "preco": 3500.00
}
```

### Criar pagamento

```json
{
  "pedido": {
    "id": 1
  },
  "metodo": "pix",
  "status": "pendente",
  "valor": 3500.00
}
```

### Criar movimentação de estoque

```json
{
  "produto": {
    "id": 1
  },
  "tipo": "entrada",
  "quantidade": 10,
  "motivo": "Compra inicial"
}
```
