package tk.mybatis.simple.model;

import java.util.Date;

public class SysRole {
	/**
	 * ��ɫID
	 */
	private Long roleId;
	
	/**
	 * ��ɫ����
	 */
	private String roleName;
	
	/**
	 * ��Ч��־
	 */
	private Long roleEnabled;
	
	/**
	 * ������
	 */
	private Long createBy;
	
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	
	/**
	 * �û�
	 * @return
	 */
	private SysUser user;
	
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getRoleEnabled() {
		return roleEnabled;
	}

	public void setRoleEnabled(Long roleEnabled) {
		this.roleEnabled = roleEnabled;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
