package web.common;

public class Config {
    public static final String PLATFORM_AND_BROWSER = "win_chrome";

    /**
     * Clear cookies and storage after each iteration
     * if true - clear cookies
     */

    public static final boolean CLEAN_COOKIES_AND_STORAGE = true;

    /**
     * if false - hold browser open
     */
    public static final boolean HOLD_BROWSER_OPEN = true;

    /**
     * if true - browser wil be moved to the right screen before test
     */

    public static final boolean SWITCH_SCREEN = false;

    /**
     * if true - browserConsoleLogCheck will be executed
     */

    public static final boolean GET_LOGS = true;
}


