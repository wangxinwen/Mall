package tw.roysu.mall.dao.impl;

import org.springframework.stereotype.Repository;

import tw.roysu.mall.dao.IUserDao;
import tw.roysu.mall.entity.User;

@Repository
public class UserDao extends BaseDao<User> implements IUserDao {
	
	public UserDao() {
		super(User.class);
	}

	@Override
	public User findByAccount(String account) {
		return super.findBy("account", account);
	}

	@Override
	public User findByEmail(String email) {
		return super.findBy("email", email);
	}

	@Override
	public User findByName(String name) {
		return super.findBy("name", name);
	}

}
