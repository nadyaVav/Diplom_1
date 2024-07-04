# Diplom 1
Проект для задания 1: юнит-тесты для приложения, в котором можно заказать бургер Stellar Burgers.   
Репозиторий с исходным кодом приложения был слонирован с https://github.com/yandex-praktikum/QA-java-diplom-1

## Технологии
- java 11
- JUnit 4.13.1
- maven 3.8.1
- mockito-core 3.12.4
- jacoco 0.8.7
- javafaker 0.15

## Запуск
```shell
mvn clean test
```

## Формирование отчета о покрытии
```shell
mvn verify
```
Отчет будет находиться по пути /target/site/jacoco/