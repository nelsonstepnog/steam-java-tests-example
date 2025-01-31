# steam-java-tests-example

Здесь Вы можете видеть небольшой пример API и UI-автотестов, написанных на Java с использованием Allure, Rest Assured + JUnit, Selenium WebDriver и паттерна PageObject. Приемочные тесты в пакете com.steam.frontend. В пакете com.backend.tests находятся АПИ тесты, так же для примера. Все тесты в данном репозитории представлены как ознакомительные, чтобы посмотреть на код. Тесты можно прогонять.

Команды выполняются в корне проекта.
------------------------------------

- Запуск всех тестов:
$ mvn clean test site

- Запуск конкретного набора тестов с указанием названия класса:
$ mvn clean test -Dtest=com.uitests.frontend.tests.ThisClassName site

- Сгенерировать отчет в Allure. После генерации отчет будет лежать по пути /src/test/java/com/resources/allure/tests-results необходимо в браузере открыть файл index.html:
$ mvn allure:report

- Либо второй вариант генерации отчета в Allure. Выполнить данную команду, после чего страница с отчетом откроется в браузере автоматически:
$ mvn allure:serve
