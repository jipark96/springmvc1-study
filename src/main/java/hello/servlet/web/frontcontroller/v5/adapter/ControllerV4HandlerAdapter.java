package hello.servlet.web.frontcontroller.v5.adapter;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    //handler 가 ControllerV4 인 경우에만 처리하는 어댑터
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);

    }
    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {

//실행 로직
        ControllerV4 controller = (ControllerV4) handler; //handler를 ControllerV4로 케스팅
        Map<String, String> paramMap = createParamMap(request); //paramMap을 만들어서 해당 컨트롤러를 호출
        Map<String, Object> model = new HashMap<>(); //model을 만들어서 해당 컨트롤러를 호출
        String viewName = controller.process(paramMap, model); //viewName을 반환

//어댑터 변환, 어댑터가 호출하는 ControllerV4 는 뷰의 이름을 반환
        ModelView mv = new ModelView(viewName); //어댑터는 뷰의 이름이 아니라ModelView 를 만들어서 반환해야
        mv.setModel(model);
        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {

        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName,request.getParameter(paramName)));
        return paramMap;
    }
}