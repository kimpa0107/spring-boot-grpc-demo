# Spring Boot gRPC demo

### build proto

```bash
cd blog-common
mvn clean install
```

### start server

```bash
IntelliJ IDEA start server
```

#### request

```bash
grpcurl --plaintext localhost:9090 com.jasper.grpc.BlogService/GetArticles
```

#### response

```json
{
  "items": [
    {
      "id": "article-1",
      "title": "Article - 1",
      "category": {
        "id": 1,
        "name": "Java"
      }
    },
    {
      "id": "article-2",
      "title": "Article - 2",
      "category": {
        "id": 1,
        "name": "Java"
      }
    }
  ],
  "extra": {
    "page": 1,
    "size": 10,
    "total": 100
  }
}
```