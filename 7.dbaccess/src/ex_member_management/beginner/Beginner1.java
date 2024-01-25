package ex_member_management.beginner;

public class Beginner1 {
    public static void main(String[] args) {
        MemberDao dao=new MemberDao();  
        Member member1=new Member();
        Member member2=new Member();
        Member member3=new Member();
        Member member4=new Member();
        Member member5=new Member();

        member1.setName("大野智");
        member1.setDate("1980-11-26");
        member1.setGender("男");
        member1.setColorId(1);

        member2.setName("櫻井翔");
        member2.setDate("1982-1-25");
        member2.setGender("男");
        member2.setColorId(2);

        member3.setName("相葉雅紀");
        member3.setDate("1982-12-24");
        member3.setGender("男");
        member3.setColorId(3);

        member4.setName("二宮和也");
        member4.setDate("1983-06-17");
        member4.setGender("男");
        member4.setColorId(4);

        member5.setName("松本潤");
        member5.setDate("1983-08-30");
        member5.setGender("男");
        member5.setColorId(5);

        dao.insert(member1);
        dao.insert(member2);
        dao.insert(member3);
        dao.insert(member4);
        dao.insert(member5);

    }
}
