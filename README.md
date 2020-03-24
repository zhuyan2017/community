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
[Spring](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)

## 工具
[Git](https://git-scm.com/download)
[Visual Paradigm](https://www.visual-paradigm.com)
[Flyway](https://flywaydb.org/)

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
