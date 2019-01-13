# example-websocket-broadcast-echo-scala

An example of a broadcast echo server of WebSocket using Play Frameworks w/ Scala.

## Usages

Run server:

```sh
sbt run
# [info] p.c.s.AkkaHttpServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
# 
# (Server started, use Enter to stop and go back to the console...)
```

Connect:

```sh
websocat ws://localhost:9000
# Type anything.
```

This example is used [websocat](https://github.com/vi/websocat). Alternatively, You can use [wscat](https://github.com/websockets/wscat).

## License

```
Copyright 2019 Shuma Yoshioka

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
