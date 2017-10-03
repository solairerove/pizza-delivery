# pizza-delivery
Graph oriented pizza delivery prototype

### How to start:

* `docker-compose up -d`
* `./gradlew bootRun`
* `http://localhost:7474/browser/`
* `http://localhost:9090`

### Insert into collection

```bash
curl -i -X PUT -H "Content-Type:text/uri-list" -d "http://localhost:9090/nodes/2" http://localhost:9090/nodes/1/outgoing
```
