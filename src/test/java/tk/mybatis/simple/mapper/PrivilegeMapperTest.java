package tk.mybatis.simple.mapper;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {
	@Test
	public void selectById(){
		//��ȡ���ݿ����ӻỰ
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡ�ӿ�
			PrivilegeMapper privilegeMapper=sqlSession.getMapper(PrivilegeMapper.class);
			SysPrivilege privilege=privilegeMapper.selectById(1L);
			//�жϲ�Ϊ��
			Assert.assertNotNull(privilege);
			//�ж�PrivilegeName�û�����
			Assert.assertEquals("�û�����", privilege.getPrivilegeName());
		}finally{
			sqlSession.close();
		}
	}
}
