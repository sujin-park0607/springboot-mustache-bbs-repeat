# springboot-mustache-bbs-repeat
mustache 게시판 만들기 복습

## Entity Diagram
![image](https://user-images.githubusercontent.com/101695482/206090899-46c1767c-7354-437c-9280-c514cbb8f97e.png)

## API
| HTTP | URL                           |        설명        |
|:----:|:------------------------------|:----------------:|
| POST | /api/v1/visits                | create, Toekn 인증 |
| GET | /api/v1/visits                |      전체 조회       |
| GET | /api/v1/visits/users/{id}     |  특정 user의 기록 조회  |
| GET | /api/v1/visits/hospitals/{id} |   특정 병원의 기록 조회   |
