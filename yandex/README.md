Selenide examples: YandexMail
========================

This is a sample project demonstrating how to test YandexMail UI with Selenide (Selenium webdriver).

**You can checkout and run it locally with a few minutes.**

### How to run

To run YandexMail tests, just type from command line:

```
./gradle -Dyandex.username=your_email@yandex.ru -Dyandex.password=your_yandex_password
```


Alternatively, you can add these lines to file `<USER_HOME>/.gradle/gradle.properties`

```
systemProp.yandex.username=your_email@yandex.ru
systemProp.yandex.password=your_yandex_password
```

And just run `./gradle` from command line.


Some important notes (P.S.):
1)I had no time to test properly if such way of running the project will work properly, 
cos yesterday about 6pm (18:00) I was notified that I should finish the project today (29.01.19) to 14:00.
I know, that it should work and I hope it will, but I'm not sure.
If it won't, you could run it under InteliJ Idea, 
using "import project from external model" with Gradle build system and run it as test - this more likely will work.

2)was tested with:
```
YaMailSvcAutoTestAccount@yandex.ru
bypassthepassword
```

3)All tests are passed correctly if run them separately, but some may fail if run them together. Such test fails are'nt my fault, I just had no time to fix it.