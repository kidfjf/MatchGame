package match.user;

import match.user.User;

/**
 * ��������û����в����Ľӿ�
 * 
 * @author TwoPlus
 * @version V1.1
 * 
 */
public interface UserDao {
	/**
	 * �����û���¼����
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���ص�¼�Ƿ�ɹ�
	 */
	public abstract boolean Login(String username, String password);

	/**
	 * �����û�ע�Ṧ��
	 * 
	 * @param user
	 *            Ҫע����û���Ϣ
	 */
	public abstract boolean boolname(String name);
	public abstract void regist(User user);
}
