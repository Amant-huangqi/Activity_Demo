package cn.itcast.ssh.service.impl;

import java.util.List;

import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.SessionContext;

public class LeaveBillServiceImpl implements ILeaveBillService {

	private ILeaveBillDao leaveBillDao;

	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}

	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		//获取请假单ID
		Long id = leaveBill.getId();
		/**新增保存*/
		if(id==null){
			//1：从Session中获取当前用户对象，将LeaveBill对象中user与Session中获取的用户对象进行关联
			leaveBill.setUser(SessionContext.get());//建立管理关系
			//2：保存请假单表，添加一条数据
			leaveBillDao.saveLeaveBill(leaveBill);
		}
		/**更新保存*/
		else{
			//1：执行update的操作，完成更新
			leaveBillDao.updateLeaveBill(leaveBill);
		}
		
	}

	/**
	 * 请假管理首页显示
	 * @return
	 */
	@Override
	public List<LeaveBill> findLeaveBill() {
		List <LeaveBill> list = leaveBillDao.findLeaveBill();
		return list;
	}
	
	@Override
	public LeaveBill findLeaveBillById(Long id) {
		LeaveBill leaveBill = leaveBillDao.findLeaveBillById(id);
		return leaveBill;
	}

}
