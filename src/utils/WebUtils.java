package utils;

import java.util.UUID;

/**
 * Created by ozc on 2017/3/12.
 */
public class WebUtils {

    public static String makeId() {
        return UUID.randomUUID().toString();
    }



}
