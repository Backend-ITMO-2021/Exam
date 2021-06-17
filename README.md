
# Exam
Все задания сдаются как пулл-реквест к этому репозиторию.
Дедлайн 24/06 00:01, после чего решения не принимаются.
## На 60 баллов - SpringChat
Задание выполняется на Java с использованием Spring. 
Требуется реализовать приложение чата.
 1. Пользователь проходит регистрацию, после чего заходит со своими кредами.
 2. Приложение состоит из одной общей комнаты, где все пользователи могут отправлять сообщения.
 3. У сообщений отображается время отправки, порядковый номер в системе, имя пользователя, отправившего сообщение и текст сообщения.
 4. Каждый пользователь может:
	 1. Отправить новое сообщение
	 2. Ответить на определённое сообщение по его id, сообщения являющиеся ответом могут отображаться как #5 -> #1 (пятое сообщение отвечает на первое)
	 3. Отслеживать сообщения определённого пользователя (фильтр по имени пользователя)

Примеры внешнего вида интерфейса есть в [тут](https://github.com/Backend-ITMO-2021/Lecture-8).
Каждое новое сообщение появляется на странице у пользователя без обновления страницы и любых других действий. Все сообщения должны хранится в базе данных.
Так же ваше приложение должно поддерживать API:
|description|method|url|body|response|
|--|--|--|--|--|
|gets all messages from specific user|GET|/messages/$username|  |{messages: ["message 1", "message 2", ...]}|
|top 10 chatters by messages count|GET|/stats/top| |{top: [{username: "user", count: 239}, ...]}|
|gets all current messages, filtered by date (date filter is optional)|GET|/all-messages|{from:?$date, to:?$date}|{messages: [{id: id, username: "user", message: "message", replyTo:? optionalInt}, ...]}|

Приложение требуется выложить на любой публичный сервис (рекомендую Heroku), в пулреквесте к репозиторию нужно приложить весь код приложения, запись демо работы приложения и ссылку на публичный доступ к вашему приложению.

