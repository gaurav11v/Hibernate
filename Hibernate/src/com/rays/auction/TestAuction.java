package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {
	
	public static void main(String[] args) {

		Bid bid1 = new Bid();
		bid1.setId(4);
		bid1.setAmount(4000);
		bid1.setTimeStamp("B");

		Bid bid2 = new Bid();
		bid2.setId(5);
		bid2.setAmount(8000);
		bid2.setTimeStamp("BB");

		Bid bid3 = new Bid();
		bid3.setId(3);
		bid3.setAmount(3000);
		bid3.setTimeStamp("AAA");

		Set bids = new HashSet();

		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);

		AuctionItem item = new AuctionItem();
		item.setId(2);
		item.setDescription("audi");
		item.setBids(bids);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(item);

		tx.commit();

		session.close();
	}

}
