package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**    /**누르면 자동 생성
     *
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
