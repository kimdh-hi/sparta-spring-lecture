package com.sparta.item02.service;

import com.sparta.item02.domain.Memo;
import com.sparta.item02.dto.MemoDto;
import com.sparta.item02.repository.MemoRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public MemoDto addMemo(MemoDto memoDto) {
        Memo memo = new Memo(memoDto.getUsername(), memoDto.getContents());
        Memo savedMemo = memoRepository.save(memo);

        return memoDto.toDto(memo);
    }

    public List<MemoDto> getMemos() {
        return memoRepository.findAllByOrderByUpdatedAtDesc().stream()
                .map(m -> new MemoDto().toDto(m))
                .collect(Collectors.toList());
    }

    public MemoDto getMemo(Long memoId){
        Memo findMemo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메모입니다.")
        );

        return new MemoDto().toDto(findMemo);
    }

    @Transactional
    public Long deleteMemo(Long memoId) {
        memoRepository.deleteById(memoId);
        return memoId;
    }

    @Transactional
    public Long updateMemo(Long memoId, MemoDto memoDto) {
        Memo findMemo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 메모입니다.")
        );

        return findMemo.update(memoDto);
    }
}
