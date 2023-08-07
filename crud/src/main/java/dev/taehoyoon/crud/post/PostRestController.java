package dev.taehoyoon.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private final  List<PostDto> postList;

    public PostRestController() {
        this.postList = new ArrayList<>();
    }

    // POST /post
    @PostMapping() // 파라미터에 이무것도 안 써줘도 알아서 '/post' url로 request body에 있는 값을 집어넣는다
    public void createPost(@RequestBody PostDto postDto) {
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }

    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postList;
    }

    // GET /post/0
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postList.get(id);
    }

    // PUT /post/0
    @PutMapping("{id}")
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
        PostDto targetPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
    }

    // DELETE /post/0
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postList.remove(id);
    }
}
