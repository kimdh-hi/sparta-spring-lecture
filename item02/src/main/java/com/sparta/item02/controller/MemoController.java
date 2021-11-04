package com.sparta.item02.controller;

import com.sparta.item02.dto.MemoDto;
import com.sparta.item02.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api")
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memos")
    public MemoDto createMemo(@RequestBody MemoDto memoDto) {
        return memoService.addMemo(memoDto);
    }

    @GetMapping("/memos")
    public List<MemoDto> getAllMemos() {
        return memoService.getMemos();
    }

    @GetMapping("/memos/{id}")
    public MemoDto getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    @PutMapping("/memos/{id}")
    public Long memoUpdate(@PathVariable(name="id") Long id, @RequestBody MemoDto memoDto) {
        return memoService.updateMemo(id, memoDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long memoDelete(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }
}
