# grpc-tutorial
## client和server都加入TLS
```sbtshell
# 因为不需要第三方认证机构，所以在这里需要自建一个CA

# 生成CA的私钥，私钥的密码简单起见是123456
openssl genrsa -aes256 -out ca.key 4096
# 根据CA的私钥，生成CA的根证书
openssl req -new -x509 -sha256 -days 730 -key ca.key -out ca.crt

# 生成server端的证书

# 生成server端私钥
openssl genrsa -out server.key 2048
# 生成server端 证书注册请求(Certificate Signing Request)
openssl genrsa -out server.key 2048
# 根据server端证书注册请求生成证书，证书中有server端的公钥
openssl x509 -req -days 365 -sha256 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 1 -out server.crt
# 将私钥转换成pkcs8形式
openssl pkcs8 -topk8 -inform pem -in server.key -outform pem -nocrypt -out server.pem

# 生成client端的证书，与server的流程一样
openssl genrsa -out client.key 2048
openssl req -new -key client.key -out client.csr
openssl x509 -req -days 365 -sha256 -in client.csr -CA ca.crt -CAkey ca.key -set_serial 2 -out client.crt
openssl pkcs8 -topk8 -inform pem -in client.key -outform pem -nocrypt -out client.pem
```