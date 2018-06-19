package com.exp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exp.model.MemberOrder;

public interface MemberOrderDao extends JpaRepository<MemberOrder, Integer>{
		MemberOrder save(MemberOrder memberOrder);//存入预约订单@Query(value="select MemberOrder from MemberOrder m where m.memid=?1 and m.status=?2")
		public List<MemberOrder> findBymemid(int memid);//会员查看订单状态使用
		public MemberOrder findBypreorder(String preorder);//更改orderid使用
		public List<MemberOrder> findBybusid(int busid);
		void delete(MemberOrder memberOrder);
		public MemberOrder findByorderid(String order);
}
