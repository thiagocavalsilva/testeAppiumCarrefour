#Testes Mobile com Appium + Cucumber (Android) - Para Banco Carrefour
===========================================================

Descrição
---------
Suite de testes BDD (Gherkin PT-BR) para um app Android (pacote: com.wdiodemoapp),
usando:
- Java 11 (conforme pom.xml)
- Maven
- Appium Java Client
- Cucumber + JUnit
- Relatório HTML (maven-cucumber-reporting)

Estrutura principal
-------------------
/src/test/java/
  ├─ core/Driver.java        -> Inicialização do AppiumDriver (host/port e capabilities)
  ├─ Mapas/                  -> Mapeamento de elementos (PageFactory/@AndroidFindBy)
  ├─ LoginPaginas/           -> Page Objects (ações de tela)
  ├─ Passos/                 -> Definições de passos (Dado/Quando/Então)
  └─ runner/RunnerTest.java  -> Runner JUnit do Cucumber
/src/test/resources/features/
  └─ login.feature           -> Cenários de login/cadastro (em PT-BR)

Requisitos
----------
- JDK 11+
- Maven 3.8+
- Android SDK + AVD configurado (emulador Android em execução)
- Appium Server ativo (ex.: em http://127.0.0.1:4723)
- App Android de testes instalado no dispositivo/emulador:
  • Pacote esperado: com.wdiodemoapp
  • Activity:        com.wdiodemoapp.MainActivity
  Se necessário, instale o APK do "WebdriverIO Demo App" e confirme o pacote/activity acima.

Configurações importantes
-------------------------
Arquivo: src/test/java/core/Driver.java
- URL do Appium Server: "http://127.0.0.1:4723"
- Plataforma: Android (automationName: uiautomator2)
- deviceName: "testecarrefour"  -> ajuste para o nome do seu emulador/dispositivo
- appPackage/appActivity: conforme acima

Execução
--------
1) Inicie o emulador Android e garanta o app instalado/aberto.
2) Suba o Appium Server (ex.: appium server --address 127.0.0.1 --port 4723).
3) No diretório do projeto, rode:
   mvn clean test -Dtest=runner.RunnerTest

Filtrar cenários via TAGs
-------------------------
- O Runner (runner/RunnerTest.java) pode usar tags (ex.: "@login").
- Ajuste 'tags' no Runner para selecionar cenários/esquemas desejados em features/login.feature.

Relatórios
----------
- JSON:   target/reports/cucumberReports.json
- HTML:   target/reports/cucumber-html-reports/index.html

Dicas
-----
- Caso o emulador não seja detectado, revise o ANDROID_HOME/SDK e o deviceName em core/Driver.java.
- Se o pacote/atividade do app diferir, atualize appPackage/appActivity no Driver.
- Use adb logcat e o relatório Cucumber para investigar falhas.

Comandos úteis
--------------
- Listar dispositivos ADB:     adb devices
- Instalar APK:                adb install caminho/para/app.apk
- Iniciar Appium (exemplo):    appium server --address 127.0.0.1 --port 4723
- Rodar testes:                mvn clean test -Dtest=runner.RunnerTest
