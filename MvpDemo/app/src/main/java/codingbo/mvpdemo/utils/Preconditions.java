package codingbo.mvpdemo.utils;

import android.support.annotation.Nullable;

/**
 * Created by bob
 * on 17.2.8.
 */

public class Preconditions {


    public static <T> T checkNotNull(T reference, @Nullable Object errorMessage) {
        if(reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        } else {
            return reference;
        }
    }
}
