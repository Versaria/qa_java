# qa_java
QA Java Project

# Проектная работа: Тестирование программы для зоологов 🐾

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![JUnit](https://img.shields.io/badge/JUnit-5.9.2-red)
![Mockito](https://img.shields.io/badge/Mockito-5.3.1-green)
![Maven](https://img.shields.io/badge/Maven-3.9.11-orange)
![Jacoco](https://img.shields.io/badge/Jacoco-0.8.10-lightgrey)
![Git](https://img.shields.io/badge/Git-2.50.1%2B-brightgreen)
![Coverage](https://img.shields.io/badge/Coverage-100%25-brightgreen)

Проект представляет собой тестовое покрытие для программы, используемой зоологами для исследования семейства кошачьих. Включает модульные тесты для классов, представляющих различных животных, с использованием JUnit, Mockito и Jacoco для обеспечения 100% покрытия кода.

## 🚀 Быстрый старт

### Требования
- Java JDK 11 (рекомендуется Zulu 11.0.27)
- Apache Maven 3.9.11+
- Git 2.50.1+ (для клонирования)

### Установка и запуск
```bash
# Клонирование репозитория
git clone https://github.com/Versaria/qa_java.git
cd qa_java
# Сборка проекта и запуск тестов
mvn clean test
# Генерация отчета о покрытии
mvn jacoco:report
# Проверка покрытия кода
mvn jacoco:check
# Открытие отчета в браузере (macOS) 
open target/site/jacoco/index.html
```

## 📂 Структура проекта
```
qa_java/
├── src/
│   ├── main/java/com/example/
│   │   ├── Animal.java                 # Базовый класс для животных
│   │   ├── Predator.java               # Интерфейс для хищников
│   │   ├── Feline.java                 # Класс кошачьих
│   │   ├── Lion.java                   # Класс льва с инъекцией зависимости
│   │   ├── Cat.java                    # Класс кота
│   │   └── Alex.java                   # Класс льва Алекса (доп. задание)
│   └── test/java/com/example/
│       ├── AnimalTest.java             # Тесты для Animal
│       ├── FelineTest.java             # Тесты для Feline
│       ├── CatTest.java                # Тесты для Cat с Mockito
│       ├── LionTest.java               # Тесты для Lion
│       ├── LionParameterizedTest.java  # Параметризованные тесты для Lion
│       └── AlexTest.java               # Тесты для Alex
├── target/site/jacoco/                 # Отчет о покрытии кода
├── pom.xml                             # Конфигурация Maven
└── README.md                           # Документация
```
## 📋 Функционал

### Особенности реализации
- Инъекция зависимостей: Классы Lion и Cat используют принцип DI
- Мокирование: Использование Mockito для изоляции тестируемых компонентов
- Параметризованное тестирование: Тесты для проверки различных сценариев
- Полное покрытие кода: 100% покрытие для основных классов
- Дополнительный функционал: Класс Alex с уникальными методами

### Технологии
- Java 11
- JUnit 5
- Mockito
- Jacoco
- Maven

### Покрытие тестами
Проект имеет 100% покрытие кода для всех основных классов:

- ✅ Feline - 100% покрытие
- ✅ Cat - 100% покрытие
- ✅ Lion - 100% покрытие
- ✅ Alex - 100% покрытие
- ✅ Animal - 100% покрытие

Отчет Jacoco доступен в `target/site/jacoco/index.html`

## 💻 Пример работы
```java
// Создание экземпляра Lion с моком Feline
@Mock
Feline feline;

@Test
void testLionHasMane() throws Exception {
    Lion lion = new Lion("Самец", feline);
    assertTrue(lion.doesHaveMane());
}
```
### Результат выполнения тестов:
```
[INFO] Tests run: 35, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] All coverage checks have been met.
```

## 📜 Лицензия

MIT License. Полный текст доступен в файле [LICENSE](LICENSE).

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/new-dish`)
3. Сделайте коммит (`git commit -am 'Add new menu item'`)
4. Запушьте ветку (`git push origin feature/new-dish`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Только генерация отчета без запуска тестов (требует существующего jacoco.exec)
mvn jacoco:report

# Только проверка покрытия без запуска тестов
mvn jacoco:check

# Очистка данных покрытия
mvn jacoco:reset

# Просмотр отчета о покрытии
open target/site/jacoco/index.html
```
</details>

**Примечание**: Проект создан для учебных целей и демонстрирует лучшие практики тестирования на Java.