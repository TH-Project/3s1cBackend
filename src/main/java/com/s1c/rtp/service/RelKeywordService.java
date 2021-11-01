package com.s1c.rtp.service;

import com.s1c.rtp.dto.RelKeywordDto;
import com.s1c.rtp.entity.relkeywords;
import com.s1c.rtp.repository.RelKeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class RelKeywordService {


    @Autowired
    RelKeywordRepository relKeywordRepository;


    @Transactional
    public List<relkeywords> retrieveAllRelKeyword() {
        return relKeywordRepository.findAll();
    }

    @Transactional
    public List<RelKeywordDto> findRelkeywordByKeyword(String keyword) {
        List<RelKeywordDto> list = relKeywordRepository.retrieveRelKeywordsBykeyword(keyword);

        for(Iterator<RelKeywordDto> it = list.iterator() ; it.hasNext() ;) {
            RelKeywordDto dto = it.next();
            if(dto.getRelkeywordsId().getKeyword().equals(dto.getRelkeywordsId().getContent())) {
                it.remove();;
            }
        }

        return list;
    }

    @Transactional
    public List<String> findRelatedKeyword(String keyword) {
        List<RelKeywordDto> list = relKeywordRepository.retrieveRelKeywordsBykeyword(keyword);

        for(Iterator<RelKeywordDto> it = list.iterator() ; it.hasNext() ;) {
            RelKeywordDto dto = it.next();
            if(dto.getRelkeywordsId().getKeyword().equals(dto.getRelkeywordsId().getContent())) {
                it.remove();;
            }
        }
        int cnt = 3;
        List<String> stringList = new ArrayList<>();

        for(RelKeywordDto dto: list) {
            if(cnt == 0)
                break;
            stringList.add(dto.getRelkeywordsId().getContent());
            cnt--;
        }
        return stringList;
    }




}
