package ex_member_management.beginner;

public class Ex6 {
    public static void main(String[] args) {
        MemberDao dao =new MemberDao();
        Member member1 = new Member();
        Member member2 = new Member();

        

        dao.deleteById(member1);
        dao.deleteById(member2);
    }
}
