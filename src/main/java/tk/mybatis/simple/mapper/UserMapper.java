package tk.mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * ͨ��ID��ѯ�û�
	 * 
	 * @param id
	 * @return
	 */
	SysUser selectById(Long id);//�����ж�������������ֻ����SQLSessionͨ�������ռ�ķ����������˱�¶�����ռ�

	/**
	 * ��ѯȫ���û�
	 */
	List<SysUser> selectAll();
	
	/**
	 * �����û�ID��ȡ��ɫ��Ϣ
	 * @param id
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	
	/**
	 * �����û�
	 * @param sysUser
	 * @return
	 */
	int insert(SysUser user);
	
	/**
	 * �����û�����ʹ��useGeneratedkeys��ʽ
	 * @param sysUser
	 * @return
	 */
	int insert2(SysUser sysUser);
	
	/**
	 * �����û�����ʹ��selectKey��ʽ
	 * @param sysUser
	 * @return
	 */
	int insert3(SysUser sysUser);
	
	/**
	 * �������������û�
	 * @param sysUser
	 * @return
	 */
	int updateById(SysUser sysUser);
	
	/**
	 * ��������ɾ���û�
	 * @param id
	 * @return
	 */
	int deleteById(Long id);//����Ҳ������SysUser sysUser
	
	/**
	 * ��������ɾ���û�
	 * @param SysUser
	 * @return
	 */
	int deleteById(SysUser sysUser);
	
	/**
	 * �����û�id�ͽ�ɫ��enabled״̬��ȡ�û��Ľ�ɫ
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);
}
