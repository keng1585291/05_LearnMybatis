package tk.mybatis.simple.model;

public class SysUserRole {
	/**
	 * �û�ID
	 */
	private Long userId;
	
	/**
	 * ��ɫID
	 */
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}
