package com.sparta.item02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class MemoDto {

    private Long memoId;
    private String username;
    private String contents;
}
