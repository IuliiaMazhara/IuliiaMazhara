Download selenium-server-standalone from: [Selenium 3.141.59](https://github.com/SeleniumHQ/selenium/releases/tag/selenium-3.141.59)

Hub
```bash
java -jar <absolute path>/selenium-server-standalone-3.141.59.jar \
    -role hub
```
Chrome
```bash
java -Dwebdriver.chrome.driver=<absolute path to driver>/chromedriver \
    -jar <absolute path>/selenium-server-standalone-3.141.59.jar \
    -role node \
    -hub http://<address from hub logs>:4444/grid/register/ \
    -browser "browserName=chrome,maxInstances=4"
```
Firefox
```bash
java -Dwebdriver.gecko.driver=<absolute path to driver>/geckodriver \
    -jar <absolute path>/selenium-server-standalone-3.141.59.jar \
    -role node \
    -hub http://<address from hub logs>:4444/grid/register/ \
    -browser "browserName=firefox,maxInstances=2"
```
Opera
```bash
java -Dwebdriver.opera.driver=<absolute path to driver>/operadriver \
    -jar <absolute path>/selenium-server-standalone-3.141.59.jar \
    -role node \
    -hub http://<address from hub logs>:4444/grid/register/ \
    -browser "browserName=operablink"
```
