package me.alent.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异步返回各种格式，json，xml，txt
 *
 * Created by Alent on 2017/3/27.
 */
public class ResponseUtil {

    private static void render(HttpServletResponse response, String contentType, String text) {
        response.setContentType(contentType);
        try {
            response.getWriter().write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步返回json数据
     * @param response
     * @param text
     */
    public static void renderJson(HttpServletResponse response, String text) {
        render(response, "application/json; charset=UTF-8", text);
    }

    /**
     * 异步返回xml数据
     * @param response
     * @param text
     */
    public static void renderXml(HttpServletResponse response, String text) {
        render(response, "text/xml", text);
    }

    /**
     * 异步返回txt数据
     * @param response
     * @param text
     */
    public static void renderTxt(HttpServletResponse response, String text) {
        render(response, "application/plain", text);
    }

}
