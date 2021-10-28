package com.s1c.rtp.dto;

import com.s1c.rtp.entity.relkeywordsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RelKeywordDto {
    relkeywordsId relkeywordsId;
    int mentions;
}
