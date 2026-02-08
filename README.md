# vacation-calculator
Калькулятор отпускных 

Приложение для расчета отпускных с учетом праздничных и выходных дней.

## Технологии
- Spring Boot 4.0.2
- Java 17
- Maven

## Как запустить
1. Открыть проект в IntelliJ IDEA
2. Запустить класс `VacationCalculatorApplication`
3. Открыть в браузере: http://localhost:8080

## Endpoint API
GET calculate?averageSalary=60000&vacationDays=14

## Структура проекта
- controller — REST контроллер
- service — бизнес-логика расчетов
- model — модели запроса и ответа
- util — утилита для работы с праздниками
