# Проект "ForumXpress"

## Описание
Проект "ForumXpress" представляет собой простой движок форума/доски объявлений, реализованный на Java с использованием фреймворка Spring Boot для создания RESTful API. В качестве базы данных используется in-memory база данных H2.

## Безопасность
Для обеспечения безопасности доступа к различным операциям API, в проекте применяется Spring Security. Роли пользователей определены таким образом, что различные операции доступны в зависимости от роли. Например, администратор (ADMIN) имеет полные права на выполнение операций, в то время как редактор (EDITOR) имеет доступ только к чтению и редактированию тем, а обычные пользователи (VIEWER) могут только просматривать содержимое.

## Возможности администратора
Чтобы облегчить тестирование через Postman, можно использовать предварительно установленные учетные данные администратора. Они указаны в файле настроек:


admin.login=1

admin.password=1

admin.role=ADMIN


## Функциональность
Этот движок позволяет пользователям создавать новые темы, публиковать сообщения, а также редактировать и удалять их собственные сообщения. Все это осуществляется через простой и интуитивно понятный интерфейс RESTful API.

## Маппинг

### GET /topic
- Описание: Получение списка всех тем на форуме
- Пример запроса: GET /topic
- Пример ответа:
  - Список объектов Topic
  
### GET /topic/{id}
- Описание: Получение сообщений в указанной теме
- Принимаемые значения: ID темы
- Пример запроса: GET /topic/1
- Пример ответа:
  - Список объектов Message, принадлежащих теме с указанным ID
  
### POST /topic
- Описание: Создание новой темы
- Принимаемые значения: Объект TopicDTO
- Пример запроса:
  ```json
    {
      "title": "тема",
      "messages": [
        {
        "authorName": "John Doe",
        "text": "This is a sample message text.",
        "creationDate": "2024-03-23T08:00:00Z"
        }
      ]
    }

### POST /topic/{id}
- Описание: Добавление сообщения в указанную тему
- Принимаемые значения: ID темы, объект Message
- Пример запроса:
  ```json
    {
    "authorName": "John Doe",
    "text": "This is a sample message text.",
    "creationDate": "2024-03-23T08:00:00Z"
    }

### PUT /message/{id}
- Описание: Обновление сообщения
- Принимаемые значения: ID сообщения, объект Message
- Пример запроса:
  ```json
      {
        "authorName": "John Doe",
        "text": "8888",
        "creationDate": "2024-03-23T08:00:00.000+00:00",
            "topic": {
                "id": 1,
                "title": "9999"
            }
        }

### DELETE /message/{id}
- Описание: Удаление сообщения по ID
- Принимаемые значения: ID сообщения
- Пример запроса: DELETE /message/1
- Пример ответа: Статус 200 OK

# Контроллер SecurityController

Контроллер SecurityController представляет собой RESTful API для управления сущностями безопасности. В данном контроллере реализованы следующие методы:

### GET /security
- **Описание:** Получение списка всех сущностей безопасности.
- **Пример запроса:** GET /security
- **Данные в ответе:** Список объектов Security.

http://localhost:8080/security

### POST /security
- **Описание:** Создание новой сущности безопасности.
- **Принимаемые значения:** Параметры запроса - login, role, password.
- **Пример запроса:**

http://localhost:8080/security?login=2&role=ADMIN&password=333

### PUT /security

**Описание:** Обновление сущности безопасности.

**Принимаемые значения:** Параметры запроса - login, role, password.


### DELETE /security

**Описание:** Удаление сущности безопасности по логину.

**Принимаемые значения:** Параметр запроса - login.

**Пример запроса:** DELETE /security?login=example_login

**Данные в ответе:** Отсутствуют.

Контроллер аннотирован как @RestController для автоматической сериализации/десериализации HTTP запросов и ответов в/из объектов Java.


