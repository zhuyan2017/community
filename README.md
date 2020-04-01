## 学习SpringBoot

## 资料
[Spring](https://spring.io/guides)
[Spring Web](https://spring.io/guides/gs/serving-web-content/)
[es](https://elasticsearch.cn/explore)
[GitHub deploy key](https://developer.github.com/v3/guides/managing-deploy-keys/#deploy-keys)
[Bootstrap](https://v3.bootcss.com/getting_started/)
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/)
[okHttp](https://square.github.io/okhttp/)
[MySQL菜鸟教程](https://www.runoob.com/mysql/mysql-tutorial.html)
[H2](http://www.h2database.com/html/main.html)
[mvn仓库](https://mvnrepository.com/)
[Spring Boot](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
[Mybatis-Spring Boot](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
[jQuery](https://jquery.com/)
[Spring MVC(学习拦截器)](https://docs.spring.io/spring/docs/5.0.3.RELEASE/spring-framework-reference/web.html#mvc-servlet-sequence)

## 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/)
[Lombok](https://projectlombok.org/)

## 脚本
```sql
create table USER
(
    ID           INT auto_increment primary key not null,
    ACCOUNT_ID   VARCHAR(100),
    NAME         VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
);
```
```bash
mvn flyway:migrate
```
