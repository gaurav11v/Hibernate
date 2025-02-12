package com.rays.crud;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestSave {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("gourav");
		dto.setLastName("verma");
		dto.setLoginId("gourav@gmail.com");
		dto.setPassword("1234");
		dto.setDob(new Date());
		dto.setAddress("bhopal");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();

	}

}