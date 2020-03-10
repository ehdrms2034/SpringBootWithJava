package com.donggeun;

import org.hibernate.HibernateError;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class BoardClient {


    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapters");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Board board = new Board();
            board.setTitle("제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 잘 되네요.");
            board.setCreateDate(new Date());
            board.setCnt(0L);

//            Board board = em.find(Board.class,1L);
//            em.remove(board);

            em.persist(board);

            String jpql = "select b from Board b order by b.seq asc";
            List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();

            for(Board brd : boardList) {
                System.out.println("--->"+ brd.toString());
            }
            tx.commit();
        }
        catch(Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            em.close();
            emf.close();
        }

    }

}
