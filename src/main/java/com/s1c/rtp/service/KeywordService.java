package com.s1c.rtp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.dto.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeywordService {

    @Autowired
    KeywordRepository keywordRepository;

    @Transactional
    public List<KeywordDto> returnBiggerThanRate(double rate){
        List<KeywordDto> listKeyword = keywordRepository.findAllKeyword();
        ArrayList<KeywordDto> listBiggerThanRate = new ArrayList<KeywordDto>();
        for(KeywordDto obj : listKeyword){
            if (obj.getRate() > rate) {
                listBiggerThanRate.add(obj);
            }
        }
        return listBiggerThanRate;
    }
}
