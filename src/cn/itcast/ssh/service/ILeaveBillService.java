package cn.itcast.ssh.service;

import java.util.List;

import cn.itcast.ssh.domain.LeaveBill;



public interface ILeaveBillService {

	void saveLeaveBill(LeaveBill leaveBill);

	List<LeaveBill> findLeaveBill();

	LeaveBill findLeaveBillById(Long id);

}
