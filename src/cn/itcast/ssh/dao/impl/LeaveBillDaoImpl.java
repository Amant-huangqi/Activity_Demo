package cn.itcast.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.ssh.dao.ILeaveBillDao;
import cn.itcast.ssh.domain.Employee;
import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.utils.LogUtils;
import cn.itcast.ssh.utils.SessionContext;

public class LeaveBillDaoImpl extends HibernateDaoSupport implements ILeaveBillDao {


	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		this.getHibernateTemplate().save(leaveBill);
	}
	
	/**
	 * 请假管理首页显示
	 * @return
	 */
	@Override
	public List<LeaveBill> findLeaveBill() {
		//从Session中获取当前用户
		Employee employee = SessionContext.get();
		String hql = "from LeaveBill o where o.user=?";//指定当前用户的请假单
		List<LeaveBill> list = this.getHibernateTemplate().find(hql,employee);
		//LogUtils.info(list.toString(), this.getClass());
		return list;
	}

	/**
	 * 更新请假单
	 */
	@Override
	public void updateLeaveBill(LeaveBill leaveBill) {
		this.getHibernateTemplate().update(leaveBill);
	}

	/**使用请假单ID，查询请假单的对象*/
	@Override
	public LeaveBill findLeaveBillById(Long id) {
		return this.getHibernateTemplate().get(LeaveBill.class, id);
	}
	
}
