package dev.taeho.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping( // 경로 설정해주는 부분
            value = "/hello", // url: 127.0.0.1:8000/hello
            method = RequestMethod.GET // method: GET
    )
    public String hello( // html을 렌더링 해주려면 string 타입으로 해당 html 파일명을 리턴해주면 된다. (확장자 꼭 포함해야함)
            @RequestParam(name = "id", required = false, defaultValue = "" // 쿼리 파라미터를 설정해주는 부분
                    // http://127.0.0.1:8080/hello?id=123123 처럼 넘김
    ) String id) {
        logger.info(id);
        return "/hello.html";
    }

    @GetMapping( // method 마다 어노테이션 있음. 웬만하면 메소드 어노테이션 사용 권장한다고 함
            value = "/hello/{id}"
    )
    public String helloPath(@PathVariable("id") String id) {
        logger.info(id); // 콘솔에 아이디 잘 찍히는 지 확인
        return "/hello.html";
    }

    @GetMapping(
            value = "/get-profile"
    )
    public @ResponseBody SamplePayload getProfile(){ // response body로 return 값을 보내고 싶다면 저 어노테이션 해줘야함
        return new SamplePayload("taeho", 25, "student");
    }
}
