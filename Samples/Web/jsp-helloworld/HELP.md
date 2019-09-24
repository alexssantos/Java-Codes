# Link tutorial used.
<https://dzone.com/articles/spring-boot-2-with-jsp-view>


### Dicas

1. WEB-INF funciona dentro de webapp e nao precisa estar necessariamente dentro de "resources".
2. Precisa adicionar as duas dependencias pra JSP que é o tomcat embeded e jasper. (spring web ja tem ele mas parece que tem q deixar explicito)
3. To usando o build por WAR. Nesse exemplo [jsp-spring-boot](https://htr3n.github.io/2018/12/jsp-spring-boot/) ele explica que usar JAR tem alguns problemas com Java WEB.  
4. Erro 1: deu erro na pagina com a nao especificação dos parametros do @RequestParam.
5. Pode dar erro na pagina por questão de rota.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.1.8.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

