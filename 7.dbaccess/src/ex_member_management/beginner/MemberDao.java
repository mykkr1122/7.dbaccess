package ex_member_management.beginner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    public Member load(int id){
        Connection con=DBManager.createConnection();
        String sql="""
                select 
                id,name,birthDay,gender,color_id
                from members
                where id=?
                """;

        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();

            Date date = rs.getDate("birthDay");
            LocalDate localDate = date.toLocalDate();
            
            if (rs.next()) {
                Member member=new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setBirthDay(localDate);

                return member;
                }
                return null;
        } catch (Exception ex) {
                System.err.println("SQL= "+sql);
                throw new RuntimeException("load処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public List<Member> findByName(String name){
        Connection con=DBManager.createConnection();
        String sql="""
                select *
                from members
                where name=%?%
                """;
        
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, name);

            ResultSet rs=pstmt.executeQuery();
            List<Member> memberList=new ArrayList<>();

            while (rs.next()) {
                Member member=new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                Date date = rs.getDate("birth_day");
                LocalDate localDate = date.toLocalDate();
                member.setDate(localDate);
                member.setGender("gender");
                member.setColorId(rs.getInt("color_id"));
                memberList.add(member);
            }
            return memberList;
        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("検索処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public List<Member> findAll(int id){
        Connection con=DBManager.createConnection();
        String sql="""
                select *
                from members
                order by
                birth_day desc
                """;
        
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet rs=pstmt.executeQuery();
            List<Member> memberList=new ArrayList<>();

            while (rs.next()) {
                Member member=new Member();
                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                Date date = rs.getDate("birth_day");
                LocalDate localDate = date.toLocalDate();
                member.setDate(localDate);
                member.setGender("gender");
                member.setColorId(rs.getInt("color_id"));
                memberList.add(member);
            }
            return memberList;
        } catch (SQLException ex) {
            System.err.println("SQL= "+sql);
            throw new RuntimeException("検索処理に失敗しました",ex);
        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int insert(Member member){
        Connection con=DBManager.createConnection();
        String sql="""
                insert into members
                (name,bithDay,gender,colorId)
                values
                (?,  ? , ? , ? )
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            LocalDate localDate = member.getBirthDay();
            Date date = Date.valueOf(localDate);
            pstmt.setDate(2, date);
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());


            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("insert処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int update(Member member){
        Connection con=DBManager.createConnection();
        String sql="""
                update members
                set
                name=?,
                birth_day=?,
                gender=?,
                color_id=?
                where id=?
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setString(1, member.getName());
            LocalDate localDate = member.getBirthDay();
            Date date = Date.valueOf(localDate);
            pstmt.setDate(2, date);
            pstmt.setString(3, member.getGender());
            pstmt.setInt(4, member.getColorId());


            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("update処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }

    public int deleteById(String member1){
        Connection con=DBManager.createConnection();
        String sql="""
                delete from members
                where id=?
                """;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);

            pstmt.setNString(1, member1);

            int affected=pstmt.executeUpdate();
            return affected;
        } catch (SQLException ex) { 
            System.err.println("SQL= "+sql);
            throw new RuntimeException("delete処理に失敗しました",ex);

        }finally{
            DBManager.closeConnection(con);
        }
    }

    public void deleteById(Member member2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    

}

