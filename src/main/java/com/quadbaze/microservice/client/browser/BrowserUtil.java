package com.quadbaze.microservice.client.browser;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Olatunji O. Longe: Created on (04/07/2018)
 */

@SuppressWarnings("Duplicates")
public class BrowserUtil {

    public static void browse(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
            }
        } else {
            launchPlatformBrowser(Runtime.getRuntime(), url);
        }
    }

    private static void launchPlatformBrowser(Runtime runtime, String url) {
        try {
            attemptLinuxLauncher(runtime, url);
        } catch (IOException ex) {
            try {
                attemptWindowsLauncher(runtime, url);
            } catch (IOException e) {
                try {
                    attemptMacLauncher(runtime, url);
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
            }
        }
    }

    private static void attemptLinuxLauncher(Runtime runtime, String url) throws IOException {
        runtime.exec("xdg-open " + url);
    }

    private static void attemptWindowsLauncher(Runtime runtime, String url) throws IOException {
        runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
    }

    private static void attemptMacLauncher(Runtime runtime, String url) throws IOException {
        runtime.exec("open " + url);
    }

}
