package cn.itcast.ssh.web.action;

import java.util.List;

import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.service.ILeaveBillService;
import cn.itcast.ssh.utils.ValueContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings("serial")
public class LeaveBillAction extends ActionSupport implements ModelDriven<LeaveBill> {

	private LeaveBill leaveBill = new LeaveBill();
	
	@Override
	public LeaveBill getModel() {
		return leaveBill;
	}
	
	private ILeaveBillService leaveBillService;

	public void setLeaveBillService(ILeaveBillService leaveBillService) {
		this.leaveBillService = leaveBillService;
	}

	/**
	 * 请假管理首页显示
	 * @return
	 */
	public String home(){
		List<LeaveBill> list = leaveBillService.findLeaveBill();
		ValueContext.putValueContext("LBlist", list);
		return "home";
	}
	
	/**
	 * 添加请假申请
	 * @return
	 */
	public String input(){
		//1：获取请假单ID
		Long id = leaveBill.getId();
		//修改
		if(id!=null){
			//2：使用请假单ID，查询请假单信息，
			LeaveBill bill = leaveBillService.findLeaveBillById(id);
			//3：将请假单信息放置到栈顶，页面使用struts2的标签，支持表单回显
			ValueContext.putValueStack(bill);
		}
		//新增
		return "input";
	}
	
	/**
	 * 保存/更新，请假申请
	 * 
	 * */
	public String save() {
		leaveBillService.saveLeaveBill(leaveBill);
		return "save";
	}
	
	/**
	 * 删除，请假申请
	 * 
	 * */
	public String delete(){
		return "save";
	}
	
}
