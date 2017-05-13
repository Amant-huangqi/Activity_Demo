package cn.itcast.ssh.dao;

import java.util.List;

import cn.itcast.ssh.domain.LeaveBill;



public interface ILeaveBillDao {

	void saveLeaveBill(LeaveBill leaveBill);

	List<LeaveBill> findLeaveBill();

	void updateLeaveBill(LeaveBill leaveBill);

	LeaveBill findLeaveBillById(Long id);


}
