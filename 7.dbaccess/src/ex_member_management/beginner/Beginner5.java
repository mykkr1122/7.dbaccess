package ex_member_management.beginner;


public class Beginner5 {
    public static void main(String[] args) {
           MemberDao dao =new MemberDao();
           Member member = new Member();
           member.setId(1);
           member.setName("宮木香");
           member.setDate("1995-11-22");
           member.setGender("女");
           member.setColorId(1);
           
            dao.update(member);

            System.out.println("id="+member.getId());
            System.out.println("name="+member.getName());
            System.out.println("date="+member.getDate());
            System.out.println("gender="+member.getGender());
            System.out.println("colorId="+member.getColorId());
        
    }
}
