package ex_member_management.beginner;

public class Beginner2 {
    public static void main(String[] args) {
        MemberDao dao =new MemberDao();

        Member member=dao.load(1);

        System.out.println("id="+member.getId());
        System.out.println("name="+member.getName());
        System.out.println("date="+member.getDate());
        System.out.println("gender="+member.getGender());
        System.out.println("colorId="+member.getColorId());
    }
}
