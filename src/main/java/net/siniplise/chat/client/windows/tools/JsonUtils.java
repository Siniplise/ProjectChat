package net.siniplise.chat.client.windows.tools;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.tinylog.Logger;

import java.io.IOException;

public class JsonUtils {

    @Contract(pure = true)
    public static @Nullable JSONObject loads(String context) throws JSONException {
        try {
            Logger.info("Loading JSON File:" + context);
            return JSONObject.parseObject(context);
        } catch (JSONException e) {
            Logger.error("Fail to load Json:" + e);
            return null;
        }
    }

    public static boolean dumps (JSONObject jsonObject){

            Logger.info("Dumping JSON File:" + jsonObject);
            return JSONObject.toJSONString(jsonObject).equals(jsonObject.toString());

    }

}
