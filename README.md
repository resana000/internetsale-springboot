к резюме ildar показал основной стек

### Показано использование spring boot, liquebase, mvc, kafka, docker-compose, bash скриптов, hibernate

###Общие приципы clean architecture и композиции сервисов в docker-compose

### UML диаграмма демонстрирует архитектуру связности и компонентов

![qwd](https://github.com/juniorresana/internetsale-springboot/blob/master/image.png)

запуск ./install.sh или команды по очереди
1 сборка mvn clean package
2 докеризация docker build -t sprinbootcore:dev .
3 запуск бд в докере и приложения docker-compose up -d --build
