package model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class GuestBookDAOImpl implements GuestBookDAO{
	private SqlSessionTemplate template;
	public GuestBookDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	/* (non-Javadoc)
	 * @see model.GuestBookDAO#getAllGuestBookList()
	 */
	@Override
	public List<GuestBookVO> getAllGuestBookList(){
		return template.selectList("guestbook.getAllGuestBookList");
	}
}
