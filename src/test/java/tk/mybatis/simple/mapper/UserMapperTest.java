package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest{
	@Test
	public void testSelectById(){
		SqlSession sqlSession=getSqlSession();
		try {
			// ʹ�ýӿڱ�̣���ͬ�ڽ�ʹ��XML
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			// ����SelectByID��������ѯid=1���û�
			SysUser user = userMapper.selectById(1L);
			// User��Ϊ��
			Assert.assertNotNull(user);
			// userName=admin
			Assert.assertEquals("admin", user.getUserName());
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectAll(){
		SqlSession sqlSession=getSqlSession();
		try{
			//��ȡ�ӿ�
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			
			List<SysUser> userList=userMapper.selectAll();			
			// User��Ϊ��
			Assert.assertNotNull(userList);
						// userName=admin
			Assert.assertTrue(userList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserId(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			List<SysRole> sysRoleList=userMapper.selectRolesByUserId(1L);
			Assert.assertNotNull(sysRoleList);
			Assert.assertTrue(sysRoleList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//����һ��user����
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//���������Ӧ�ö���һ��ͼƬ�浽byte������
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//�������Ķ���������ݿ��У��ر�ע������ķ���ֵresult��ִ�е�SQLӰ�������
			int result =userMapper.insert(user);
			//ֻ����һ������
			Assert.assertEquals(1, result);
			//idΪnull,û�и�id��ֵ������û�����û�дID��ֵ
			Assert.assertNull(user.getId());
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2(){
		SqlSession sqlSession = getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//����һ��user����
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//���������Ӧ�ö���һ��ͼƬ�浽byte������
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//�������Ķ���������ݿ��У��ر�ע������ķ���ֵresult��ִ�е�SQLӰ�������
			int result =userMapper.insert2(user);
			//ֻ����һ������
			Assert.assertEquals(1, result);
			//idΪnull,û�и�id��ֵ������û�����û�дID��ֵ
			Assert.assertNotNull(user.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3(){
		SqlSession sqlSession = getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//����һ��user����
			SysUser user=new SysUser();
			user.setUserName("test1");
			user.setUserPassword("123456");
			user.setUserEmail("test@mybatis.tk");
			user.setUserInfo("test info");
			//���������Ӧ�ö���һ��ͼƬ�浽byte������
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			//�������Ķ���������ݿ��У��ر�ע������ķ���ֵresult��ִ�е�SQLӰ�������
			int result =userMapper.insert3(user);
			//ֻ����һ������
			Assert.assertEquals(1, result);
			//idΪnull,û�и�id��ֵ������û�����û�дID��ֵ
			Assert.assertNotNull(user.getId());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateById(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user=userMapper.selectById(1L);
			//�ж��û���Ϊ��
			Assert.assertNotNull(user);
			//admin�û�
			Assert.assertEquals("admin", user.getUserName());
			
			user.setUserName("admin_test");
			user.setUserEmail("test@mybatis.tk");
			
			int result=userMapper.updateById(user);			
			Assert.assertEquals(1, result);
			
			user=userMapper.selectById(1L);
			Assert.assertNotNull(user);
			Assert.assertEquals("admin_test", user.getUserName());
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			SysUser user1=userMapper.selectById(1L);
			Assert.assertNotNull(user1);
			
			Assert.assertEquals(1, userMapper.deleteById(1L));
			Assert.assertNull(userMapper.selectById(1L));
			
			SysUser user2=userMapper.selectById(1001L);
			Assert.assertNotNull(user2);
			
			Assert.assertEquals(1, userMapper.deleteById(user2));
			Assert.assertNull(userMapper.selectById(1001L));
		}finally{
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled(){
		SqlSession sqlSession=getSqlSession();
		try{
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			//����selectRolesByUserIdAndRoleEnabled������ѯ�û��Ľ�ɫ
			List<SysRole> userList=userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
			//�жϽ���Ƿ�Ϊ��
			Assert.assertNotNull(userList);
		    //�жϽ�ɫ�����Ƿ����0
			Assert.assertTrue(userList.size()>0);
		}finally{
			sqlSession.close();
		}
	}
}
