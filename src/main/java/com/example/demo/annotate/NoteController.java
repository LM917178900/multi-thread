package com.example.demo.annotate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: NoteController
 * @author: leiming5
 * @date: 2020-11-04 14:37
 */
@RestController
public class NoteController {

    @Resource
    private NoteService noteService;

    @GetMapping("test/note")
    public String testxx(String id){

        for (int i = 0; i < 10; i++) {
            noteService.f1(i); // 执行异步任务
            noteService.f2(i);
        }
        return id;
    }

}
