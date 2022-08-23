/*
 * package namoo.user.dao;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import javax.sql.DataSource;
 * 
 * import namoo.common.web.Params; import namoo.user.dto.User;
 * 
 * public class jdbcUserDao2 implements UserDao {
 * 
 * private DataSource dataSource;
 * 
 * public jdbcUserDao2(DataSource dataSource) { this.dataSource = dataSource; }
 * 
 * @Override public void create(User user) throws SQLException { Connection con
 * = null; PreparedStatement pstmt = null; StringBuilder sb = new
 * StringBuilder(); sb.append(" INSERT INTO users(id, passwd, name, email)")
 * .append(" VALUES (?, ?, ?, ?)"); try { con = dataSource.getConnection(); //
 * con.setAutoCommit(false); pstmt = con.prepareStatement(sb.toString());
 * pstmt.setString(1, user.getId()); pstmt.setString(2, user.getPasswd());
 * pstmt.setString(3, user.getName()); pstmt.setString(4, user.getEmail());
 * pstmt.executeUpdate(); }finally{ if(pstmt != null) pstmt.close(); if(con !=
 * null) con.close(); } }
 * 
 * @Override public User read(String id) throws SQLException { User user = null;
 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * StringBuilder sb = new StringBuilder(); sb.
 * append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate"
 * ) .append(" FROM users") .append(" WHERE id = ?"); try { con =
 * dataSource.getConnection(); pstmt = con.prepareStatement(sb.toString());
 * pstmt.setString(1, id); rs = pstmt.executeQuery(); if(rs.next()) { user = new
 * User(); user.setId(rs.getString("id"));
 * user.setPasswd(rs.getString("passwd")); user.setName(rs.getString("name"));
 * user.setEmail(rs.getString("email"));
 * user.setRegdate(rs.getString("regdate")); } }finally{ if(rs != null)
 * rs.close(); if(pstmt != null) pstmt.close(); if(con != null) con.close(); }
 * return user; }
 * 
 * @Override public User login(String id, String passwd) throws SQLException {
 * User user = null; Connection con = null; PreparedStatement pstmt = null;
 * ResultSet rs = null; StringBuilder sb = new StringBuilder(); sb.
 * append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate"
 * ) .append(" FROM users") .append(" WHERE id = ? AND passwd = ?"); try { con =
 * dataSource.getConnection(); pstmt = con.prepareStatement(sb.toString());
 * pstmt.setString(1, id); pstmt.setString(2, passwd); rs =
 * pstmt.executeQuery(); if(rs.next()) { user = new User();
 * user.setId(rs.getString("id")); user.setPasswd(rs.getString("passwd"));
 * user.setName(rs.getString("name")); user.setEmail(rs.getString("email"));
 * user.setRegdate(rs.getString("regdate")); } }finally{ if(pstmt != null)
 * pstmt.close(); if(con != null) con.close(); } return user; }
 * 
 * @Override public List<User> list() throws SQLException { List<User> list =
 * null; Connection con = null; PreparedStatement pstmt = null; ResultSet rs =
 * null; StringBuilder sb = new StringBuilder(); sb.
 * append(" SELECT id, passwd, name, email, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS DAY') regdate"
 * ) .append(" FROM users") .append(" ORDER BY regdate DESC"); try { con =
 * dataSource.getConnection(); pstmt = con.prepareStatement(sb.toString()); rs =
 * pstmt.executeQuery(); list = new ArrayList<User>(); while(rs.next()) { User
 * user = createUser(rs); list.add(user); } }finally{ if(rs != null) rs.close();
 * if(pstmt != null) pstmt.close(); if(con != null) con.close(); } return list;
 * }
 * 
 * private User createUser(ResultSet rs) throws SQLException{ User user = new
 * User(); user.setId(rs.getString("id"));
 * user.setPasswd(rs.getString("passwd")); user.setName(rs.getString("name"));
 * user.setEmail(rs.getString("email"));
 * user.setRegdate(rs.getString("regdate")); return user; }
 * 
 * 
 * @Override public List<User> listByPage(int page) throws SQLException {
 * List<User> list = null; Connection con = null; PreparedStatement pstmt =
 * null; ResultSet rs = null; StringBuilder sb = new StringBuilder();
 * sb.append(" SELECT id, name, passwd, email, regdate")
 * .append(" FROM ( SELECT CEIL(rownum / 10) request_page, id, name, passwd, email, regdate"
 * )
 * .append("        FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate"
 * ) .append("                 FROM users")
 * .append("	                ORDER  BY regdate DESC))")
 * .append("	WHERE  request_page = ?"); try { con =
 * dataSource.getConnection(); pstmt = con.prepareStatement(sb.toString());
 * pstmt.setInt(1, page); rs = pstmt.executeQuery(); list = new
 * ArrayList<User>(); while(rs.next()) { User user = createUser(rs);
 * list.add(user); } }finally{ if(rs != null) rs.close(); if(pstmt != null)
 * pstmt.close(); if(con != null) con.close(); } return list; }
 * 
 * @Override public List<User> listByPage(int page, int listSize) throws
 * SQLException { List<User> list = null; Connection con = null;
 * PreparedStatement pstmt = null; ResultSet rs = null; StringBuilder sb = new
 * StringBuilder(); sb.append(" SELECT id, name, passwd, email, regdate")
 * .append(" FROM ( SELECT CEIL(rownum / ?) request_page, id, name, passwd, email, regdate"
 * )
 * .append("        FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate"
 * ) .append("                 FROM users")
 * .append("	                ORDER  BY regdate DESC))")
 * .append("	WHERE  request_page = ?"); try { con =
 * dataSource.getConnection(); pstmt = con.prepareStatement(sb.toString());
 * pstmt.setInt(1, listSize); pstmt.setInt(2, page); rs = pstmt.executeQuery();
 * list = new ArrayList<User>(); while(rs.next()) { User user = createUser(rs);
 * list.add(user); } }finally{ if(rs != null) rs.close(); if(pstmt != null)
 * pstmt.close(); if(con != null) con.close(); } return list; }
 * 
 * @Override public List<User> listByPage(int page, int listSize, String
 * searchType, String searchValue) throws SQLException { List<User> list = null;
 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * StringBuilder sb = new StringBuilder();
 * sb.append(" SELECT id, name, passwd, email, regdate")
 * .append(" FROM ( SELECT CEIL(rownum / ?) request_page, id, name, passwd, email, regdate"
 * )
 * .append("        FROM   ( SELECT id, name, passwd, email, TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate"
 * ) .append("                 FROM users"); // 검색유형별 WHERE절 동적 추가 switch
 * (searchType) { case "id": sb.append(" WHERE id = ?"); break; case "name": //
 * searchValue = "%" + searchValue + "%"; sb.append(" WHERE name LIKE ?");
 * break; } sb.append("	                ORDER  BY regdate DESC))")
 * .append("	WHERE  request_page = ?");
 * 
 * try { con = dataSource.getConnection(); pstmt =
 * con.prepareStatement(sb.toString()); pstmt.setInt(1, listSize);
 * 
 * searchValue = searchType.equals("id") ? searchValue : "%" + searchValue +
 * "%"; pstmt.setString(2, searchValue); pstmt.setInt(3, page);
 * 
 * rs = pstmt.executeQuery(); list = new ArrayList<User>(); while(rs.next()) {
 * User user = createUser(rs); list.add(user); } }finally{ if(rs != null)
 * rs.close(); if(pstmt != null) pstmt.close(); if(con != null) con.close(); }
 * return list; }
 * 
 * @Override public int countByPage(String searchType, String searchValue)
 * throws SQLException { int count = 0;
 * 
 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * StringBuilder sb = new StringBuilder(); sb.append(" SELECT COUNT(id) count")
 * .append(" FROM   users");
 * 
 * // 검색 유형별 WHERE 절 동적 추가 if(searchType != null){ switch (searchType) { case
 * "id": sb.append(" WHERE id = ?"); break; case "name": searchValue = "%" +
 * searchValue + "%"; sb.append(" WHERE name LIKE ?"); break; } }
 * 
 * try { con = dataSource.getConnection(); pstmt =
 * con.prepareStatement(sb.toString());
 * 
 * // 전체검색이 아닌경우 경우 if(searchType != null){ pstmt.setString(1, searchValue); }
 * 
 * rs = pstmt.executeQuery(); if (rs.next()) { count = rs.getInt("count"); } }
 * finally { try { if(rs != null) rs.close(); if(pstmt != null) pstmt.close();
 * if(con != null) con.close(); }catch (Exception e) {} } return count; }
 * 
 * @Override public List<User> listByPage(Params params) throws SQLException {
 * return listByPage(params.getPage(), params.getListSize(),
 * params.getSearchType(), params.getSearchValue()); }
 * 
 * @Override public int countByPage(Params params) throws SQLException { return
 * countByPage(params.getSearchType(), params.getSearchValue()); }
 * 
 * }
 */