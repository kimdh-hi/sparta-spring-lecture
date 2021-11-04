package com.sparta.item02.dto;

import com.sparta.item02.domain.Memo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemoDto {

    private Long id;
    private String username;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemoDto(Long id, String username, String contents) {
        this.id = id;
        this.username = username;
        this.contents = contents;
    }

    public Memo toEntity() {

        return new Memo(this.getUsername(), this.getContents());
    }

    public MemoDto toDto(Memo memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
        this.createdAt = memo.getCreatedAt();
        this.updatedAt = memo.getUpdatedAt();

        return this;
    }
}
