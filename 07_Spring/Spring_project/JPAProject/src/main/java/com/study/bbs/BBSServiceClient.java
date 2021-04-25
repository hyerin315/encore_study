package com.study.bbs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BBSServiceClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			// Transaction 시작
			tx.begin();

			//setting만 했음에도 sql에 값이 들어감 (persistence.xml의 옵션 설정값때문에 이렇게 나오는 것)
			BBS bbs = new BBS();
			//bbs.setBbsno(23);
			bbs.setWname("홍길동");
			bbs.setTitle("jpa 제목");
			bbs.setContent("jpa 내용");
			bbs.setPasswd("1234");
			//bbs.setWdate("2021-02-23");

			// 등록
			em.persist(bbs);

			// 글목록 조회
			String jpql = "select b from BBS b order by b.bbsno desc";
			List<BBS> list = em.createQuery(jpql, BBS.class).getResultList();
			for (BBS bs : list) {
				System.out.println("--->" + bs.toString());
			}

			tx.commit();

		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}

}
