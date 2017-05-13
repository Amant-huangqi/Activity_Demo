package cn.itcast.ssh.service;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import cn.itcast.ssh.domain.LeaveBill;
import cn.itcast.ssh.web.form.WorkflowBean;



public interface IWorkflowService {

	void saveNewDelove(File file, String filename);

	List<Deployment> findDeployment();

	List<ProcessDefinition> findProcessDefinition();

	InputStream findImageView(String deploymentId, String imageName);

	void delDeploymentById(String deploymentId);

	void saveStartProcess(WorkflowBean workflowBean);

	List<Task> findPersonalTask();

	String findTaskFormKeyByTaskId(String taskId);

	LeaveBill findLeaveBillByTaskId(String taskId);

	List<String> findOutComeListByTaskId(String taskId);

	List<Comment> findCommentByTaskId(String taskId);

	void saveSubmitTask(WorkflowBean workflowBean);

	List<Comment> findCommentByLeaveBillId(Long id);

	ProcessDefinition findProcessDefinitionByTaskId(String taskId);

	Map<String, Object> findCoordingByTask(String taskId);

	

}
