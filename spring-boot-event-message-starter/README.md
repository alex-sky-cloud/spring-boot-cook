### Создание пользовательского starter. Сборщик - **maven**.

**Spring-boot-starter** будет обеспечивать следующие функции:

-	**EventPublisher**, это компонент, который позволяет нам отправлять события 
в центральную инфраструктуру обмена сообщениями (events to a central messaging infrastructure)

-	Абстрактный класс **EventListener**, который можно реализовать, 
чтобы "подписаться" на определенные события из центральной инфраструктуры 
обмена сообщениями (certain events from the central messaging infrastructure).