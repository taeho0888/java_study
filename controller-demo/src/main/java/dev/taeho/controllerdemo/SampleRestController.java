package dev.taeho.controllerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController // 그냥 Controller는 view를 제공하는 어노테이션이라면, RestController는 기본적으로 데이터를 주고받는 데에 사
@RequestMapping("/rest")
public class SampleRestController {
     private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class );

     @GetMapping("/sample-payload")
    public SamplePayload samplePayloadGet() {
         return new SamplePayload("taeho", 25, "student");
     }

    @PostMapping("/sample-payload")
    @ResponseStatus(HttpStatus.NO_CONTENT ) // 정상적으로 로직이 처리되었을 떄의 결괏값 세팅
    public void samplePayloadPost(@RequestBody SamplePayload samplePayload) {
         logger.info(samplePayload.toString() );
    }

    @PostMapping(
            value = "/sample-multipart",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sampleMultipartPost(
            @RequestParam("name") String name,
            @RequestParam("age") Integer age,
            @RequestParam("name") String occupation,
            @RequestParam("file")MultipartFile multipartFile
            ) {
        logger.info("name: " + name);
        logger.info("age: " + age);
        logger.info("occupation: " + occupation);
        logger.info("file: " + multipartFile.getOriginalFilename());
    }

     @GetMapping(
             value = "/sample-image",
             produces = MediaType.IMAGE_PNG_VALUE // 확장자를 선언할 수 있는 부분
     )
    public byte[] sampleImage() throws IOException {
         InputStream inputStream = getClass().getResourceAsStream("/static/img.png");

         assert inputStream != null;
         return inputStream.readAllBytes();
     }


}
