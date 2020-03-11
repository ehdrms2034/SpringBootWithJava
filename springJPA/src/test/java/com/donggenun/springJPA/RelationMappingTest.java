package com.donggenun.springJPA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void testManyToOneInsert(){
        Member member1 = new Member();
        member1.setId("member1");
        member1.setPassword("member111");
        member1.setName("둘리");
        member1.setRole("User");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setId("member2");
        member2.setPassword("member222");
        member2.setName("도우너");
        member2.setRole("Admin");
        memberRepo.save(member2);

        for(int i=1; i<=3; i++){
            Board board = new Board();
            board.setMember(member1);
            board.setTitle("둘리가 등록한 게시글 " + i);
            board.setContent("둘리가 등록한 게시글 내용 "+ i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }

        for(int i=1; i<=3; i++){
            Board board = new Board();
            board.setMember(member2);
            board.setTitle("도우너가 등록한 게시글"+ i);
            board.setContent("도우너가 등록한 게시글 내용 "+ i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }
    }

}
