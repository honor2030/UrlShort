# make short url
+ URL에 대한 short URL을 반환하는 서비스입니다
+ short URL입력시 원래 URL로 페이지를 이동시킵니다

## 프로젝트 설명

### 요구사항
+ URL 입력폼 제공 및 결과 출력
+ URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
+ 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
+ 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
+ Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
+ Database 사용은 필수 아님

### 사용 기술
+ Spring Boot Web MVC 2.4.3
+ Spring Data JPA 2.4.3
+ Spring Boot devtools 2.4.3
+ Spring Boot thymeleaf 2.4.3
+ Lombok 1.18.18
+ h2 1.4.200

### 기술적인 집중 요소
+ 유지보수가 용이하도록 lombok을 통한 코드 단순화
+ 입력 URL에 대한 Validation 체크
+ 추후 예외처리를 용이하도록 RestControllerAdviser 사용하여 전역 예외처리

### 설치 및 빌드방법
1. git clone https://github.com/honor2030/UrlShort.git
2. cd UrlShort 로 이동
3. ./gradlew bootjar 실행
4. cd ./build/libs/ 로 이동
5. java -jar urlshort-0.0.1-SNAPSHOT.jar 로 실행
