package com.company.utils;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
    private static DesiredCapabilities chromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

    public static void initDriver() {
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Configuration.browserCapabilities = chromeOptions();

        switch (System.getProperty("browser") == null ? "chrome" : System.getProperty("browser")) {
            case "chrome":
            default:
                Configuration.browser = Browsers.CHROME;
                break;
        }
    }
}
