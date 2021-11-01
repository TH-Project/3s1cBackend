package com.s1c.rtp.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1c.rtp.repository.*;
import com.s1c.rtp.dto.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    WholeDataRepository wholeDataRepository;

    @Transactional
    public GroupByDto returnNumOfWritersNComments() {
        Long numOfComments = wholeDataRepository.numOfCommentsData();
        Long numOfWriters = commentsRepository.returnNumOfWriters();

        return new GroupByDto(numOfComments, numOfWriters);
    }

    @Transactional
    public Long returnNumOfWriters() {        
        Long numWriters = commentsRepository.returnNumOfWriters();

        return numWriters;
    }

    @Transactional
    public JSONObject returnCommentsNTime() {
        int zero, one, two, three, four, five, six, seven, eight, nine, ten;
        int eleven, twelve, thirteen, fourteen, fifteen, sixteen, seventeen, eighteen, nineteen, twenty;
        int twentyOne, twentyTwo, twentyThree;

        zero = one = two = three = four = five = six = seven = eight = nine = ten = 0;
        eleven = twelve = thirteen = fourteen = fifteen = sixteen = seventeen = eighteen = nineteen = twenty = 0;
        twentyOne = twentyTwo = twentyThree = 0;

        List<TimeCommentsDto> timeCommentsDtoList = commentsRepository.findAllCommentsNTime();
        for (TimeCommentsDto obj : timeCommentsDtoList) {
            if (obj.getTime() == 0) {
                zero++;
            } else if (obj.getTime() == 1) {
                one++;
            } else if (obj.getTime() == 2) {
                two++;
            } else if (obj.getTime() == 3) {
                three++;
            } else if (obj.getTime() == 4) {
                four++;
            } else if (obj.getTime() == 5) {
                five++;
            } else if (obj.getTime() == 6) {
                six++;
            } else if (obj.getTime() == 7) {
                seven++;
            } else if (obj.getTime() == 8) {
                eight++;
            } else if (obj.getTime() == 9) {
                nine++;
            } else if (obj.getTime() == 10) {
                ten++;
            } else if (obj.getTime() == 11) {
                eleven++;
            } else if (obj.getTime() == 12) {
                twelve++;
            } else if (obj.getTime() == 13) {
                thirteen++;
            } else if (obj.getTime() == 14) {
                fourteen++;
            } else if (obj.getTime() == 15) {
                fifteen++;
            } else if (obj.getTime() == 16) {
                sixteen++;
            } else if (obj.getTime() == 17) {
                seventeen++;
            } else if (obj.getTime() == 18) {
                eighteen++;
            } else if (obj.getTime() == 19) {
                nineteen++;
            } else if (obj.getTime() == 20) {
                twenty++;
            } else if (obj.getTime() == 21) {
                twentyOne++;
            } else if (obj.getTime() == 22) {
                twentyTwo++;
            } else if (obj.getTime() == 23) {
                twentyThree++;
            }
        }
        JSONObject times = new JSONObject();
        times.put("zero",zero);
        times.put("one",one);
        times.put("two",two);
        times.put("three",three);
        times.put("four",four);
        times.put("five",five);
        times.put("six",six);
        times.put("seven",seven);
        times.put("eight",eight);
        times.put("nine",nine);
        times.put("ten",ten);

        times.put("eleven",eleven);
        times.put("twelve",twelve);
        times.put("thirteen",thirteen);
        times.put("fourteen",fourteen);
        times.put("fifteen",fifteen);
        times.put("sixteen",sixteen);
        times.put("seventeen",seventeen);
        times.put("eighteen",eighteen);
        times.put("nineteen",nineteen);
        times.put("twenty",twenty);

        times.put("twentyOne",twentyOne);
        times.put("twentyTwo",twentyTwo);
        times.put("twentyThree",twentyThree);


        return times;
    }

    @Transactional
    public List<CommentsDto2> returnNewsHasManyCommentsTopThree() {
        List<CommentsDto2> commentsDto2s = commentsRepository.returnNewsIdNNumofComments();
        List<CommentsDto2> topThree = new ArrayList<CommentsDto2>();

        for(int i=0;i<3;i++){
            topThree.add(commentsDto2s.get(i));
        }
        return topThree;
    }

    @Transactional
    public Page<CommentsUserDto> retrieveHeavyUser() {
        Pageable pageable = PageRequest.of(0, 20);
        Page<CommentsUserDto> commentsUserList = commentsRepository.retrieveHeavyUser(pageable);

        // 프론트엔드단 id인덱싱을 위해 1씩 증가하는 임의id 부여
        int cnt =1;
        for(CommentsUserDto dto : commentsUserList) {
            dto.setId(cnt);
            cnt++;
        }
        return commentsUserList;
    }
}
